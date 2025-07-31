package com.ipacs.qa.icm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ipacs.qa.baseclass.TestBase;
import com.ipacs.qa.icm.pages.Report;
import com.ipacs.qa.listeners.ExtentReportListener;
import com.ipacs.qa.utilities.FileUtil;
import com.ipacs.qa.utilities.WaitUtil;

@Listeners(ExtentReportListener.class) // Assuming you have an ExtentReportListener class for reporting
public class ReportTest extends TestBase {

	// Create an instance of the Report class
	private Report report;

	// This method will be executed before each test method in the class
	// It initializes the report object
	// The driver is already available in the TestBase class

	@BeforeMethod
	public void setUpPageObject() {
		report = new Report(); // driver is already available

	}

	//@Test(priority = 1)
	// Scenario: Validate IPACS User Login
	public void verifyIpacsLoginPage() throws InterruptedException {

		report.login("partnercode", "username", "password");
		WaitUtil.waitForUrlContains(driver, "Home/Index"); // use WaitUtil

		//
		String actualTitle = driver.getCurrentUrl();
		String expectedTitle = "https://ipacs-qa.azurewebsites.net/Home/Index?IsFromLogin=1";
		// Assert that the actual title matches the expected title
		Assert.assertEquals(actualTitle, expectedTitle, "The page title doesn't match the expected value!");
	}

	//@Test(priority = 2)

	// Validate Report Menu
	public void verifyReportMenu() throws InterruptedException {
		System.out.println("Starting Report Menu Test");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();

	}

	//@Test(priority = 3)
	// Validate Certification Report SOP Tab and Current Certification
	public void verifySOPCurrentCertificationReport() throws InterruptedException {
		System.out.println("Starting Certification Report Test- SOP Tab and Current Certification");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.clickCertification();
		report.clickSOPTab();
		report.clickSOP_CurrentCertification();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Certification"), "Report file not downloaded!");
		FileUtil.clearDownloadDirectory(System.getProperty("user.dir") + "/downloads");
	}

	//@Test(priority = 4)
	// Validate Certification Report SOP Tab and Expired Certification
	public void verifySOPExpiredCertificationReport() throws InterruptedException {
		System.out.println("Starting Certification Report Test- Expired Certification");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.clickCertification();
		report.clickSOPTab();
		report.clickSOP_ExpiredCertification();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Certification"), "Report file not downloaded!");
	}

	//@Test(priority = 5)
	// Validate Certification Report SOP Tab and Certification History
	public void verifySOPCertificationHistoryReport() throws InterruptedException {
		System.out.println("Starting Certification Report Test- SOP Tab and Certification History");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.clickCertification();
		report.clickSOPTab();
		report.clickSOP_CertificationHistory();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Certification"), "Report file not downloaded!");
	}

	//@Test(priority = 6) // Validate Certification Report Policy Tab and Current
	// Certification
	public void verifyPolicyCurrentCertificationReport() throws InterruptedException {
		System.out.println("Starting Certification Report Test- Policy Tab and Current Certification");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.clickCertification();
		report.clickPolicyTab();
		report.clickPolicy_CurrentCertification();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Certification"), "Report file not downloaded!");
	}

	//@Test(priority = 7) // Validate Certification Report Policy Tab and Expired
	// Certification
	public void verifyPolicyExpiredCertificationReport() throws InterruptedException {
		System.out.println("Starting Certification Report Test- Policy Tab and Expired Certification");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.clickCertification();
		report.clickPolicyTab();
		report.clickPolicy_ExpiredCertification();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Certification"), "Report file not downloaded!");
	}

	//@Test(priority = 8) // Validate Certification Report Policy Tab and
	// Certification History

	public void verifyPolicyCertificationHistoryReport() throws InterruptedException {
		System.out.println("Starting Certification Report Test- Policy Tab and Certification History");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.clickCertification();
		report.clickPolicyTab();
		report.clickPolicy_CertificationHistory();

		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Certification"), "Report file not downloaded!");
	}

	//@Test(priority = 9)
	// Validate Approval Report SOP, Policy and Test
	public void verifyCurrentApprovalListSOP() throws InterruptedException {
		System.out.println("Starting Approval Report Test- SOP Approval List");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.clickApproval();
		report.ExportcurrentApprovalListSOP();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Approval"), "Report file not downloaded!");

	}

