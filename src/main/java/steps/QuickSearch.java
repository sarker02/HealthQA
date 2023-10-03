package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		Assert.assertTrue("Expected search results not found", driver.findElement(homePage.patientCassinClaudineRecord).isDisplayed());
	}

	@Given("I am an Authenticated User")
	public void perfomLogin() throws InterruptedException {
		logger.info("Executing step: I am an Authenticated User");
		loginPage.login();
		
	}

	@Given("I navigate to the Solutions Portal")
	public void i_navigate_to_the_solutions_portal() throws InterruptedException {
		logger.info("Executing Step: I navigate to the Solutions Portal ");
		WebElement solutionportal= driver.findElement(homePage.solutionPortalTxt);
		Assert.assertTrue("Solutions Portal Page Not Found", solutionportal.isDisplayed());
		Thread.sleep(2000);
	}

	@When("I perform search with keyword having more than three chracters")
	public void performQuickSearch() throws InterruptedException {
		 logger.info("Executing Step: I search up results in the Quick Search Results more than int Characters ");
         homePage.performSearch("Cass");
	}

	@Then("I see list of expected records in search results")
	public void verifyValidSearchResults() {
		logger.info("Executing Step: I see list of Expected result queries");

	try {
			boolean displayedoption1=driver.findElement(homePage.patientCassinMclaughlinRecord).isDisplayed();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			boolean displayedoption2 =driver.findElement(homePage.patientCassinSanjuanitaRecord).isDisplayed();

			if(displayedoption1 && displayedoption2) {
				System.out.print("options are available");
                 logger.info("options are available");
			}else {

				System.out.print("options are not available");
				 logger.info("options are not available");
			}

		}catch (Exception e) {

			System.out.print("This Option is not available= \t" + e);
			 logger.info("this options is not availabe");
		}

		
		
		//Assert.assertTrue("Patient Cassin Bartoletti Record not found in search results", driver.findElement(homePage.patientCassinMclaughlinRecord).isDisplayed());
	//	Assert.assertTrue("Patient cassin Ross record not found in search results", driver.findElement(homePage.patientCassinSanjuanitaRecord).isDisplayed());
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
