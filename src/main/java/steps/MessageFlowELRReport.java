package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;
import pages.Messageflowpages;
import utils.BaseTest;

public class MessageFlowELRReport extends BaseTest {

	
	public Messageflowpages report = new Messageflowpages(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 
	
	@When("I navigate to the <Selected Chart ELR Report>")
	public void i_navigate_to_the_selected_chart_elr_report() {
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(report.clkonMessageflow_btn).click();
		
		driver.findElement(report.clkonELRReport_btn).click();
		
	}



	
	
	
}
