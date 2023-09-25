package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;

import pages.Messageflowpages;
import utils.BaseTest;

public class MessageflowDataQuality extends BaseTest {

	public Messageflowpages flow = new Messageflowpages(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout);
	
	
	@When("I navigate to the <Selected Chart ELR Data Quality>")
	public void i_navigate_to_the_selected_chart_elr_data_quality() {
		// click on message flow dropdown button
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(flow.clkonMessageflow_btn).click();
		// click on ELR data Quality
		driver.findElement(flow.clkonMessageflow_btn).click();
		
	}



	
	
}
