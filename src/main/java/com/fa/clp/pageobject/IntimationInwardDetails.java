package com.fa.clp.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class IntimationInwardDetails extends AbstractComponents {
	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(IntimationInwardDetails.class);

	public IntimationInwardDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".intimation-menu-information-head")
	private WebElement intimationInwardDetailsPage;

	@FindBy(id = "courtType")
	private WebElement courtType;

	@FindBy(id = "caseTitle")
	private WebElement caseTitle;

	@FindBy(id = "courtLocationCode")
	private WebElement courtLocation;

	@FindBy(id = "courtName")
	private WebElement courtName;

	@FindBy(id = "caseDetails__casePrefix")
	private WebElement casePrefix;

	@FindBy(xpath = "//input[@placeholder='Case Number']")
	private WebElement caseNumber;

	@FindBy(id = "caseDetails__caseYear")
	private WebElement caseYear;

	@FindBy(id = "caseDetails__policyNumber")
	private WebElement policyNumber;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement nextButton;

	public IntimationDetails intimationInwardDetails() throws InterruptedException {

		waitForElementToAppear(intimationInwardDetailsPage);
		courtType.click();
		courtType.sendKeys("Trial Court");
		courtType.sendKeys(Keys.ENTER);

		caseTitle.sendKeys("case title");

		courtLocation.click();
		courtLocation.sendKeys("Bangalore");
		courtLocation.sendKeys(Keys.ENTER);

		courtName.click();
		courtName.sendKeys("HIGH COURT REGISTRAR JUDICIAL");
		courtName.sendKeys(Keys.ENTER);

		casePrefix.click();
		casePrefix.sendKeys("MACT");
		casePrefix.sendKeys(Keys.ENTER);

		scrollbyjavascript("window.scrollBy(0,1000)");

	

		caseNumber.sendKeys("653645");

		caseYear.click();
		caseYear.sendKeys("2023");
		caseYear.sendKeys(Keys.ENTER);

		policyNumber.sendKeys("12-1805-0000848913-00");

		nextButton.click();
		
		IntimationDetails intDetails = new IntimationDetails(driver);
		return intDetails;

	}

}
