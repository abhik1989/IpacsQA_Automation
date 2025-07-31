package com.ipacs.qa.icm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ipacs.qa.baseclass.TestBase;
import com.ipacs.qa.icm.pages.VendorManagement;

public class VendorManagementTest extends TestBase {

	VendorManagement vendormanagement;



	@BeforeMethod
    public void setUpPageObject() {
		vendormanagement = new VendorManagement(); // driver is already available
	}

	@Test(priority = 1)

	// Scenario: Validate IPACS User Login
	public void verifyIpacsLoginPage() throws InterruptedException {

		vendormanagement.login("partnercode", "username", "password");
		Thread.sleep(2000);
		String actualTitle = driver.getCurrentUrl();
		String expectedTitle = "https://ipacs-qa.azurewebsites.net/Home/Index?IsFromLogin=1";
		// Assert that the actual title matches the expected title
		Assert.assertEquals(actualTitle, expectedTitle, "The page title doesn't match the expected value!");
	}

	// Validate Vendor Managemnt Menu
	public void verifyVendorManagement() throws InterruptedException {
		vendormanagement.login("partnercode", "username", "password");
		Thread.sleep(2000);
		vendormanagement.clickVendorManagement();
		Thread.sleep(2000);
	
	}
	
	//@Test(priority = 2)
	//Scenario: User Add Vendor Category via Vendor Management
	
			public void verifyAddVendorCategoryInVendorManagement() throws InterruptedException {
				vendormanagement.login("partnercode", "username", "password");
				Thread.sleep(2000);
				vendormanagement.clickVendorManagement();
				vendormanagement.clickAddVendorCategory();
				// Thread.sleep(2000);
				vendormanagement.enterDetailsInAddVendorCategory();
				Thread.sleep(2000);
				vendormanagement.addvendorcategoryButton();
				vendormanagement.verifyTxtAddSuccessfullyMsg();
			}
/*
		
	
//@Test(priority = 3)
	 //Scenario: User Add Vendor and Document via Vendor Management
	public void verifyAddVendorAndDocumentInVendorManagement() throws InterruptedException {
		vendormanagement.login("partnercode", "username", "password");
		Thread.sleep(2000);
		vendormanagement.clickVendorManagement();
		Thread.sleep(2000);
		vendormanagement.clickAddVendor();
		Thread.sleep(2000);
		vendormanagement.enterDetailsInAddVendorPage();
		Thread.sleep(2000);
		vendormanagement.UploadDocumentsBtn();
		Thread.sleep(2000);
		vendormanagement.verifyAddSuccessfullyMsg();

	}
	*/



	
}
