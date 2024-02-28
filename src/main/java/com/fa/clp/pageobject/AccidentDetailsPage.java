package com.fa.clp.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class AccidentDetailsPage extends AbstractComponents {
	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(AccidentDetailsPage.class);

	public AccidentDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h4[contains(text(),'Accident Details')]")
	private WebElement accidentDetailsPageVisible;

	@FindBy(css = "input[data-targetfield='accidentTime']")
	private WebElement dateOfLoss;

	@FindBy(xpath = "//div[contains(text(),'Continue')]")
	private WebElement calendarDateButton;
	
	@FindBy(id = "accidentNature")
	private WebElement natureofAccident;
	
	@FindBy(id = "victimStatus")
	private WebElement statusOfVictim;

	@FindBy(id = "victimName")
	private WebElement nameOfVictim;
	
	@FindBy(id = "accidentDescription")
	private WebElement elaborateOfAccident;
	
	@FindBy(css = "input[placeholder='Monthly Income']")
	private WebElement monthlyIncome;
	
	@FindBy(id = "occupation")
	private WebElement occupation;


	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement nextButton;

	public VehicleDetailsPage accidentDetails() throws InterruptedException {

		waitForElementToAppear(accidentDetailsPageVisible);
		Thread.sleep(2000);
		dateOfLoss.click();
		calendarDateButton.click();
		Thread.sleep(1000);
		natureofAccident.click();
		natureofAccident.sendKeys("Head on Collision");
		natureofAccident.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		statusOfVictim.click();
		statusOfVictim.sendKeys("Rider of IV");
		statusOfVictim.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		nameOfVictim.sendKeys("YYYYYY");
		elaborateOfAccident.sendKeys("Accident occurs due to drunk & drive");
		monthlyIncome.sendKeys("35000");
		occupation.sendKeys("Engineer");
		nextButton.click();
		
		VehicleDetailsPage vehicleDetailsPage = new VehicleDetailsPage(driver);
		return vehicleDetailsPage;


	}

}
