package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;
import pages.MessageFlowPage;
import utils.BaseTest;

public class MessageFlowELRReportSteps extends BaseTest {

	public MessageFlowPage report = new MessageFlowPage(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 

	@When("I navigate to the <Selected Chart ELR Report>")
	public void navigateTOELRReport() {
		logger.info("Executing Step: I navigate to the <Selected Chart ELR Report>");
		wait.until(ExpectedConditions.visibilityOfElementLocated(report.clkonMessageflow_btn));
		driver.findElement(report.clkonMessageflow_btn).click();
		driver.findElement(report.clkonELRReport_btn).click();
	}

}
