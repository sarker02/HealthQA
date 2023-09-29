package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;
import pages.ManagementPage;
import utils.BaseTest;

public class ManagementInvestigationResolutionSteps extends BaseTest{
	public ManagementPage invest = new ManagementPage(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 

	@When("I navigate to the <Selected Chart Investigation Resolution>")
	public void navigateToInvestigationResolution() {
		logger.info("Executing Step: I navigate to the <Selected Chart Investigation Resolution>");
		// click on Managment dropdown btn
		wait.until(ExpectedConditions.visibilityOfElementLocated(invest.ClkonManagment_btn));
		driver.findElement(invest.ClkonManagment_btn).click();
		// click on investigation Resolution		
		driver.findElement(invest.ClkInvestigationResolution_btn).click();
	}
}
