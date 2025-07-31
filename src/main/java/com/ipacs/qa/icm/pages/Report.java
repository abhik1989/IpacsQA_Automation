package com.ipacs.qa.icm.pages;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.ipacs.qa.baseclass.TestBase;
import com.ipacs.qa.utilities.ConfigUtil;
import com.ipacs.qa.utilities.ExcelReader;
import com.ipacs.qa.utilities.WaitUtil;

public class Report extends TestBase {

	// Login Page

	@FindBy(id = "partnerCode")
	WebElement partnercode;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(id = "Login")
	WebElement submit;

	// Report Page
	@FindBy(xpath = "//a[normalize-space()='Reports']")
	WebElement reportMenu;

	// Certification page web elements
	@FindBy(xpath = "//a[normalize-space()='Certification']")
	WebElement certificationLink;
	@FindBy(xpath = "//a[@id='ui-id-1']")
	WebElement sopTab;
	@FindBy(xpath = "//a[@id='ui-id-3']")
	WebElement sop_currentCertification;
	@FindBy(xpath = "//a[@href='/Reports/ExportCurrentCertification']")
	WebElement sop_exportCurrentCertification;
	@FindBy(xpath = "//a[@id='ui-id-4']")
	WebElement sop_expiredCertification;
	@FindBy(xpath = "//a[@href='/Reports/ExportExpiredCertificaton']")
	WebElement sop_exportExpiredCertification;
	@FindBy(xpath = "//a[@id='ui-id-5']")
	WebElement sop_certificationHistory;
	@FindBy(xpath = "//a[@href='/Reports/ExportHistoryCertification']")
	WebElement sop_exportCertificationHistory;
	@FindBy(xpath = "//a[@id='ui-id-2']")
	WebElement policyTab;

	@FindBy(xpath = "//a[@id='ui-id-6']")
	WebElement policy_currentCertification;
	@FindBy(xpath = "//a[@href='/Reports/ExportCurrentPolCertification']")
	WebElement policy_exportCurrentCertification;
	@FindBy(xpath = "//a[@id='ui-id-7']")
	WebElement policy_expiredCertification;
	@FindBy(xpath = "//a[@href='/Reports/ExportCurrentPolCertification']")
	WebElement policy_exportExpiredCertification;
	@FindBy(xpath = "//a[@id='ui-id-8']")
	WebElement policy_CertificationHistory;
	@FindBy(xpath = "//a[@href='/Reports/ExportHistoryPolCertification']")
	WebElement policy_exportCertificationHistory;

//Approval page web elements

	@FindBy(xpath = "//a[normalize-space()='Approval List']")
	WebElement approvalList;
	@FindBy(xpath = "//a[@id='SopMain']")
	WebElement sopMain;
	@FindBy(xpath = "//a[@id='SopCurrentLink']")
	WebElement sop_currentLink;
	@FindBy(xpath = "//a[@id='SopHistoryLink']")
	WebElement sop_historyLink;
	@FindBy(xpath = "//a[normalize-space()='Export to Excel']")
	WebElement exportCurrentApprovalListSOP;
	@FindBy(xpath = "(//a[contains(text(),'Export to Excel ')])[2]")
	WebElement ExportToExcelbutton;
	@FindBy(xpath = "//a[@id='PolicyMain']")
	WebElement policyMain;
	@FindBy(xpath = "//a[@id='PolicyCurrentLink']")
	WebElement CurAppListPolicy;
	@FindBy(xpath = "//a[@id='PolicyHistoryLink']")
	WebElement approvalListHistoryPolicy;
	@FindBy(xpath = "(//a[contains(text(),'Export to Excel ')])[3]")
	WebElement exportApprovalListHistoryPolicy;
	@FindBy(xpath = "//a[@id='TestMain']")
	WebElement TestMain;
	@FindBy(xpath = "//a[@id='TestCurrentLink']")
	WebElement TestCurrentLink;
	@FindBy(xpath = "//a[@id='TestHistoryLink']")
	WebElement TestHistoryLink;
	@FindBy(xpath = "(//a[contains(text(),'Export to Excel ')])[2]")
	WebElement TestCurrApprovalList;
	@FindBy(xpath = "(//a[contains(text(),'Export to Excel ')])[3]")
	WebElement TestApprovalListHistory;

//Audit Summary Report page web elements

