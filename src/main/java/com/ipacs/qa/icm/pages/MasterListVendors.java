package com.ipacs.qa.icm.pages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
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
import com.ipacs.qa.utilities.SortUtil;
import com.ipacs.qa.utilities.TestUtil;
import com.ipacs.qa.utilities.WaitUtil;

public class MasterListVendors extends TestBase {

	// Login Page

	@FindBy(id = "partnerCode")
	WebElement partnercode;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(id = "Login")
	WebElement submit;

	// Master List Vendors Page Menu and Submenu
	@FindBy(xpath = "//a[normalize-space()='Master List - Vendors']")
	WebElement MasterListVendorsMenu;

	@FindBy(xpath = "//a[@href='/CCMS/ViewVendors']")
	WebElement viewMasterList;

	@FindBy(xpath = "//a[@href='/CCMS/AddVendorCategory']")
	WebElement addVendorCategorySubmenu;

	// Add Vendor Category Page
	@FindBy(xpath = "//input[@id='catname']")
	WebElement txtBoxVendorCategoryName;

	@FindBy(xpath = "//input[@id='NoOfComplaintsToChiefOfficers']")
	WebElement txtBoxComplaintManager;

	@FindBy(xpath = "//input[@id='NoOfComplaintsToComplaintManager']")
	WebElement txtBoxAlertChiefComplianceOffice;

	@FindBy(xpath = "//button[@id='btn2']")
	WebElement btnSubmitInMasterListVendor;

	@FindBy(xpath = "//span[normalize-space()='Vendor category added successfully']")
	WebElement vendorCatsuccessMsg;

	// Add Vendor Page all WebElements

	@FindBy(xpath = "//button[@id='btn1']")
	WebElement submitBtn1;

	// View Master List Page all webelements

	@FindBy(xpath = "//select[@name='ml_dyntable_length']")
	WebElement showEntries;
	@FindBy(xpath = "//th[normalize-space()='Vendor Name']")
	WebElement vendorNameHeader;
	@FindBy(xpath = "//th[normalize-space()='Vendor Category']")
	WebElement vendorCategoryHeader;
	@FindBy(xpath = "//th[normalize-space()='Status']")
	WebElement statusHeader;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBox;
	@FindBy(xpath = "//a[@id='ml_dyntable_first']")
	WebElement first;
	@FindBy(xpath = "//a[@id='ml_dyntable_previous']")
	WebElement previous;
	@FindBy(xpath = "//a[@id='ml_dyntable_next']")
	WebElement next;
	@FindBy(xpath = "//a[@id='ml_dyntable_last']")
	WebElement last;

	// Vendor Category headers xpath
	@FindBy(xpath = "(//a[contains(text(),'Collection Services')])[1]")
	WebElement vendorCategoryHyperlink;
	@FindBy(xpath = "//th[contains(text(),'VENDOR NAME')]")
	WebElement vendorNameheader2;
	@FindBy(xpath = "//th[contains(text(),'STATUS')]")
	WebElement vendorCategoryStatus;
	@FindBy(xpath = "//select[@id='vendorCategoryID']")
	WebElement SelectVendorCategory;

	// Vendor Name Hyperlink and Edit Vendor Profile in View Master List

	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	WebElement vendorNameHyperlink;
	@FindBy(xpath = "//a[normalize-space()='Edit this Vendor profile']")
	WebElement editVendorProfile;
	/*
	 * @FindBy(xpath = "//th[contains(text(),'VENDOR NAME   ')]") WebElement
	 * vendor_Name;
	 */
	@FindBy(xpath = "//input[@id='IPACS_Vendor_name']")
	WebElement vendorName;
	@FindBy(xpath = "//button[@id='btn6']")
	WebElement submitBtn;
	@FindBy(xpath = "//span[normalize-space()='Vendor Update successfully.']")
	WebElement successMsg1;
	@FindBy(xpath = "//a[@href='/CCMS/AddVendors']")
	WebElement addVendor;
	@FindBy(xpath = "//*[@id='name']")
	WebElement vname;
	@FindBy(xpath = "//select[@id='serviceCategory']")
	WebElement vCategory;
	@FindBy(xpath = "//*[@id='descriptionOfService']")
	WebElement descriptionOfService;
	@FindBy(xpath = "//select[@id='status']")
	WebElement status;
	@FindBy(xpath = "//select[@id='contactAtFirm']")
	WebElement primaryVendor;
	@FindBy(xpath = "//select[@id='secondaryContactAtFirm']")
	WebElement vendorContact;
	@FindBy(xpath = "//*[@id='firstName']")
	WebElement fname;
	@FindBy(xpath = "//*[@id='lastName']")
	WebElement lname;
	@FindBy(xpath = "//span[normalize-space()='Vendor added successfully.']")
	WebElement successMsg;

