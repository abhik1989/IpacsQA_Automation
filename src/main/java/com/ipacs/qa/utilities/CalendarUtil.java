/*
 * package com.ipacs.qa.utilities;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * java.time.LocalDate; import java.time.format.TextStyle; import
 * java.util.Locale;
 * 
 * public class CalendarUtil { private WebDriver driver;
 * 
 * public CalendarUtil(WebDriver driver) { this.driver = driver; }
 * 
 * public void selectDate(By calendarIconLocator, LocalDate targetDate) { //
 * Click the calendar icon to open the calendar
 * driver.findElement(calendarIconLocator).click();
 * 
 * String monthYear = targetDate.getMonth().getDisplayName(TextStyle.FULL,
 * Locale.ENGLISH) + ", " + targetDate.getYear();
 * 
 * while (true) { String displayedMonthYear =
 * driver.findElement(By.cssSelector(".calendar .rdtPicker .rdtMonth")).getText(
 * );
 * 
 * if (displayedMonthYear.equalsIgnoreCase(monthYear)) { break; }
 * 
 * // Navigate to correct month if (targetDate.isBefore(LocalDate.now())) {
 * driver.findElement(By.cssSelector(".rdtPrev")).click(); } else {
 * driver.findElement(By.cssSelector(".rdtNext")).click(); } }
 * 
 * // Select the day String dayLocator =
 * String.format("//td[not(contains(@class, 'rdtDisabled')) and text()='%d']",
 * targetDate.getDayOfMonth());
 * driver.findElement(By.xpath(dayLocator)).click(); }
 * 
 * public void selectDateRange(By startCalendarIcon, By endCalendarIcon,
 * LocalDate startDate, LocalDate endDate) { selectDate(startCalendarIcon,
 * startDate); selectDate(endCalendarIcon, endDate); } }
 */