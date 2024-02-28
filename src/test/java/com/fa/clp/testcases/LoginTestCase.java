package com.fa.clp.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fa.clp.constants.ClpConstants;
import com.fa.clp.pageobject.LoginPage;
import com.fa.clp.testcomponents.BaseTest;

import net.sourceforge.tess4j.TesseractException;

public class LoginTestCase extends BaseTest {

	public static final Logger logger = LogManager.getLogger(LoginTestCase.class);
	DataFormatter formatter = new DataFormatter();
	LoginPage loginPage;

	public LoginTestCase() {

		super();
	}

	// @Test(dependsOnMethods = { "testCaseDataLogin" }, groups = "login")

//	public void emptyLogin() throws IOException, InterruptedException, TesseractException {
//
//		try {
//
//			
//			loginPage = new LoginPage(driver);
//			loginPage.goTo();
//			loginPage.implicitWaitBeforeThrowingError();
//			driver.findElement(By.id("username")).sendKeys("");
//			driver.findElement(By.cssSelector("#password")).sendKeys("");
//			do {
//				/**
//				 * captchaText method is used to extract the text from the Captcha
//				 */
//				String extractedCaptchaText = loginPage.captchaText();
//				loginPage.loginButtonClicked(extractedCaptchaText);
//				try {
//
//					String errorMessage = driver.findElement(By.cssSelector(".message-text.text-danger")).getText();
//
//					System.out.println(errorMessage);
//
//					if (errorMessage.equalsIgnoreCase(ClpConstants.errorMessageForReLogin))
//
//					{
//						Thread.sleep(2000);
//						driver.close();
//						// driver = initializeDriver();
//						emptyLogin();
//
//					}
//
//					else if (errorMessage.equalsIgnoreCase(ClpConstants.errorMessageForInvalidCredentials))
//
//					{
//						loginPage.errorValidation();
//						Thread.sleep(2000);
//						driver.close();
//						break;
//
//					}
//
//				} catch (Exception e1) {
//					driver.findElement(By.xpath("//input[@type='submit']")).click();
//
//				}
//
//				try {
//					String popup = driver.switchTo().alert().getText().toString();
//					if (popup.contains("enter valid captcha code")) {
//						loginPage.alertHandleByApproving();
//						Thread.sleep(1000);
//						driver.findElement(By.xpath("//div/img[@alt='Refresh']")).click();
//					}
//				} catch (Exception e) {
//
//					e.printStackTrace();
//				}
//
//				/**
//				 * While loop is implemented for capturing the exact captcha text
//				 */
//
//			} while (driver.findElement(By.xpath("//div/img[@alt='Refresh']")).isDisplayed());
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//
//		/**
//		 * Explicit wait is implemented to avoid synchronization issue.
//		 */
//
//		// loginPage.submitLoginButton();
//		loginPage.errorValidation();
//		Thread.sleep(2000);
//		driver.close();
//
//	}

	@Test(groups = { "login" }, dataProvider = "driveTest", dependsOnMethods = { "logOutFunctionality" })

	public void testCaseDataLogin(String Username, String Password)
			throws InterruptedException, IOException, TesseractException {

		try {
			driver = initializeDriver();
			loginPage = new LoginPage(driver);
			loginPage.goTo();
			loginPage.implicitWaitBeforeThrowingError();
			driver.findElement(By.id("username")).sendKeys(Username);
			driver.findElement(By.cssSelector("#password")).sendKeys(Password);
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
						// driver = initializeDriver();
						testCaseData();
					}

					else if (errorMessage.equalsIgnoreCase(ClpConstants.errorMessageForInvalidCredentials))

					{
						loginPage.errorValidation();
						Thread.sleep(2000);
						driver.close();
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
		
		

		// loginPage.submitLoginButton();
		// loginPage.errorValidation();

	}

	@Test(groups = { "login" })

	public void logOutFunctionality() throws IOException, InterruptedException, TesseractException {

		try {

			loginPage = new LoginPage(driver);
			loginPage.goTo();
			loginPage.implicitWaitBeforeThrowingError();
			driver.findElement(By.id("username")).sendKeys("lpu.bangalore");
			driver.findElement(By.cssSelector("#password")).sendKeys("newpas12");
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

					else if (errorMessage.equalsIgnoreCase(ClpConstants.errorMessageForInvalidCredentials))

					{
						loginPage.errorValidation();
						Thread.sleep(2000);
						// driver.close();
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

		// loginPage.submitLoginButton();
		// loginPage.errorValidation();

	}

	@DataProvider(name = "driveTest")

	public Object[][] testCaseData() throws IOException {
		String filelocation = "./LoginData/CLP User Input.xlsx";
		XSSFWorkbook wbook = new XSSFWorkbook(filelocation);
		XSSFSheet sheet = wbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colcount = row.getLastCellNum();
		Object data[][] = new Object[rowCount - 1][colcount];
		for (int i = 0; i < rowCount - 1; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < colcount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
			
			
		}
		wbook.close();
		return data;

	}

//	@DataProvider(name = "driveTestFromJson")
//
//	public Object[][] getData() throws IOException {
//
//		List<HashMap<String, String>> data = getJsonDataToMap("./src/test/java/com/fa/clp/data/data.json");
//		return new Object[][] { { data.get(0) }, { data.get(1) } };
//
//	}

}
