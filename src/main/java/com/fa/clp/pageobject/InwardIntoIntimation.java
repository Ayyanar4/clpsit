package com.fa.clp.pageobject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class InwardIntoIntimation extends AbstractComponents {
	WebDriver driver;
	WebDriverWait Wait;
	public static final Logger logger = LogManager.getLogger(InwardIntoIntimation.class);

	public InwardIntoIntimation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "label[for='type-condition_radio']")
	private WebElement convertion;

	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	private WebElement yesRadioButton;

	@FindBy(xpath = "//button[@data-button='inwsave']")
	private WebElement saveButton;

	@FindBy(css = "div[class='policy-detail-head popup-iward-header']")
	private WebElement inwardPriorIntimation;

	@FindBy(xpath = "//label[contains(text(),'Yes')]")
	private WebElement inwardPriorIntimationYes;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement submitButton;

	@FindBy(css = "p[class='success-text']")
	private WebElement inwardIdSuccess;

	@FindBy(xpath = "//p/span")
	private WebElement inwardValue;

	@FindBy(xpath = "//button[@data-dismiss='modal']")
	private WebElement okayButton;

	@FindBy(css = "p[class='success-text']")
	private WebElement popupText;

	public void getInwardID() throws InterruptedException, IOException {

		waitForElementToAppear(popupText);
		String Inward = inwardValue.getText();
		System.out.println("The Inward ID is : " + Inward);
		Thread.sleep(2000);
		okayButton.click();

	}

	public IntimationInwardDetails inwardToIntimation() throws InterruptedException, IOException {

		// waitForElementToAppear(convertion);
		yesRadioButton.click();
		scrollbyjavascript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		saveButton.click();
		waitForElementToAppear(inwardPriorIntimation);
		inwardPriorIntimationYes.click();
		Thread.sleep(1000);
		submitButton.click();
		waitForElementToAppear(inwardIdSuccess);
		String Inward = inwardValue.getText();
		System.out.println(Inward);
		okayButton.click();
		Thread.sleep(2000);
		IntimationInwardDetails intInwardDetails = new IntimationInwardDetails(driver);
		return intInwardDetails;

	}

}