	//@Test(priority = 10)
	// Validate Approval Report SOP Approval List History
	public void verifyApprovalListHistorySOP() throws InterruptedException {
		System.out.println("Starting Approval Report Test- SOP Approval List History");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.clickApproval();
		WaitUtil.waitForSeconds(5);

		report.ExportApprovalListHistorySOP();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Approval"), "Report file not downloaded!");

	}

	//@Test(priority = 11)
	// Validate Current Approval List Policy

	public void verifyCurrentApprovalListPolicy() throws InterruptedException {
		System.out.println("Starting Approval Report Test- Current Approval List Policy");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.clickApproval();
		report.ExportcurrentApprovalListPolicy();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Approval"), "Report file not downloaded!");

	}

	//@Test(priority = 12)
	// Validate Approval List History policy

	public void verifyApprovalListHistoryPolicy() throws InterruptedException {
		System.out.println("Starting Approval Report Test- Approval List History Policy");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.clickApproval();

		report.ExportApprovalListHistoryPolicy();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(7);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Approval"), "Report file not downloaded!");

	}

	//@Test(priority = 13)
	// Validate Approval List Test- Current Approval List

	public void verifyCurrentApprovalListTest() throws InterruptedException {
		System.out.println("Starting Approval Report Test- Current Approval List Test");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.clickApproval();
		report.ExportcurrentApprovalListTest();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Test"), "Report file not downloaded!");

	}

	//@Test(priority = 14)
	// Validate Approval List History Test- Approval List History

	public void verifyApprovalListHistoryTest() throws InterruptedException {
		System.out.println("Starting Approval Report Test- Approval List History Test");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.clickApproval();
		report.ExportApprovalListHistoryTest();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Test"), "Report file not downloaded!");

	}

	//@Test(priority = 15)
	// Validate Audit Summary Report- Internal Audit Report
	public void verifyInternalAuditReport() throws InterruptedException {
		System.out.println("Starting Audit Summary Report Test- Internal Audit Report");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.clickAuditSummary();
		report.getInternalAuditReport();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Audit"), "Report file not downloaded!");

	}

	//@Test(priority = 16)
	// Validate Audit Summary Report- External Audit Report
	public void verifyExternalAuditReport() throws InterruptedException {
		System.out.println("Starting Audit Summary Report Test- External Audit Report");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.clickAuditSummary();
		report.getExternalAuditReport();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Audit"), "Report file not downloaded!");

	}

	//@Test(priority = 17)
	// Validate Employee Report
	public void verifyEmployeeReport() throws InterruptedException {
		System.out.println("Starting Employee Report Test");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.exportEmployeeReport();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Employee"), "Report file not downloaded!");

	}

	//@Test(priority = 18)
	// Validate EmployeeTestHistory Report

	public void verifyEmployeeTestHistoryReport() throws InterruptedException {
		System.out.println("Starting Employee Test History Report Test");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.exportEmployeeTestHistoryReport();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Employee"), "Report file not downloaded!");

	}

	//@Test(priority = 19)
	// Vendor Document Status Report

	public void verifyVendorDocumentStatusReportByVendor() throws InterruptedException {
		System.out.println("Starting Vendor Document Status Report Test by Vendor");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.exportVendorDocumentStatusReportByVendor();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Vendor"), "Report file not downloaded!");
		FileUtil.clearDownloadDirectory(downloadPath); // Clear the download directory after test

	}

	//@Test(priority = 20)
	// Vendor Document Status Report by Vendor Category

	public void verifyVendorDocumentStatusReportByDocumentType() throws InterruptedException {
		System.out.println("Starting Vendor Document Status Report Test by Vendor Category");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.exportVendorDocumentStatusReportByVendorCategory();

		// Wait a bit to allow download to complete WaitUtil.waitForSeconds(5);
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Vendor"), "Report file not downloaded!");
		FileUtil.clearDownloadDirectory(downloadPath); // Clear the download directory after test

	}

