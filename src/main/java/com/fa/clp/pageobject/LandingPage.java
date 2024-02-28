package com.fa.clp.pageobject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fa.clp.abstractcomponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(LandingPage.class);

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Claim Management")
	private WebElement claimManagementDashboard;

	@FindBy(css = ".inward-card.navigation-card.flex-fill")
	private WebElement clickInwardInDashboard;

	@FindBy(xpath = "//div[@class='inward-menu-information-head case-details']")
	private WebElement inwardPage;

	@FindBy(css = ".navigation-menus")
	private WebElement visibleOfNavigationMenus;

	@FindBy(css = ".flaticon-profile-user.pr-3")
	private WebElement visibleOfLoginButton;

	@FindBy(css = ".col-lg-3.col-md-6.col-sm-12.d-flex.mb-4")
	private WebElement backToLandingPage;

	@FindBy(id = "kc-logout")
	private WebElement logout;

	@FindBy(xpath = "//small[@class='authour_name']/span[2]")
	private WebElement logoutButton;

	public void claimManagement() {

		claimManagementDashboard.click();
		logger.info("The Claim management button is clicked in the homepage");

	}

	public CaseDetailsPage goToInwardPage() {

		waitForElementToAppearAndClick(clickInwardInDashboard);
		logger.info("Clicked the inward button");
		waitForElementToAppear(inwardPage);
		logger.info("Case Details Page is displayed");
		CaseDetailsPage caseDetailPage = new CaseDetailsPage(driver);
		return caseDetailPage;
	}

	public void logOutFunction() throws InterruptedException {

		waitForElementToAppearAndClick(visibleOfNavigationMenus);
		Thread.sleep(1000);
		scrollbyjavascript("window.scrollBy(0,-600)");
		Thread.sleep(1000);
		visibleOfLoginButton.click();
		Thread.sleep(2000);
		logoutButton.click();
		Thread.sleep(3000);
		logger.info("The application has logged out");

	}

	public void backToLandingPage() throws InterruptedException, IOException {

		waitForElementToAppear(backToLandingPage);
		Thread.sleep(2000);

	}

}
