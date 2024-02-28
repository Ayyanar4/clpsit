package com.fa.clp.testcomponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir") +"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter (path);
		reporter.config().setReportName("CLP SANITY TEST CASE REPORT");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("Bagic CLP Test Results");
		reporter.viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD,ViewName.TEST,ViewName.CATEGORY}).apply();
		
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "FA Testing Team");
		extent.setSystemInfo("Browser", "Google Chrome");
		extent.setSystemInfo("Environment", "Automation Testing");
		return extent;
		
	}

}
