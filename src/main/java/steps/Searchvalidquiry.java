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
import pages.Searchvalidquriypage;
import utils.BaseTest;

public class Searchvalidquiry extends BaseTest {
	
	
	public Searchvalidquriypage validquriy = new Searchvalidquriypage(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 
	public static Logger logger = Logger.getLogger(LoginSteps.class.getName());
	
	
	
	
	
	
	
	
	
	@When("I search for the following \\(People, Investigation, Lab Reports \\(ALL SEPARATELY)")
	public void i_search_for_the_following_people_investigation_lab_reports_all_separately() {
		driver.findElement(validquriy.clkonsearch_bar).click();
		driver.findElement(By.xpath("//*[@id='default-search']")).sendKeys("cas");

	}
	

	@Then("I Expect to see the results populated accordingly above {int} search")
	public void i_expect_to_see_the_results_populated_accordingly_above_search(Integer int1) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		WebElement found=driver.findElement(By.xpath("/html/body/div[2]/ul/li[1]/a/div[2]"));
		    Assert.assertEquals(true, found.isDisplayed());
		    System.out.print("Result Found");

		    
			try {
				boolean displayed=driver.findElement(By.xpath("/html/body/div[2]/ul/li[1]/a/div[2]")).isDisplayed();

				
				if(displayed) {
					System.out.print("Result found displayed ");
	                 logger.info("Result found displayed on screen");
				}else {

					System.out.print("result not found");
					 logger.info("result not found");
				}

			}catch (Exception e) {

				System.out.print("result not found= \t" + e);
				 logger.info("result not found");
			}

		    
		    
		    
		    
		    
		    
	}




}
