package com.fa.clp.abstractcomponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public abstract class AbstractComponents {

	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(AbstractComponents.class);

	public AbstractComponents(WebDriver driver) {

		this.driver = driver;

	}

	public String captchaText() throws IOException, TesseractException {
		/**
		 * WebElement captcha = driver.findElement(By.cssSelector("#valicode")) -
		 * WebElement of the Captcha textbox
		 */
		WebElement captcha = driver.findElement(By.cssSelector("#valicode"));
		File src = captcha.getScreenshotAs(OutputType.FILE);
		String path = ".\\CaptchaImages\\Captcha.png";
		FileHandler.copy(src, new File(path));
		ITesseract instance = new Tesseract();
		/**
		 * Need to add tessdata below as Eng.traineddata taken from github
		 */
		instance.setDatapath("tessdata");
		String extractedCaptchaText = instance.doOCR(new File(path));
		return extractedCaptchaText;
	}

	public void waitForElementToAppear(WebElement explicit) {
		/**
		 * Explicit wait is implemented to avoid synchronization issue.
		 */
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
		waits.until(ExpectedConditions.visibilityOf((explicit))).isDisplayed();

	}

	public void alertHandleByApproving() {
		/**
		 * The below statement of code is used for Approving the alert.
		 */
		driver.switchTo().alert().accept();
		logger.info("The alert is approved");

	}
	
	public void scrollIntoWebElementLeftSide(String scrolldown, String scrollhorizontal) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("document.querySelector("+scrolldown+").scrollLeft="+scrollhorizontal+"");
		//js.executeScript("document.querySelector(\"#details-container-payment-scroll\").scrollLeft="+scrollhorizontal+"");

	}
	
	

	public void waitForElementToAppearAndClick(WebElement explicitclick) {
		/**
		 * Explicit wait is implemented to avoid synchronization issue and to click the
		 * element
		 */

		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));
		waits.until(ExpectedConditions.visibilityOf((explicitclick))).click();
		

	}

	public void implicitWaitBeforeThrowingError() {
		/**
		 * The below statement of code is used for wait before throwing any error for
		 * finding locators
		 */

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		logger.info("Implicit wait is initiated");
	}

	public void scrollbyjavascript(String scrolldown) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript(scrolldown);
	}
	
//	public void scrollIntoWebElementbyjavascript(WebElement scrolldown, String locator) throws InterruptedException {
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		Thread.sleep(2000);
//
//		WebElement fullFrame = driver.findElement(By.xpath(locator));
//
//		js.executeScript("arguments[0].scrollIntoView(true)", fullFrame);
//
//	}

	public void staticDropdownHandleByValues(List<WebElement> option, String values) {

		for (WebElement dropdown : option) {

			if (dropdown.getText().equalsIgnoreCase(values)) {

				dropdown.click();
				break;
			}
		}
	}

	public void staticDropdownHandleByVisibleText(WebElement documentType, String values) {

		WebElement clickingTheTextbox = documentType;
		Select selectDropdown = new Select(clickingTheTextbox);
		selectDropdown.selectByVisibleText(values);
	}

	public void uploadingFileInWindowsUsingAutoIt(String Path) throws IOException {

		Runtime.getRuntime().exec(Path);

	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

		// read json to string
		@SuppressWarnings("deprecation")
		String jsonContent = FileUtils.readFileToString(new File(filePath));

		// Convert string to HashMap - Using JackSon Databind

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}
	
	

}
