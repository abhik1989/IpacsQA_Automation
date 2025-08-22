package com.ipacs.qa.ecm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ipacs.qa.baseclass.TestBase;
import com.ipacs.qa.ecm.pages.ECM_AdminSection;
import com.ipacs.qa.listeners.ExtentReportListener;
import com.ipacs.qa.utilities.WaitUtil;

// This class is a test class for the ECM Admin Section
@Listeners(ExtentReportListener.class)
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

	@Test(priority = 1)
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

	@Test(priority = 2)
	// Scenario: Validate Admin Section Link
	public void verifyAdminSectionLink() {
		ecm_AdminSection.login();
		WaitUtil.waitForSeconds(3);
		ecm_AdminSection.navigateToAdminSection();

	}

	@Test(priority = 3)
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

	@Test(priority = 5)
	// Scenario: Validate Edit User functionality
	public void verifyEditUserFunctionality() {
		ecm_AdminSection.login();
		ecm_AdminSection.navigateToAdminSection();
		ecm_AdminSection.EditUser();
		WaitUtil.waitForSeconds(3);
		ecm_AdminSection.verifyUserEdited();
	}

	@Test(priority = 6)
	// Scenario: User performs sorting of all columns present on the user Details
	// page (ascending/descending )

	public void verifyUserDetailsSorting() {
		ecm_AdminSection.login();
		ecm_AdminSection.navigateToAdminSection();
		ecm_AdminSection.sortUserDetails();
		WaitUtil.waitForSeconds(3);
		ecm_AdminSection.verifyUserDetailsSorted();

	}

	@Test(priority = 7)
	// Scenario: Validate show entries on User Details page
	public void verifyShowEntriesOnUserDetailsPage() {
		ecm_AdminSection.login();
		ecm_AdminSection.navigateToAdminSection();
		ecm_AdminSection.showEntries();
		WaitUtil.waitForSeconds(3);
		ecm_AdminSection.verifyShowEntries();

	}

	@Test(priority = 8)
	// Scenario: Validate Search User functionality
	public void verifySearchUserFunctionality() {
		ecm_AdminSection.login();
		ecm_AdminSection.navigateToAdminSection();
		ecm_AdminSection.searchUser();
		WaitUtil.waitForSeconds(3);
		ecm_AdminSection.verifySearchUser();
	}

	@Test(priority = 9)
	// Scenario:User verifies Fields in User Logs Page under IPACS Administration
	public void verifyUserLogsPageFields() {
		ecm_AdminSection.login();
		ecm_AdminSection.navigateToAdminSection();
		ecm_AdminSection.navigateToIpacsAdministration();
		ecm_AdminSection.clickUserLogsLink();
		ecm_AdminSection.verifyUserLogsPageFields();
		WaitUtil.waitForSeconds(3);
	}

	@Test(priority = 10)
	// Scenario:User verifies Search box in User Logs Page under IPACS
	// Administration
	public void verifySearchBoxInUserLogsPage() {
		ecm_AdminSection.login();
		ecm_AdminSection.navigateToAdminSection();
		ecm_AdminSection.navigateToIpacsAdministration();
		ecm_AdminSection.clickUserLogsLink();
		ecm_AdminSection.verifySearchBoxInUserLogsPage();
		WaitUtil.waitForSeconds(3);
	}

	@Test(priority = 11)
	// Scenario:User verifies Fields in User Login History under IPACS
	// Administration
	public void verifyUserLoginHistoryFields() {
		ecm_AdminSection.login();
		ecm_AdminSection.navigateToAdminSection();
		ecm_AdminSection.navigateToIpacsAdministration();
		ecm_AdminSection.clickUserLoginHistoryLink();
		ecm_AdminSection.verifyUserLoginHistoryFields();
		WaitUtil.waitForSeconds(3);
	}

	@Test(priority = 12)
	// Scenario:User verifies Search box in User Login History under IPACS
	// Administration
	public void verifySearchBoxInUserLoginHistory() {
		ecm_AdminSection.login();
		ecm_AdminSection.navigateToAdminSection();
		ecm_AdminSection.navigateToIpacsAdministration();
		ecm_AdminSection.clickUserLoginHistoryLink();
		ecm_AdminSection.verifySearchBoxInUserLoginHistory();
		WaitUtil.waitForSeconds(3);
	}

	@Test(priority = 13)
	// Scenario:Edit user having roles "User"

	public void verifyEditUserWithUserRole() {
		ecm_AdminSection.login();
		ecm_AdminSection.navigateToAdminSection();
		WaitUtil.waitForSeconds(5);
		ecm_AdminSection.EditUserWithUserRole();
		WaitUtil.waitForSeconds(5);
		ecm_AdminSection.verifyUserEditedWithUserRole();
	}

	
	//@Test(priority = 14)
	// Scenario:Edit user having roles "Admin"
}