package com.fa.clp.pageobject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class DocumentUploadPage extends AbstractComponents {
	WebDriver driver;
	WebDriverWait Wait;
	public static final Logger logger = LogManager.getLogger(CaseDetailsPage.class);

	public DocumentUploadPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".inward-menu-information-head.document-upload")
	private WebElement uploadDocument;

	@FindBy(xpath = "//button[normalize-space()='Next']")
	private WebElement nextButton;

	@FindBy(xpath = "//select[@placeholder='Document Type']")
	private WebElement documentType;

	@FindBy(xpath = "//select[@placeholder='Document Sub Type']")
	private WebElement documentSubType;

	@FindBy(xpath = "//select[@placeholder='Nature of the Document']")
	private WebElement natureOfTheDocument;

	@FindBy(xpath = "//input[@placeholder='No Of Pages']")
	private WebElement noOfPages;

	@FindBy(xpath = "//label[@data-browse='Browse']")
	private WebElement UploadButton;

	@FindBy(className = "add_button")
	private WebElement CloseButton;

	@FindBy(css = ".toast-body")
	private WebElement documentUploadSuccessMessageAtTopRight;

	@FindBy(css = "button[aria-label='Close']")
	private WebElement documentUploadSuccessMessage;

	@FindBy(css = ".align-top.file-download-link.col-sm-12")
	private WebElement documentUploadPageVisible;

	@FindBy(xpath = "//button[@class='submit-button']")
	private WebElement saveButton;

	String selectingDocumentType = "Court Papers";
	String selectingDocumentTypepolice = "Police Papers";
	String selectingSubDocumentType = "NFL Order";
	String selectingSubDocumentTypeSummary = "A Summary";
	String selectingNatureOfTheDocument = "Original";
	String pathForUploadingFile = "C:\\Users\\Fasoftwares\\Desktop\\code.txt";

	public InwardIntoIntimation uploadingDocument() throws InterruptedException, IOException {

		waitForElementToAppear(uploadDocument);
		staticDropdownHandleByVisibleText(documentType, selectingDocumentTypepolice);
		staticDropdownHandleByVisibleText(documentSubType, selectingSubDocumentTypeSummary);
		noOfPages.sendKeys("1");
		staticDropdownHandleByVisibleText(natureOfTheDocument, selectingNatureOfTheDocument);
		UploadButton.click();
		Thread.sleep(3000);
		uploadingFileInWindowsUsingAutoIt(pathForUploadingFile);
		Thread.sleep(2000);
		CloseButton.click();

		waitForElementToAppear(documentUploadPageVisible);
		scrollbyjavascript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		InwardIntoIntimation inwardToInt = new InwardIntoIntimation(driver);
		return inwardToInt;
		// saveButton.click();

	}

	public InwardIntoIntimation saveInward() throws InterruptedException, IOException {
		waitForElementToAppear(uploadDocument);
		staticDropdownHandleByVisibleText(documentType, selectingDocumentType);
		staticDropdownHandleByVisibleText(documentSubType, selectingSubDocumentType);
		noOfPages.sendKeys("1");
		staticDropdownHandleByVisibleText(natureOfTheDocument, selectingNatureOfTheDocument);
		UploadButton.click();
		Thread.sleep(3000);
		uploadingFileInWindowsUsingAutoIt(pathForUploadingFile);
		Thread.sleep(2000);
		CloseButton.click();
		try {
			if (Wait.until(ExpectedConditions.visibilityOf(documentUploadSuccessMessageAtTopRight)).isDisplayed()) {

				documentUploadSuccessMessage.click();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		waitForElementToAppear(documentUploadPageVisible);
		scrollbyjavascript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		saveButton.click();
		InwardIntoIntimation inwardToInt = new InwardIntoIntimation(driver);
		return inwardToInt;

		//

	}

}
