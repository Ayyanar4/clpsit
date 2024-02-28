package com.fa.clp.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.fa.clp.constants.ClpConstants;
import com.fa.clp.pageobject.LandingPage;
import com.fa.clp.pageobject.LoginPage;
import com.fa.clp.testcomponents.BaseTest;

import net.sourceforge.tess4j.TesseractException;

public class LogoutFunction extends BaseTest {

	public static final Logger logger = LogManager.getLogger(LogoutFunction.class);
	DataFormatter formatter = new DataFormatter();
	LoginPage loginPage;

	public LogoutFunction() {

		super();
	}

	@Test()

	public void logOutFunctionality() throws IOException, InterruptedException, TesseractException {

		try {
			
			loginPage = new LoginPage(driver);
			loginPage.goTo();
			loginPage.implicitWaitBeforeThrowingError();
			loginPage.loginApplication("lpu.bangalore", "newpas12");
			do {
				/**
				 * captchaText method is used to extract the text from the Captcha
				 */
				String extractedCaptchaText = loginPage.captchaText();
				loginPage.loginButtonClicked(extractedCaptchaText);
				try {

					String errorMessage = driver.findElement(By.cssSelector(".message-text.text-danger")).getText();

					System.out.println(errorMessage);

					if (errorMessage.equalsIgnoreCase(ClpConstants.errorMessageForReLogin))

					{
						Thread.sleep(2000);
						driver.close();
						driver = initializeDriver();
						logOutFunctionality();
						break;
						

					}


				} catch (Exception e1) {
					driver.findElement(By.xpath("//input[@type='submit']")).click();

				}

				try {
					String popup = driver.switchTo().alert().getText().toString();
					if (popup.contains("enter valid captcha code")) {
						loginPage.alertHandleByApproving();
						Thread.sleep(1000);
						driver.findElement(By.xpath("//div/img[@alt='Refresh']")).click();
					}
				} catch (Exception e) {

					e.printStackTrace();
				}

				/**
				 * While loop is implemented for capturing the exact captcha text
				 */

			} while (driver.findElement(By.xpath("//div/img[@alt='Refresh']")).isDisplayed());

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		Boolean welcomeBoardFlag;
		try {
			@SuppressWarnings("unused")
			WebElement welcomeBoard = driver.findElement(By.xpath("//h3[contains(text(),'Welcome')]"));
			welcomeBoardFlag = true;
		} catch (Exception e) {
			
			e.printStackTrace();
			welcomeBoardFlag = false;
		}

		if (welcomeBoardFlag == true) {

			driver.close();

		}

		else {
		// loginPage.submitLoginButton();

	
			loginPage.visibilityOfLoginButton();
			Thread.sleep(2000);

			/**
			 * Clicking the claim Management button in the dashboard
			 */

			LandingPage landingPage = new LandingPage(driver);
			landingPage.logOutFunction();
		}
		} 
		//driver.close();

	}


