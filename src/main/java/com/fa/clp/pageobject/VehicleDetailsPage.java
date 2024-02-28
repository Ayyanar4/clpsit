package com.fa.clp.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class VehicleDetailsPage extends AbstractComponents {
	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(VehicleDetailsPage.class);

	public VehicleDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='registration-menu-information-head']")
	WebElement vehicleDetailsPageVisible;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	WebElement nextButton;

	public VBDetailsPage64 vehicleDetails() throws InterruptedException {

		waitForElementToAppear(vehicleDetailsPageVisible);

		Thread.sleep(2000);
		scrollbyjavascript("window.scrollBy(0,1500)");

		Thread.sleep(2000);

		nextButton.click();
		
		VBDetailsPage64 vbDetailsPage = new VBDetailsPage64(driver);
		
		return vbDetailsPage;

	}

}