	// //Manage complaint alerts web elements
	@FindBy(xpath = "//a[@id='ui-id-2']")
	WebElement manageComplaintAlertsSubTab;
	@FindBy(xpath = "//input[@id='NoOfComplaintsToChiefOfficer']")
	WebElement NoOfComplaintsToChiefOfficer;
	@FindBy(xpath = "//input[@id='NoOfComplaintsToManagingPartner']")
	WebElement NoOfComplaintsToManagingPartner;
	@FindBy(xpath = "//button[@id='editRequiredDocumentation1']")
	WebElement editRequiredDocumentation;
	@FindBy(xpath = "//button[@id='saveRequiredDocumentation']")
	WebElement saveRequiredDocumentation;

	// vendor list web elements
	@FindBy(xpath = "//select[@name='viewVendorList_length']")
	WebElement showEntriesInVendorList;
	@FindBy(xpath = "//a[@id='viewVendorList_first']")
	WebElement firstvl;
	@FindBy(xpath = "//a[@id='viewVendorList_last']")
	WebElement lastvl;
	@FindBy(xpath = "//a[@id='viewVendorList_previous']")
	WebElement previousvl;
	@FindBy(xpath = "//a[@id='viewVendorList_next']")
	WebElement nextvl;

	// Constructor to initialize the PageFactory elements

	public MasterListVendors() {
		PageFactory.initElements(driver, this);
	}

	// Login Method

	public void login(String pc, String un, String pwd) {
		Map<String, String> testData = ExcelReader.readKeyValueFromExcel(ConfigUtil.getTestDataFilePath(), "TestData");

		partnercode.sendKeys(testData.get("partnerCode"));
		username.sendKeys(testData.get("username"));
		password.sendKeys(testData.get("password"));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
	}

