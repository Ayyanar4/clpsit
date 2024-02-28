package com.fa.clp.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class OfficeTakingInwardDetailsPage extends AbstractComponents {
	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(OfficeTakingInwardDetailsPage.class);
	public OfficeTakingInwardDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(css=".inward-menu-information-head.office-taking.inward.details")
	private WebElement offInwardDetails;
	
	@FindBy(xpath="//button[normalize-space()='Next']")
	private WebElement nextButton;


	public DocumentUploadPage officeTakeInward() throws InterruptedException {

		waitForElementToAppear(offInwardDetails);
		Thread.sleep(1000);
		nextButton.click();	
		logger.info("Redirected to Document Upload Page from Office Taking Inward Details Page");
		DocumentUploadPage documentUpload = new DocumentUploadPage(driver);
		return documentUpload;
		
	}
		
}
