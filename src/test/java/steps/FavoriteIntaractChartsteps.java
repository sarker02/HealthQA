package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FavoritesIntractChartPage;
import utils.BaseTest;

public class FavoriteIntaractChartsteps extends BaseTest{
	
	public  FavoritesIntractChartPage favort = new  FavoritesIntractChartPage(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 
	public static Logger logger = Logger.getLogger(LoginSteps.class.getName());


	@When("I navigate to the <Selected Chart>")
	public void navigatetoSelectedChart() {
		logger.info("Executing Step: I navigate to the <Selected Chart>");
		driver.findElement(favort.clkonsurvilence_btn).click();
		driver.findElement(favort.clkondiseasanalyticstrends_btn).click();
		driver.findElement(favort.clkoneventdate_btn).click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(favort.eventDateBtn));
		driver.findElement(favort.eventDateBtn).sendKeys("");
		driver.findElement(favort.clkonwithinlastweek_btn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(favort.clkondropdown_btn));
		// click on dropdown button
		driver.findElement(favort.clkondropdown_btn).click();
		driver.findElement(favort.clkondatatable ).click();
	}
	
	@When("I select the about this data option")
	public void selectThisDataOption() {
		logger.info("Executing Step: I select the about this data option");
		wait.until(ExpectedConditions.visibilityOfElementLocated(favort.clkonaboutus_btn));
		// click on about this data
		driver.findElement(favort.clkonaboutus_btn).click();
	}
	
	@Then("I expect their to be a text about the chart")
	public void verifyTextAboutTheChart() {
		logger.info("Executing Step: I select the about this data option");
		wait.until(ExpectedConditions.visibilityOfElementLocated(favort.thisDataTxt));

		// display about this data Text
		WebElement  text =driver.findElement(favort.thisDataTxt);
		Assert.assertEquals(true,  text.isDisplayed());
		System.out.print("text is display same about this data");
	}
	
	@When("I Click the download button")
	public void clickDownloadButton() {
		logger.info("Executing Step: I Click the download button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(favort.downloadIcon));
		// click on download icon
		driver.findElement(favort.downloadIcon).click();
	}
	
	@Then("I expect their to be options to choose")
	public void verifyOptionsToChoose() {
		logger.info("Executing Step: I expect their to be options to choose");
		try {
			boolean displayedoption1=driver.findElement(favort.chartDataTxt).isDisplayed();
			boolean displayedoption2 =driver.findElement(favort.lineListTxt).isDisplayed();

			if(displayedoption1 && displayedoption2) {
				System.out.print("Both options are available");
				logger.info("both options are available");
			}else {

				System.out.print("Both options are not available");
				logger.info("both options are not available");
			}

		}catch (Exception e) {

			System.out.print("This Option is not available= \t" + e);
			logger.info("this options is not availabe");
		}
	}
}