	// Click on Master List Vendors Menu
	public void clickMasterListMenu() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", MasterListVendorsMenu);
		WaitUtil.waitForElementToBeVisible(driver, MasterListVendorsMenu);
		WaitUtil.waitForElementToBeClickable(driver, MasterListVendorsMenu);
		MasterListVendorsMenu.click();
		WaitUtil.waitForSeconds(5);

	}

	// Click on Add Vendor Category Submenu
	public void clickAddVendorCategory() throws InterruptedException {
		// click on Add Vendor Category button
		WaitUtil.waitForElementToBeClickable(driver, addVendorCategorySubmenu);
		addVendorCategorySubmenu.click();
		WaitUtil.waitForSeconds(5);

	}

	public void enterDetailsAddVendorCategoryInMasterListVendor() throws InterruptedException {
		// generate a random name for the vendor category using the simple date format
		SimpleDateFormat df = new SimpleDateFormat("MMdd");
		String vendorCategoryName = "TestCat" + df.format(System.currentTimeMillis()) + TestUtil.randomNumber(1, 100);
		txtBoxVendorCategoryName.sendKeys(vendorCategoryName);
		WaitUtil.waitForSeconds(5);
		txtBoxComplaintManager.sendKeys(TestUtil.randomNumber(1, 100)); // to generate a random number between 1 and 100
		WaitUtil.waitForSeconds(5);
		txtBoxAlertChiefComplianceOffice.sendKeys(TestUtil.randomNumber(1, 100)); // to generate a random number between
																					// 1 and
		// 100
		WaitUtil.waitForSeconds(5);
	}

	public void clickBtnSubmitInMasterListVendor() throws InterruptedException {
		btnSubmitInMasterListVendor.click();
		WaitUtil.waitForSeconds(5);
	}

	public void clickViewMasterList() {
		// click on View Master List button
		viewMasterList.click();

	}

	public void verifyTxtAddSuccessfullyMsgInMasterListVendor() {

		String actualMsg = vendorCatsuccessMsg.getText();
		String expectedMsg = "Vendor category added successfully";
		if (actualMsg.equals(expectedMsg)) {
			System.out.println("Vendor category added successfully");
		} else {
			System.out.println("Vendor category not added successfully");
		}

	}

	public void ShowEntriesInViewMasterList() {
		// select values from the dropdown to show entries

		Select selectValueFromDropdown = new Select(showEntries);
		WaitUtil.waitForElementToBeVisible(driver, showEntries);

		// List of option values you want to select
		List<String> valuesToSelect = Arrays.asList("25", "50", "-1"); // Add your actual option values here

		// Loop through the list and select each value
		for (String value : valuesToSelect) {
			selectValueFromDropdown.selectByValue(value); // Select each value in the list
		}

		// Optionally, you can print or log the selected values for confirmation
		System.out.println("Selected values: " + valuesToSelect);
	}

	public void sortingByVendorName() throws InterruptedException {

		// click on the Vendor Name header again to sort in descending order
		vendorNameHeader.click();
		WaitUtil.waitForSeconds(5);
		vendorNameHeader.click();
		WaitUtil.waitForSeconds(5);

	}

	public void sortingByVendorCategory() throws InterruptedException {
		// click on the Vendor Category header to sort the list

		vendorCategoryHeader.click();
		WaitUtil.waitForSeconds(5);
		vendorCategoryHeader.click();

	}

	public void sortingByStatus() throws InterruptedException {
		// click on the Status header to sort the list

		statusHeader.click();
		WaitUtil.waitForSeconds(5);
		statusHeader.click();
		WaitUtil.waitForSeconds(5);
	}

	public void searchInViewMasterList() throws InterruptedException {

		Map<String, String> testdata = ExcelReader.readKeyValueFromExcel(ConfigUtil.getTestDataFilePath(), "TestData");
		String searchText = testdata.get("searchStringAfterEditVendorName");
		if (searchText != null && !searchText.trim().isEmpty()) {
			searchBox.sendKeys(searchText);
		} else {
			throw new IllegalArgumentException("Search string is null or empty. Please check your test data.");
		}

	}

	public void paginationInViewMasterList() throws InterruptedException {

		first.click();
		WaitUtil.waitForSeconds(5);

		previous.click();
		WaitUtil.waitForSeconds(5);

		next.click();
		WaitUtil.waitForSeconds(5);

		last.click();
		WaitUtil.waitForSeconds(5);

	}

	public void clickVendorNameHyperlinkInViewMasterList() throws InterruptedException {

		vendorNameHyperlink.click();
		WaitUtil.waitForSeconds(5);

		editVendorProfile.click();

		Map<String, String> testdata = ExcelReader.readKeyValueFromExcel(ConfigUtil.getTestDataFilePath(), "TestData");
		String vendorNameText = testdata.get("vendorName");
		vendorName.clear();
		vendorName.sendKeys(vendorNameText + TestUtil.randomNumber(1, 100));

		submitBtn.click();
		WaitUtil.waitForSeconds(5);

		WaitUtil.waitForSeconds(5);
		String actualMsg1 = successMsg1.getText();
		String expectedMsg1 = "Vendor Update successfully.";
		assert actualMsg1.equals(expectedMsg1) : "Vendor not updated successfully";

	}

	public void clickAddVendor() throws InterruptedException {
		// click on Add Vendor button

		addVendor.click();
		WaitUtil.waitForSeconds(5);

	}

	public void enterDetailsAddVendorInMasterListVendor() throws InterruptedException {

		vname.sendKeys("QA" + TestUtil.randomNumber(1, 100));

		// Select vendor Category (Custom Dropdown)

		// this line is to make the dropdown visible
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", vCategory);
		Select select = new Select(vCategory);
		select.selectByVisibleText(TestUtil.getReadData("vendorCategoryName"));
		WaitUtil.waitForSeconds(5);

		// Enter Description of Service

		descriptionOfService.sendKeys("This is for testing purpose");
		WaitUtil.waitForSeconds(5);

		// this line is to make the dropdown visible
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", status);
		Select select1 = new Select(status);
		select1.selectByVisibleText(TestUtil.getReadData("status"));
		WaitUtil.waitForSeconds(5);

		// Select Primary Vendor (Custom Dropdown)
		// this line is to make the dropdown visible
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", primaryVendor);
		Select select2 = new Select(primaryVendor);
		select2.selectByVisibleText(TestUtil.getReadData("primaryVendor"));
		WaitUtil.waitForSeconds(5);

		// Select Vendor Contact (Custom Dropdown)
		// this line is to make the dropdown visible
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", vendorContact);
		Select select3 = new Select(vendorContact);
		select3.selectByVisibleText(TestUtil.getReadData("vendorContact"));
		WaitUtil.waitForSeconds(5);

		// Enter First Name
		fname.sendKeys("Test");

		// Enter Last Name
		lname.sendKeys("QA1");

		// Click on Submit button
		submitBtn1.click();
	}

	public void clickSubmitOnAddVendorPage() throws InterruptedException {
		// click on Add Vendor button
		submitBtn1.click();
		WaitUtil.waitForSeconds(5);

	}

	public void verifyTxtVendorAddSuccessfullyMsgInAddVendorPage() throws IOException {
		// WebElement successMsg =

		String actualMsg = successMsg.getText();
		String expectedMsg = "Vendor added successfully.";
		if (actualMsg.equals(expectedMsg)) {
			System.out.println("Vendor added successfully");
		} else {
			System.out.println("Vendor not added successfully");
			captureScreenShot(driver, "VendorAddSuccessfully");
		}

	}

	public void searchInViewMasterListVendorCategory() throws InterruptedException {

		searchBox.sendKeys((TestUtil.getReadData("searchwithVendorCategory")));
		WaitUtil.waitForSeconds(5);

	}

	public void clickVendorCategoryHyperlinkInViewMasterList() throws InterruptedException {

		vendorCategoryHyperlink.click();
		WaitUtil.waitForSeconds(5);

	}

	public void iShouldSeeTheVendorCategoryPageSubTabUnderMasterListVendor() {
		driver.findElement(By.xpath("//h1[normalize-space()='Vendor Category']"));
		driver.findElement(By.xpath("//a[@id='ui-id-1']"));
		driver.findElement(By.xpath("//a[@id='ui-id-2']"));

	}

	public void sortingVendorName() throws InterruptedException {

		vendorNameheader2.click();
		WaitUtil.waitForSeconds(5);
		vendorNameheader2.click();

	}

	public void sortingStatus() throws InterruptedException {

		vendorCategoryStatus.click();
		WaitUtil.waitForSeconds(5);
		vendorCategoryStatus.click();
		WaitUtil.waitForSeconds(5);
	}

	public void selectValueFromDropDownInVendorCategoryPage() throws InterruptedException {

		Select selectValueFromDropdown = new Select(SelectVendorCategory);

		selectValueFromDropdown.selectByVisibleText(TestUtil.getReadData("vendorCategoryName"));
		WaitUtil.waitForSeconds(5);
	}

	public void searchInVendorCategoryPage() {

		searchBox.sendKeys((TestUtil.getReadData("searchStringonVendorCategoryPage")));

	}

	public void verifySearchResult() {
		List<WebElement> searchResults = driver.findElements(By.xpath("//a[normalize-space()='TestUser1']"));

		if (searchResults.isEmpty()) {
			throw new AssertionError("Search result not found: No elements matching the XPath.");
		}

		String actualMsg = searchResults.get(0).getText().trim(); // trim to be safe
		String expectedMsg = TestUtil.getReadData("searchStringonVendorCategoryPage");

		assert actualMsg.equals(expectedMsg)
				: "Search result mismatch. Expected: '" + expectedMsg + "', but found: '" + actualMsg + "'";
	}

	public void verifyManageComplaintAlertsSubTabInVendorCategoryPage() throws InterruptedException {

		manageComplaintAlertsSubTab.click();
		editRequiredDocumentation.click();
		WaitUtil.waitForSeconds(5);

		NoOfComplaintsToChiefOfficer.clear();
		NoOfComplaintsToChiefOfficer.sendKeys(TestUtil.randomNumber(1, 100));

		NoOfComplaintsToManagingPartner.clear();
		NoOfComplaintsToManagingPartner.sendKeys(TestUtil.randomNumber(1, 100));

		saveRequiredDocumentation.click();

	}

	public void verifyShowEntriesInVendorListTabInVendorCategoryPage() {

		// select values from the dropdown to show entries
		Select selectValueFromDropdown = new Select(showEntriesInVendorList);

		// List of option values you want to select
		List<String> valuesToSelect = Arrays.asList("50", "100", "-1"); // Add your actual option values here

		// Loop through the list and select each value
		for (String value : valuesToSelect) {
			selectValueFromDropdown.selectByValue(value); // Select each value in the list
		}

		// Optionally, you can print or log the selected values for confirmation
		System.out.println("Selected values: " + valuesToSelect);

	}

	public void verifySearchInVendorListTabInVendorCategoryPage() {

		String searchText = TestUtil.getReadData("searchStringInVendorListTab");

		if (searchText != null && !searchText.trim().isEmpty()) {
			searchBox.sendKeys(searchText);
		} else {
			throw new IllegalArgumentException("Search string is null or empty. Please check your test data.");
		}

		WaitUtil.waitForSeconds(5);
	}

	public void verifySortingInVendorListTabInVendorCategoryPage() {

		// click on the Vendor Name header to sort the list
		vendorNameheader2.click();
		WaitUtil.waitForSeconds(5);
		vendorNameheader2.click();
		WaitUtil.waitForSeconds(5);

		// click on the Status header to sort the list
		vendorCategoryStatus.click();
		WaitUtil.waitForSeconds(5);
		vendorCategoryStatus.click();
		WaitUtil.waitForSeconds(5);

	}

	public void verifyPaginationInVendorListTabInVendorCategoryPage() {
		firstvl.click();
		WaitUtil.waitForSeconds(5);

		previousvl.click();
		WaitUtil.waitForSeconds(5);

		nextvl.click();
		WaitUtil.waitForSeconds(5);

		lastvl.click();
		WaitUtil.waitForSeconds(5);

	}

	public void verifyManageComplaintValidation() {

		manageComplaintAlertsSubTab.click();
		editRequiredDocumentation.click();
		WaitUtil.waitForSeconds(5);

		NoOfComplaintsToChiefOfficer.clear();
		// NoOfComplaintsToChiefOfficer.sendKeys(TestUtil.randomNumber(1, 100));

		NoOfComplaintsToManagingPartner.clear();
		// NoOfComplaintsToManagingPartner.sendKeys(TestUtil.randomNumber(1, 100));

		saveRequiredDocumentation.click();

	}

	public void searchInViewMasterListWithInvalidData() {
		// System.out.println("Search with invalid data");
		Map<String, String> testData = ExcelReader.readKeyValueFromExcel(ConfigUtil.getTestDataFilePath(), "TestData");
		searchBox.sendKeys(testData.get("searchStringWithInvalidData"));
		WaitUtil.waitForSeconds(5);

	}

	public void verifyInactiveVendorInViewMasterList() {
		// System.out.println("Inactive Vendor");
		searchBox.sendKeys("inactive");
		WaitUtil.waitForSeconds(5);

		List<WebElement> inactiveVendors = driver
				.findElements(By.xpath("//tr[@class='gradeX odd']//td[contains(text(),'Inactive')]"));
		if (inactiveVendors.isEmpty()) {
			System.out.println("No inactive vendors found.");
		} else {
			System.out.println("Inactive vendors found:");
			for (WebElement vendor : inactiveVendors) {
				System.out.println(vendor.getText());
			}
		}
	}

	public void verifyActiveVendorInViewMasterList() {
		searchBox.sendKeys("active");
		WaitUtil.waitForSeconds(5);

		List<WebElement> activeVendors = driver.findElements(By.xpath("(//td[contains(text(),'Active')])[1]"));
		if (activeVendors.isEmpty()) {
			System.out.println("No active vendors found.");
		} else {
			System.out.println("Active vendors found:");
			for (WebElement vendor : activeVendors) {
				System.out.println(vendor.getText());
			}
		}

	}

	public static List<WebElement> getVendorNameColumnElements() {
		return driver.findElements(By.xpath("//tr[contains(@class, 'gradeX')]/td[1]")); // Adjust td[1] based on actual
																						// // column index
	}

	public void sortedOrderResultByVendorNameInAscending() {
		vendorNameHeader.click();
		WaitUtil.waitForSeconds(5);

		List<WebElement> vendorNameElements = getVendorNameColumnElements();
		List<String> vendorNames = SortUtil.extractTextFromElements(vendorNameElements);
		System.out.println("Vendor Names Sorted List in Ascending order: " + vendorNames);

		boolean isSorted = SortUtil.isSortedAscendingNatural(vendorNames); // or isSortesdDescending
		System.out.println("Is Sorted: " + isSorted);

		// assertTrue(isSorted, "Vendor names are not sorted in ascending order.");

	}

	public void displayVendorNameListBeforeSorting() {
		WaitUtil.waitForSeconds(7); // Replace with explicit wait if possible
		List<WebElement> vendorNameElementsBefore = getVendorNameColumnElements();

		List<String> vendorNamesBefore = SortUtil.extractTextFromElements(vendorNameElementsBefore);

		System.out.println("Vendor Names Before Sorting:");
		for (String name : vendorNamesBefore) {
			System.out.println(name);
		}
	}

	public static List<WebElement> getVendorCategoryColumnElements() {
		return driver.findElements(By.xpath("//td[contains(@class, 'sorting_1')]"));
	}

	public void sortingVendorCategoryInAscending() {
		vendorCategoryHeader.click();
		WaitUtil.waitForSeconds(5);

		List<WebElement> vendorCatElements = getVendorCategoryColumnElements();
		List<String> vendorCategory = SortUtil.extractTextFromElements(vendorCatElements);
		System.out.println("Vendor Category Sorted List in Ascending order: " + vendorCategory);

		boolean isSorted = SortUtil.isSortedAscending(vendorCategory); // or isSortesdDescending
		// System.out.println("Is Sorted: " + isSorted);

		assertTrue(isSorted, "Vendor Categories Names are not sorted in ascending order.");

	}

	public void sortingVendorCategoryInDescending() {
		vendorCategoryHeader.click();
		WaitUtil.waitForSeconds(5);

		List<WebElement> vendorCatElements = getVendorCategoryColumnElements();
		List<String> vendorCategory = SortUtil.extractTextFromElements(vendorCatElements);
		System.out.println("Vendor Category Sorted List in descending order: " + vendorCategory);

		boolean isSorted = SortUtil.isSortedDescending(vendorCategory); // or isSortesdDescending

		assertTrue(isSorted, "Vendor Categories Names are not sorted in descending order.");

	}

	public static List<WebElement> getStatusColumnElements() {
		return driver.findElements(By.xpath("//td[contains(@class, 'sorting_1')]"));
	}

	public void sortingStatusInAscending() {
		statusHeader.click();
		WaitUtil.waitForSeconds(5);

		List<WebElement> vendorStaus = getVendorCategoryColumnElements();
		List<String> status = SortUtil.extractTextFromElements(vendorStaus);
		System.out.println("Vendor Status Sorted List in Ascending order: " + status);

		boolean isSorted = SortUtil.isSortedAscending(status); // or isSortesdDescending
		// System.out.println("Is Sorted: " + isSorted);

		assertTrue(isSorted, "Vendor status are not sorted in ascending order.");

	}

	public void sortingStatusInDescending() {
		statusHeader.click();
		WaitUtil.waitForSeconds(5);

		List<WebElement> vendorStaus = getVendorCategoryColumnElements();
		List<String> status = SortUtil.extractTextFromElements(vendorStaus);
		System.out.println("Vendor Status Sorted List in Descending order: " + status);

		boolean isSorted = SortUtil.isSortedDescending(status); // or isSortesdDescending

		assertTrue(isSorted, "Vendor Status are not sorted in descending order.");

	}

}