	//@Test(priority = 21)
	// Validate Vendor Details Report by vendor
	public void verifyVendorDetailsReportByVendor() throws InterruptedException {
		System.out.println("Starting Vendor Details Report Test by Vendor");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.exportVendorDetailsReportByVendor();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		System.out.println("Download path: " + downloadPath);
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Vendor"), "Report file not downloaded!");
		FileUtil.clearDownloadDirectory(downloadPath); // Clear the download directory after test

	}

	//@Test(priority = 22)
	// Validate Vendor Details Report by vendor category

	public void verifyVendorDetailsReportByVendorCategory() throws InterruptedException {
		System.out.println("Starting Vendor Details Report Test by Vendor Category");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.exportVendorDetailsReportByVendorCategory();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		// Print files in download directory for debugging
		java.io.File downloadDir = new java.io.File(downloadPath);
		String[] files = downloadDir.list();
		System.out.println("Files in download directory:");
		if (files != null) {
			for (String file : files) {
				System.out.println(file);
			}
		} else {
			System.out.println("Download directory is empty or does not exist.");
		}
		System.out.println("Checking for file containing: Vendor");
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Vendor"), "Report file not downloaded!");
		FileUtil.clearDownloadDirectory(downloadPath); // Clear the download directory after test

	}

	//@Test(priority = 23)
	// Validate Passing Score Test Report Department Wide
	public void verifyPassingScoreTestReportDepartmentWide() throws InterruptedException {
		System.out.println("Starting Passing Score Test Report Test- Department Wide");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.exportPassingScoreTestReportDepartmentWide();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Test"), "Report file not downloaded!");

	}

	//@Test(priority = 24)
	// Validate Passing Score Test Report Company Wide
	public void verifyPassingScoreTestReportCompanyWide() throws InterruptedException {
		System.out.println("Starting Passing Score Test Report Test- Company Wide");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.exportPassingScoreTestReportCompanyWide();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Test"), "Report file not downloaded!");
	}

	//@Test(priority = 25)
	// Validate Passing Score Test Report by Title wide

	public void verifyPassingScoreTestReportByTitle() throws InterruptedException {
		System.out.println("Starting Passing Score Test Report Test- Title Wide");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.exportPassingScoreTestReportByTitle();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Test"), "Report file not downloaded!");
	}

	//@Test(priority = 26)
	// Validate Passing Score Test Report by alltest
	public void verifyPassingScoreTestReportByAllTest() throws InterruptedException {
		System.out.println("Starting Passing Score Test Report Test- All Test");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.exportPassingScoreTestReportByAllTest();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Test"), "Report file not downloaded!");
	}

	//@Test(priority = 27)
	// Validate Company Test History Report by Department Wide
	public void verifyCompanyTestHistoryReportByDepartmentWide() throws InterruptedException {
		System.out.println("Starting Company Test History Report Test- Department Wide");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.exportCompanyTestHistoryReportByDepartmentWide();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Test"), "Report file not downloaded!");
	}

	//@Test(priority = 28)
	// Validate Company Test History Report by Company Wide
	public void verifyCompanyTestHistoryReportByCompanyWide() throws InterruptedException {
		System.out.println("Starting Company Test History Report Test- Company Wide");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.exportCompanyTestHistoryReportByCompanyWide();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Test"), "Report file not downloaded!");
	}

	//@Test(priority = 29)
	// Validate Company Test History Report by Title Wide
	public void verifyCompanyTestHistoryReportByTitleWide() throws InterruptedException {
		System.out.println("Starting Company Test History Report Test- Title Wide");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.exportCompanyTestHistoryReportByTitleWide();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Test"), "Report file not downloaded!");
	}

	//@Test(priority = 30)
	// Validate Company Test History Report by All Test
	public void verifyCompanyTestHistoryReportByAllTest() throws InterruptedException {
		System.out.println("Starting Company Test History Report Test- All Test");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.exportCompanyTestHistoryReportByAllTest();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Test"), "Report file not downloaded!");
	}

	//@Test(priority = 31)
	// Validate Test Questions & Responses Report

	public void verifyTestQuestionsAndResponsesReport() throws InterruptedException {
		System.out.println("Starting Test Questions & Responses Report Test");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.exportTestQuestionsAndResponsesReport();

		// Wait a bit to allow download to complete
		WaitUtil.waitForSeconds(5);

		String downloadPath = System.getProperty("user.dir") + "/downloads";
		Assert.assertTrue(report.isFileDownloaded(downloadPath, "Test"), "Report file not downloaded!");
	}

