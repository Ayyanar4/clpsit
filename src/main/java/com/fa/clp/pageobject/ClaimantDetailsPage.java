package com.fa.clp.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class ClaimantDetailsPage extends AbstractComponents {
	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(ClaimantDetailsPage.class);

	public ClaimantDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".registration-menu-information-head")
	private WebElement claimantDetailsPageVisible;

	@FindBy(css = "input[placeholder='Name']")
	private WebElement nameOfClaimant;

	@FindBy(xpath = "(//input[@class='search'])[1]")
	private WebElement typeofEntity;

	@FindBy(xpath = "(//input[@class='search'])[2]")
	private WebElement age;

	@FindBy(xpath = "(//input[@class='search'])[3]")
	private WebElement occupation;

	@FindBy(xpath = "input[placeholder='Income/Month']")
	private WebElement monthIncome;

	@FindBy(xpath = "(//input[@class='search'])[4]")
	private WebElement proofOfIncome;

	@FindBy(xpath = "//input[@placeholder='Name of Employer']")
	private WebElement nameOfEmployer;

	@FindBy(xpath = "(//input[@class='search'])[5]")
	private WebElement employersameasAssured;

	@FindBy(xpath = "//input[@placeholder='Address of Claimant']")
	private WebElement addressOfClaimant;

	@FindBy(xpath = "(//input[@class='search'])[6]")
	private WebElement gender;

	@FindBy(xpath = "(//input[@class='search'])[7]")
	private WebElement relationshipWith;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement nextButton;

	public void claimantDetails() throws InterruptedException {

		waitForElementToAppear(claimantDetailsPageVisible);

		nameOfClaimant.sendKeys("XXXXXX");

		typeofEntity.click();
		typeofEntity.sendKeys("Individual");
		typeofEntity.sendKeys(Keys.ENTER);

		Thread.sleep(1000);

		scrollIntoWebElementLeftSide("\"#details-container-payment-scroll\"", "600");

		Thread.sleep(1000);

		age.click();
		age.sendKeys("30");
		age.sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		scrollIntoWebElementLeftSide("\"#details-container-payment-scroll\"", "800");

		Thread.sleep(1000);

		occupation.click();
		occupation.sendKeys("Self Employed");
		occupation.sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		scrollIntoWebElementLeftSide("\"#details-container-payment-scroll\"", "1000");
		Thread.sleep(1000);

		monthIncome.sendKeys("40000");

		proofOfIncome.click();
		proofOfIncome.sendKeys("Salary Slip or Certificate");
		proofOfIncome.sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		scrollIntoWebElementLeftSide("\"#details-container-payment-scroll\"", "1200");
		Thread.sleep(1000);

		nameOfEmployer.sendKeys("ZZZZZZ");

		Thread.sleep(1000);
		scrollIntoWebElementLeftSide("\"#details-container-payment-scroll\"", "1400");
		Thread.sleep(1000);

		employersameasAssured.click();
		employersameasAssured.sendKeys("Yes");
		employersameasAssured.sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		scrollIntoWebElementLeftSide("\"#details-container-payment-scroll\"", "1500");
		Thread.sleep(1000);

		addressOfClaimant.sendKeys("No.67, T.Nagar, Chennai");

		gender.click();
		gender.sendKeys("Male");
		gender.sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		scrollIntoWebElementLeftSide("\"#details-container-payment-scroll\"", "1700");
		Thread.sleep(1000);

		relationshipWith.click();
		relationshipWith.sendKeys("Wife");
		relationshipWith.sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		scrollbyjavascript("window.scrollBy(0,1000)");
		Thread.sleep(1000);

		nextButton.click();

	}

}
