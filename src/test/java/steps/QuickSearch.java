package steps;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

public class QuickSearch extends BaseTest{


	public LoginPage loginPage = new LoginPage(driver);
	public static Logger logger = Logger.getLogger(QuickSearch.class.getName());
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 
	public HomePage homePage = new HomePage(driver);


	@When("I select the quick search bar")
	public void selectQuickSearchBar() {
		logger.info("Executing Step: I select the quick search bar ");
		driver.findElement(homePage.searchBar).click();
	}

	@When("I perform a search with a valid keyword")
	public void performSearchWithValidKeyword() throws InterruptedException {
		logger.info("Executing Step: I perform a search with a valid keyword");
		homePage.performSearch("cas");
	}

	@Then("I expect to see the correct results populated")
	public void verifySearchResults() {
		logger.info("Executing Step: I expect to see the correct results populated ");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(homePage.resultsContainingText("Cas")));
		List<WebElement> searchResults = driver.findElements(homePage.resultsContainingText("Cas"));
		Assert.assertTrue("No matching results found", searchResults.size() > 0);
	}

	@Given("I am an Authenticated User")
	public void perfomLogin() throws InterruptedException {
		logger.info("Executing step: I am an Authenticated User");
		loginPage.login();

	}

	@Given("I navigate to the Solutions Portal")
	public void navigateToSolutionsPortal() throws InterruptedException {
		logger.info("Executing Step: I navigate to the Solutions Portal ");
		WebElement solutionportal= driver.findElement(homePage.solutionPortalTxt);
		Assert.assertTrue("Solutions Portal Page Not Found", solutionportal.isDisplayed());
		Thread.sleep(2000);
	}

	@When("I perform search with keyword having more than three chracters")
	public void performQuickSearch() throws InterruptedException {
		logger.info("Executing Step: I search up results in the Quick Search Results more than int Characters ");
		homePage.performSearch("cass");
	}

	@Then("I see list of expected records in search results")
	public void verifyValidSearchResults() {
		logger.info("Executing Step: I see list of Expected result queries");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(homePage.resultsContainingText("Cass")));
		List<WebElement> searchResults = driver.findElements(homePage.resultsContainingText("Cass"));
		Assert.assertTrue("No matching results found", searchResults.size() > 0);

	}

	@Then("I click on the first user queried in the search list")
	public void clickFirstUserQueriedInSearchList() {
		logger.info("Executing Step: I click on the first user queried in the search list ");
		driver.findElement(homePage.firstUserInSearchResults).click();
	}


	@When("I perform search with invalid keyword")
	public void performSearcWithInvalidKeyword() throws InterruptedException {
		logger.info("I perform search with invalid keyword");
		homePage.performSearch("qqww");

	}


	@Then("I expect to see no results found")
	public void verifyNoResultFoundInSearchResults() {
		logger.info("Executing Step: I expect to see the No Result Found in search results");
		Assert.assertTrue("No Results Found Element no found", driver.findElement(homePage.noSearchResultsFoundTxt).isDisplayed());
	}



}
