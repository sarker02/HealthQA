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
import utils.BaseTest;

public class ForgetPassword extends BaseTest {
	
	public LoginPage loginPage;
	public static Duration timeout;
	public WebDriverWait wait;
	public static Logger logger = Logger.getLogger(LoginSteps.class.getName());
	
	@Given("I am on the the landing page")
	public void i_am_on_the_the_landing_page() {
		timeout = Duration.ofSeconds(10);
    	WebDriverWait wait = new WebDriverWait(driver, timeout); 
    	loginPage = new LoginPage(driver);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.usernameTxt));
	}
//	@When("I navigate to the forgot password link")
//	public void i_navigate_to_the_forgot_password_link() {
//		driver.findElement(By.xpath("//*[@id=\"kc-form-options\"]/a")).click();
//	}
//	@Then("I expect their to be a Forgot Password Header")
//	public void i_expect_their_to_be_a_forgot_password_header() {
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		WebElement forgotpasswordtext= driver.findElement(By.xpath("//*[text()='Forgot Password?']"));
//		Assert.assertEquals(true, forgotpasswordtext.isDisplayed());
//		System.out.print("forgotpassword text is displayed");
//
//	}
//	@Then("I enter in my username")
//	public void i_enter_in_my_username() {
//		driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("inductiveEpitraxAdmin");
//	}
	@When("I select Submit")
	public void i_select_submit() {
		driver.findElement(By.xpath("//*[@value='Submit']")).click();
	}
	@Then("I expect to see")
	public void i_expect_to_see() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement popupmessage= driver.findElement(By.xpath("//*[@id='userMessageText']"));
		Assert.assertEquals(true, popupmessage.isDisplayed());
		System.out.print("popupmessage is display after submit username");



	}

}
