package com.fa.clp.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class FirAndPoliceDetails extends AbstractComponents {
	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(FirAndPoliceDetails.class);

	public FirAndPoliceDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='intimation-menu-information-head']")
	private WebElement policeDetails;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement nextButton;

	public DocumentList firDetails() throws InterruptedException {

		waitForElementToAppear(policeDetails);
		Thread.sleep(2000);
		scrollbyjavascript("window.scrollBy(0,1500)");
//		System.out.println("Scroll done");
		Thread.sleep(2000);
		nextButton.click();
		DocumentList documentList = new DocumentList(driver);
		return documentList;
	}

}