	@FindBy(xpath = "//a[normalize-space()='Audit Summary Reports']")
	WebElement auditSummary;
	@FindBy(xpath = "//a[@id='ui-id-1']")
	WebElement internalAuditTab;
	@FindBy(xpath = "//select[@id='internalAuditTypeName']")
	WebElement internalAuditTypeName;
	@FindBy(xpath = "//button[@id='getInternalAuditReport']")
	WebElement getReportButton;
	@FindBy(xpath = "//div[@id='internalAuditDetails_outerdiv']//a[1]")
	WebElement ExportinternalAudit;
	@FindBy(xpath = "//a[@id='ui-id-2']")
	WebElement externalAuditTab;
	@FindBy(xpath = "//select[@id='clientNameList']")
	WebElement clientNameList;
	@FindBy(xpath = "//button[@id='getExternalAuditReport']")
	WebElement getExternalReportButton;
	@FindBy(xpath = "//div[@id='externalAuditDetails_outerdiv']//a[1]")
	WebElement ExportExternalAuditReport;

	// Employee Report page web elements
	@FindBy(xpath = "//a[contains(text(),'Employee Report')]")
	WebElement employeeReportLink;
	@FindBy(xpath = "//select[@id='DepttName']")
	WebElement DepttName;
	@FindBy(xpath = "//a[@id='empReport']")
	WebElement employeeReport;

	// Employee Test History Report page web elements
	@FindBy(xpath = "//a[contains(text(),'Employee Test History Report')]")
	WebElement EmployeeTestHistoryReprt;
	@FindBy(xpath = "//select[@id='UserId']")
	WebElement UserId;
	@FindBy(xpath = "//a[@id='EmpReportUserWiseExport']")
	WebElement EmpReportUserWiseExport;

	// Vendor Document Status Report page web elements

	@FindBy(xpath = "//a[contains(text(),'Vendor Document Status Report')]")
	WebElement vendorDocumentStatusReportLink;
	@FindBy(xpath = "//div[@id='uniform-vendorname']")
	WebElement radiobtnvendor;
	@FindBy(xpath = "//div[@id='uniform-vendorcategory']")
	WebElement vendorcategorybtn;
	@FindBy(xpath = "//input[@id='checkboxvendor1']")
	WebElement checkbox1;
	@FindBy(xpath = "//input[@id='CkboxAllVendorCategory']")
	WebElement checkbox2;
	@FindBy(xpath = "//button[@id='getvendorreports']")
	WebElement getvendorreportsSubmitbtn;
	@FindBy(xpath = "//a[@id='downbuttonvendor_btn']")
	WebElement exportvendorReport;

	// Vendor Details Report page web elements
	@FindBy(xpath = "//a[contains(text(),'Vendor Details Report')]")
	WebElement VendorDetailsReportLink;
	@FindBy(xpath = "//div[@id='uniform-vendorname']")
	WebElement vendor_name;
	@FindBy(xpath = "//input[@id='checkboxvendor1']")
	WebElement checkboxvendor1;
	@FindBy(xpath = "//button[@id='getvendorreports']")
	WebElement submitBtn;
	@FindBy(xpath = "//a[@id='downbuttonvendor_btn']")
	WebElement exportToExcel;
	@FindBy(xpath = "//input[@id='vendorcategory']")
	WebElement vendor_category;
	@FindBy(xpath = "//input[@id='CkboxAllVendorCategory']")
	WebElement checkboxvendor2;

	// Passing Score Test Report page web elements

	@FindBy(xpath = "//a[contains(text(),'Passing Score Test Report')]")
	WebElement passingScoreTestReportLink;

	@FindBy(xpath = "//input[@value='Department']")
	WebElement departmentWide;
	@FindBy(xpath = "//input[@value='Company']")
	WebElement companyWide;
	@FindBy(xpath = "//input[@name='CkboxAllDept']")
	WebElement CkboxAllDept;
	@FindBy(xpath = "//input[@value='Title']")
	WebElement titleWide;
	@FindBy(xpath = "//input[@name='CkboxAllTitle']")
	WebElement CkboxAllTitle;
	@FindBy(xpath = "//button[@onclick='FetchEmpReportDeptCmpnyAllTestWise()']")
	WebElement submitbtndept;
	@FindBy(xpath = "//a[@onclick='FetchEmpReportDeptCmpnyAllTestWiseExport()']")
	WebElement FetchEmpReportDeptWiseExport;
	@FindBy(xpath = "//input[@value='AllTest']")
	WebElement AllTest;
	@FindBy(xpath = "//input[@id='allTestReportSel']")
	WebElement allTestReportSel;
	@FindBy(xpath = "//input[@id='CkboxAllPeriod2']")
	WebElement CkboxAllPeriod2;

