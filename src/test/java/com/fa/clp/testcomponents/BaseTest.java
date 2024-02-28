package com.fa.clp.testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.fa.clp.pageobject.LoginPage;
import com.fa.clp.testcases.InwardIdTextGeneration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected static WebDriver driver;
	public LoginPage loginPage;

	public static final Logger logger = LogManager.getLogger(InwardIdTextGeneration.class);

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\GlobalData.properties");
		prop.load(fis);
		/**
		 * ternary operator used
		 */
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		// prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = WebDriverManager.chromedriver().capabilities(options).create();

		}

		else if (browserName.contains("headless")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = WebDriverManager.chromedriver().capabilities(options).create();
		}

		else if (browserName.equalsIgnoreCase("edge")) {

			// Microsoft Edge
			// driver = WebDriverManager.chromedriver().capabilities(options).create();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.edgedriver().capabilities(options).create();

		}

		return driver;

	}

	@BeforeClass(alwaysRun = true)
	public void onStartGo() {

		/**
		 * invoked before test suite execution starts
		 */

		try {

			driver = initializeDriver();
			logger.info("Driver is initialized");

		} catch (IOException e) {

			System.out.println("driver is not initialized");
			logger.info("Driver is not initialized");
		}
	}

	@AfterClass(alwaysRun = true)

	public void tearDown() {

		driver.close();
	}

//	public void beforeInvocation() {
//		
//		/**
//		 * 
//		 * this method gets invoked before every method
//		 * 
//		 */
//		
//	}
//	
//	public void afterInvocation() {
//		
//		/**
//		 * 
//		 * this method gets invoked after every method
//		 * 
//		 */
//		
//	}

}