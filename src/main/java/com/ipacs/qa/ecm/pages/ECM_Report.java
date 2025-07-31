package com.ipacs.qa.ecm.pages;

import java.io.File;
import java.util.Map;

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

public class ECM_Report extends TestBase {

	// Login Page

	@FindBy(id = "partnerCode")
	WebElement partnercode;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(id = "Login")
	WebElement submit;

	// Report page all web elements

	@FindBy(xpath = "//a[normalize-space()='Reports']")
	WebElement reportMenu;

	// Approval List Report Section all web elements
	@FindBy(xpath = "//a[contains(text(),'Approval Report')]")
	WebElement approvalReport;

	@FindBy(xpath = "//a[contains(text(),'Current Approval List - Section')]")
	WebElement currentApprovalListSection;

	@FindBy(xpath = "//a[@href='/RampIPacs/Reports/ExportDataApprovalPendingSection']")
	WebElement exportDataApprovalPendingSection;

	@FindBy(xpath = "//a[contains(text(),'Approval List History - Section')]")
	WebElement ApprovalListHistorySection;

	@FindBy(xpath = "//a[@href='/RampIPacs/Reports/ExportDataApprovalHistorySection']")
	WebElement exportDataApprovalHistorySection;
	
	@FindBy(xpath = "//select[@name='section_dyntable_length']")
	WebElement showEntries;


	// Acknowledgement Report Section all web elements

	@FindBy(xpath = "//a[contains(text(),'Acknowledgement Report')]")
	WebElement acknowledgementReport;

	@FindBy(xpath = "//li[@class='ui-state-default ui-corner-top ui-tabs-active ui-state-active']")
	WebElement currentAcknowledgement;

	@FindBy(xpath = "//a[@href='/RampIPacs/Reports/ExportVendorCurrentCertification']")
	WebElement exportVendorCurrentCertification;

	@FindBy(xpath = "//a[@id='ui-id-2']")
	WebElement assignedAcknowledgement;

	@FindBy(xpath = "//a[@href='/RampIPacs/Reports/ExportVendorExpiredCertificaton']")
	WebElement exportVendorExpiredCertificaton;

	@FindBy(xpath = "//a[@id='ui-id-3']")
	WebElement acknowledgementHistory;

	@FindBy(xpath = "//a[@href='/RampIPacs/Reports/ExportVendorHistoryCertification']")
	WebElement exportVendorHistoryCertification;
	
	@FindBy(xpath = "//select[@name='ml_dyntable_length']")
	WebElement showEntriesCurrentAcknowledgement;
	
	@FindBy(xpath = "//input[@aria-controls='ml_dyntable']")
	WebElement searchCurrentAcknowledgement;

	// servicer document status report section all web elements

	@FindBy(xpath = "//a[@href='/RampIPacs/Reports/VendorDocumentStatusReport']")
	WebElement ServicerDocumentStatusReportLink;
	@FindBy(xpath = "//input[@id='vendorname']")
	WebElement selectServicer;
	@FindBy(xpath = "//input[@id='checkboxvendor1']")
	WebElement allchkboxServicer;
	@FindBy(xpath = "//button[@id='getvendorreports']")
	WebElement submitBtn;
	@FindBy(xpath = "//div[@id='downbuttonvendor']")
	WebElement exportToExcelbtn;
	@FindBy(xpath = "//input[@id='vendorcategory']")
	WebElement servicerCategory;
	@FindBy(xpath = "//input[@id='CkboxAllVendorCategory']")
	WebElement CkboxAllVendorCategory;
	
	@FindBy(xpath = "//select[@name='ml_dyntableVD_length']")
	WebElement showEntriesServicerDocument;
	@FindBy(xpath = "//input[@aria-controls='ml_dyntableVD']")
	WebElement searchServicerDocument;
	

	// Servicer Details Report Section all web elements

	@FindBy(xpath = "//a[@href='/RampIPacs/Reports/VendorDetailsReport']")
	WebElement ServicerDetailsReportLink;
	@FindBy(xpath = "//input[@id='checkboxvendor1']")
	WebElement checkboxvendor1;

	// Constructor to initialize the PageFactory elements

	public ECM_Report() {
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

		partnercode.sendKeys(testData.get("ECM_partnerCode"));
		username.sendKeys(testData.get("ECM_username"));
		password.sendKeys(testData.get("ECM_password"));

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
	}

	public void exportCurrentApprovalListSection() {
		reportMenu.click();
		approvalReport.click();
		currentApprovalListSection.click();
		exportDataApprovalPendingSection.click();

	}

	public void exportApprovalListHistorySection() {
		reportMenu.click();
		approvalReport.click();
		ApprovalListHistorySection.click();
		exportDataApprovalHistorySection.click();

	}

	public void exportCurrentAcknowledgement() {
		reportMenu.click();
		acknowledgementReport.click();
		currentAcknowledgement.click();
		exportVendorCurrentCertification.click();

	}

