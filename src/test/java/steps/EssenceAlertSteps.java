package steps;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EssenceAlertPage;
import pages.LoginPage;
import utils.BaseTest;

public class EssenceAlertSteps extends BaseTest{
	public LoginPage loginPage = new LoginPage(driver);
	public static Logger logger = Logger.getLogger(EssenceAlertSteps.class.getName());
	public EssenceAlertPage alerts = new EssenceAlertPage(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 

	@When("I navigate to the <Selected Chart ESSENCE Alerts>")
	public void navigateToESSENCEAlerts() {
		logger.info("Executing Step: I navigate to the <Selected Chart ESSENCE Alerts>");
		wait.until(ExpectedConditions.visibilityOfElementLocated(alerts.syndromicBtn));
		driver.findElement(alerts.syndromicBtn).click();
		driver.findElement(alerts.essenceAlertsBtn).click();
	}
	}
	