	//@Test(priority = 32)
	// Verify Audit Summary Report -> Internal Audit validation message
	public void verifyInternalAuditValidationMessage() throws InterruptedException {
		System.out.println("Starting Internal Audit Validation Message Test");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.clickAuditSummary();
		String validationMessage = report.verifyInternalAuditValidation();

		// Assert that the validation message is displayed correctly
		Assert.assertEquals(validationMessage, "Please Select internal audit type name.",
				"Validation message does not match expected value!");
	}

	//@Test(priority = 33)
	// Verify Audit Summary Report -> External Audit validation message
	public void verifyExternalAuditValidationMessage() throws InterruptedException {
		System.out.println("Starting External Audit Validation Message Test");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		report.clickAuditSummary();

		String validationMessage = report.verifyExternalAuditValidation();

		// Assert that the validation message is displayed correctly
		Assert.assertEquals(validationMessage, "Please Select Client Name.",
				"Validation message does not match expected value!");
	}

	//@Test(priority = 34)
	// Verify Company Test History Report-> Department Wide validation message
	public void verifyCompanyTestHistoryReportByDepartmentWideValidationMessage() throws InterruptedException {
		System.out.println("Starting Company Test History Report by Department Wide Validation Message Test");

		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		String validationMessage = report.verifyCompanyTestHistoryReportByDepartmentWideValidationMessage();
		// Assert that the alert text matches the expected validation message
		Assert.assertEquals(validationMessage, "Please select Test Name",
				"Validation message does not match expected value!");

	}

	//@Test(priority = 35)
	// Verify Company Test History Report-> Company Wide validation message
	public void verifyCompanyTestHistoryReportByCompanyWideValidationMessage() throws InterruptedException {
		System.out.println("Starting Company Test History Report by Company Wide Validation Message Test");

		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		String validationMessage = report.verifyCompanyTestHistoryReportByCompanyWideValidationMessage();
		// Assert that the alert text matches the expected validation message
		Assert.assertEquals(validationMessage, "Please select Test Name",
				"Validation message does not match expected value!");

	}

	//@Test(priority = 36)
	// Verify Company Test History Report-> Title Wide validation message
	public void verifyCompanyTestHistoryReportByTitleWideValidationMessage() throws InterruptedException {
		System.out.println("Starting Company Test History Report by Title Wide Validation Message Test");

		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		String validationMessage = report.verifyCompanyTestHistoryReportByTitleWideValidationMessage();
		// Assert that the alert text matches the expected validation message
		Assert.assertEquals(validationMessage, "Please select title first",
				"Validation message does not match expected value!");

	}

	//@Test(priority = 37)
	// Verify Company Test History Report-> All Test validation message
	public void verifyCompanyTestHistoryReportByAllTestValidationMessage() throws InterruptedException {
		System.out.println("Starting Company Test History Report by All Test Validation Message Test");

		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		String validationMessage = report.verifyCompanyTestHistoryReportByAllTestValidationMessage();
		// Assert that the alert text matches the expected validation message
		Assert.assertEquals(validationMessage, "Please select Test Name",
				"Validation message does not match expected value!");

	}

	//@Test(priority = 38)
	// Verify Passing Score Test Report -> Department Wide validation message
	public void verifyPassingScoreTestReportByDepartmentWideValidationMessage() throws InterruptedException {
		System.out.println("Starting Passing Score Test Report by Department Wide Validation Message Test");

		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		String validationMessage = report.verifyPassingScoreTestReportByDepartmentWideValidationMessage();
		// Assert that the alert text matches the expected validation message
		Assert.assertEquals(validationMessage, "Please select Department Name",
				"Validation message does not match expected value!");

	}

	@Test(priority = 39)
	// Verify Passing Score Test Report -> Company Wide validation message
	public void verifyPassingScoreTestReportByCompanyWideValidationMessage() throws InterruptedException {
		System.out.println("Starting Passing Score Test Report by Company Wide Validation Message Test");

		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		String validationMessage = report.verifyPassingScoreTestReportByCompanyWideValidationMessage();
		// Assert that the alert text matches the expected validation message
		Assert.assertEquals(validationMessage, "Please select Test Name",
				"Validation message does not match expected value!");

	}

