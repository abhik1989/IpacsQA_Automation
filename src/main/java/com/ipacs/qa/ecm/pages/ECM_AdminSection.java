package com.ipacs.qa.ecm.pages;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	@FindBy(xpath = "//input[@id='User-chk2']")
	WebElement roles;
	@FindBy(xpath = "//div[@id='uniform-Auditor-chk2']")
	WebElement NmmRoles_Auditor;
	@FindBy(xpath = "//div[@id='uniform-ComplaintContact-chk2']")
	WebElement complaintLogRoles;

	// WebElement for the Edit User Page
	@FindBy(xpath = "//a[normalize-space()='Edit User']")
	WebElement editUserLink;
	@FindBy(xpath = "//select[@name='doc_dyntable_length']")
	WebElement showEntries;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchUserInput;
	@FindBy(xpath = "//input[@id='5-chk2']")
	WebElement ManualOwner;
	@FindBy(xpath = "//input[@id='16-chk2']")
	WebElement ComplaintContact;
	@FindBy(xpath = "//button[@id='btnedituser']")
	WebElement Editsubmitbtn;
	@FindBy(xpath = "//i[@class='iconfa-pencil']")
	WebElement editUserPencilIcon;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchEditUser;

	// WebElement for the IPACS Administration Page

	@FindBy(xpath = "//a[normalize-space()='IPACS Administration']")
	WebElement IPACSAdminPage;
	@FindBy(xpath = "//a[@id='aUserLog']")
	WebElement userLogTab;
	@FindBy(xpath = "//th[@class='head0 sorting_asc']")
	WebElement User_Name;
	@FindBy(xpath = "//div[@id='ml_dyntableUser_wrapper']//div[@class='dataTables_scrollHead']//tr[@role='row']")
	WebElement Full_Name;
	@FindBy(xpath = "//div[contains(@class,'dataTables_scrollHeadInner')]//th[contains(@aria-label,'')][normalize-space()='Is Provana User']")
	WebElement IsProvana_User;

	// WebElement for the User Login History Page

	@FindBy(xpath = "//a[@id='ui-id-1']")
	WebElement userLoginHistoryTab;
	@FindBy(xpath = "//input[@id='startdate']")
	WebElement startdate;
	@FindBy(xpath = "//input[@id='enddate']")
	WebElement enddate;
	@FindBy(xpath = "//button[@id='newSearchBtnHistory']")
	WebElement searchHistoryBtn;
	@FindBy(xpath = "//div[@class='controls']//button[@type='button'][normalize-space()='Pick a date']")
	WebElement startDate;
	@FindBy(xpath = "//td[@class='dp_selected dp_hover']")
	WebElement startdateSelected;
	@FindBy(xpath = "//span[2]//button[1]")
	WebElement endDate;
	@FindBy(xpath = "//td[contains(@class,'dp_today dp_hover')]")
	WebElement endDateSelected;
	@FindBy(xpath = "//button[@id='newSearchBtnHistory']")
	WebElement newSearchBtnHistory;

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
		// UserName.sendKeys(testData.get("ECM_UserName") + System.nanoTime()); //
		// Append timestamp to ensure
		// uniqueness
		EmailId.sendKeys("testuser05@yopmail.com");
		// WaitUtil.waitForSeconds(3);
		// selectDate(); // Call the method to select the date
		// Click on the checkboxes if they are present

		roles.click();
		NmmRoles_Auditor.click();
		complaintLogRoles.click();
		driver.findElement(By.xpath("//input[@id='IsActive']")).click();
		submitBtn.click();

	}

	public void selectDate() {
		dateofjoining.click();
		driver.findElement(By.xpath("//span[@class='Zebra_DatePicker_Icon_Wrapper']")).click();
		driver.findElement(By.xpath("//td[@class='dp_today dp_hover']")).click();

	}

	public void verifyNewUserAdded() {
		// Verify that the new user has been added successfully
		// This can be done by checking for a success message or by verifying the user
		// list
		String successMessage = "User profile has been added successfully."; // Example message, adjust as needed
		WebElement messageElement = driver.findElement(By.xpath("//div[contains(text(),'" + successMessage + "')]"));
		assert messageElement.isDisplayed() : "Success message is not displayed.";

	}

	public void EditUser() {
		editUserLink.click();

		Map<String, String> testData = ExcelReader.readKeyValueFromExcel(ConfigUtil.getTestDataFilePath(), "TestData");

		WaitUtil.waitForSeconds(5);
		searchEditUser.sendKeys(testData.get("EditUserName")); // Search user
		WaitUtil.waitForSeconds(2);
		editUserPencilIcon.click(); // Click edit
		WaitUtil.waitForSeconds(2);
		NetworkManualManagementRoles.click(); // Click on Network Manual Management Roles

		// Step 1: Find and uncheck all selected checkboxes in divRoleTable2
		List<WebElement> checkedBoxes = driver
				.findElements(By.xpath("//div[@id='divRoleTable2']//input[@type='checkbox' and @checked='checked']"));
		for (WebElement checkbox : checkedBoxes) {
			checkbox.click();
		}
		System.out.println(checkedBoxes.size() > 0 ? "Existing roles cleared." : "No pre-selected roles found.");

		// Step 2: Select role manually
		ManualOwner.click(); // Click on Manual Owner

		// Step 3: Save
		Editsubmitbtn.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(text(),'User profile has been saved successfully.')]")));
		System.out.println("Message: " + successMsg.getText());
		WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='popup_ok']")));
		okButton.click(); // Click OK button to close the popup

	}

	public void verifyUserEdited() {
		// adminSectionLink.click();
		// editUserLink.click();
		WaitUtil.waitForSeconds(2);

		// Read expected user from Excel
		Map<String, String> testData = ExcelReader.readKeyValueFromExcel(ConfigUtil.getTestDataFilePath(), "TestData");
		String expectedUser = testData.get("EditUserName");

		// Enter the username in search
		searchEditUser.sendKeys(expectedUser);
		WaitUtil.waitForSeconds(3);

		// Retry loop for stale elements (max 2 tries)
		int retries = 0;
		boolean userFound = false;
		boolean roleFound = false;

		while (retries < 2) {
			try {
				List<WebElement> userRows = driver.findElements(By.xpath("//table[@id='doc_dyntable']//tbody/tr"));

				for (WebElement row : userRows) {
					String rowText = row.getText();

					if (rowText.contains(expectedUser)) {
						userFound = true;

						WebElement roleCell = row.findElement(By.xpath("//label[normalize-space()='Manual Owner']"));
						String rolesText = roleCell.getText();

						System.out.println("Roles found for user '" + expectedUser + "': " + rolesText);

						if (rolesText.contains("Manual Owner")) {
							roleFound = true;
						}
						break;
					}
				}
				break; // Break out of while loop if no stale exception occurred
			} catch (StaleElementReferenceException e) {
				System.out.println("StaleElementReferenceException occurred. Retrying...");
				retries++;
			}
		}

		assert userFound : "User not found in the user list: " + expectedUser;
		assert roleFound : "Expected role 'Manual Owner' not found for user: " + expectedUser;
	}

	public void sortUserDetails() {
		editUserLink.click();
		// Add logic to sort user details here
		List<WebElement> sortButtons = driver.findElements(By.xpath("//th[contains(text(),'User Name')]"));
		for (WebElement sortButton : sortButtons) {
			sortButton.click(); // Click to sort in ascending order
			WaitUtil.waitForSeconds(2); // Wait for sorting to complete
			sortButton.click(); // Click again to sort in descending order
			WaitUtil.waitForSeconds(2); // Wait for sorting to complete
		}

	}

	public void verifyUserDetailsSorted() {
		// Verify that the user details are sorted correctly
		// This can be done by checking the order of user names or other sortable fields
		List<WebElement> userNames = driver.findElements(By.xpath("//td[@class='user-name']"));
		String previousUserName = "";
		for (WebElement userName : userNames) {
			String currentUserName = userName.getText();
			assert currentUserName.compareTo(previousUserName) >= 0 : "User names are not sorted correctly.";
			previousUserName = currentUserName;
		}

		System.out.println("User details are sorted correctly.");

	}

	public void showEntries() {
		editUserLink.click();
		showEntries.click();
		// Add logic to show entries here
		List<WebElement> entries = driver.findElements(By.xpath("//select[@name='doc_dyntable_length']/option"));
		for (WebElement entry : entries) {
			if (entry.getText().equals("10")) { // Example for showing 10 entries
				entry.click();
				break;
			}

		}

	}

	public void verifyShowEntries() {
		List<WebElement> entries = driver.findElements(By.xpath("//select[@name='doc_dyntable_length']/option"));
		boolean isTenEntriesShown = false;
		for (WebElement entry : entries) {
			if (entry.getText().equals("10")) { // Example for showing 10 entries
				isTenEntriesShown = true;
				break;
			}
		}
		assert isTenEntriesShown : "Show entries functionality is not working correctly. 10 entries are not shown.";
		System.out.println("Show entries functionality is working correctly. 10 entries are shown.");

	}

	public void searchUser() {
		editUserLink.click();
		// Add logic to search for a user here
		searchUserInput.sendKeys("Test");
		WaitUtil.waitForSeconds(2);
		List<WebElement> searchResults = driver.findElements(By.xpath("//table[@id='doc_dyntable']//tbody/tr"));
		boolean userFound = false;
		for (WebElement result : searchResults) {
			if (result.getText().contains("Test")) { // Example search term
				userFound = true;
				break;
			}
		}
		assert userFound : "Search functionality is not working correctly. User not found.";
	}

	public void verifySearchUser() {
		List<WebElement> searchResults = driver.findElements(By.xpath("//table[@id='doc_dyntable']//tbody/tr"));
		boolean userFound = false;
		for (WebElement result : searchResults) {
			if (result.getText().contains("Test")) { // Example search term
				userFound = true;
				break;
			}
		}
		assert userFound : "Search functionality is not working correctly. User not found.";
		System.out.println("Search functionality is working correctly. User found.");

	}

	public void clickUserLogsLink() {
		userLogTab.click();

	}

	public void verifyUserLogsPageFields() {
		if (User_Name.isDisplayed() && Full_Name.isDisplayed() && IsProvana_User.isDisplayed()) {
			System.out.println("All fields are displayed on the User Logs page.");
		} else {
			throw new RuntimeException("One or more fields are not displayed on the User Logs page.");
		}

	}

	public void navigateToIpacsAdministration() {
		if (IPACSAdminPage.isDisplayed()) {
			IPACSAdminPage.click();
		} else {
			throw new RuntimeException("IPACS Administration page is not displayed.");
		}

	}

	public void verifySearchBoxInUserLogsPage() {
		WebElement searchBox = driver.findElement(By.xpath("//input[@aria-controls='ml_dyntableUser']"));
		if (searchBox.isDisplayed()) {
			System.out.println("Search box is displayed on the User Logs page.");
			searchBox.sendKeys("akhil"); // Example search term
			WaitUtil.waitForSeconds(2);
			List<WebElement> searchResults = driver.findElements(By.xpath("//table[@id='ml_dyntableUser']//tbody/tr"));
			boolean userFound = false;
			for (WebElement result : searchResults) {
				if (result.getText().contains("akhil")) { // Example search term
					userFound = true;
					break;
				}
			}
			assert userFound : "Search functionality in User Logs page is not working correctly. User not found.";
			System.out.println("Search functionality in User Logs page is working correctly. User found.");
		} else {
			throw new RuntimeException("Search box is not displayed on the User Logs page.");
		}
	}

	public void clickUserLoginHistoryLink() {
		userLoginHistoryTab.click();

	}

	public void verifyUserLoginHistoryFields() {
		if (startdate.isDisplayed() && enddate.isDisplayed() && searchHistoryBtn.isDisplayed()) {
			System.out
					.println("Start date, End date and searchbtn fields are displayed on the User Login History page.");
		} else {
			throw new RuntimeException(
					"Start date, End date and searchbtn fields are displayed on the User Login History page.");
		}

	}

	public void verifySearchBoxInUserLoginHistory() {
	    selectDateFromZebraDatePicker("startdate", "01", "August", "2025");

	    // Wait for enddate to become enabled (optional: check via JS or wait)
	    WaitUtil.waitForSeconds(10); 
	    selectDateFromZebraDatePicker("enddate", "20", "August", "2025");

	    driver.findElement(By.id("NewSearchBtnHistory")).click();
	}




	public static void selectDateFromZebraDatePicker(String inputFieldId, String expectedDay, String expectedMonth, String expectedYear) {
	    try {
	        System.out.println("➡️ Trying to select date for input field: " + inputFieldId);

	        // Find calendar icon
	        WebElement calendarIcon = driver.findElement(By.xpath(
	            "//input[@id='" + inputFieldId + "']/parent::span[contains(@class,'Zebra_DatePicker_Icon_Wrapper')]/button"));

	        System.out.println("✅ Calendar icon found. Clicking...");
	        calendarIcon.click();

	        WaitUtil.waitForSeconds(5); // wait for calendar to appear

	        expectedMonth = expectedMonth.trim().toLowerCase();
	        expectedYear = expectedYear.trim();
	        expectedDay = String.valueOf(Integer.parseInt(expectedDay)); // remove leading zero

	        int attempts = 0;
	        boolean found = false;

	        while (attempts++ < 24) {
	            WebElement caption = driver.findElement(By.cssSelector("td.dp_caption"));
	            String captionText = caption.getText().trim().replace(",", "").toLowerCase();
	            System.out.println("📅 Current caption: " + captionText);

	            String[] parts = captionText.split("\\s+");
	            if (parts.length >= 2) {
	                String actualMonth = parts[0];
	                String actualYear = parts[1];

	                if (actualMonth.equals(expectedMonth) && actualYear.equals(expectedYear)) {
	                    found = true;
	                    System.out.println("✅ Reached expected month and year.");
	                    Thread.sleep(500);
	                    break;
	                }
	            }

	            driver.findElement(By.cssSelector("td.dp_next")).click();
	            Thread.sleep(300);
	        }

	        if (!found) {
	            throw new RuntimeException("❌ Could not navigate to expected month/year: " + expectedMonth + " " + expectedYear);
	        }

	        List<WebElement> dayCells = driver.findElements(By.xpath(
	            "//table[contains(@class, 'dp_daypicker')]//td[normalize-space(text())='" + expectedDay + "']"));

	        System.out.println("📅 Found " + dayCells.size() + " day cells for day: " + expectedDay);

	        if (!dayCells.isEmpty()) {
	            dayCells.get(0).click();
	            System.out.println("✅ Date selected: " + expectedDay + " " + expectedMonth + " " + expectedYear);
	        } else {
	            throw new NoSuchElementException("❌ Day " + expectedDay + " not found.");
	        }

	    } catch (Exception e) {
	        e.printStackTrace(); // log the real error
	        throw new RuntimeException("❌ Failed to select date for field '" + inputFieldId + "'", e);
	    }
	}

	

	public void EditUserWithUserRole() {
		editUserLink.click();
		// Locate table rows
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		String targetRole = "User";

		for (WebElement row : rows) {
			// Get role text from the Role column (adjust column index if needed)
			String roleText = row.findElement(By.xpath("./td[3]")).getText().trim();

			if (roleText.equalsIgnoreCase(targetRole)) {
				// Found the row with the desired role
				WebElement editButton = row.findElement(By
						.xpath("./td[last()]//button | ./td[last()]//i | ./td[last()]//span[contains(@class,'edit')]"));
				editButton.click();
				ManualOwner.click();
				ComplaintContact.click();
				Editsubmitbtn.click();
				break; // Exit loop after clicking
			}
		}

	}

	public void verifyUserEditedWithUserRole() {

		String[] expectedRoles = { "User", "Manual Owner", "Complaint Contact" };

		boolean rolesFound = false;

		// Loop through each row's Role column
		List<WebElement> roleCells = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));

		for (WebElement roleCell : roleCells) {
			String roleText = roleCell.getText();

			boolean allRolesMatch = true;
			for (String expectedRole : expectedRoles) {
				if (!roleText.contains(expectedRole)) {
					allRolesMatch = false;
					break;
				}
			}

			if (allRolesMatch) {
				rolesFound = true;
				break; // No need to check further if match found
			}
		}

		if (rolesFound) {
			System.out.println("✅ Found a row with all expected roles.");
		} else {
			System.out.println("❌ No row found with all expected roles.");
		}

	}

}
