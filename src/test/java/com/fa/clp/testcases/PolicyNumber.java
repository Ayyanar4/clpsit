package com.fa.clp.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.fa.clp.constants.ClpConstants;
import com.fa.clp.pageobject.AccidentDetailsPage;
import com.fa.clp.pageobject.CaseDetailsPage;
import com.fa.clp.pageobject.CaseDetailsRegistration;
import com.fa.clp.pageobject.ClaimantDetailsPage;
import com.fa.clp.pageobject.ConnectedTpClaims;
import com.fa.clp.pageobject.DocumentList;
import com.fa.clp.pageobject.DocumentUploadPage;
import com.fa.clp.pageobject.EndorsementDetails;
import com.fa.clp.pageobject.FirAndPoliceDetails;
import com.fa.clp.pageobject.IntimationDetails;
import com.fa.clp.pageobject.IntimationInwardDetails;
import com.fa.clp.pageobject.InwardDetailsPage;
import com.fa.clp.pageobject.InwardDocumentDetailsPage;
import com.fa.clp.pageobject.InwardIntoIntimation;
import com.fa.clp.pageobject.LandingPage;
import com.fa.clp.pageobject.LoginPage;
import com.fa.clp.pageobject.OfficeTakingInwardDetailsPage;
import com.fa.clp.pageobject.OverallIntimationDetails;
import com.fa.clp.pageobject.VBDetailsPage64;
import com.fa.clp.pageobject.VehicleDetailsPage;
import com.fa.clp.testcomponents.BaseTest;

public class PolicyNumber extends BaseTest {

	JavascriptExecutor js;
	LoginPage loginPage;

	public static final Logger logger = LogManager.getLogger(InwardIdTextGeneration.class);

	public PolicyNumber() {

		super();
	}

	// @Test(retryAnalyzer = Retry.class)

	@Test()

	public void policyNumber() throws InterruptedException, IOException {
		/**
		 * Used for open the chrome even the chromedriver is updated automatically.
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

					if (errorMessage.equalsIgnoreCase(ClpConstants.errorMessageForReLogin))

					{
						Thread.sleep(2000);
						driver.close();
						driver = initializeDriver();
						policyNumber();
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
			loginPage.visibilityOfLoginButton();

			/**
			 * Clicking the claim Management button in the dashboard
			 */

			LandingPage landingPage = new LandingPage(driver);
			landingPage.claimManagement();
			CaseDetailsPage caseDetailPage = landingPage.goToInwardPage();
			InwardDetailsPage inwardDetailsPage = caseDetailPage.caseDetails();
			InwardDocumentDetailsPage inwardDocumentDetailsPage = inwardDetailsPage.inwardDetails();
			OfficeTakingInwardDetailsPage officeTakingInwardDetails = inwardDocumentDetailsPage.inwardDocumentDetails();
			DocumentUploadPage documentUpload = officeTakingInwardDetails.officeTakeInward();
			InwardIntoIntimation inwardToInt = documentUpload.uploadingDocument();
			IntimationInwardDetails intInwardDetails = inwardToInt.inwardToIntimation();
			IntimationDetails intDetails = intInwardDetails.intimationInwardDetails();
			FirAndPoliceDetails firandPoliceDetails = intDetails.intimationDetails();
			DocumentList documentList = firandPoliceDetails.firDetails();
			OverallIntimationDetails overallIntimationDetails = documentList.docList();
			EndorsementDetails endorsementDetails = overallIntimationDetails.overallIntDetails();
			ConnectedTpClaims connectedTp = endorsementDetails.endorsementDetailsPage();
			CaseDetailsRegistration caseRegistration = connectedTp.connectTpClaims();
			AccidentDetailsPage accidentDetailsPage = caseRegistration.caseDetailRegistration();
			VehicleDetailsPage vehicleDetailsPage = accidentDetailsPage.accidentDetails();
			VBDetailsPage64 vbDetailsPage = vehicleDetailsPage.vehicleDetails();
			ClaimantDetailsPage claimantDetailsPage = vbDetailsPage.VBDetails();
			claimantDetailsPage.claimantDetails();

		}
	}

}
