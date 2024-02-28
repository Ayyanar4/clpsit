package com.fa.clp.pageobject;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class InwardDocumentDetailsPage extends AbstractComponents {
	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(InwardDocumentDetailsPage.class);

	public InwardDocumentDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="isDocStampingDone")
	private WebElement stampingOfTheDocumentDone;
	
	@FindBy(id = "inwardSource")
	private WebElement inwardSource;

	@FindBy(id = "inwardMode")
	private WebElement inwardMode;

	@FindBy(id = "courierName")
	private WebElement courierName;

	@FindBy(id = "isCourierReceiptSnapshot")
	private WebElement snapshotOfCourierReceipt;

	@FindBy(css = "div[class='inward-menu-information-head inward-document details'] h4")
	private WebElement inwardDocumentDetails;

	@FindBy(xpath = "//button[normalize-space()='Next']")
	private WebElement NextButton;

	@FindBy(id = "inwardDocumentSentBy")
	private WebElement inwardDocumentSentBy;

	@FindBy(css = "#receiptModeDocument")
	private WebElement modeOfReceipt;

	@FindBy(xpath = "//div[@class='item']")
	private List<WebElement> modeOfReceiptOfDocument;

	@FindBy(css = "input[data-targetfield='reasonForDelayedInward']")
	private WebElement dateOfReceipt;

	@FindBy(xpath = "//div[contains(text(),'Continue')]")
	private WebElement continueButtonInCalender;

	@FindBy(xpath = "//button[normalize-space()='Next']")
	private WebElement nextButton;
	
	@FindBy(id="podNumber")
	private WebElement podNumber;
	
	@FindBy(xpath = "//input[@placeholder='Select Date of Stamping']")
	private WebElement dateOfStamping;

	public OfficeTakingInwardDetailsPage inwardDocumentDetails() throws InterruptedException {

		waitForElementToAppear(inwardDocumentDetails);
		Thread.sleep(2000);
		//inwardDocumentSentBy.sendKeys("ZZZZZZ");
		//		modeOfReceipt.click();
		//		modeOfReceipt.sendKeys("Post");
		//		modeOfReceipt.sendKeys(Keys.ENTER);
		inwardSource.click();
		inwardSource.sendKeys("Court");
		inwardSource.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		inwardMode.click();
		inwardMode.sendKeys("API");
		inwardMode.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		courierName.sendKeys("Courier");
		Thread.sleep(1000);
		snapshotOfCourierReceipt.click();
		snapshotOfCourierReceipt.sendKeys("Yes");
		snapshotOfCourierReceipt.sendKeys(Keys.ENTER);
		podNumber.sendKeys("987868");
		dateOfReceipt.click();
		for (int i = 0; i < 2; i++) {

			continueButtonInCalender.click();

		}
		
		stampingOfTheDocumentDone.click();
		stampingOfTheDocumentDone.sendKeys("Yes");
		stampingOfTheDocumentDone.sendKeys(Keys.ENTER);
		dateOfStamping.click();
		for (int i = 0; i < 2; i++) {

			continueButtonInCalender.click();

		}
		nextButton.click();
		logger.info("Redirected to Office Taking Inward Details Page from Inward Document Details Page");
		OfficeTakingInwardDetailsPage offTakingInwardDetails = new OfficeTakingInwardDetailsPage(driver);
		return offTakingInwardDetails;

	}

}
