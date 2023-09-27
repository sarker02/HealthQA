package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;
import pages.FavoritePage;
import utils.BaseTest;

public class InvestigationManagementSteps extends BaseTest{
	
	public FavoritePage ivestmanagment = new FavoritePage(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout);
	
	@When("I navigate to the <Selected Chart Investigation Managment>")
	public void navigateToInvestigationManagment() {
		logger.info("Executing Step: I navigate to the <Selected Chart Investigation Managment>");
		driver.findElement(ivestmanagment.diseaseSurveillanceBtn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ivestmanagment.clkonInvestigationmanagment_btn));
		driver.findElement(ivestmanagment.clkonInvestigationmanagment_btn).click();		
	}
}
