package com.ipacs.qa.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CalendarUtil {
	
	 /**
     * Selects a date from a calendar widget.
     *
     * @param driver         WebDriver instance
     * @param dateFieldXpath Xpath of the date input field (to open calendar)
     * @param day            Day (e.g., "03")
     * @param month          Month name (e.g., "June")
     * @param year           Year (e.g., "2025")
     */
	
	
    public static void selectDateFromCalendar(WebDriver driver, String dateFieldXpath, String day, String month, String year) {
        // Open the calendar
        WebElement dateField = driver.findElement(By.xpath(dateFieldXpath));
        dateField.click();

        // Select year
        WebElement yearDropdown = driver.findElement(By.xpath("//select[contains(@class, 'year')]"));
        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByVisibleText(year);

        // Select month
        WebElement monthDropdown = driver.findElement(By.xpath("//select[contains(@class, 'month')]"));
        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByVisibleText(month);

        // Select day (some calendars may need td/a adjustment based on HTML)
        driver.findElement(By.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='" + Integer.parseInt(day) + "']")).click();
    }
}


