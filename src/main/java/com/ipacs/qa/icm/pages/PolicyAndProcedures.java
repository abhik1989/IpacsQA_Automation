package com.ipacs.qa.icm.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ipacs.qa.baseclass.TestBase;
import com.ipacs.qa.utilities.TestUtil;

public class PolicyAndProcedures extends TestBase {
	
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
	
//Policies and Procedures
	@FindBy(xpath = "//a[normalize-space()='Policies and Procedures']")
	WebElement policiesandprocedures;

	public PolicyAndProcedures() 
	{
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}

	public void login(String pc, String un, String pwd) 
	{

		partnercode.sendKeys(TestUtil.getReadData("partnercode"));
		username.sendKeys(TestUtil.getReadData("username"));
		password.sendKeys(TestUtil.getReadData("password"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", submit);
	}


		
		public void clickPolicyAndProcedures() {
		    try {
		        // Wait until the element is clickable
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        WebElement policiesAndProcedures = wait.until(ExpectedConditions.elementToBeClickable(policiesandprocedures));
		        
		        // Click the element
		        policiesAndProcedures.click();
		        
		        // Take snapshot
		        TestUtil.takeSnapShot("Login Page/Policies and Procedures Screen");
		    } catch (Exception e) {
		        // Handle the exception (log or rethrow)
		        e.printStackTrace();
		    }
		}
	
		
	}
	
