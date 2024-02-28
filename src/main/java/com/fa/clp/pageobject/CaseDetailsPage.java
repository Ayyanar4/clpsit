package com.fa.clp.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class CaseDetailsPage extends AbstractComponents {
	WebDriver driver;

	public static final Logger logger = LogManager.getLogger(CaseDetailsPage.class);
	
	public CaseDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='litigationType']")
	private WebElement litigationDd;

	@FindBy(id = "courtType")
	private WebElement courtType;

	@FindBy(xpath = "//button[normalize-space()='Next']")
	private WebElement NextButton;

	@FindBy(xpath = "//div[@data-buttonholder='next']")
	private WebElement caseDetailsDownButton;

	public InwardDetailsPage caseDetails() throws InterruptedException {
		litigationDd.click();
		litigationDd.sendKeys("Third Party Claim");
		litigationDd.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		courtType.click();
		courtType.sendKeys("Select");
		courtType.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		scrollbyjavascript("window.scrollBy(0,400)");
		waitForElementToAppear(caseDetailsDownButton);
		NextButton.click();
		logger.info("Redirected to Inward Details Page from Case Details Page");
		InwardDetailsPage inwardDetailsPage = new InwardDetailsPage (driver);
		return inwardDetailsPage;

	}

}
