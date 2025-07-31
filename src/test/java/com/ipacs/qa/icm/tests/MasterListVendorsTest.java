package com.ipacs.qa.icm.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ipacs.qa.baseclass.TestBase;
import com.ipacs.qa.icm.pages.MasterListVendors;
import com.ipacs.qa.listeners.ExtentReportListener;
import com.ipacs.qa.utilities.*;

@Listeners(ExtentReportListener.class)
public class MasterListVendorsTest extends TestBase {

	// Create an instance of the MasterListVendors class
	private MasterListVendors masterlistvendors;

	// This method will be executed before each test method in the class
	// It initializes the masterlistvendors object
	// The driver is already available in the TestBase class

	@BeforeMethod
	public void setUpPageObject() {
		masterlistvendors = new MasterListVendors(); // driver is already available

	}

	@Test(priority = 1)

	// Scenario: Validate IPACS User Login
	public void verifyIpacsLoginPage() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");
		WaitUtil.waitForUrlContains(driver, "Home/Index"); // use WaitUtil

		//
		String actualTitle = driver.getCurrentUrl();
		String expectedTitle = "https://ipacs-qa.azurewebsites.net/Home/Index?IsFromLogin=1";
		// Assert that the actual title matches the expected title
		Assert.assertEquals(actualTitle, expectedTitle, "The page title doesn't match the expected value!");
	}

	@Test(priority = 2)

	// Validate Master List Vendors Menu
	public void verifyMasterListVendors() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");

		masterlistvendors.clickMasterListMenu();

	}

	 @Test(priority = 3)

	// Scenario: User Add Vendor Category via Master List Vendor
	public void verifyAddVendorCategoryInMasterListVendors() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");
		masterlistvendors.clickMasterListMenu();
		masterlistvendors.clickAddVendorCategory();
		masterlistvendors.enterDetailsAddVendorCategoryInMasterListVendor();
		masterlistvendors.clickBtnSubmitInMasterListVendor();
		masterlistvendors.verifyTxtAddSuccessfullyMsgInMasterListVendor();

	}

	@Test(priority = 4)
	// Validate View Master List Menu
	public void verifyViewMasterList() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");

		masterlistvendors.clickMasterListMenu();
		masterlistvendors.clickViewMasterList();

		String actualTitle = driver.getCurrentUrl();
		String expectedTitle = "https://ipacs-qa.azurewebsites.net/CCMS/ViewVendors";
		// Assert that the actual title matches the expected title
		Assert.assertEquals(actualTitle, expectedTitle, "The page title doesn't match the expected value!");
	}

	@Test(priority = 5)
	// Scenario: User verifies Show Entries in View Master List under Master List

	public void verifyShowEntriesInViewMasterList() throws InterruptedException {

		try {
			// Log in using the partner code, username, and password
			masterlistvendors.login("partnercode", "username", "password");

			// Navigate to the master list menu
			masterlistvendors.clickMasterListMenu();

			// Click to view the master list
			masterlistvendors.clickViewMasterList();

			// Show the entries in the view master list
			masterlistvendors.ShowEntriesInViewMasterList();

		} catch (Exception e) {
			// Log the exception or handle it based on your framework's logging strategy
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
	}

	@Test(priority = 6)
	// Scenario: User Verifies sorting of all columns present on the view Master
	// List grid (ascending/descending ) under Master List Vendor

	public void verifySortingInViewMasterList() throws InterruptedException {

		// Log in using the partner code, username, and password
		masterlistvendors.login("partnercode", "username", "password");

		// Navigate to the master list menu
		masterlistvendors.clickMasterListMenu();

		// Click to view the master list
		masterlistvendors.clickViewMasterList();
		WaitUtil.waitForSeconds(5);

		// Sort the entries in the view master list by Vendor Name
		masterlistvendors.sortingByVendorName();

	}

	//@Test(priority = 7)

	// Validate Sorting in View Master List by Vendor Category
	public void verifySortingByVendorCategory() throws InterruptedException {

		// Log in using the partner code, username, and password
		masterlistvendors.login("partnercode", "username", "password");

		// Navigate to the master list menu
		masterlistvendors.clickMasterListMenu();

		// Click to view the master list
		masterlistvendors.clickViewMasterList();

		// Sort the entries in the view master list
		masterlistvendors.sortingVendorCategoryInAscending();
		masterlistvendors.sortingVendorCategoryInDescending();
	}

	@Test(priority = 8)
	// Validate Sorting in View Master List by Status
	public void verifySortingByStatus() throws InterruptedException {

		// Log in using the partner code, username, and password
		masterlistvendors.login("partnercode", "username", "password");

		// Navigate to the master list menu
		masterlistvendors.clickMasterListMenu();

		// Click to view the master list
		masterlistvendors.clickViewMasterList();

		// Sort the entries in the view master list
		// masterlistvendors.sortingByStatus();
		masterlistvendors.sortingStatusInAscending();
		masterlistvendors.sortingStatusInDescending();

	}

	@Test(priority = 9)

	// Scenario: User verifies Search text box in View Master List under Master List
	// Vendor
	public void searchInViewMasterList() throws InterruptedException {

		// Log in using the partner code, username, and password
		masterlistvendors.login("partnercode", "username", "password");

		// Navigate to the master list menu
		masterlistvendors.clickMasterListMenu();

		// Click to view the master list
		masterlistvendors.clickViewMasterList();

		// Search in the view master list
		masterlistvendors.searchInViewMasterList();

	}

	@Test(priority = 10)

	// Validate Pagination in View Master List
	public void verifyPaginationInViewMasterList() throws InterruptedException {

		// Log in using the partner code, username, and password
		masterlistvendors.login("partnercode", "username", "password");

		// Navigate to the master list menu
		masterlistvendors.clickMasterListMenu();

		// Click to view the master list
		masterlistvendors.clickViewMasterList();

		// Verify pagination in the view master list
		masterlistvendors.paginationInViewMasterList();

	}

	@Test(priority = 11)
	// Scenario: User edit and verifies Vendor Name Hyperlink in View Master List
	// under Master List Vendor

	public void editandverifyVendorNameHyperlinkInviewMasterList() throws InterruptedException {

		// Log in using the partner code, username, and password
		masterlistvendors.login("partnercode", "username", "password");

		// Navigate to the master list menu
		masterlistvendors.clickMasterListMenu();

		// Click to view the master list
		masterlistvendors.clickViewMasterList();

		// Edit vendor name hyperlink in the view master list
		masterlistvendors.clickVendorNameHyperlinkInViewMasterList();

	}

	@Test(priority = 12)

	// Scenario: User verifies Edit Vendor Name in View Master List under Master
	// List Vendor

	public void verifyEditVendorNameInViewMasterList() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");

		masterlistvendors.clickMasterListMenu();
		masterlistvendors.clickViewMasterList();
		masterlistvendors.searchInViewMasterList();

	}

	@Test(priority = 13)

	// Scenario: User Add Vendor via Master List Vendor
	public void verifyAddVendorInMasterListVendors() throws InterruptedException, IOException {

		masterlistvendors.login("partnercode", "username", "password");

		masterlistvendors.clickMasterListMenu();

		masterlistvendors.clickAddVendor();

		masterlistvendors.enterDetailsAddVendorInMasterListVendor();

		masterlistvendors.verifyTxtVendorAddSuccessfullyMsgInAddVendorPage();

	}

	@Test(priority = 14)
	// Scenario Outline: User verifies Search text box in View Master List under
	// Master List Vendor (Vendor Category)

	public void searchInViewMasterListVendorCategory() throws InterruptedException {

		// Log in using the partner code, username, and password
		masterlistvendors.login("partnercode", "username", "password");

		// Navigate to the master list menu
		masterlistvendors.clickMasterListMenu();

		// Click to view the master list
		masterlistvendors.clickViewMasterList();

		// Search in the view master list
		masterlistvendors.searchInViewMasterListVendorCategory();

	}

	@Test(priority = 15)

	// Scenario Outline: User click and verifies Vendor Category Name Hyperlink in
	// View Master List under Master List Vendor

	public void clickandverifyVendorCategoryNameHyperlinkInviewMasterList() throws InterruptedException {

		// Log in using the partner code, username, and password
		masterlistvendors.login("partnercode", "username", "password");

		// Navigate to the master list menu
		masterlistvendors.clickMasterListMenu();

		// Click to view the master list
		masterlistvendors.clickViewMasterList();

		// Edit vendor name hyperlink in the view master list
		masterlistvendors.clickVendorCategoryHyperlinkInViewMasterList();

		masterlistvendors.iShouldSeeTheVendorCategoryPageSubTabUnderMasterListVendor();
	}

	// Scenario: User Verifies sorting of all columns present of the VendorCategory
	// grid (ascending/descending )
	@Test(priority = 16)
	public void verifySortingInVendorCategory() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");

		// Navigate to the master list menu
		masterlistvendors.clickMasterListMenu();

		// Click to view the master list
		masterlistvendors.clickViewMasterList();

		masterlistvendors.clickVendorCategoryHyperlinkInViewMasterList(); // sorting of all columns present on the
																			// VendorCategory grid

		masterlistvendors.sortingVendorName();
		masterlistvendors.sortingStatus();

	}

	@Test(priority = 17)
	// Scenario: User verifies Drop down and Search text box in VendorCategory page
	// under Master List Vendor

	public void verifyDropDownAndSearchTextBoxInVendorCategoryPage() throws InterruptedException {

		// Log in using the partner code, username, and password
		masterlistvendors.login("partnercode", "username", "password");

		// Navigate to the master list menu
		masterlistvendors.clickMasterListMenu();

		// Click to view the master list
		masterlistvendors.clickViewMasterList();

		masterlistvendors.clickVendorCategoryHyperlinkInViewMasterList();

		masterlistvendors.selectValueFromDropDownInVendorCategoryPage();

		masterlistvendors.searchInVendorCategoryPage();

		masterlistvendors.verifySearchResult();

	}

	@Test(priority = 18)

	// Scenario: verify validation message on Vendor Category page without input
	// required fields

	public void verifyValidationMessageOnVendorCategoryPage() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");

		masterlistvendors.clickMasterListMenu();

		masterlistvendors.clickAddVendorCategory();

		masterlistvendors.clickBtnSubmitInMasterListVendor();

		// Verify the validation message
		WebElement catNameMsg = driver.findElement(By.xpath("//label[@id='catname-error']"));
		WebElement NoOfComplaintsToChiefOfficersMsg = driver
				.findElement(By.xpath("//label[@id='NoOfComplaintsToChiefOfficers-error']"));
		WebElement NoOfComplaintsToComplaintManagerMsg = driver
				.findElement(By.xpath("//label[@id='NoOfComplaintsToComplaintManager-error']"));

		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(catNameMsg.getText().trim(), "Please provide a name for vendor category.",
				"Validation message mismatch!");
		assertion.assertEquals(NoOfComplaintsToChiefOfficersMsg.getText().trim(),
				"Please enter number of complaints, after which Chief Compliance Officer will be notified.",
				"Validation message mismatch!");
		assertion.assertEquals(NoOfComplaintsToComplaintManagerMsg.getText().trim(),
				"Please enter number of complaints, after which Complaint Manager will be notified.",
				"Validation message mismatch!");
		assertion.assertAll();
	}

	@Test(priority = 19)

