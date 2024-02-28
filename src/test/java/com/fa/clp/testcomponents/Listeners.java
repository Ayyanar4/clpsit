package com.fa.clp.testcomponents;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.IExecutionListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.fa.clp.pageobject.InwardDocumentDetailsPage;

public class Listeners extends BaseTest implements ITestListener, IExecutionListener {
	public WebDriver driver;
	Utils utils;
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public static final Logger logger = LogManager.getLogger(InwardDocumentDetailsPage.class);

	@Override()
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);// unique thread id implemented for avoiding parallel execution run failure.

	}

	@Override()
	public void onTestSuccess(ITestResult result) {

		/**
		 * invoked on the success of a test
		 */

		extentTest.get().pass(MarkupHelper.createLabel("Test Passes", ExtentColor.GREEN));

	}

	@Override()
	public void onFinish(ITestContext context) {

		/**
		 * invoked after all tests of a class are executed
		 */

		extent.flush();
		

	}

	@Override()
	public void onStart(ITestContext context) {

//		/**
//		 * invoked before test suite execution starts
//		 */
//
//		try {
//			driver = initializeDriver();
//			logger.info("Driver is initialized");
//
//		} catch (IOException e) {
//
//			System.out.println("driver is not initialized");
//			logger.info("Driver is not initialized");
//		}
	}

	@Override()
	public void onTestFailure(ITestResult result) {

		/**
		 * invoked on the failure of a test
		 */

		logger.info("Test fails");

		extentTest.get().fail(result.getThrowable());

		String filePath = null;

		try {
			Utils utils = new Utils();
			filePath = utils.getScreenshot(result.getMethod().getMethodName());

		} catch (IOException e) {

			e.printStackTrace();
		}

		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

		extentTest.get().fail(MarkupHelper.createLabel("Test Fails", ExtentColor.RED));
		
		
	}

	@Override()
	public void onTestSkipped(ITestResult result) {
		/**
		 * invoked when a test is skipped
		 */

		logger.info("Test is skipped");
	}

	@Override() 
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		/**
		 * invoked whenever a method fails but within the defined success percentage
		 */
	}
	@Override
	public void onExecutionFinish() {
		
		Utils.emailAttachment();
		
//		configfailurepolicy="continue" skipfailedinvocationcounts="true"
//		extent.flush();
//		Utils.emailAttachment();
//		driver.close();

	}

}
