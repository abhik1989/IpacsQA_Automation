
/**
 * TestBase class provides setup and utility functions for Selenium WebDriver tests.
 * It includes browser initialization, screenshot capturing, file download handling,
 * and cleanup operations. Supports Chrome, Firefox, and Edge browsers.
 */
package com.ipacs.qa.baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ipacs.qa.utilities.ConfigUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
    /** WebDriver instance used across tests */
    public static WebDriver driver;

    /** Default file download path under the project directory */
    public static String downloadPath = System.getProperty("user.dir") + File.separator + "downloads";

    /**
     * Setup method executed before each test.
     * Initializes Chrome browser with custom download settings.
     */
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://ipacs-qa.azurewebsites.net/");
    }

    /**
     * Initializes the WebDriver based on the browser name.
     *
     * @param browserName Name of the browser ("chrome", "firefox", "edge")
     */
    public void initializeDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Invalid browser name provided: " + browserName);
        }
    }

    /**
     * Teardown method executed after each test.
     * Quits the browser if driver is not null.
     */
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Captures a screenshot and saves it to the screenshot path.
     *
     * @param driver WebDriver instance
     * @param screenshotName Name of the screenshot file (without extension)
     * @throws IOException if file operation fails
     */
    public void captureScreenShot(WebDriver driver, String screenshotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = ConfigUtil.screenshotPath() + "screenshots/" + screenshotName + ".png";
        File destination = new File(path);
        FileUtils.copyFile(source, destination);
    }

    /**
     * Checks if a file with partial name exists in the download directory.
     *
     * @param partialFileName Substring of the expected file name
     * @return true if a matching file is found, false otherwise
     */
    public boolean isFileDownloaded(String partialFileName) {
        File dir = new File(downloadPath);
        File[] files = dir.listFiles();
        if (files == null) return false;
        for (File file : files) {
            if (file.getName().contains(partialFileName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Clears the download directory by deleting all files within it.
     */
    public void clearDownloadDirectory() {
        File dir = new File(downloadPath);
        if (dir.exists()) {
            for (File file : dir.listFiles()) {
                file.delete();
            }
        }
    }
}
