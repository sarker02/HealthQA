package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;
import pages.EssenceAlertspages;
import utils.BaseTest;

public class ESSENCEAlerts extends BaseTest {

	public EssenceAlertspages Alerts = new  EssenceAlertspages(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 
	
	@When("I navigate to the <Selected Chart ESSENCE Alerts>")
	public void i_navigate_to_the_selected_chart_essence_alerts() {
	 
		// click on Syndromic Analytics dropdown btn
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.findElement(Alerts.clkonSynadromic_btn).click();
			
				// click on Essence Alerts  button
				driver.findElement(Alerts.EssenceAlerts_btn).click();
	}



	
	
}
