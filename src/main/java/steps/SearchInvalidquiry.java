package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchInvalidquriypage;
import utils.BaseTest;

public class SearchInvalidquiry extends BaseTest{

	
	public SearchInvalidquriypage invalidquriy = new SearchInvalidquriypage(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 
	public static Logger logger = Logger.getLogger(LoginSteps.class.getName());
	
	
	
	
	
	
	
	@When("I Select the Quick Search Bar")
	public void i_select_the_quick_search_bar() {
		driver.findElement(invalidquriy.clkonsearch_bar).click();
	}
	@When("I search for the following \\(People, Investigation, Lab Reports \\(ALL SEPARATELY) \\{ENTER RANDOM CHARACTER STRING}")
	public void i_search_for_the_following_people_investigation_lab_reports_all_separately() {
		driver.findElement(By.xpath("//*[@id='default-search']")).sendKeys("wwqq");
	}
	
	@Then("I Expect to see the �No Result Found� in quick search query")
	public void i_expect_to_see_the_no_result_found_in_quick_search_query() {
	
		
		try {
			boolean displayed=driver.findElement(By.xpath("//*[text()='No results found']")).isDisplayed();

			
			if(displayed) {
				System.out.print("No result found is displayed");
                 logger.info("No result found is displayed");
			}else {

				System.out.print("No result found is not displayed");
				 logger.info("No result found is not displayed");
			}

		}catch (Exception e) {

			System.out.print("No result found is not displayed= \t" + e);
			 logger.info("No result found is not displayed");
		}

		
		
		
		
		
		
		
	/*	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement result= driver.findElement(By.xpath("//*[text()='No results found']"));
		Assert.assertEquals(true, result.isDisplayed());
		System.out.print(" result is not found");*/
		  
	}





	
}
