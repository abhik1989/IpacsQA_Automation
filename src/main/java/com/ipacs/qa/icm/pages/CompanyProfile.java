package com.ipacs.qa.icm.pages;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ipacs.qa.baseclass.TestBase;
import com.ipacs.qa.utilities.ConfigUtil;
import com.ipacs.qa.utilities.ExcelReader;
import com.ipacs.qa.utilities.TestUtil;

public class CompanyProfile extends TestBase {
	
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
	
	@FindBy(xpath = "//a[normalize-space()='Policies and Procedures']")
	WebElement policiesandprocedures;
	
	@FindBy(xpath = "//a[normalize-space()='Documentation']")
	WebElement clickDocumentation;
	
	@FindBy(xpath = "//div[@class='btn addnewlicensedocbtn']")
	WebElement UploadNewDocument;

	@FindBy(xpath = "//select[@name='tl_document_display_length']")
	WebElement showentries;
	
	


	public CompanyProfile() 
	{
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}

	public void login(String pc, String un, String pwd) {
    	Map<String, String> testData = ExcelReader.readKeyValueFromExcel(
    	        ConfigUtil.getTestDataFilePath(), 
    	        "TestData"
    	    );

        partnercode.sendKeys(testData.get("partnerCode"));
        username.sendKeys(testData.get("username"));
        password.sendKeys(testData.get("password"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
    }

	public void companyprofile() throws InterruptedException 
	{
		companyprofile.click();
		Thread.sleep(3000);
		//updatecompanyprofile.click();
		//Thread.sleep(5000);
		try {
			TestUtil.takeSnapShot("Login Page/Update Company Profile Screen");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	  public void verifyDocumentationPage() throws InterruptedException 
	  {
		  
	  //companyprofile.click(); 
	  //Thread.sleep(3000); 
	  clickDocumentation. click();
	  Thread.sleep(3000);
	  UploadNewDocument.click();
	  Thread.sleep(5000);
	  Select showentriesSelect = new Select(showentries);
	  showentriesSelect.selectByValue("50");
	  Thread.sleep(8000);
	  }


	  
	  
	  
	 
	}
