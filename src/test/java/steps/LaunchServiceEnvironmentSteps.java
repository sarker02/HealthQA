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
import pages.LaunchServiceEnvironmentPage;
import utils.BaseTest;

public class LaunchServiceEnvironmentSteps extends BaseTest{
	public LaunchServiceEnvironmentPage launchService = new LaunchServiceEnvironmentPage(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 
	public static Logger logger = Logger.getLogger(LaunchServiceEnvironmentSteps.class.getName());


@When("Click on the Surveillance NBS link")
public void clickSurveillanceNBSLink() {
	logger.info("Executing Step: Click on the Surveillance NBS link");
	wait.until(ExpectedConditions.visibilityOfElementLocated(launchService.nbsOption));
	driver.findElement(launchService.nbsOption).click();
}

@Then("Check NBS page is displayed")
public void verifyNBSPageDisplayed() {
	logger.info("Executing Step: Check NBS page is displayed");
	wait.until(ExpectedConditions.visibilityOfElementLocated(launchService.nbsPage));
	WebElement nbsPage= driver.findElement(launchService.nbsPage);
	Assert.assertTrue("NBS page is not there", nbsPage.isDisplayed());
}

@When("Click on the Surveillance ESSENCE link")
public void clickSurveillanceEssenceLink() {
	logger.info("Executing Step: Click on the Surveillance ESSENCE link");
	wait.until(ExpectedConditions.visibilityOfElementLocated(launchService.essenceOption));
	driver.findElement(launchService.essenceOption).click();
}

@Then("Check ESSENCE page is displayed")
public void verifyEssencePageDisplayed() {
	logger.info("Executing Step: Check ESSENCE page is displayed");
	wait.until(ExpectedConditions.visibilityOfElementLocated(launchService.essencePage));
	WebElement essencePage= driver.findElement(launchService.essencePage);
	Assert.assertTrue("essence page is not there", essencePage.isDisplayed());
	wait.until(ExpectedConditions.visibilityOfElementLocated(launchService.essenceDemo));
	WebElement essenceDemo= driver.findElement(launchService.essenceDemo);
	Assert.assertTrue("essence demo is not there", essenceDemo.isDisplayed());
	wait.until(ExpectedConditions.visibilityOfElementLocated(launchService.essenceDemoButton));
	WebElement essenceDemoButton= driver.findElement(launchService.essenceDemoButton);
	Assert.assertTrue("essence demo button is not there", essenceDemoButton.isDisplayed());
}

@When("Click on the Surveillance EpiTrax link")
public void clickSurveillanceEpitraxLink() {
	logger.info("Executing Step: Click on the Surveillance EpiTrax link");
	wait.until(ExpectedConditions.visibilityOfElementLocated(launchService.epiTraxOption));
	driver.findElement(launchService.epiTraxOption).click();
}

@Then("Check EpiTrax page is displayed")
public void verifyEpitraxPageDisplayed() {
	logger.info("Executing Step: Check EpiTrax page is displayed");
	wait.until(ExpectedConditions.visibilityOfElementLocated(launchService.epiTraxPage));
	WebElement epiTraxPage= driver.findElement(launchService.epiTraxPage);
	Assert.assertTrue("epiTrax Page is not there", epiTraxPage.isDisplayed());
	wait.until(ExpectedConditions.visibilityOfElementLocated(launchService.epiTraxDemo));
	WebElement epiTraxDemo= driver.findElement(launchService.epiTraxDemo);
	Assert.assertTrue("epiTrax Demo is not there", epiTraxDemo.isDisplayed());
	wait.until(ExpectedConditions.visibilityOfElementLocated(launchService.epiTraxDemoButton));
	WebElement epiTraxDemoButton= driver.findElement(launchService.epiTraxDemoButton);
	Assert.assertTrue("epiTrax Demo Button is not there", epiTraxDemoButton.isDisplayed());
	

}

@When("Click on the Surveillance Respond point of care link")
public void clickSurveillanceRespondPointOfCareLink() {
	logger.info("Executing Step: Click on the Surveillance Respond point of care link");
	wait.until(ExpectedConditions.visibilityOfElementLocated(launchService.respondPointOption));
	driver.findElement(launchService.respondPointOption).click();
}

@Then("Check Respond point of care page is displayed")
public void verifyRespondPointOfCarePageIsDisplayed() {
	logger.info("Executing Step: Check Respond point of care page is displayed");
	wait.until(ExpectedConditions.visibilityOfElementLocated(launchService.respondPage));
	WebElement respondPage= driver.findElement(launchService.respondPage);
	Assert.assertTrue("respond Page is not there", respondPage.isDisplayed());
}

}
