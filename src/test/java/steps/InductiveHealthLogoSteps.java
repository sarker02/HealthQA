package steps;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InductiveHealthLogoPage;
import utils.BaseTest;

public class InductiveHealthLogoSteps extends BaseTest{
	public InductiveHealthLogoPage inductiveHealthLogoPage = new InductiveHealthLogoPage(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 
	public static Logger logger = Logger.getLogger(InductiveHealthLogoSteps.class.getName());
	
	@When("Click on the Video Tutorials option")
	public void clickVideoTutorialsOption() {
		logger.info("Executing Step: Click on the Video Tutorials option");
		wait.until(ExpectedConditions.visibilityOfElementLocated(inductiveHealthLogoPage.tutorialOption));
		driver.findElement(inductiveHealthLogoPage.tutorialOption).click();
	}

	@Then("Check InductiveHealth tutorials page is displayed")
	public void verifyTutorialsPageDisplayed() {
		logger.info("Executing Step: Check InductiveHealth tutorials page is displayed");
		wait.until(ExpectedConditions.visibilityOfElementLocated(inductiveHealthLogoPage.videoTutorialPage));
		WebElement videoTutorialPage= driver.findElement(inductiveHealthLogoPage.videoTutorialPage);
		Assert.assertTrue("video Tutorial Page is not there", videoTutorialPage.isDisplayed());
	}
}
