package com.fa.clp.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class InwardIdGenerate extends AbstractComponents {
	WebDriver driver;
	WebDriverWait Wait;
	public static final Logger logger = LogManager.getLogger(InwardIdGenerate.class);

	public InwardIdGenerate(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p/span")
	private WebElement inwardvalue;

	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement okayButton;

}