// Scenario: verify validation message on Add Vendor page without input required fields
	public void verifyValidationMessageOnAddVendorPage() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");

		masterlistvendors.clickMasterListMenu();

		masterlistvendors.clickAddVendor();

		masterlistvendors.clickSubmitOnAddVendorPage();

		// Verify the validation message
		WebElement vendorNameMsg = driver.findElement(By.xpath("//label[@id='name-error']"));
		WebElement vendorCategoryMsg = driver.findElement(By.xpath("//label[@id='serviceCategory-error']"));
		WebElement statusMsg = driver.findElement(By.xpath("//label[@id='status-error']"));
		WebElement contactAtFirm = driver.findElement(By.xpath("//label[@id='contactAtFirm-error']"));

		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(vendorNameMsg.getText().trim(), "Please enter vendor Name.",
				"Validation message mismatch!");
		assertion.assertEquals(vendorCategoryMsg.getText().trim(), "Please select vendor Category.",
				"Validation message mismatch!");
		assertion.assertEquals(statusMsg.getText().trim(), "Please select Status.", "Validation message mismatch!");
		assertion.assertEquals(contactAtFirm.getText().trim(), "Please select vendor contact at company.",
				"Validation message mismatch!");
		assertion.assertAll();
	}

	@Test(priority = 20)

	// Scenario Outline: User verifies Manage Complaint Alerts sub tab in
	// VendorCategory page under Master List Vendor

	public void verifyManageComplaintAlertsSubTabInVendorCategoryPage() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");

		masterlistvendors.clickMasterListMenu();

		masterlistvendors.clickViewMasterList();

		masterlistvendors.clickVendorCategoryHyperlinkInViewMasterList();

		masterlistvendors.verifyManageComplaintAlertsSubTabInVendorCategoryPage();

	}

	@Test(priority = 21)

	// Scenario: User verifies show entries in Vendor List tab in VendorCategory
	// page

	public void verifyShowEntriesInVendorListTabInVendorCategoryPage() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");

		masterlistvendors.clickMasterListMenu();

		masterlistvendors.clickViewMasterList();

		masterlistvendors.clickVendorCategoryHyperlinkInViewMasterList();

		masterlistvendors.verifyShowEntriesInVendorListTabInVendorCategoryPage();

	}

	@Test(priority = 22)
	// Scenario: User verifies search in the Vendor List tab

	public void verifySearchInVendorListTabInVendorCategoryPage() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");

		masterlistvendors.clickMasterListMenu();

		masterlistvendors.clickViewMasterList();

		masterlistvendors.clickVendorCategoryHyperlinkInViewMasterList();

		masterlistvendors.verifySearchInVendorListTabInVendorCategoryPage();

		masterlistvendors.verifySearchResult();

	}

	@Test(priority = 23)
	// Scenario: User verifies sorting of all columns present on the Vendor List tab

	public void verifySortingInVendorListTabInVendorCategoryPage() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");

		masterlistvendors.clickMasterListMenu();

		masterlistvendors.clickViewMasterList();

		masterlistvendors.clickVendorCategoryHyperlinkInViewMasterList();

		masterlistvendors.verifySortingInVendorListTabInVendorCategoryPage();

	}

	@Test(priority = 24)
	// Scenario: User verifies pagination in Vendor List tab in VendorCategory page
	public void verifyPaginationInVendorListTabInVendorCategoryPage() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");

		masterlistvendors.clickMasterListMenu();

		masterlistvendors.clickViewMasterList();

		masterlistvendors.clickVendorCategoryHyperlinkInViewMasterList();

		masterlistvendors.verifyPaginationInVendorListTabInVendorCategoryPage();

	}

	@Test(priority = 25)
	// Scenario: User verifies validation message on Manage Complaint Alerts page
	//// without input required fields
	public void verifyValidationMessageOnManageComplaintAlertsPage() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");

		masterlistvendors.clickMasterListMenu();

		masterlistvendors.clickViewMasterList();

		masterlistvendors.clickVendorCategoryHyperlinkInViewMasterList();

		masterlistvendors.verifyManageComplaintValidation();

		// Verify the validation message
		WebElement NoOfComplaintsToChiefOfficer = driver
				.findElement(By.xpath("//label[@id='NoOfComplaintsToChiefOfficer-error']"));
		WebElement NoOfComplaintsToManagingPartner = driver
				.findElement(By.xpath("//label[@id='NoOfComplaintsToManagingPartner-error']"));

		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(NoOfComplaintsToChiefOfficer.getText().trim(),
				"Please enter number of complaints, after which Chief compliance Officer will be notified.",
				"Validation message mismatch!");
		assertion.assertEquals(NoOfComplaintsToManagingPartner.getText().trim(),
				"Please enter number of complaints, after which Complaint Manager will be notified.",
				"Validation message mismatch!");

		assertion.assertAll();
	}

	@Test(priority = 26)
	// Scenario: User verifies search in view Master List Page with Invalid data
	public void verifySearchInViewMasterListWithInvalidData() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");

		masterlistvendors.clickMasterListMenu();

		masterlistvendors.clickViewMasterList();

		masterlistvendors.searchInViewMasterListWithInvalidData();

		// Verify the validation message
		WebElement noRecordsFound = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(noRecordsFound.getText().trim(), "No matching records found",
				"Validation message mismatch!");

	}

	@Test(priority = 27)
	// Scenario: User verifies Inactive Vendor in View Master List Page
	public void verifyInactiveVendorInViewMasterList() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");

		masterlistvendors.clickMasterListMenu();

		masterlistvendors.clickViewMasterList();

		masterlistvendors.verifyInactiveVendorInViewMasterList();

	}

	@Test(priority = 28)
	// Scenario: User verifies active Vendor in View Master List Page
	public void verifyActiveVendorInViewMasterList() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");

		masterlistvendors.clickMasterListMenu();

		masterlistvendors.clickViewMasterList();

		masterlistvendors.verifyActiveVendorInViewMasterList();

	}

	@Test(priority = 29)
	// Scenario: User verifies sorting result in View Master List Page using vendor
	// name
	public void verifySortingResultInViewMasterListUsingVendorName() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");
		masterlistvendors.clickMasterListMenu();
		masterlistvendors.clickViewMasterList();
		masterlistvendors.displayVendorNameListBeforeSorting();
		masterlistvendors.sortedOrderResultByVendorNameInAscending();
	}

	@Test(priority = 30)
	// Scenario: User verifies sorting result in View Master List Page using vendor
	// category
	public void verifySortingResultInViewMasterListUsingVendorCategory() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");
		masterlistvendors.clickMasterListMenu();
		masterlistvendors.clickViewMasterList();
		masterlistvendors.sortingVendorCategoryInAscending();
		masterlistvendors.sortingVendorCategoryInDescending();

	}

	@Test(priority = 31)
	// Scenario: User verifies sorting result in View Master List Page using status
	public void verifySortingResultInViewMasterListUsingStatus() throws InterruptedException {

		masterlistvendors.login("partnercode", "username", "password");
		masterlistvendors.clickMasterListMenu();
		masterlistvendors.clickViewMasterList();
		masterlistvendors.sortingStatusInAscending();
		masterlistvendors.sortingStatusInDescending();

	}

}
