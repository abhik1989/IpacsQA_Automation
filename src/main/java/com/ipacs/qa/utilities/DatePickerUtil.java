package com.ipacs.qa.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.ipacs.qa.baseclass.TestBase;

public class DatePickerUtil extends TestBase {



	/**
	 * Selects a date from a Zebra Date Picker associated with the specified input field ID.
	 *
	 * @param inputFieldId The ID of the input field linked to the Zebra Date Picker.
	 * @param expectedDay  The day to select (1-31).
	 * @param expectedMonth The month to select (e.g., "January", "Feb", etc.).
	 * @param expectedYear The year to select (e.g., "2023").
	 */

public static void selectDateFromZebraDatePicker(String inputFieldId, String expectedDay, String expectedMonth, String expectedYear) {
    try {
        System.out.println("➡️ Selecting date for input field: " + inputFieldId);

        // 1. Open calendar
        WebElement calendarIcon = driver.findElement(By.xpath(
            "//input[@id='" + inputFieldId + "']/parent::span[contains(@class,'Zebra_DatePicker_Icon_Wrapper')]/button"));
        calendarIcon.click();
        WaitUtil.waitForSeconds(1);

        expectedMonth = expectedMonth.trim().toLowerCase();
        expectedYear = expectedYear.trim();
        expectedDay = String.valueOf(Integer.parseInt(expectedDay));

        // 2. Get popup (more reliable)
        WebElement calendarPopup = driver.findElement(By.xpath(
            "//div[contains(@class,'Zebra_DatePicker') and not(contains(@style,'display: none'))]"));

        // 3. Navigate to correct month/year
        int attempts = 0;
        while (attempts++ < 24) {
            WebElement caption = calendarPopup.findElement(By.cssSelector("td.dp_caption"));
            String captionText = caption.getText().trim().replace(",", "").toLowerCase();
            System.out.println("📅 Current caption: " + captionText);

            String[] parts = captionText.split("\\s+");
            if (parts.length >= 2) {
                String actualMonth = parts[0];
                String actualYear = parts[1];

                if (actualYear.equals(expectedYear) && actualMonth.startsWith(expectedMonth)) {
                    break;
                }

                int currentYear = Integer.parseInt(actualYear);
                int targetYear = Integer.parseInt(expectedYear);

                if (currentYear > targetYear ||
                   (currentYear == targetYear && compareMonth(actualMonth, expectedMonth) > 0)) {
                    calendarPopup.findElement(By.cssSelector("td.dp_previous")).click();
                } else {
                    calendarPopup.findElement(By.cssSelector("td.dp_next")).click();
                }
                Thread.sleep(250);
            }
        }

        // 4. Select valid day
        List<WebElement> dayCells = calendarPopup.findElements(By.xpath(
            ".//table[contains(@class, 'dp_daypicker')]//td[not(contains(@class,'dp_disabled')) " +
            "and not(contains(@class,'dp_othermonth')) " +
            "and (normalize-space(text())='" + expectedDay + "' or normalize-space(text())='" + String.format("%02d", Integer.parseInt(expectedDay)) + "')]"));

        if (dayCells.isEmpty()) {
            throw new NoSuchElementException("❌ No valid cell found for day " + expectedDay);
        }

        WebElement targetDay = dayCells.get(0);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", targetDay);

        // 5. Fallback if input empty
        WebElement inputField = driver.findElement(By.id(inputFieldId));
        String value = inputField.getAttribute("value").trim();
        if (value.isEmpty()) {
            String fallbackDate = String.format("%s-%s-%s", expectedDay,
                                                expectedMonth.substring(0, 3), expectedYear);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + fallbackDate + "';", inputField);
            System.out.println("⚠️ Used fallback: Typed directly = " + fallbackDate);
        } else {
            System.out.println("✅ Date selected: " + value);
        }

    } catch (Exception e) {
        System.err.println("❌ ERROR selecting date: " + e.getMessage());
        e.printStackTrace();
        throw new RuntimeException("❌ Failed to select date for field '" + inputFieldId + "'", e);
    }
}




private static int compareMonth(String actualMonth, String expectedMonth) {
		    String[] months = { "january", "february", "march", "april", "may", "june",
                        "july", "august", "september", "october", "november", "december" };
    int actualIndex = -1, expectedIndex = -1;
    for (int i = 0; i < months.length; i++) {
        if (months[i].startsWith(actualMonth)) actualIndex = i;
        if (months[i].startsWith(expectedMonth)) expectedIndex = i;
    }
    return Integer.compare(actualIndex, expectedIndex);
	
}

}