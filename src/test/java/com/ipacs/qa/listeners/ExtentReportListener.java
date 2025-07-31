package com.ipacs.qa.listeners;

import java.io.File;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.ipacs.qa.baseclass.TestBase;
import com.ipacs.qa.utilities.ConfigUtil;

public class ExtentReportListener implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	private String reportFilePath;

	public void configureReport() {
		reportFilePath = ConfigUtil.reportPath() + "ExtentReportFile.html";
		htmlReporter = new ExtentSparkReporter(reportFilePath);
	
	
		// 🔽 Set chart view as default tab on report open
		htmlReporter.viewConfigurer()
			.viewOrder()
			.as(new ViewName[] {
				ViewName.DASHBOARD, // chart view
				ViewName.TEST, 
				ViewName.CATEGORY, 
				ViewName.AUTHOR, 
				ViewName.DEVICE, 
				ViewName.EXCEPTION 
			})
			.apply();
		
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		reports.setSystemInfo("Machine", "QA Environment");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Project Name", "IPACS");
		reports.setSystemInfo("User Name", "Abhishek Kumar");

		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("QA Automation Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
	}

	@Override
	public void onStart(ITestContext context) {
		configureReport();
		System.out.println("On start method invoked...");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On finish method invoked...");
		reports.flush();
		// hideTimestampColumnInReport(reportFilePath); // ✅ Hide timestamp column
		//hideTimestampColumnInReport(ConfigUtil.reportPath());
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Name of started test method: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of passed test method: " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of passed test case is: " + result.getName(), ExtentColor.GREEN));
		String screenshotPath = captureScreenshot(result.getName());
		File screenshotFile = new File(screenshotPath);
		if (screenshotFile.exists()) {
			test.pass("Screenshot for passed test:").addScreenCaptureFromPath(screenshotPath);
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of failed test method: " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of Failed test case is: " + result.getName(), ExtentColor.RED));

		String screenshotPath = captureScreenshot(result.getName());
		File screenshotFile = new File(screenshotPath);
		if (screenshotFile.exists()) {
			test.fail("Screenshot for failed test:").addScreenCaptureFromPath(screenshotPath);
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of skipped test method: " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of skipped test case is: " + result.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// No-op
	}

	private String captureScreenshot(String testName) {
		String safeTestName = testName.replaceAll("[:\\\\/*?|<>]", "_");
		String screenshotPath = ConfigUtil.screenshotPath() + "screenshots/" + safeTestName + ".png";
		try {
			TestBase base = new TestBase();
			base.captureScreenShot(TestBase.driver, safeTestName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotPath;
	}
	
}

	
	
	/*
	 * // ✅ Inject CSS to hide timestamp column from ExtentReport HTML private void
	 * hideTimestampColumnInReport(String reportHtmlPath) { try { File htmlFile =
	 * new File(reportHtmlPath); String content = new
	 * String(Files.readAllBytes(htmlFile.toPath()));
	 * 
	 * String customStyle =
	 * "<style>th.timestamp, td.timestamp { display: none !important; }</style>"; if
	 * (!content.contains(customStyle)) { content = content.replace("</head>",
	 * customStyle + "\n</head>"); Files.write(htmlFile.toPath(),
	 * content.getBytes()); System.out.
	 * println("✅ Timestamp column successfully hidden from Extent Report."); } }
	 * catch (IOException e) {
	 * System.err.println("❌ Failed to inject CSS to hide timestamp column.");
	 * e.printStackTrace(); } }
	 */