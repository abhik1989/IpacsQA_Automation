package com.ipacs.qa.icm.pages;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ipacs.qa.baseclass.TestBase;
import com.ipacs.qa.utilities.ConfigUtil;
import com.ipacs.qa.utilities.ExcelReader;
import com.ipacs.qa.utilities.TestUtil;

public class VendorManagement extends TestBase {

	

    // Login Page
    @FindBy(id = "partnerCode")
    WebElement partnercode;
    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "Password")
    WebElement password;
    @FindBy(id = "Login")
    WebElement submit;

    // Vendor Management Page
    //@FindBy(xpath = "//a[normalize-space()='Vendor Management']")
    @FindBy(xpath = "//li[@id='vendormasterlist_link']")
    WebElement vendormanagementTab;
    @FindBy(xpath = "//a[@href='/Vendor/AddVendorCategory']")
    WebElement addVendorCategorySubmenu;
    @FindBy(xpath = "//input[@id='name']")
    WebElement txtBoxVendorCategoryName;
    @FindBy(xpath = "//input[@id='NoOfComplaintsToChiefOfficer']")
    WebElement txtBoxComplaintManager;
    @FindBy(xpath = "//input[@id='NoOfComplaintsToManagingPartner']")
    WebElement txtBoxAlertChiefComplianceOffice;
    @FindBy(xpath = "//input[@id='documentType_11']")
    WebElement requiredDocumentation;
    @FindBy(xpath = "//button[@id='addNewAuditCategory']")
    WebElement addvendorcategoryButton;
    @FindBy(xpath = "//span[normalize-space()='Vendor category added successfully']")
    WebElement vendorCatsuccessMsg;

    // Add Vendor Page
    @FindBy(xpath = "//a[@href='/Vendor/AddVendor']")
    WebElement addvendorSubMenu;
    @FindBy(xpath = "//input[@id='name']")
    WebElement vendorName;
    @FindBy(xpath = "//span[normalize-space()='Select Vendor Category']")
    WebElement selectVendorCategory;
    @FindBy(xpath = "//div[@id='status_chzn']//a[@class='chzn-single']")
    WebElement selectStatus;
    @FindBy(xpath = "//span[normalize-space()='Select Receive NPI']")
    WebElement selectReceiveNPI;
    @FindBy(xpath = "//span[normalize-space()='Public']")
    WebElement selectAccessLevel;
    @FindBy(xpath = "//span[normalize-space()='Select primary vendor contact at company']")
    WebElement selectprimaryvendorcontactatcompany;

    @FindBy(xpath = "//a[@class='overlay_form_link uploadbtnshow']")
    WebElement uploadBtn;
    @FindBy(xpath = "//span[normalize-space()='Other']")
    WebElement SelectDocumentType;
    @FindBy(xpath = "//button[@id='vendorFinishButton1']")
    WebElement completeBtn;
    @FindBy(xpath = "//span[normalize-space()='Vendor added successfully.']")
    WebElement successMsgafterVendoradded;

    @FindBy(xpath = "//button[@onclick=\"docAttribute();\"]")
    WebElement docAttributeBtn;
    
    public VendorManagement() {
        PageFactory.initElements(driver, this);
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


    public void clickVendorManagement() throws InterruptedException {
        vendormanagementTab.click();
        Thread.sleep(2000);
    }

    public void clickAddVendorCategory() throws InterruptedException {
        addVendorCategorySubmenu.click();
        Thread.sleep(2000);
    }

    public void enterDetailsInAddVendorCategory() throws InterruptedException {
        String vendorCategoryName = "TestCat" + new SimpleDateFormat("MMdd").format(System.currentTimeMillis()) + TestUtil.randomNumber(1, 100);
        txtBoxVendorCategoryName.sendKeys(vendorCategoryName);
        Thread.sleep(2000);
        txtBoxComplaintManager.sendKeys(TestUtil.randomNumber(1, 100));
        Thread.sleep(2000);
        txtBoxAlertChiefComplianceOffice.sendKeys(TestUtil.randomNumber(1, 100));
        Thread.sleep(2000);
        if (!requiredDocumentation.isSelected()) {
            requiredDocumentation.click();
        }
    }

    public void addvendorcategoryButton() throws InterruptedException {
        addvendorcategoryButton.click();
        Thread.sleep(2000);
    }

    public void verifyTxtAddSuccessfullyMsg() {
        String actualMsg = vendorCatsuccessMsg.getText();
        String expectedMsg = "Vendor category added successfully";
        System.out.println(actualMsg.equals(expectedMsg) ? "Vendor category added successfully" : "Vendor category not added successfully");
    }

    public void clickAddVendor() throws InterruptedException {
        addvendorSubMenu.click();
        Thread.sleep(2000);
    }

	/*
	 * public void enterDetailsInAddVendorPage() throws InterruptedException {
	 * String name = "TestCat" + new
	 * SimpleDateFormat("MMdd").format(System.currentTimeMillis()) +
	 * TestUtil.randomNumber(1, 100); vendorName.sendKeys(name);
	 * 
	 * selectCustomDropdown(selectVendorCategory,
	 * getReadData("selectVendorCategory")); selectCustomDropdown(selectStatus,
	 * getReadData("selectStatus")); selectCustomDropdown(selectAccessLevel,
	 * getReadData("selectAccessLevel"));
	 * selectCustomDropdown(selectprimaryvendorcontactatcompany,
	 * getReadData("selectprimaryvendorcontactatcompany"));
	 * selectCustomDropdown(selectReceiveNPI, getReadData("selectReceiveNPI")); }
	 */
    public void UploadDocumentsBtn() throws InterruptedException {
        uploadBtn.click();
        Thread.sleep(2000);
        SelectDocumentType.click();
        completeBtn.click();
    }

    public void verifyAddSuccessfullyMsg() {
        System.out.println("Vendor added successfully");
    }
}
