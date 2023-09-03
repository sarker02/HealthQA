package steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.BaseTest;
import org.apache.log4j.Logger;



public class LoginSteps extends BaseTest {

	public LoginPage loginPage;
	public static Duration timeout;
	public WebDriverWait wait;
	public static Logger logger = Logger.getLogger(LoginSteps.class.getName());
	
			
    @Given("I am on the the login page")
    public void openLandingPage() {
      //setup();
      logger.info("Executing Step: I am on the the login page");
      
    }
    
    @When("I enter username and password")
    public void navigateToLoginPage() {
    	logger.info("Executing step: I enter username and password ");
    	String username = "inductiveEpitraxAdmin";
    	String password = "Pass!2345678";
    	timeout = Duration.ofSeconds(10);
    	WebDriverWait wait = new WebDriverWait(driver, timeout); 
    	loginPage = new LoginPage(driver);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.usernameTxt));
    	driver.findElement(loginPage.usernameTxt).sendKeys(username);
    	driver.findElement(loginPage.passwordTxt).sendKeys(password);
    	captureScreenshot("login_page_screenshot");
    }

    @And("I click on sign in button")
    public void enterCredentials() throws InterruptedException {
    	logger.info("Executing Step: I click on sign in button");
    	driver.findElement(loginPage.loginBtn).click();
    	Thread.sleep(10000);
    }
    
    @Then("I expect to be signed on")
    public void verifySuccessfulLogin() {
    	Assert.assertTrue(driver.findElement(loginPage.favoritesBtn).isDisplayed(), "Favorites button not found. Failing the login test case");
    	logger.info("Executing Step: I expect to be signed on");
    	//tearDown();
    	
    }
}
