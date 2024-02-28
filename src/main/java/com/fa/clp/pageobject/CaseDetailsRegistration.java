package com.fa.clp.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class CaseDetailsRegistration extends AbstractComponents {
	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(CaseDetailsRegistration.class);

	public CaseDetailsRegistration(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".registration-menu-information-head")
	private WebElement caseRegisterPageVisible;

	@FindBy(id = "underSection")
	private WebElement UnderSection;

	@FindBy(id = "claimDetails__causeOfLoss")
	private WebElement causeofLoss;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement nextButton;

	public AccidentDetailsPage caseDetailRegistration() throws InterruptedException {

		waitForElementToAppear(caseRegisterPageVisible);

		Thread.sleep(1000);
		
		scrollbyjavascript("window.scrollBy(0,1000)");
		
		Thread.sleep(1000);

		UnderSection.click();
		UnderSection.sendKeys("Sec. 140 & 166 of MV Act");
		UnderSection.sendKeys(Keys.ENTER);

		Thread.sleep(1000);

		causeofLoss.click();
		causeofLoss.sendKeys("DEATH");
		causeofLoss.sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		scrollbyjavascript("window.scrollBy(0,1000)");

		Thread.sleep(2000);

		nextButton.click();
		AccidentDetailsPage accidentDetailsPage = new AccidentDetailsPage(driver);
		return accidentDetailsPage;

	}

}
