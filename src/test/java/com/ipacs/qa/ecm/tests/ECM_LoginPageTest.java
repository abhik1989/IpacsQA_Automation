package com.ipacs.qa.ecm.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ipacs.qa.baseclass.TestBase;
import com.ipacs.qa.icm.pages.LoginPage;
import com.ipacs.qa.utilities.ScreenRecorderUtil;
import com.ipacs.qa.utilities.WaitUtil;

public class ECM_LoginPageTest extends TestBase {

	LoginPage loginpage;

	@BeforeMethod
	public void setUpPageObject() {
		loginpage = new LoginPage(); // driver is already available

	}

	@Test(priority = 1)

	public void validateCorrectUsernameandCorrectPassword() throws Exception {
		ScreenRecorderUtil.startRecord("LoginPage");
		loginpage.login("ECM_partnercode", "ECM_username", "ECM_password");
		WaitUtil.waitForSeconds(8);
		loginpage.logout();
	}

	@AfterMethod

	public void Final() throws Exception {
		driver.quit();
		ScreenRecorderUtil.stopRecord();
	}

}
