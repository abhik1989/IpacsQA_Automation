package com.ipacs.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ipacs.qa.baseclass.TestBase;

public class ScreenshotUtil extends TestBase {

	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		// ✅ Use modern, locale-safe timestamp format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		String dateTime = LocalDateTime.now().format(formatter);

		String fileName = screenshotName + "_" + dateTime + ".png";
		String destination = System.getProperty("user.dir") + "/test-output/screenshots/" + fileName;
		File finalDestination = new File(destination);

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destination;
	}
}

/*
 * Pre-used code package com.ipacs.qa.utilities;
 * 
 * import java.io.File; import java.io.IOException; import
 * java.text.SimpleDateFormat; import java.util.Date;
 * 
 * import org.apache.commons.io.FileUtils; import
 * org.openqa.selenium.OutputType; import org.openqa.selenium.TakesScreenshot;
 * import org.openqa.selenium.WebDriver;
 * 
 * import com.ipacs.qa.baseclass.TestBase;
 * 
 * public class ScreenshotUtil extends TestBase {
 * 
 * public static String captureScreenshot(WebDriver driver, String
 * screenshotName) { String dateName = new
 * SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); TakesScreenshot ts =
 * (TakesScreenshot) driver; File source = ts.getScreenshotAs(OutputType.FILE);
 * 
 * String destination = System.getProperty("user.dir") +
 * "/test-output/screenshots/" + screenshotName + "_" + dateName + ".png"; File
 * finalDestination = new File(destination);
 * 
 * try { FileUtils.copyFile(source, finalDestination); } catch (IOException e) {
 * e.printStackTrace(); }
 * 
 * return destination; } }
 */