	// Company Test History Report All web elements
	
	@FindBy(xpath ="//input[@value='Department']")
	WebElement deptWide;

	@FindBy(xpath ="//input[@id='allDepartReport']")
	WebElement allDepartReport;

	@FindBy(xpath ="//select[@id='TestId']")
	WebElement testName;

	@FindBy(xpath ="//input[@id='CkboxAllPeriod1']")
	WebElement chkboxall;

	@FindBy(xpath ="//button[@onclick='FetchEmployeeReport();']")
	WebElement submitbtn;

	@FindBy(xpath ="//a[@onclick='FetchEmployeeReportExport()']")
	WebElement fetchEmpExport;
	
	@FindBy(xpath = "//a[contains(text(),'Company Test History Report')]")
	WebElement companyTestHistoryReportLink;

	@FindBy(xpath = "//input[@value='Company']")
	WebElement company_Wide;

	@FindBy(xpath = "//input[@id='allTestReport']")
	WebElement allCompanyTestReport;

	@FindBy(xpath = "//input[@id='CkboxAllPeriod']")
	WebElement CkboxAllPeriod;

	@FindBy(xpath = "//button[@onclick='FetchEmployeeReport();']")
	WebElement submit_fetchEmployeeReport;

	@FindBy(xpath = "//a[@onclick='FetchEmployeeReportExport()']")
	WebElement export_FetchEmployeeReport;

	@FindBy(xpath = "//input[@value='Title']")
	WebElement title_Wide;
	
	@FindBy(xpath = "//select[@id='TitleTestId']")
	WebElement alltestdropdown;

	@FindBy(xpath = "//input[@id='allTitleReport']")
	WebElement allTitleReport;

	@FindBy(xpath = "//input[@id='TitleCkboxAllPeriod1']")
	WebElement TitleCkboxAllPeriod1;

	@FindBy(xpath = "//input[@value='AllTest']")
	WebElement AllTest_report;

	// Test Questions & Responses Report web elements
	@FindBy(xpath = "//a[contains(text(),'Test Questions & Responses Report')]")
	WebElement testquesRespReport;

	@FindBy(xpath = "//select[@id='testId']")
	WebElement selectTest;

	@FindBy(xpath = "//select[@id='ddlUser']")
	WebElement employeeName;

	@FindBy(xpath = "//input[@id='chkAllDate']")
	WebElement chkAllDate;

	@FindBy(xpath = "//select[@id='ddlExportFormat']")
	WebElement selectFormat;

	@FindBy(xpath = "//button[@id='btnSubmit']")
	WebElement btnSubmit;
	
	
	
	// Constructor to initialize the PageFactory elements

	public Report() {
		PageFactory.initElements(driver, this);
	}

