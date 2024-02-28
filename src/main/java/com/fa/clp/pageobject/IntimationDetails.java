package com.fa.clp.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class IntimationDetails extends AbstractComponents {
	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(IntimationDetails.class);

	public IntimationDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".intimation-menu-information-head")
	private WebElement intimationDetailsPage;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement nextButton;

	public FirAndPoliceDetails intimationDetails() throws InterruptedException {

		waitForElementToAppear(intimationDetailsPage);

		Thread.sleep(1000);
		scrollbyjavascript("window.scrollBy(0,800)");
		Thread.sleep(1000);

		nextButton.click();
		
		
		FirAndPoliceDetails firandPoliceDetails = new FirAndPoliceDetails(driver);
		return firandPoliceDetails;
	}

}
