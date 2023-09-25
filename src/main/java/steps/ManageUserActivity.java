package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;

import pages.ManagmentPages;
import utils.BaseTest;

public class ManageUserActivity extends BaseTest {

	
	public ManagmentPages Activity= new ManagmentPages(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout);
	

	@When("I navigate to the <Selected Chart User Activity>")
	public void i_navigate_to_the_selected_chart_user_activity() {
	 
		// click on Managment dropdown btn
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(Activity.ClkonManagment_btn).click();
	
		// click on user Activity button
		driver.findElement(Activity.clkonuserActivity_btn).click();
		
		
	}



	
	
	
	
}
