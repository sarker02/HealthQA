package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;
import pages.MessageFlowPage;
import utils.BaseTest;

public class MessageFlowDataQualitySteps extends BaseTest{
	public MessageFlowPage flow = new MessageFlowPage(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout);
	
	
	@When("I navigate to the <Selected Chart ELR Data Quality>")
	public void navigateToELRDataQuality() {
		logger.info("Executing Step: I navigate to the <Selected Chart ELR Data Quality>");
		// click on message flow dropdown button
		wait.until(ExpectedConditions.visibilityOfElementLocated(flow.clkonMessageflow_btn));
		driver.findElement(flow.clkonMessageflow_btn).click();
		// click on ELR data Quality
		driver.findElement(flow.clkonMessageflow_btn).click();
	}
}
