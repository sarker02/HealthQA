package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.QuickstartPages;
import utils.BaseTest;

public class QuickStart extends BaseTest {
	
	public LoginPage loginPage;
	public static Logger logger = Logger.getLogger(LoginSteps.class.getName());
	public static Duration timeout;
	public WebDriverWait wait;
	public QuickstartPages quickStart = new QuickstartPages(driver);
	
	
	@Given("I am an Authenticated User")
	public void i_am_an_authenticated_user() {
		
		logger.info("Executing step: I enter username and password ");
		
		timeout = Duration.ofSeconds(10);
    	WebDriverWait wait = new WebDriverWait(driver, timeout);
		
    	loginPage = new LoginPage(driver);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.usernameTxt));
    	
		// enter username and password
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("inductiveEpitraxAdmin");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Pass!2345678");

		driver.findElement(By.xpath("//*[@type='submit']")).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement Epitraxinductive= driver.findElement(By.xpath("//*[text()='Epitrax Inductive']"));
		Assert.assertEquals(true, Epitraxinductive.isDisplayed());
		System.out.print("Epitraxinductive text is displayed");




	}
	@Given("I navigate to the Solutions Portal")
	public void i_navigate_to_the_solutions_portal() {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement solutionportal= driver.findElement(By.xpath("//*[text()='Solutions Portal']"));
		Assert.assertEquals(true, solutionportal.isDisplayed());
		System.out.print("solutionportal is displayed");


	}
	@When("I search up results in the Quick Search Results more than {int} Characters")
	public void i_search_up_results_in_the_quick_search_results_more_than_characters(Integer int1) {
		driver.findElement(quickStart.clkonsearc_box).click();
		driver.findElement(quickStart.clkonsearc_box).sendKeys("cas");
	}
	@Then("I see list of Expected result queries")
	public void i_see_list_of_expected_result_queries() {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement quries= driver.findElement(quickStart.clkonfirstquiry);
		Assert.assertEquals(true, quries.isDisplayed());
		System.out.print("quries result is displayed");


	}
	@Then("I click on the first user queried in the search list")
	public void i_click_on_the_first_user_queried_in_the_search_list() {
		driver.findElement(quickStart.clkonfirstquiry).click();
	}

}
