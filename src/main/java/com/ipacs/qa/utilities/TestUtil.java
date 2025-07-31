/*
 * package com.ipacs.qa.utilities;
 * 
 * import java.io.File; import java.io.InputStream; import
 * java.text.SimpleDateFormat; import java.time.Duration; import java.util.Date;
 * import java.util.Properties; import java.util.Random;
 * 
 * import org.apache.commons.io.FileUtils; import org.openqa.selenium.By; import
 * org.openqa.selenium.JavascriptExecutor; import
 * org.openqa.selenium.OutputType; import org.openqa.selenium.TakesScreenshot;
 * import org.openqa.selenium.WebElement; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * import com.ipacs.qa.baseclass.TestBase;
 * 
 * public class TestUtil extends TestBase {
 * 
 * public static void takeSnapShot(String Name) throws Exception {
 * TakesScreenshot Screenshot = (TakesScreenshot) driver; File SrcFile =
 * Screenshot.getScreenshotAs(OutputType.FILE); String timestamp = new
 * SimpleDateFormat("dd-MM-yyyy_hh.mm.ss").format(new Date()); File DestFile =
 * new File(
 * "C:/Users/abhishek.kumar/OneDrive - Provana India Pvt. Ltd/Ipacs_Automation/Screenshot/"
 * + Name + "_" + timestamp + ".png"); FileUtils.copyFile(SrcFile, DestFile); }
 * 
 * public static String getReadData(String key) { String value = ""; try {
 * InputStream input =
 * TestBase.class.getClassLoader().getResourceAsStream("config.properties"); if
 * (input == null) {
 * System.out.println("Sorry, unable to find config.properties"); return value;
 * } Properties prop = new Properties(); prop.load(input); value =
 * prop.getProperty(key); input.close(); } catch (Exception e) {
 * System.out.println(e); } return value; }
 * 
 * public static String randomNumber(int i, int j) { Random rand = new Random();
 * int n = rand.nextInt(j - i + 1) + i; // to include 'i' as the lower bound
 * return String.valueOf(n); }
 * 
 * protected void selectCustomDropdown(WebElement dropdownElement, String
 * visibleText) throws InterruptedException { dropdownElement.click();
 * Thread.sleep(1000); WebDriverWait wait = new WebDriverWait(driver,
 * Duration.ofSeconds(10)); WebElement option = wait.until(
 * ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'" +
 * visibleText + "')]"))); option.click(); }
 * 
 * public void selectCustomDropdown(WebElement dropdown, By optionLocator) {
 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 * 
 * WebElement dropdownEl =
 * wait.until(ExpectedConditions.elementToBeClickable(dropdown));
 * dropdownEl.click();
 * 
 * WebElement option =
 * wait.until(ExpectedConditions.presenceOfElementLocated(optionLocator));
 * ((JavascriptExecutor)
 * driver).executeScript("arguments[0].scrollIntoView(true);", option);
 * wait.until(ExpectedConditions.elementToBeClickable(option)).click(); }
 * 
 * }
 */


package com.ipacs.qa.utilities;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ipacs.qa.baseclass.TestBase;

public class TestUtil extends TestBase {

    public static void takeSnapShot(String name) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        // ✅ Use safe DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH.mm.ss");
        String timestamp = LocalDateTime.now().format(formatter);

        String path = "C:/Users/abhishek.kumar/OneDrive - Provana India Pvt. Ltd/Ipacs_Automation/Screenshot/" 
                      + name + "_" + timestamp + ".png";

        File destFile = new File(path);
        FileUtils.copyFile(srcFile, destFile);
    }

    public static String getReadData(String key) {
        String value = "";
        try {
            InputStream input = TestBase.class.getClassLoader().getResourceAsStream("config.properties");
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return value;
            }
            Properties prop = new Properties();
            prop.load(input);
            value = prop.getProperty(key);
            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return value;
    }

    public static String randomNumber(int i, int j) {
        Random rand = new Random();
        int n = rand.nextInt(j - i + 1) + i;
        return String.valueOf(n);
    }

    protected void selectCustomDropdown(WebElement dropdownElement, String visibleText) throws InterruptedException {
        dropdownElement.click();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(text(),'" + visibleText + "')]")));
        option.click();
    }

    public void selectCustomDropdown(WebElement dropdown, By optionLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdownEl = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        dropdownEl.click();

        WebElement option = wait.until(ExpectedConditions.presenceOfElementLocated(optionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }
}
