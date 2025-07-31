package com.ipacs.qa.ecm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ipacs.qa.baseclass.TestBase;
import com.ipacs.qa.ecm.pages.ECM_Report;
import com.ipacs.qa.listeners.ExtentReportListener;
import com.ipacs.qa.utilities.FileUtil;
import com.ipacs.qa.utilities.WaitUtil;

@Listeners(ExtentReportListener.class)
public class ECM_ReportTest extends TestBase {

	// Create an instance of the class
	private ECM_Report ecmReport;;

	// This method will be executed before each test method in the class
	// It initializes the report object
	// The driver is already available in the TestBase class

	@BeforeMethod
	public void setUpPageObject() {
		ecmReport = new ECM_Report(); // driver is already available

	}

	@Test(priority = 1)
	// Scenario: Validate IPACS_ECM Login
	public void verifyIpacsEcmLoginPage() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		WaitUtil.waitForUrlContains(driver, "RampIPacs"); // use WaitUtil

		//
		String actualTitle = driver.getCurrentUrl();
		String expectedTitle = "https://ipacs-qa.azurewebsites.net/RampIPacs/Home?IsFromLogin=1";
		// Assert that the actual title matches the expected title
		Assert.assertEquals(actualTitle, expectedTitle, "The page title doesn't match the expected value!");
	}

	@Test(priority = 2)
	// Scenario: Verify Report Module
	public void verifyReportModule() throws InterruptedException {
		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();

	}

	@Test(priority = 3)
	// Scenario: Verify Approval List Report-> Current Approval List - Section

	public void verifyCurrentApprovalListSection() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.exportCurrentApprovalListSection();
		// Wait for the file to be downloaded
		WaitUtil.waitForSeconds(5); // Adjust the wait time as necessary

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(ecmReport.isFileDownloaded(downloadPath, "CurrentApprovalList-Section"),
				"Report file not downloaded!");
		FileUtil.clearDownloadDirectory(downloadPath);
	}

	@Test(priority = 4)
	// Scenario: Verify Approval List Report-> Approval List History - Section
	public void verifyApprovalListHistorySection() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.exportApprovalListHistorySection();
		// Wait for the file to be downloaded
		WaitUtil.waitForSeconds(5); // Adjust the wait time as necessary

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(ecmReport.isFileDownloaded(downloadPath, "ApprovalListHistory-Section"),
				"Report file not downloaded!");
		FileUtil.clearDownloadDirectory(downloadPath);
	}

	@Test(priority = 5)
	// Scenario: Verify Acknowlegment Report-> Current Acknowledgement
	public void verifyCurrentAcknowledgement() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.exportCurrentAcknowledgement();
		// Wait for the file to be downloaded
		WaitUtil.waitForSeconds(5); // Adjust the wait time as necessary

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(ecmReport.isFileDownloaded(downloadPath, "VendorCurrentCertification"),
				"Report file not downloaded!");
		FileUtil.clearDownloadDirectory(downloadPath);
	}

	@Test(priority = 6)
	// Scenario: Verify Acknowledgment Report-> Assigned Acknowledgement
	public void verifyAssignedAcknowledgement() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.exportAssignedAcknowledgement();
		// Wait for the file to be downloaded
		WaitUtil.waitForSeconds(5); // Adjust the wait time as necessary

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(ecmReport.isFileDownloaded(downloadPath, "VendorAssignedCertification"),
				"Report file not downloaded!");
		FileUtil.clearDownloadDirectory(downloadPath);
	}

	@Test(priority = 7)
	// Scenario: Verify Acknowledgment Report-> Acknowledgement History
	public void verifyAcknowledgementHistory() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.exportAcknowledgementHistory();
		// Wait for the file to be downloaded
		WaitUtil.waitForSeconds(5); // Adjust the wait time as necessary

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(ecmReport.isFileDownloaded(downloadPath, "VendorCertificationHistory"),
				"Report file not downloaded!");
		FileUtil.clearDownloadDirectory(downloadPath);
	}

	@Test(priority = 8)
	// Scenario: Verify Servicer Document Status Report-> select servicer
	public void verifyServicerDocumentStatusReport() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.exportServicerDocumentStatusReportbyServicer();
		// Wait for the file to be downloaded
		WaitUtil.waitForSeconds(5); // Adjust the wait time as necessary

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(ecmReport.isFileDownloaded(downloadPath, "ServicerDocumentStatus"),
				"Report file not downloaded!");
		FileUtil.clearDownloadDirectory(downloadPath);
	}

	@Test(priority = 9)
	// Scenario: Verify Servicer Document Status Report-> select servicerCategory
	public void verifyServicerDocumentStatusReportbyServicerCategory() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.exportServicerDocumentStatusReportbyServicerCategory();
		// Wait for the file to be downloaded
		WaitUtil.waitForSeconds(5); // Adjust the wait time as necessary

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(ecmReport.isFileDownloaded(downloadPath, "ServicerDocumentStatus"),
				"Report file not downloaded!");
		FileUtil.clearDownloadDirectory(downloadPath);
	}

	@Test(priority = 10)
	// Scenario: Verify Servicer Details Report-> select servicer
	public void verifyServicerDetailsReport() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.exportServicerDetailsReportbyServicer();
		// Wait for the file to be downloaded
		WaitUtil.waitForSeconds(5); // Adjust the wait time as necessary

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(ecmReport.isFileDownloaded(downloadPath, "ServicerDetails"), "Report file not downloaded!");
		FileUtil.clearDownloadDirectory(downloadPath);
	}

	@Test(priority = 11)
	// Scenario: Verify Servicer Details Report-> select servicerCategory
	public void verifyServicerDetailsReportbyServicerCategory() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.exportServicerDetailsReportbyServicerCategory();
		// Wait for the file to be downloaded
		WaitUtil.waitForSeconds(5); // Adjust the wait time as necessary

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(ecmReport.isFileDownloaded(downloadPath, "ServicerDetails"), "Report file not downloaded!");
		FileUtil.clearDownloadDirectory(downloadPath);
	}

	@Test(priority = 12)
	// Scenario: Verify approval list report page show entries
	public void verifyApprovalListReportPageShowEntries() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.verifyApprovalListReportPageShowEntries();

	}

	@Test(priority = 13)
	// Scenario: Verify approval list report page search
	public void verifyApprovalListReportPageSearch() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.verifyApprovalListReportPageSearch();

	}

	@Test(priority = 14)
	// Scenario: Verify pagination in approval list report page
	public void verifyApprovalListReportPagePagination() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.verifyApprovalListReportPagePagination();

	}

	@Test(priority = 15)
	// Scenario: Verify Acknowledgement-Reports-> Current Acknowledgement report
	// page show entries
	public void verifyAcknowledgementReportPageShowEntries() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.verifyAcknowledgementReportPageShowEntries();

	}

	@Test(priority = 16)
	// Scenario: Verify Acknowledgement-Reports Current Acknowledgement report page
	// search
	public void verifyAcknowledgementReportPageSearch() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.verifyAcknowledgementReportPageSearch();

	}

	@Test(priority = 17)
	// Scenario: Verify Acknowledgement-Reports Current Acknowledgement report page
	// pagination
	public void verifyAcknowledgementReportPagePagination() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.verifyAcknowledgementReportPagePagination();

	}

	@Test(priority = 18)
	// Scenario: Verify servicer document status report page show entries
	public void verifyServicerDocumentStatusReportPageShowEntries() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.verifyServicerDocumentStatusReportPageShowEntries();

	}

	@Test(priority = 19)
	// Scenario: Verify servicer document status report page search

	public void verifyServicerDocumentStatusReportPageSearch() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.verifyServicerDocumentStatusReportPageSearch();

	}

	@Test(priority = 20)
	// Scenario: Verify servicer document status report page pagination
	public void verifyServicerDocumentStatusReportPagePagination() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.verifyServicerDocumentStatusReportPagePagination();

	}

	@Test(priority = 21)
	// Scenario: Verify Servicer Document Status Report- Validation message
	// unchecked servicer option
	public void verifyValidationMessageUncheckedServicerOption() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.verifyValidationMessageUncheckedServicerOption();

	}

	@Test(priority = 22)
	// Scenario: Verify Servicer Document Status Report- Validation message
	// unchecked all checkbox
	public void verifyValidationMessageUncheckedAllchkbox() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.verifyValidationMessageUncheckedAllchkbox();

	}

	@Test(priority = 23)
	// Scenario: Verify Servicer Document Status Report- Validation message
	// unchecked servicer category all checkbox
	public void verifyValidationMessageUncheckedServicerCategoryAllchkbox() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.verifyValidationMessageUncheckedServicerCategoryAllchkbox();

	}

	@Test(priority = 24)
	// Scenario: Verify Servicer Details Report- Validation message empty servicer
	// name
	public void verifyValidationMessageEmptyServicerName() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.verifyValidationMessageEmptyServicerName();

	}
	
	@Test(priority = 25)
	// Scenario: Verify Servicer Details Report- Validation message empty servicer
	// category
	public void verifyValidationMessageEmptyServicerCategory() throws InterruptedException {

		ecmReport.login("partnercode", "username", "password");
		ecmReport.clickReportMenu();
		ecmReport.verifyValidationMessageEmptyServicerCategory();

	}
	


}
