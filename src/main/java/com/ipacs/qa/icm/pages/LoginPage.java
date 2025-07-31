package com.ipacs.qa.icm.pages;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ipacs.qa.baseclass.TestBase;
import com.ipacs.qa.utilities.ConfigUtil;
import com.ipacs.qa.utilities.ExcelReader;
import com.ipacs.qa.utilities.TestUtil;

public class LoginPage extends TestBase {
	@FindBy(id = "partnerCode")
	WebElement partnercode;
	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "Password")
	WebElement password;
	@FindBy(id = "Login")
	WebElement submit;

///Logout///
	@FindBy(xpath = "//div[@class='headmenu right']")
	WebElement logout;
	@FindBy(xpath = "//a[normalize-space()='Log Out']")
	WebElement logoutclick;

////Company Profile///
	@FindBy(xpath = "//a[@href='/CompanyProfile/Index']")
	WebElement companyprofile;

	@FindBy(xpath = "//a[normalize-space()='Update Company Profile']")
	WebElement updatecompanyprofile;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {

		return driver.getTitle();

	}

	public void login(String pc, String un, String pwd) {
		Map<String, String> testData = ExcelReader.readKeyValueFromExcel(ConfigUtil.getTestDataFilePath(), "TestData");

		partnercode.sendKeys(testData.get("partnerCode"));
		username.sendKeys(testData.get("username"));
		password.sendKeys(testData.get("password"));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
	}

	public void logout() throws InterruptedException {
		logout.click();
		Thread.sleep(3000);
		try {
			TestUtil.takeSnapShot("Login Page/Logout Screen");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logoutclick.click();

	}

	public void companyprofile() throws InterruptedException {
		companyprofile.click();
		Thread.sleep(3000);
		try {
			TestUtil.takeSnapShot("Login Page/Company Profile Screen");
		} catch (Exception e) {
			e.printStackTrace();
		}
		updatecompanyprofile.click();
		Thread.sleep(5000);
		try {
			TestUtil.takeSnapShot("Login Page/Update Company Profile Screen");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
