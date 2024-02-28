package com.fa.clp.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.fa.clp.constants.ClpConstants;
import com.fa.clp.pageobject.CaseDetailsPage;
import com.fa.clp.pageobject.DocumentUploadPage;
import com.fa.clp.pageobject.InwardDetailsPage;
import com.fa.clp.pageobject.InwardDocumentDetailsPage;
import com.fa.clp.pageobject.InwardIntoIntimation;
import com.fa.clp.pageobject.LandingPage;
import com.fa.clp.pageobject.LoginPage;
import com.fa.clp.pageobject.OfficeTakingInwardDetailsPage;
import com.fa.clp.testcomponents.BaseTest;

public class InwardIdTextGeneration extends BaseTest {

	JavascriptExecutor js;
	WebDriverWait waits;
	LoginPage loginPage;

	public static final Logger logger = LogManager.getLogger(InwardIdTextGeneration.class);

	public InwardIdTextGeneration() {

		super();
	}

	// @Test(retryAnalyzer = Retry.class)
	@Test()
	public void Inward() throws InterruptedException, IOException {
		/**
		 * Used for opening the chrome even the chromedriver is updated automatically.
		 */

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

					// errorMessage.equalsIgnoreCase(ClpConstants.errorMessageForReLogin

					if (errorMessage.equalsIgnoreCase(ClpConstants.errorMessageForReLogin))

					{

						Thread.sleep(2000);
						driver.close();
						driver = initializeDriver();
						Inward();
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

		/**
		 * Explicit wait is implemented to avoid synchronization issue.
		 */

		// loginPage.submitLoginButton();

		// loginPage.visibilityOfLoginButton();

		/**
		 * Clicking the claim Management button in the dashboard
		 */

//		try {

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
			LandingPage landingPage = new LandingPage(driver);
			landingPage.claimManagement();
			CaseDetailsPage caseDetailPage = landingPage.goToInwardPage();
			InwardDetailsPage inwardDetailsPage = caseDetailPage.caseDetails();
			InwardDocumentDetailsPage inwardDocumentDetailsPage = inwardDetailsPage.inwardDetails();
			OfficeTakingInwardDetailsPage officeTakingInwardDetails = inwardDocumentDetailsPage.inwardDocumentDetails();
			DocumentUploadPage documentUpload = officeTakingInwardDetails.officeTakeInward();
			InwardIntoIntimation inwardToInt = documentUpload.saveInward();
			inwardToInt.getInwardID();
			landingPage.backToLandingPage();
			landingPage.logOutFunction();

		}

//		} catch (Exception e) {
//			
//			System.err.println("Element not found");
//			
//			 throw new AssertionError("A clear description of the failure", e);
//		}

	}

}