	public boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		for (File file : dirContents) {
			if (file.getName().contains(fileName)) {
				return true;
			}
		}
		return false;
	}

	// Login Method

	public void login(String pc, String un, String pwd) {
		Map<String, String> testData = ExcelReader.readKeyValueFromExcel(ConfigUtil.getTestDataFilePath(), "TestData");

		partnercode.sendKeys(testData.get("partnerCode"));
		username.sendKeys(testData.get("username"));
		password.sendKeys(testData.get("password"));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
	}

	public void clickReportMenu() {
		// Click on the Report menu
		reportMenu.click();

		// Wait for the Report page to load
		try {
			Thread.sleep(2000); // Adjust the sleep time as needed
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Verify that the Report page is displayed
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("/Report/Index")) {
			System.out.println("Report page is displayed.");
		} else {
			System.out.println("Failed to navigate to Report page.");
		}

	}

	public void clickCertification() {
		// Click on the Certification Report link
		certificationLink.click();

	}
	public void clickSOPTab() {
		sopTab.click();

	}

	public void clickSOP_CurrentCertification() {
		// Click on the Current Certification link
		sop_currentCertification.click();
		sop_exportCurrentCertification.click();

	}

	public void clickSOP_ExpiredCertification() {
		// Click on the Expired Certification link
		sop_expiredCertification.click();
		sop_exportExpiredCertification.click();

	}

	public void clickSOP_CertificationHistory() {
		// Click on the Certification History link
		sop_certificationHistory.click();
		sop_exportCertificationHistory.click();
	}

	public void clickPolicyTab() {
		// Click on the Policy Tab
		policyTab.click();

	}

	public void clickPolicy_CurrentCertification() {
		policy_currentCertification.click();
	}

	public void clickPolicy_ExpiredCertification() {

		policy_expiredCertification.click();
	}

	public void clickPolicy_CertificationHistory() {

		policy_CertificationHistory.click();
	}

	public void clickApproval() {

		approvalList.click();
	}

	public void ExportcurrentApprovalListSOP() {
		sopMain.click();
		sop_currentLink.click();
		// Wait for the Export to Excel button to be clickable
		WaitUtil.waitForSeconds(5);
		exportCurrentApprovalListSOP.click();

	}

	public void ExportApprovalListHistorySOP() {
		sopMain.click();
		sop_historyLink.click();
		// Wait for the Export to Excel button to be clickable
		WaitUtil.waitForSeconds(5);
		ExportToExcelbutton.click();

	}

	public void ExportcurrentApprovalListPolicy() {
		policyMain.click();
		CurAppListPolicy.click();
		WaitUtil.waitForSeconds(5);
		ExportToExcelbutton.click();

	}

	public void ExportApprovalListHistoryPolicy() {

		policyMain.click();
		approvalListHistoryPolicy.click();

		WaitUtil.waitForSeconds(5);
		exportApprovalListHistoryPolicy.click();

	}

	public void ExportcurrentApprovalListTest() {
		TestMain.click();
		TestCurrentLink.click();
		WaitUtil.waitForSeconds(5);
		TestCurrApprovalList.click();

	}

	public void ExportApprovalListHistoryTest() {
		TestMain.click();
		TestHistoryLink.click();
		WaitUtil.waitForSeconds(5);
		TestApprovalListHistory.click();

	}

	public void clickAuditSummary() {
		auditSummary.click();

	}

	public void getInternalAuditReport() {
		internalAuditTab.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", internalAuditTypeName);
		Select internalAuditType = new Select(internalAuditTypeName);
		internalAuditType.selectByValue("200");

		// 3. Check the 'All periods' checkbox
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='allPeriods']"));
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
		getReportButton.click();
		// Wait for the Export to Excel button to be clickable
		WaitUtil.waitForSeconds(5);
		ExportinternalAudit.click();

	}

	public void getExternalAuditReport() {
		externalAuditTab.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", clientNameList);
		Select clientName = new Select(clientNameList);
		clientName.selectByValue("6");

		// 3. Check the 'All periods' checkbox
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='extRepAllPeriods']"));
		if (!checkbox.isSelected()) {
			checkbox.click();
		}

		getExternalReportButton.click();
		// Wait for the Export to Excel button to be clickable
		WaitUtil.waitForSeconds(5);
		ExportExternalAuditReport.click();

	}

	public void exportEmployeeReport() {
		// Click on the Employee Report link

		employeeReportLink.click();

		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", DepttName);
		Select Deptt_Name = new Select(DepttName);
		Deptt_Name.selectByValue("29");
		WaitUtil.waitForSeconds(5);
		employeeReport.click();

	}

	public void exportEmployeeTestHistoryReport() {
		// Click on the Employee Report link
		EmployeeTestHistoryReprt.click();

		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", UserId);
		Select user_id = new Select(UserId);
		user_id.selectByValue("14");
		WebElement employeeTestHistoryReport = driver.findElement(By.xpath("//button[@onclick='FetchEmpReportUserWise()']"));
		employeeTestHistoryReport.click();
		// Wait for the Export to Excel button to be clickable
		WaitUtil.waitForSeconds(5);
		EmpReportUserWiseExport.click();

	}

	public void exportVendorDocumentStatusReportByVendor() {
		vendorDocumentStatusReportLink.click();
		radiobtnvendor.click();
		WaitUtil.waitForSeconds(2);
		checkbox1.click();
		getvendorreportsSubmitbtn.click();
		// Wait for the Export to Excel button to be clickable
		WaitUtil.waitForSeconds(5);
		exportvendorReport.click();
	}

	public void exportVendorDocumentStatusReportByVendorCategory() {

		vendorDocumentStatusReportLink.click();
		vendorcategorybtn.click();
		WaitUtil.waitForSeconds(2);
		checkbox2.click();
		getvendorreportsSubmitbtn.click();
		// Wait for the Export to Excel button to be clickable
		WaitUtil.waitForSeconds(5);
		exportvendorReport.click();
	}

	public void exportVendorDetailsReportByVendor() {
		VendorDetailsReportLink.click();
		vendor_name.click();
		checkboxvendor1.click();
		submitBtn.click();
		// Wait for the Export to Excel button to be clickable
		WaitUtil.waitForSeconds(5);
		exportToExcel.click();

	}

	public void exportVendorDetailsReportByVendorCategory() {
		VendorDetailsReportLink.click();
		vendor_category.click();
		checkboxvendor2.click();
		submitBtn.click();
		// Wait for the Export to Excel button to be clickable
		WaitUtil.waitForSeconds(10);
		exportToExcel.click();

	}

	public void exportPassingScoreTestReportDepartmentWide() {

		passingScoreTestReportLink.click();
		departmentWide.click();
		CkboxAllDept.click();
		submitbtndept.click();
		// Wait for the Export to Excel button to be clickable
		WaitUtil.waitForSeconds(5);
		FetchEmpReportDeptWiseExport.click();

	}

	public void exportPassingScoreTestReportCompanyWide() {

		passingScoreTestReportLink.click();
		companyWide.click();
		submitbtndept.click();
		// Wait for the Export to Excel button to be clickable
		WaitUtil.waitForSeconds(5);
		FetchEmpReportDeptWiseExport.click();

	}

	public void exportPassingScoreTestReportByTitle() {
		passingScoreTestReportLink.click();
		titleWide.click();
		CkboxAllTitle.click();
		submitbtndept.click();
		// Wait for the Export to Excel button to be clickable
		WaitUtil.waitForSeconds(5);
		FetchEmpReportDeptWiseExport.click();

	}

	public void exportPassingScoreTestReportByAllTest() {
		passingScoreTestReportLink.click();
		AllTest.click();
		allTestReportSel.click();
		CkboxAllPeriod2.click();
		submitbtndept.click();
		// Wait for the Export to Excel button to be clickable
		WaitUtil.waitForSeconds(5);
		FetchEmpReportDeptWiseExport.click();

	}

	public void exportCompanyTestHistoryReportByCompanyWide() {
		companyTestHistoryReportLink.click();
		company_Wide.click();
		allCompanyTestReport.click();
		CkboxAllPeriod.click();
		submit_fetchEmployeeReport.click();
		// Wait for the Export to Excel button to be clickable
		WaitUtil.waitForSeconds(5);
		export_FetchEmployeeReport.click();

	}


	public void exportCompanyTestHistoryReportByTitleWide() {
		companyTestHistoryReportLink.click();
		title_Wide.click();
		allTitleReport.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", alltestdropdown);
		Select allTest = new Select(alltestdropdown);
		allTest.selectByValue("17");
		TitleCkboxAllPeriod1.click();
		submit_fetchEmployeeReport.click();
		// Wait for the Export to Excel button to be clickable
		WaitUtil.waitForSeconds(5);
		export_FetchEmployeeReport.click();
	}
	
	public void exportCompanyTestHistoryReportByAllTest() {
		companyTestHistoryReportLink.click();
		AllTest_report.click();
		allTestReportSel.click();
		CkboxAllPeriod2.click();
		submit_fetchEmployeeReport.click();
		// Wait for the Export to Excel button to be clickable
		WaitUtil.waitForSeconds(5);
		export_FetchEmployeeReport.click();
	}

	public void exportTestQuestionsAndResponsesReport() {
		testquesRespReport.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", selectTest);
		Select test = new Select(selectTest);
		test.selectByValue("6");
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", employeeName);
		Select employee = new Select(employeeName);
		employee.selectByValue("8");
		chkAllDate.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", selectFormat);
		Select format = new Select(selectFormat);
		format.selectByValue("2");
		WaitUtil.waitForSeconds(10);
		btnSubmit.click();
		
		
	}

	public void exportCompanyTestHistoryReportByDepartmentWide() {
		companyTestHistoryReportLink.click();
		deptWide.click();
		allDepartReport.click();
		Select testName= new Select(this.testName);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", testName);
		testName.selectByValue("2");
		chkboxall.click();
		submitbtn.click();
		// Wait for the Export to Excel button to be clickable
		WaitUtil.waitForSeconds(5);
		fetchEmpExport.click();
	}

	 public String verifyInternalAuditValidation() throws InterruptedException {
	        // Find and click on "Get Report" without selecting audit type
	        WebElement getReportBtn = driver.findElement(By.xpath("//button[contains(text(),'Get Report')]"));
	        getReportBtn.click();

	        // Wait and handle the alert
	        WaitUtil.waitForSeconds(3);
	        Alert alert = driver.switchTo().alert();
	        String alertText = alert.getText();
	        System.out.println("Alert says: " + alertText);

	        // Validate alert text
	        if (alertText.equals("Please Select internal audit type name.")) {
	            System.out.println("Alert message is correct.");
	        } else {
	            System.out.println("Unexpected alert message!");
	        }

	        alert.accept();  // Click OK on alert
			return alertText;
			

	        // Optionally: take screenshot
	        // File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        // FileUtils.copyFile(src, new File("AlertScreenshot.png"));
	    }

	public String verifyExternalAuditValidation() {
		externalAuditTab.click();
		WebElement getExternalReportBtn = driver.findElement(By.xpath("//button[@id='getExternalAuditReport']"));
		getExternalReportBtn.click();
		
		// Wait and handle the alert
		WaitUtil.waitForSeconds(3);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert says: " + alertText);
		// Validate alert text
		if (alertText.equals("Please Select Client Name.")) {
			System.out.println("Alert message is correct.");
		} else {
			System.out.println("Unexpected alert message!");
		}
		alert.accept();  // Click OK on alert
		return alertText;
		}

	public String verifyCompanyTestHistoryReportByDepartmentWideValidationMessage() throws InterruptedException {
		companyTestHistoryReportLink.click();
		deptWide.click();
		submitbtn.click();
		// Wait and handle the alert
				WaitUtil.waitForSeconds(3);
				String alertText = driver.findElement(By.xpath("//div[contains(text(),'Please select Test Name')]")).getText();
				System.out.println("Alert says: " + alertText);
				driver.findElement(By.xpath("//div[@id='popup_panel']/input")).click();
				return alertText;
	}

	public String verifyCompanyTestHistoryReportByCompanyWideValidationMessage() {
		companyTestHistoryReportLink.click();
		company_Wide.click();
		submitbtn.click();
		// Wait and handle the alert
				WaitUtil.waitForSeconds(3);
				String alertText = driver.findElement(By.xpath("//div[@id='popup_message']")).getText();
				System.out.println("Alert says: " + alertText);
				driver.findElement(By.xpath("//div[@id='popup_panel']/input")).click();
				return alertText;
	}

	public String verifyCompanyTestHistoryReportByTitleWideValidationMessage() {
		companyTestHistoryReportLink.click();
		title_Wide.click();
		submitbtn.click();
		WaitUtil.waitForSeconds(3);
		String alertText = driver.findElement(By.xpath("//div[@id='popup_message']")).getText();
		System.out.println("Alert says: " + alertText);
		driver.findElement(By.xpath("//div[@id='popup_panel']/input")).click();
		return alertText;
	}

	public String verifyCompanyTestHistoryReportByAllTestValidationMessage() {
		companyTestHistoryReportLink.click();
		AllTest_report.click();
		submitbtn.click();
		// Wait and handle the alert
		WaitUtil.waitForSeconds(3);
		String alertText = driver.findElement(By.xpath("//div[@id='popup_message']")).getText();
		System.out.println("Alert says: " + alertText);
		driver.findElement(By.xpath("//div[@id='popup_panel']/input")).click();
		return alertText;
		
	}

	public String verifyPassingScoreTestReportByDepartmentWideValidationMessage() {
		passingScoreTestReportLink.click();
		departmentWide.click();
		submitbtndept.click();
		
		// Wait and handle the alert
		WaitUtil.waitForSeconds(3);
		String alertText = driver.findElement(By.xpath("//div[@id='popup_message']")).getText();
		System.out.println("Alert says: " + alertText);
		driver.findElement(By.xpath("//div[@id='popup_panel']/input")).click();
		return alertText;
		
	
	}

	public String verifyPassingScoreTestReportByCompanyWideValidationMessage() {
		
		passingScoreTestReportLink.click();
		companyWide.click();
		submitbtndept.click();
		
		// Wait and handle the alert
		WaitUtil.waitForSeconds(3);
		String alertText = driver.findElement(By.xpath("//div[@id='popup_message']")).getText();
		System.out.println("Alert says: " + alertText);
		driver.findElement(By.xpath("//div[@id='popup_panel']/input")).click();
		return alertText;
	}

	public String verifyPassingScoreTestReportByTitleWideValidationMessage() {
		passingScoreTestReportLink.click();
		titleWide.click();
		submitbtndept.click();
		
		// Wait and handle the alert
		WaitUtil.waitForSeconds(3);
		String alertText = driver.findElement(By.xpath("//div[@id='popup_message']")).getText();
		System.out.println("Alert says: " + alertText);
		driver.findElement(By.xpath("//div[@id='popup_panel']/input")).click();
		return alertText;
	}

	public String verifyPassingScoreTestReportByAllTestValidationMessage() {
		passingScoreTestReportLink.click();
		AllTest.click();
		submitbtndept.click();
		
		// Wait and handle the alert
		WaitUtil.waitForSeconds(3);
		String alertText = driver.findElement(By.xpath("//div[@id='popup_message']")).getText();
		System.out.println("Alert says: " + alertText);
		driver.findElement(By.xpath("//div[@id='popup_panel']/input")).click();
		return alertText;
	}

	public String verifyTestQuestionsAndResponsesReportValidationMessage() {
	    testquesRespReport.click();
	    btnSubmit.click();

	    // Wait and handle the alert
	    WaitUtil.waitForSeconds(3);

	    // Get the alert text
	    String alertText = driver.findElement(By.xpath("//div[@id='popup_message']")).getText();
	    System.out.println("Raw Alert says: " + alertText);

	    // ✅ Close the alert
	    driver.findElement(By.xpath("//div[@id='popup_panel']/input")).click();

	    // ✅ Normalize: Trim, remove extra spaces and merge lines
	    String cleanedAlert = alertText.trim().replaceAll("\\s+", " ");  // removes extra spaces, line breaks, tabs
	    System.out.println("Cleaned Alert: " + cleanedAlert);

	    // ✅ Expected merged message
	    String expectedMessage = "Please select test name. Please select format.";

	    if (cleanedAlert.equals(expectedMessage)) {
	        System.out.println("Alert message is correct.");
	    } else {
	        System.out.println("Unexpected alert message!");
	    }

	    return cleanedAlert;
	}

	public String verifyVendorDocumentStatusReportByVendorValidationMessage() {
		vendorDocumentStatusReportLink.click();
		radiobtnvendor.click();
		getvendorreportsSubmitbtn.click();
		// Wait and handle the alert
		WaitUtil.waitForSeconds(3);
		String alertText = driver.findElement(By.xpath("//div[@id='popup_message']")).getText();
		System.out.println("Alert says: " + alertText);
		driver.findElement(By.xpath("//div[@id='popup_panel']/input")).click();
		return alertText;
		

	}

	public String verifyVendorDocumentStatusReportByVendorCategoryValidationMessage() {
		vendorDocumentStatusReportLink.click();
		vendorcategorybtn.click();
		getvendorreportsSubmitbtn.click();
		// Wait and handle the alert
		WaitUtil.waitForSeconds(3);
		String alertText = driver.findElement(By.xpath("//div[@id='popup_message']")).getText();
		System.out.println("Alert says: " + alertText);
		driver.findElement(By.xpath("//div[@id='popup_panel']/input")).click();
		return alertText;
		

	}

	public String verifyVendorDetailsReportByVendorValidationMessage() {
		VendorDetailsReportLink.click();
		vendor_name.click();
		submitBtn.click();
		// Wait and handle the alert
		WaitUtil.waitForSeconds(3);
		String alertText = driver.findElement(By.xpath("//div[@id='popup_message']")).getText();
		System.out.println("Alert says: " + alertText);
		driver.findElement(By.xpath("//div[@id='popup_panel']/input")).click();
		return alertText;
	
	}

	public String verifyVendorDetailsReportByVendorCategoryValidationMessage() {
		VendorDetailsReportLink.click();
		vendor_category.click();
		submitBtn.click();
		// Wait and handle the alert
		WaitUtil.waitForSeconds(3);
		String alertText = driver.findElement(By.xpath("//div[@id='popup_message']")).getText();
		System.out.println("Alert says: " + alertText);
		driver.findElement(By.xpath("//div[@id='popup_panel']/input")).click();
		return alertText;
	}
	
	

}		

		
	
	


