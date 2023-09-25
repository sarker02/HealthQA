package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;
import pages.FavoritePages;
import utils.BaseTest;

public class UtilizationDashboard extends BaseTest {

	
	public FavoritePages Utilize = new FavoritePages(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout);
	
	
	
	
	
	@When("I navigate to the <Selected Chart utilization dashboard>")
	public void i_navigate_to_the_selected_chart_utilization_dashboard() {
	
		driver.findElement(Utilize.diseaseSurveillanceBtn).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//click on Utilization Dashboard
		driver.findElement(Utilize.clkonUtilizationdashboard_btn).click();
	}



	
}
