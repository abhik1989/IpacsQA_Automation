package com.ipacs.qa.utilities;

import java.awt.*;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserUtil {

    public static WebDriver launchChromeOnExtendedScreen() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Set your actual path

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);

        // Use AWT to detect extended screen
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screens = ge.getScreenDevices();

        if (screens.length > 1) {
            int primaryWidth = screens[0].getDisplayMode().getWidth();
            int secondWidth = screens[1].getDisplayMode().getWidth();
            int secondHeight = screens[1].getDisplayMode().getHeight();

            driver.manage().window().setPosition(new Point(primaryWidth + 10, 0));
            driver.manage().window().setSize(new Dimension(secondWidth, secondHeight));
        } else {
            System.out.println("⚠️ Only one screen detected. Running on primary screen.");
        }

        return driver;
    }
}
