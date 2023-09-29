package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;
import pages.FavoritePage;
import utils.BaseTest;

public class UtilizationDashboardSteps extends BaseTest {
	
	public FavoritePage Utilize = new FavoritePage(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout);
	
	@When("I navigate to the <Selected Chart utilization dashboard>")
	public void navigateToUtilizationDashboard() {
		logger.info("Executing Step: I navigate to the <Selected Chart utilization dashboard>");
		driver.findElement(Utilize.diseaseSurveillanceBtn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Utilize.clkonUtilizationdashboard_btn));		
		//click on Utilization Dashboard
		driver.findElement(Utilize.clkonUtilizationdashboard_btn).click();
	}
}
