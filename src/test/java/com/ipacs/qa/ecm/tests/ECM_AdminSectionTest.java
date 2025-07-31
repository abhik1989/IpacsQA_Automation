package com.ipacs.qa.ecm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ipacs.qa.baseclass.TestBase;
import com.ipacs.qa.ecm.pages.ECM_AdminSection;
import com.ipacs.qa.utilities.WaitUtil;

public class ECM_AdminSectionTest extends TestBase {
	
	// Create an instance of the Report class
	private ECM_AdminSection ecm_AdminSection;

		// This method will be executed before each test method in the class
		// It initializes the report object
		// The driver is already available in the TestBase class

		@BeforeMethod
		public void setUpPageObject() {
			ecm_AdminSection = new ECM_AdminSection(); // driver is already available

		}

		//@Test(priority = 1)
		// Scenario: Validate IPACS_ECM Login
		public void verifyIpacsLoginPage() {

			ecm_AdminSection.login();
			WaitUtil.waitForUrlContains(driver, "RampIPacs"); // use WaitUtil

			//
			String actualTitle = driver.getCurrentUrl();
			String expectedTitle = "https://ipacs-qa.azurewebsites.net/RampIPacs/Home?IsFromLogin=1";
			// Assert that the actual title matches the expected title
			Assert.assertEquals(actualTitle, expectedTitle, "The page title doesn't match the expected value!");
		}
		
		
		//@Test(priority = 2)
		// Scenario: Validate Admin Section Link
		public void verifyAdminSectionLink() {
			ecm_AdminSection.login();
			WaitUtil.waitForSeconds(3);
			ecm_AdminSection.navigateToAdminSection();

		}
		
		//@Test(priority = 3)
		// Scenario: Validate Add new user Page UI
		public void verifyAddNewUserPageUI() {
			ecm_AdminSection.login();
			ecm_AdminSection.navigateToAdminSection();
			ecm_AdminSection.clickAddNewUserLink();
			ecm_AdminSection.verifyNewUserPageUI();
			WaitUtil.waitForSeconds(3);
		
		}
		
		
		@Test(priority = 4)
		// Scenario: Validate Add new user functionality
		public void verifyAddNewUserFunctionality() {
			ecm_AdminSection.login();
			ecm_AdminSection.navigateToAdminSection();
			ecm_AdminSection.clickAddNewUserLink();
			ecm_AdminSection.addNewUser();
			WaitUtil.waitForSeconds(3);
			ecm_AdminSection.verifyNewUserAdded();
		}
		

}