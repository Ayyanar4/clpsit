package com.fa.clp.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class DocumentList extends AbstractComponents {
	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(DocumentList.class);

	public DocumentList(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".intimation-menu-information-head")
	private WebElement documentListPage;

	@FindBy(css = "button[data-button='save']")
	private WebElement saveButton;

	@FindBy(xpath = "//p/span")
	private WebElement intimationvalue;

	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement okayButton;

	@FindBy(xpath = "//input[@value='Yes']")
	private WebElement radioButton;

	@FindBy(css = "p[class='success-text']")
	private WebElement successPopup;

	public OverallIntimationDetails docList() throws InterruptedException {

		waitForElementToAppear(documentListPage);
		Thread.sleep(2000);
		scrollbyjavascript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		radioButton.click();
		Thread.sleep(1000);
		saveButton.click();
		waitForElementToAppear(successPopup);
		String Intimation = intimationvalue.getText();
		System.out.println("The Intimation id is :" + Intimation);
		Thread.sleep(2000);
		okayButton.click();
		OverallIntimationDetails overallIntimationDetails = new OverallIntimationDetails(driver);
		return overallIntimationDetails;

	}

}
