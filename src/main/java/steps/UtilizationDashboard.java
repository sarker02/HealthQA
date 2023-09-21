package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.cucumber.java.en.When;
import utils.BaseTest;

public class UtilizationDashboard extends BaseTest {

	
	@When("I navigate to the <Selected Chart utilization dashboard>")
	public void i_navigate_to_the_selected_chart_utilization_dashboard() {
	
		driver.findElement(By.xpath("//*[text()='Disease Surveillance']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@href='/insights/epi/utilization']")).click();
	}



	
}
