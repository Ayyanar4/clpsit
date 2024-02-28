package com.fa.clp.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class ConnectedTpClaims extends AbstractComponents {
	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(ConnectedTpClaims.class);

	public ConnectedTpClaims(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Connected TP Claims']")
	private WebElement connectTpVisible;

	@FindBy(xpath = "//button[contains(text(),'Register')]")
	private WebElement txtBox;

	public CaseDetailsRegistration connectTpClaims() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForElementToAppear(connectTpVisible);
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true)", txtBox);
		Thread.sleep(2000);
		txtBox.click();
		CaseDetailsRegistration caseRegistration = new CaseDetailsRegistration(driver);
		return caseRegistration;

	}

}
