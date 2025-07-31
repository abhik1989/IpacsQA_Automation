package com.ipacs.qa.utilities;

public class ConfigUtil {

	public static String getTestDataFilePath() {
		return System.getProperty("user.dir") + "/src/main/resources/Config/TestData.xlsx";

	}

	public static String reportPath() {
		return "C://Users//abhishek.kumar//OneDrive - Provana India Pvt. Ltd//Ipacs_Automation//ipacsQA//reports//";

	}

	public static String screenshotPath() {
		return "C://Users//abhishek.kumar//OneDrive - Provana India Pvt. Ltd//Ipacs_Automation//ipacsQA//reports//";
	}
}