	public void exportAssignedAcknowledgement() {
		reportMenu.click();
		acknowledgementReport.click();
		assignedAcknowledgement.click();
		exportVendorExpiredCertificaton.click();

	}

	public void exportAcknowledgementHistory() {
		reportMenu.click();
		acknowledgementReport.click();
		acknowledgementHistory.click();
		exportVendorHistoryCertification.click();

	}

	public void exportServicerDocumentStatusReportbyServicer() {

		reportMenu.click();
		ServicerDocumentStatusReportLink.click();
		selectServicer.click();
		allchkboxServicer.click();
		submitBtn.click();
		exportToExcelbtn.click();

	}

	public void exportServicerDocumentStatusReportbyServicerCategory() {
		reportMenu.click();
		ServicerDocumentStatusReportLink.click();
		servicerCategory.click();
		CkboxAllVendorCategory.click();
		submitBtn.click();
		exportToExcelbtn.click();

	}

	public void exportServicerDetailsReportbyServicer() {
		reportMenu.click();
		ServicerDetailsReportLink.click();
		selectServicer.click();
		checkboxvendor1.click();
		submitBtn.click();
		exportToExcelbtn.click();

	}

	public void exportServicerDetailsReportbyServicerCategory() {
		reportMenu.click();
		ServicerDetailsReportLink.click();
		servicerCategory.click();
		CkboxAllVendorCategory.click();
		submitBtn.click();
		exportToExcelbtn.click();

	}

	public void verifyApprovalListReportPageShowEntries() {
		reportMenu.click();
		approvalReport.click();
		currentApprovalListSection.click();
		showEntries.click();
		// Assuming showEntries is a dropdown, you might need to select an option
		// For example, if you want to select "10" entries:
		Select select = new Select(showEntries);
		select.selectByValue("10");	
		WaitUtil.waitForElementToBeVisible(driver, showEntries); // Adjust the sleep time as needed
		
		
	}

	public void verifyApprovalListReportPageSearch() {
		reportMenu.click();
		approvalReport.click();
		currentApprovalListSection.click();
		// Assuming there is a search input field, you would locate it and perform a search
		WebElement searchInput = driver.findElement(By.xpath("//input[@aria-controls='section_dyntable']")); 
		searchInput.sendKeys("Test"); 
		assert searchInput.isDisplayed() : "Search input is not displayed!";
	
	}

	public void verifyApprovalListReportPagePagination() {
		reportMenu.click();
		approvalReport.click();
		currentApprovalListSection.click();
		WebElement first = driver.findElement(By.xpath("//a[@id='section_dyntable_first']"));
		first.click();
		WebElement previous = driver.findElement(By.xpath("//a[@id='section_dyntable_previous']"));
		previous.click();
		WebElement next = driver.findElement(By.xpath("//a[@id='section_dyntable_next']"));
		next.click();
		WebElement last = driver.findElement(By.xpath("//a[@id='section_dyntable_last']"));
		last.click();
		
		}

	public void verifyAcknowledgementReportPageShowEntries() {
		reportMenu.click();
		acknowledgementReport.click();
		currentAcknowledgement.click();
		showEntriesCurrentAcknowledgement.click();
		// Assuming showEntries is a dropdown, you might need to select an option
		// For example, if you want to select "10" entries:
		Select select = new Select(showEntriesCurrentAcknowledgement);
		select.selectByValue("50");	
		WaitUtil.waitForElementToBeVisible(driver, showEntriesCurrentAcknowledgement); // Adjust the sleep time as needed
		
	}

	public void verifyAcknowledgementReportPageSearch() {
		reportMenu.click();
		acknowledgementReport.click();
		currentAcknowledgement.click();
		searchCurrentAcknowledgement.click();
		// Assuming there is a search input field, you would locate it and perform a search
		WebElement searchInput = driver.findElement(By.xpath("//input[@aria-controls='ml_dyntable']")); 
		searchInput.sendKeys("Test"); 
		assert searchInput.isDisplayed() : "Search input is not displayed!";
	
	}
	
	public void verifyAcknowledgementReportPagePagination() {
		reportMenu.click();
		acknowledgementReport.click();
		currentAcknowledgement.click();
		WebElement first = driver.findElement(By.xpath("//a[@id='ml_dyntable_first']"));
		first.click();
		WebElement previous = driver.findElement(By.xpath("//a[@id='ml_dyntable_previous']"));
		previous.click();
		WebElement next = driver.findElement(By.xpath("//a[@id='ml_dyntable_next']"));
		next.click();
		WebElement last = driver.findElement(By.xpath("//a[@id='ml_dyntable_last']"));
		last.click();
	}

