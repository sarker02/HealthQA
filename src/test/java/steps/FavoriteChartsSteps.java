package steps;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FavoriteChartPage;
import pages.FavoritePage;
import pages.LoginPage;
import utils.BaseTest;

public class FavoriteChartsSteps extends BaseTest{
	public LoginPage loginPage = new LoginPage(driver);
	public FavoriteChartPage favoriteChartPage = new FavoriteChartPage(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 
	public static Logger logger = Logger.getLogger(FavoriteChartsSteps.class.getName());

	@Given("I am an authenticated user")
	public void performLogin() throws InterruptedException {
		logger.info("Executing Step: I am an authenticated user");
		loginPage.login();
	}

	@When("I navigate to the Favorite Page")
	public void navigateToFavoritePage() {
		logger.info("Executing Step: I navigate to the Favorite Page");
		favoriteChartPage.performMouseHover(driver,favoriteChartPage.inductiveHealthLogo);
		wait.until(ExpectedConditions.visibilityOfElementLocated(favoriteChartPage.favoriteButton));
		driver.findElement(favoriteChartPage.favoriteButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(favoriteChartPage.favoritePageText));
		WebElement favoritePageText= driver.findElement(favoriteChartPage.favoritePageText);
		Assert.assertTrue("Favorites", favoritePageText.isDisplayed());
	}

	@Then("I expect there are no favorite charts and the system display a text")
	public void verifyNoFavoriteChartsAndSystemDisplayText() {
		logger.info("Executing Step: I expect there are no favorite charts and the system display a text");
		wait.until(ExpectedConditions.visibilityOfElementLocated(favoriteChartPage.inductiveHealthLogo));
		favoriteChartPage.performMouseHover(driver,favoriteChartPage.inductiveHealthLogo);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(favoriteChartPage.noFavoritesAlertText));
			WebElement favoritePageText= driver.findElement(favoriteChartPage.noFavoritesAlertText);
			Assert.assertTrue("You haven't selected any dashboards as favorites. Get started by clicking the star icon (★) at the top of any of your Insights graphs or tables.", favoritePageText.isDisplayed());
		}catch(Exception err) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(favoriteChartPage.chartList));
			favoriteChartPage.isBarChartDisplayedAndHighlightStar(driver,favoriteChartPage.chartList ,favoriteChartPage.starIcon);
		}
	}

	@When("I navigate to Selected Chart page and click on the favorite Icon")
	public void navigateToSelectedChartPageAndClickOnFavoriteIcon(){
		logger.info("Executing Step: I navigate to Selected Chart page and click on the favorite Icon");
		wait.until(ExpectedConditions.visibilityOfElementLocated(favoriteChartPage.diseaseSurveillanceButton));
		driver.findElement(favoriteChartPage.diseaseSurveillanceButton).click();
		driver.findElement(favoriteChartPage.diseaseAnalytics).click();
		
	}

	@Then("I expect the Favorite Start icon to be highlighted")
	public void verifyFavoriteStartIconToBeHighlighted() {
		logger.info("Executing Step:I expect the Favorite Start icon to be highlighted");
	try {
		Thread.sleep(2000);
		driver.findElement(favoriteChartPage.starIconAdd).click();
		favoriteChartPage.isBarChartDisplayedAndHighlightStar(driver,favoriteChartPage.chartList ,favoriteChartPage.starIcon);
	}catch(Exception error){
		favoriteChartPage.isBarChartDisplayedAndHighlightStar(driver,favoriteChartPage.chartList ,favoriteChartPage.starIcon);
	}
	
	}

	@When("I navigate to the Favorite home page")
	public void navigateToFavoriteHomePage() {
		logger.info("Executing Step: I navigate to the Favorite home page");
		wait.until(ExpectedConditions.visibilityOfElementLocated(favoriteChartPage.favoriteButton));
		driver.findElement(favoriteChartPage.favoriteButton).click();
	
	}

	@Then("I see the favorite chart that was previously favorite to be visible on the favorites page")
	public void verifyFavoriteChartVisibleOnTheFavoritesPage() {
		logger.info("Executing Step: I see the favorite chart that was previously favorite to be visible on the favorites page");
		wait.until(ExpectedConditions.visibilityOfElementLocated(favoriteChartPage.diseaseChartTitle));
		WebElement diseaseChartTitle= driver.findElement(favoriteChartPage.diseaseChartTitle);
		Assert.assertTrue("there is no disease chart title", diseaseChartTitle.isDisplayed());
	}

	@And("Remove all favorite charts from the favorites page")
	public void removeAllFavoriteChartsFromFavoritesPage() throws Throwable {
		logger.info("Executing Step: Remove all favorite charts from the favorites page");
	Thread.sleep(3000);
	driver.findElement(favoriteChartPage.starIcon).click();
	}
}
