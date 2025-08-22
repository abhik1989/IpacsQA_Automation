package com.ipacs.qa.utilities;




public class DatePicker {
	
	//static WebDriver driver =new ChromeDriver(); // Assuming you have initialized the WebDriver
	
	/*public static void selectDateFromZebraDatePicker(String expectedDay, String expectedMonth, String expectedYear) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        WebElement calendarIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("Zebra_DatePicker_Icon Zebra_DatePicker_Icon_Inside")));
	        calendarIcon.click();

	        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.Zebra_DatePicker")));

	        expectedMonth = expectedMonth.trim().toLowerCase();
	        expectedYear = expectedYear.trim();

	        int attempts = 0;
	        boolean found = false;

	        while (attempts++ < 24) {
	            WebElement caption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td.dp_caption")));
	            String captionText = caption.getText().trim().replace(",", "").toLowerCase(); // "july 2025"
	            String[] parts = captionText.split("\\s+");

	            if (parts.length >= 2) {
	                String actualMonth = parts[0];
	                String actualYear = parts[1];

	                if (actualMonth.equals(expectedMonth) && actualYear.equals(expectedYear)) {
	                    found = true;
	                    break;
	                }
	            }

	            // Go to next month
	            WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("td.dp_next")));
	            nextBtn.click();
	            Thread.sleep(300); // brief wait for UI update
	        }

	        if (!found) {
	            throw new RuntimeException("❌ Could not navigate to expected month/year: " + expectedMonth + " " + expectedYear);
	        }

	        // Now select the day
	        List<WebElement> dayCells = driver.findElements(By.xpath(
	                "//table[@class='dp_daypicker']//td[not(contains(@class, 'dp_not_in_month')) and normalize-space(text())='" + expectedDay + "']"
	        ));

	        if (!dayCells.isEmpty()) {
	            dayCells.get(0).click();
	           
	        } else {
	            throw new NoSuchElementException("❌ Day " + expectedDay + " not found in current calendar view.");
	        }

	    } catch (Exception e) {
	        
	        
	        
	        throw new RuntimeException("❌ Failed to select date", e);
	    }*/
	

}