	public void verifyServicerDocumentStatusReportPageShowEntries() {
		reportMenu.click();
		ServicerDocumentStatusReportLink.click();
		selectServicer.click();
		allchkboxServicer.click();
		submitBtn.click();
		showEntriesServicerDocument.click();
		// Assuming showEntries is a dropdown, you might need to select an option
		// For example, if you want to select "10" entries:
		Select select = new Select(showEntriesServicerDocument);
		select.selectByValue("50");	
		WaitUtil.waitForElementToBeVisible(driver, showEntriesServicerDocument); // Adjust the sleep time as needed
		
	}

	public void verifyServicerDocumentStatusReportPageSearch() {
		reportMenu.click();
		ServicerDocumentStatusReportLink.click();
		selectServicer.click();
		allchkboxServicer.click();
		submitBtn.click();
		searchServicerDocument.click();
		// Assuming there is a search input field, you would locate it and perform a search
		WebElement searchInput = driver.findElement(By.xpath("//input[@aria-controls='ml_dyntableVD']")); 
		searchInput.sendKeys("Test"); 
		assert searchInput.isDisplayed() : "Search input is not displayed!";
		
	}

	public void verifyServicerDocumentStatusReportPagePagination() {
		reportMenu.click();
		ServicerDocumentStatusReportLink.click();
		selectServicer.click();
		allchkboxServicer.click();
		submitBtn.click();
		WebElement first = driver.findElement(By.xpath("//a[@id='ml_dyntableVD_first']"));
		first.click();
		WebElement previous = driver.findElement(By.xpath("//a[@id='ml_dyntableVD_previous']"));
		previous.click();
		WebElement next = driver.findElement(By.xpath("//a[@id='ml_dyntableVD_next']"));
		next.click();
		WebElement last = driver.findElement(By.xpath("//a[@id='ml_dyntableVD_last']"));
		last.click();
		
	}

	public void verifyValidationMessageUncheckedServicerOption() {
		reportMenu.click();
		ServicerDocumentStatusReportLink.click();
		submitBtn.click();
		
		WebElement validationMessage = driver.findElement(By.xpath("//div[@id='popup_message']"));
		String expectedMessage = "Please select an option first.";
		
		if (validationMessage.isDisplayed()) {
			String actualMessage = validationMessage.getText();
			assert actualMessage.equals(expectedMessage) : "Validation message does not match!";
		} else {
			assert false : "Validation message is not displayed!";
		}
		
		
	}

	public void verifyValidationMessageUncheckedAllchkbox() {
		reportMenu.click();
		ServicerDocumentStatusReportLink.click();
		selectServicer.click();
		submitBtn.click();
		WebElement validationMessage = driver.findElement(By.xpath("//div[@id='popup_message']"));
		String expectedMessage = "Either select required servicer names from Select servicer Names dropdown, or check All checkbox to select all servicer.";
		if (validationMessage.isDisplayed()) {
			String actualMessage = validationMessage.getText();
			assert actualMessage.equals(expectedMessage) : "Validation message does not match!";
		} else {
			assert false : "Validation message is not displayed!";
		
		}
		
	}

	public void verifyValidationMessageUncheckedServicerCategoryAllchkbox() {
		reportMenu.click();
		ServicerDocumentStatusReportLink.click();
		servicerCategory.click();
		submitBtn.click();
		WebElement validationMessage = driver.findElement(By.xpath("//div[@id='popup_message']"));
		String expectedMessage = "Either select required servicer category from Select Servicer category dropdown, or check All checkbox to select all servicer categories.";
		if (validationMessage.isDisplayed()) {
			String actualMessage = validationMessage.getText();
			assert actualMessage.equals(expectedMessage) : "Validation message does not match!";
		} else {
			assert false : "Validation message is not displayed!";
	
		}
	}

	public void verifyValidationMessageEmptyServicerName() {
		reportMenu.click();
		ServicerDetailsReportLink.click();
		selectServicer.click();
		submitBtn.click();
		
		WebElement validationMessage = driver.findElement(By.xpath("//div[@id='popup_message']"));
		String expectedMessage = "Either select required servicer names from Select Servicer Names dropdown, or check All checkbox to select all servicer.";
		
		if (validationMessage.isDisplayed()) {
			String actualMessage = validationMessage.getText();
			assert actualMessage.equals(expectedMessage) : "Validation message does not match!";
		} else {
			assert false : "Validation message is not displayed!";
		
		}
		
		
	}

	public void verifyValidationMessageEmptyServicerCategory() {
		reportMenu.click();
		ServicerDetailsReportLink.click();
		servicerCategory.click();
		submitBtn.click();
		WebElement validationMessage = driver.findElement(By.xpath("//div[@id='popup_message']"));
		String expectedMessage = "Either select required servicer category from Select Servicer category dropdown, or check All checkbox to select all servicer categories.";
		if (validationMessage.isDisplayed()) {
			String actualMessage = validationMessage.getText();
			assert actualMessage.equals(expectedMessage) : "Validation message does not match!";
		} else {
			assert false : "Validation message is not displayed!";
		
		}
			
		
	}
}

