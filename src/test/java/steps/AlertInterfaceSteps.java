package steps;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AlertInterfacePage;
import utils.BaseTest;

public class AlertInterfaceSteps extends BaseTest {
	public AlertInterfacePage alertInterfacePage = new AlertInterfacePage(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 
	public static Logger logger = Logger.getLogger(AlertInterfaceSteps.class.getName());

	@When("Create at least one alert")
	public void createOneAlert() throws Throwable {
		logger.info("Executing Step: Create at least one alert");
		wait.until(ExpectedConditions.visibilityOfElementLocated(alertInterfacePage.syndromicAnalytics));
		driver.findElement(alertInterfacePage.syndromicAnalytics).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(alertInterfacePage.essenceAlerts));
		driver.findElement(alertInterfacePage.essenceAlerts).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(alertInterfacePage.createAlertButton));
		alertInterfacePage.javaScriptClickElement(driver.findElement(alertInterfacePage.createAlertButton));
		alertInterfacePage.switchToWindowByTitle("Create Alert");
		System.out.println();
		wait.until(ExpectedConditions.visibilityOfElementLocated(alertInterfacePage.createButton));
		alertInterfacePage.javaScriptClickElement(driver.findElement(alertInterfacePage.createButton));
		Thread.sleep(2000);
	}

	@When("Click on the notification button")
	public void clickNotificationButton() {
		logger.info("Executing Step: Click on the notification button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(alertInterfacePage.bellIcon));
		driver.findElement(alertInterfacePage.bellIcon).click();
	}

	@Then("Verify alert interface is visible")
	public void verifyAlertInterfaceVisible() {
		logger.info("Executing Step: Verify alert interface is visible");
		wait.until(ExpectedConditions.visibilityOfElementLocated(alertInterfacePage.markAllReadButton));
		driver.findElement(alertInterfacePage.markAllReadButton).click();
	}

}
