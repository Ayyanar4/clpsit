package com.fa.clp.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class EndorsementDetails extends AbstractComponents {
	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(EndorsementDetails.class);

	public EndorsementDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='modal-content']")
	private WebElement endorsementPageVisible;

	@FindBy(xpath = "//button[contains(text(),'Okay')]")
	private WebElement Element;

	@FindBy(xpath = "//button[@type='button'][normalize-space()='Next']")
	private WebElement nextButton;

	@FindBy(css = ".submit-button.mt-2")
	private WebElement searchPolicyButton;

	public ConnectedTpClaims endorsementDetailsPage() throws InterruptedException {

		waitForElementToAppear(endorsementPageVisible);
		Thread.sleep(2000);
		nextButton.click();
		ConnectedTpClaims connectedTp = new ConnectedTpClaims(driver);
		return connectedTp;

	}

}