	//@Test(priority = 40)
	// Verify Passing Score Test Report -> Title Wide validation message
	public void verifyPassingScoreTestReportByTitleWideValidationMessage() throws InterruptedException {
		System.out.println("Starting Passing Score Test Report by Title Wide Validation Message Test");

		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		String validationMessage = report.verifyPassingScoreTestReportByTitleWideValidationMessage();
		// Assert that the alert text matches the expected validation message
		Assert.assertEquals(validationMessage, "Please select Title",
				"Validation message does not match expected value!");

	}

	//@Test(priority = 41)
	// Verify Passing Score Test Report -> All Test validation message
	public void verifyPassingScoreTestReportByAllTestValidationMessage() throws InterruptedException {
		System.out.println("Starting Passing Score Test Report by All Test Validation Message Test");

		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		String validationMessage = report.verifyPassingScoreTestReportByAllTestValidationMessage();
		// Assert that the alert text matches the expected validation message
		Assert.assertEquals(validationMessage, "Please select Test Name",
				"Validation message does not match expected value!");

	}

	//@Test(priority = 42)
	// Verify Test Questions & Responses Report validation message
	public void verifyTestQuestionsAndResponsesReportValidationMessage() throws InterruptedException {
		System.out.println("Starting Test Questions & Responses Report Validation Message Test");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		String validationMessage = report.verifyTestQuestionsAndResponsesReportValidationMessage();
		// Assert that the validation message is displayed correctly
		Assert.assertEquals(validationMessage, "Please select test name. Please select format.",
				"Validation message does not match expected value!");

	}
	
	//@Test(priority = 43)
	// Verify Vendor Document Status Report by Vendor validation message
	public void verifyVendorDocumentStatusReportByVendorValidationMessage() throws InterruptedException {
		System.out.println("Starting Vendor Document Status Report by Vendor Validation Message Test");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		String validationMessage = report.verifyVendorDocumentStatusReportByVendorValidationMessage();
		// Assert that the validation message is displayed correctly
		Assert.assertEquals(validationMessage, "Either select required vendor names from Select Vendor Names dropdown, or check All checkbox to select all vendors.",
				"Validation message does not match expected value!");
	}
	
	//@Test(priority = 44)
	// Verify Vendor Document Status Report by Vendor Category validation message
	public void verifyVendorDocumentStatusReportByVendorCategoryValidationMessage() throws InterruptedException {
		System.out.println("Starting Vendor Document Status Report by Vendor Category Validation Message Test");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		String validationMessage = report.verifyVendorDocumentStatusReportByVendorCategoryValidationMessage();
		// Assert that the validation message is displayed correctly
		Assert.assertEquals(validationMessage, "Either select required vendor category from Select Vendor category dropdown, or check All checkbox to select all vendor categories.",
				"Validation message does not match expected value!");
	}
	
	//@Test(priority = 45)
	// Verify Vendor Details Report by Vendor validation message
	public void verifyVendorDetailsReportByVendorValidationMessage() throws InterruptedException {
		System.out.println("Starting Vendor Details Report by Vendor Validation Message Test");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		String validationMessage = report.verifyVendorDetailsReportByVendorValidationMessage();
		// Assert that the validation message is displayed correctly
		Assert.assertEquals(validationMessage, "Either select required vendor names from Select Vendor Names dropdown, or check All checkbox to select all vendors.",
				"Validation message does not match expected value!");
	}
	
	
	//@Test(priority = 46)	
	// Verify Vendor Details Report by Vendor Category validation message
	public void verifyVendorDetailsReportByVendorCategoryValidationMessage() throws InterruptedException {
		System.out.println("Starting Vendor Details Report by Vendor Category Validation Message Test");
		report.login("partnercode", "username", "password");
		report.clickReportMenu();
		String validationMessage = report.verifyVendorDetailsReportByVendorCategoryValidationMessage();
		// Assert that the validation message is displayed correctly
		Assert.assertEquals(validationMessage, "Either select required vendor category from Select Vendor category dropdown, or check All checkbox to select all vendor categories",
				"Validation message does not match expected value!");
	}
	
}
