package com.fa.clp.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class OverallIntimationDetails extends AbstractComponents {
	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(OverallIntimationDetails.class);

	public OverallIntimationDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class='policy-detail-head'] h4")
	WebElement overallIntPopup;

	@FindBy(xpath = "//button[contains(text(),'Okay')]")
	WebElement Element;
	
	@FindBy(xpath = "//button[contains(text(),'Okay')]")
	WebElement okayButton;
	

	@FindBy(css = ".submit-button.mt-2")
	WebElement searchPolicyButton;

	public EndorsementDetails overallIntDetails() throws InterruptedException {
		waitForElementToAppear(overallIntPopup);
		Thread.sleep(2000);
		Element.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		okayButton.click();
		waitForElementToAppear(overallIntPopup);
		searchPolicyButton.click();
		EndorsementDetails endorseDetails = new EndorsementDetails(driver);
		return endorseDetails;
		

		
		
		


		
	}

}
