package com.ipacs.qa.ecm.pages;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ipacs.qa.baseclass.TestBase;
import com.ipacs.qa.utilities.ConfigUtil;
import com.ipacs.qa.utilities.ExcelReader;
import com.ipacs.qa.utilities.WaitUtil;

public class ECM_AdminSection extends TestBase {

	// Login Page

	@FindBy(id = "partnerCode")
	WebElement partnercode;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(id = "Login")
	WebElement submit;

// Admin section page web elements
	@FindBy(xpath = "//li[@id='Admin_link']")
	WebElement adminSectionLink;
	@FindBy(xpath = "//a[normalize-space()='Add New User']")
	WebElement addNewUserLink;

//Add New User Page web elements
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement FirstName;
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement LastName;
	@FindBy(xpath = "//input[@id='UserName']")
	WebElement UserName;
	@FindBy(xpath = "//input[@id='EmailId']")
	WebElement EmailId;
	@FindBy(xpath = "//input[@id='dateofjoining']")
	WebElement dateofjoining;
	@FindBy(xpath = "//label[normalize-space()='Is Servicer']")
	WebElement IsServicer;
	@FindBy(xpath = "//label[normalize-space()='Is Client']")
	WebElement IsClient;
	@FindBy(xpath = "//label[normalize-space()='Roles']")
	WebElement Roles;
	@FindBy(xpath = "//label[normalize-space()='Network Manual Management Roles']")
	WebElement NetworkManualManagementRoles;
	@FindBy(xpath = "//label[normalize-space()='Complaint Log Roles']")
	WebElement ComplaintLogRoles;
	@FindBy(xpath = "//label[normalize-space()='Is Active']")
	WebElement IsActive;
	@FindBy(xpath = "//label[normalize-space()='Is Provana User']")
	WebElement IsProvanaUser;
	@FindBy(xpath = "//div[@data-section='addDashboard']")
	WebElement assignDashboard;
	@FindBy(xpath = "//div[@data-section='addlinkedpartner']")
	WebElement addLinkedpartner;
	@FindBy(xpath = "//button[@id='submitBtn']")
	WebElement submitBtn;
	@FindBy(xpath = "//div[@id='uniform-Admin-chk2']")
	WebElement rolesAdmin;
	@FindBy(xpath = "//div[@id='uniform-Auditor-chk2']")
	WebElement NmmRoles_Auditor;
	@FindBy(xpath = "//div[@id='uniform-ComplaintContact-chk2']")
	WebElement complaintLogRoles;

	// Constructor to initialize the PageFactory elements

	public ECM_AdminSection() {
		PageFactory.initElements(driver, this);
	}

	public boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		if (dirContents == null) {
			return false;
		}

		for (File file : dirContents) {
			if (file.getName().contains(fileName)) {
				return true;
			}
		}
		return false;
	}

	public void login() {
		Map<String, String> testData = ExcelReader.readKeyValueFromExcel(ConfigUtil.getTestDataFilePath(), "TestData");

		partnercode.sendKeys(testData.get("ECM_partnerCode"));
		username.sendKeys(testData.get("ECM_username"));
		password.sendKeys(testData.get("ECM_password"));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
	}

	public void navigateToAdminSection() {
		// Click on the Admin section link
		adminSectionLink.click();

	}

	public void clickAddNewUserLink() {
		addNewUserLink.click();

	}

	public void verifyNewUserPageUI() {
		// Verify the presence of each element on the Add New User page
		assert FirstName.isDisplayed() : "First Name field is not displayed.";
		assert LastName.isDisplayed() : "Last Name field is not displayed.";
		assert UserName.isDisplayed() : "User Name field is not displayed.";
		assert EmailId.isDisplayed() : "Email ID field is not displayed.";
		assert dateofjoining.isDisplayed() : "Date of Joining field is not displayed.";
		assert IsServicer.isDisplayed() : "Is Servicer checkbox is not displayed.";
		assert IsClient.isDisplayed() : "Is Client checkbox is not displayed.";
		assert Roles.isDisplayed() : "Roles section is not displayed.";
		assert NetworkManualManagementRoles.isDisplayed() : "Network Manual Management Roles section is not displayed.";
		assert ComplaintLogRoles.isDisplayed() : "Complaint Log Roles section is not displayed.";
		assert IsActive.isDisplayed() : "Is Active checkbox is not displayed.";
		assert IsProvanaUser.isDisplayed() : "Is Provana User checkbox is not displayed.";
		assert assignDashboard.isDisplayed() : "Assign Dashboard section is not displayed.";
		assert addLinkedpartner.isDisplayed() : "Add Linked Partner section is not displayed.";
		assert submitBtn.isDisplayed() : "Submit button is not displayed.";

	}

	public void addNewUser() {
		Map<String, String> testData = ExcelReader.readKeyValueFromExcel(ConfigUtil.getTestDataFilePath(), "TestData");

		WaitUtil.waitForSeconds(8);

		// Fill in the form fields with data from the test data
		FirstName.sendKeys(testData.get("ECM_FirstName"));
		LastName.sendKeys(testData.get("ECM_LastName"));
		UserName.sendKeys(testData.get("ECM_UserName"));
		EmailId.sendKeys(testData.get("ECM_EmailId"));
		selectDate(); // Call the method to select the date
		// Click on the checkboxes if they are present

		rolesAdmin.click();
		NmmRoles_Auditor.click();
		complaintLogRoles.click();
		submitBtn.click();

	}

		public void selectDate() {
			dateofjoining.click();

			// 2. Navigate to July 2025
			while (true) {
				String monthYear = driver
						.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']"))
						.getText();
				if (monthYear.equals("July, 2025")) {
					break;
				} else {
					// Click next arrow to navigate to the next month
					driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']")).click();
				}
			}

			// 3. Select 31st
			List<WebElement> dates = driver.findElements(By.xpath("//td[@class='day' and text()='31']"));
			for (WebElement date : dates) {
				if (date.isDisplayed()) {
					date.click();
					break;
				}
			}

		}


	
	public void verifyNewUserAdded() {
		// Verify that the new user has been added successfully
		// This can be done by checking for a success message or by verifying the user
		// list
		String successMessage = "User added successfully"; // Example message, adjust as needed
		WebElement messageElement = driver.findElement(By.xpath("//div[contains(text(),'" + successMessage + "')]"));
		assert messageElement.isDisplayed() : "Success message is not displayed.";

	}

}
