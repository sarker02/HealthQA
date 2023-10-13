package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FavoritePages;
import pages.HomePage;
import utils.BaseTest;

public class FavoritesintractChartSteps extends BaseTest {

	public  FavoritePages favorite = new  FavoritePages(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 
	public static Logger logger = Logger.getLogger(LoginSteps.class.getName());
	public HomePage homePage = new HomePage(driver);

		
	@When("I navigate to the {string} {string}")
	public void navigateToThe(String string, String string2) {
		//select insight
		driver.findElement(By.xpath("//*[text()='"+string2+"']")).click();
		//select chart
		driver.findElement(By.xpath("//*[text()='"+ string+"']")).click();
	}
	
	@When("I select the about this data option")
	public void selectThisDataOption() {
	}
	
	@Then("I expect their to be a text about the chart")
	public void verifyTextAboutTheChart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(favorite.aboutThisDataTxt));
		// display about this data Text
		WebElement  text =driver.findElement(favorite.aboutThisDataTxt);
		Assert.assertEquals(true,  text.isDisplayed());
		System.out.print("text is display same about this data");
	}
	
	@When("I Click the download button")
	public void clickDownloadButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(favorite.downloadBtn));
		// click on download icon
		driver.findElement(favorite.downloadBtn).click();
	}
	
	@Then("I expect their to be options to choose")
	public void verifyOptionsToChoose() throws Throwable {
		Thread.sleep(3000);
		//compare two options
		homePage.compareTwoOptions(favorite.exportChartData, favorite.exportLineList);
	}
}
