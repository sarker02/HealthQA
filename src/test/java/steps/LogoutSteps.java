package steps;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FavoriteChartPage;
import pages.LogoutPage;
import utils.BaseTest;

public class LogoutSteps extends BaseTest {
	public FavoriteChartPage favoriteChartPage = new FavoriteChartPage(driver);
	public LogoutPage logoutPage = new LogoutPage(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 
	public static Logger logger = Logger.getLogger(LogoutSteps.class.getName());

	@When("Click on the profile icon from the top right corner")
	public void clickProfileIcon() {
		logger.info("Executing Step: Click on the profile icon from the top right corner");
		wait.until(ExpectedConditions.visibilityOfElementLocated( logoutPage.profileIcon));
		driver.findElement( logoutPage.profileIcon).click();
	}

	@Then("Check All menu option is visible")
	public void verifyMenuOptionVisible() {
		logger.info("Executing Step: Check All menu option is visible");
		wait.until(ExpectedConditions.visibilityOfElementLocated( logoutPage.contactSupportOption));
		WebElement contactSupportOption= driver.findElement(logoutPage.contactSupportOption);
		Assert.assertTrue("contact Support Option is not there", contactSupportOption.isDisplayed());
		wait.until(ExpectedConditions.visibilityOfElementLocated( logoutPage.giveFeedbackOption));
		WebElement giveFeedbackOption= driver.findElement(logoutPage.giveFeedbackOption);
		Assert.assertTrue("give Feedback Option is not there", giveFeedbackOption.isDisplayed());
		wait.until(ExpectedConditions.visibilityOfElementLocated( logoutPage.videoTutorialOption));
		WebElement videoTutorialOption= driver.findElement(logoutPage.videoTutorialOption);
		Assert.assertTrue("video Tutorial Option is not there", videoTutorialOption.isDisplayed());
		wait.until(ExpectedConditions.visibilityOfElementLocated( logoutPage.aboutOption));
		WebElement aboutOption= driver.findElement(logoutPage.aboutOption);
		Assert.assertTrue("about Option is not there", aboutOption.isDisplayed());
		wait.until(ExpectedConditions.visibilityOfElementLocated( logoutPage.logoutOption));
		WebElement logoutOption= driver.findElement(logoutPage.logoutOption);
		Assert.assertTrue("logout Option is not there", logoutOption.isDisplayed());
	}

	@When("Click on the logout option")
	public void clickLogoutOption() {
		logger.info("Executing Step: Click on the logout option");
		wait.until(ExpectedConditions.visibilityOfElementLocated( logoutPage.logoutOption));
		driver.findElement( logoutPage.logoutOption).click();
	}

	@Then("Check logout popup is displayed")
	public void verifyLogoutPopupDisplayed() {
		logger.info("Executing Step: Check logout popup is displayed");
		wait.until(ExpectedConditions.visibilityOfElementLocated( logoutPage.logoutPopup));
		WebElement logoutPopup= driver.findElement(logoutPage.logoutPopup);
		Assert.assertTrue("logout Popup is not there", logoutPopup.isDisplayed());
	}

	@When("Click on the yes button")
	public void clickYesButton() {
		logger.info("Executing Step: Click on the yes button");
		wait.until(ExpectedConditions.visibilityOfElementLocated( logoutPage.yesButton));
		driver.findElement( logoutPage.yesButton).click();
	}

	@Then("Check landing page is displayed")
	public void verifyLandingPageDisplayed() {
		logger.info("Executing Step: Check landing page is displayed");
		wait.until(ExpectedConditions.visibilityOfElementLocated( logoutPage.landingPage));
		WebElement landingPage= driver.findElement(logoutPage.landingPage);
		Assert.assertTrue("landing Page is not there", landingPage.isDisplayed());
	}

	@When("Click on the keep working button")
	public void clickKeepWorkingButton() {
		logger.info("Executing Step: Click on the keep working button");
		wait.until(ExpectedConditions.visibilityOfElementLocated( logoutPage.keepWorkingButton));
		driver.findElement( logoutPage.keepWorkingButton).click();
	}

	@Then("Check home page is displayed")
	public void verifyHomePageDisplayed() {
		logger.info("Executing Step: Check home page is displayed");
		favoriteChartPage.performMouseHover(driver, favoriteChartPage.inductiveHealthLogo);
		wait.until(ExpectedConditions.visibilityOfElementLocated( favoriteChartPage.favoriteButton));
		driver.findElement(favoriteChartPage.favoriteButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated( favoriteChartPage.favoritePageText));
		WebElement favoritePageText= driver.findElement(favoriteChartPage.favoritePageText);
		Assert.assertTrue("favorite Page Text is not there", favoritePageText.isDisplayed());
		
		
	}
}
