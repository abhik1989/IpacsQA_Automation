package com.ipacs.qa.icm.tests;

import org.testng.annotations.Test;

import com.ipacs.qa.baseclass.TestBase;
import com.ipacs.qa.icm.pages.CompanyProfile;

public class CompanyProfileTest extends TestBase {

	CompanyProfile cprofile;


	/*
	 * @BeforeMethod public void setUp() throws Exception { initialization();
	 * cprofile = new Companyprofile();
	 * 
	 * }
	 */

	//@Test(priority = 2)

	/*
	 * public void validateCorrectUsernameandCorrectPassword() throws Exception {
	 * cprofile.login("partnercode", "username", "password"); Thread.sleep(8000);
	 * cprofile.companyprofile(); }
	 */
	@Test(priority = 1)

	public void validatedocumentation() throws Exception {
		cprofile.login("partnercode", "username", "password");
		Thread.sleep(8000);
		cprofile.companyprofile();
		cprofile.verifyDocumentationPage();
		Thread.sleep(8000);
	}

	/*
	 * @AfterMethod public void Final() throws Exception { driver.quit(); }
	 */
}