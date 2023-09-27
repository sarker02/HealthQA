package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;
import pages.ManagementPage;
import utils.BaseTest;

public class ManageUserActivitySteps extends BaseTest {
	public ManagementPage Activity= new ManagementPage(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout);
	

	@When("I navigate to the <Selected Chart User Activity>")
	public void navigateToUserActivity() {
		logger.info("Executing Step: I navigate to the <Selected Chart User Activity>");
		// click on Management dropdown btn
		wait.until(ExpectedConditions.visibilityOfElementLocated(Activity.ClkonManagment_btn));
		driver.findElement(Activity.ClkonManagment_btn).click();
		// click on user Activity button
		driver.findElement(Activity.clkonuserActivity_btn).click();	
	}
}
