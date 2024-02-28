package com.fa.clp.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class VBDetailsPage64 extends AbstractComponents {
	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(VBDetailsPage64.class);

	public VBDetailsPage64(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".registration-menu-information-head")
	WebElement vbDetailsPageVisible;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	
	
	WebElement nextButton;

	public ClaimantDetailsPage VBDetails() throws InterruptedException {

		waitForElementToAppear(vbDetailsPageVisible);

		Thread.sleep(1000);

		nextButton.click();

		ClaimantDetailsPage claimantDetailsPage = new ClaimantDetailsPage(driver);

		return claimantDetailsPage;

	}

}
