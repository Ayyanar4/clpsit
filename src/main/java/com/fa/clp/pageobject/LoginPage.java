package com.fa.clp.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class LoginPage extends AbstractComponents {
	WebDriver driver;

	public static final Logger logger = LogManager.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "kc-login")
	private WebElement loginButton;

	@FindBy(id = "username")
	private WebElement userName;

	@FindBy(css = "#password")
	private WebElement passWord;

	@FindBy(xpath = "//span[contains(text(),'LPU Team Member')]")
	private WebElement implicitwait;

	@FindBy(xpath = "//span[contains(text(),'LPU Team Member')]")
	private WebElement loginButtonVisible;

	public void loginApplication(String userid, String password) throws InterruptedException {
		userName.sendKeys(userid);
		Thread.sleep(1000);
		passWord.sendKeys(password);
		logger.info("User Credentials is Entered");
	}

	public void goTo() {

		driver.get("https://clpportal.bagicsit2.bajajallianz.com/#/");
		// driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().window().maximize();
		logger.info("Navigate to Homepage");

	}

	public void submitLoginButton() {

		loginButton.click();
		logger.info("Clicking the login button");
	}

	public void visibilityOfLoginButton() {

		waitForElementToAppear(loginButtonVisible);
		logger.info("Login button is displayed");
	}

	public void errorValidation() throws InterruptedException {

		Assert.assertEquals(driver.findElement(By.cssSelector(".message-text.text-danger")).getText(),
				"Invalid username or password.");

	}

	public void loginButtonClicked(String extractedCaptchaText) throws InterruptedException {

		if (extractedCaptchaText.isEmpty()) {

			extractedCaptchaText = "qwerty @";

		}
		String[] arrstr = extractedCaptchaText.split(" ");
		String extractedCaptcha = arrstr[0].trim();
		System.out.println(extractedCaptcha);
		driver.findElement(By.name("valiIpt")).clear();
		driver.findElement(By.cssSelector("#captchainp")).sendKeys(extractedCaptcha);
		Thread.sleep(1000);

	}

}
