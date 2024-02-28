package com.fa.clp.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class InwardDetailsPage extends AbstractComponents {
	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(InwardDetailsPage.class);
	public InwardDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(css = "div[class='inward-menu-information-head inward-details'] h4")
	private WebElement inwardDetails;

	@FindBy(xpath = "//button[normalize-space()='Next']")
	private WebElement NextButton;
	
	@FindBy(id="responsibleHubLocationCode")
	private WebElement inwardResponsibleHub;
	
	@FindBy(id="responsibleBranch")
	private WebElement inwardResponsibleBranch;

	public InwardDocumentDetailsPage inwardDetails() throws InterruptedException {

		waitForElementToAppear(inwardDetails);
		Thread.sleep(2000);
		
		inwardResponsibleHub.click();
		inwardResponsibleHub.sendKeys("Bangalore");
		inwardResponsibleHub.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		inwardResponsibleBranch.click();
		inwardResponsibleBranch.sendKeys("Bangalore");
		inwardResponsibleBranch.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		scrollbyjavascript("window.scrollBy(0,400)");
		NextButton.click();
		logger.info("Redirected to Inward Document Details Page from Inward Details Page");
		InwardDocumentDetailsPage inwardDocumentDetails = new InwardDocumentDetailsPage (driver);
		return inwardDocumentDetails;
	}

	
}
