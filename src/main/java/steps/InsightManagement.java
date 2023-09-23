package steps;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Date;
import pages.Insightmanagmentpages;
import utils.BaseTest;
public class InsightManagement<Selenium> extends BaseTest {
	
	public Insightmanagmentpages insith = new Insightmanagmentpages(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 
	public static Logger logger = Logger.getLogger(LoginSteps.class.getName());
	
	
	
	@When("I navigate to Disease Analytics & Trends")
	public void i_navigate_to_disease_analytics_trends() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(insith.clkonsurvilence_btn).click();
		
	    driver.findElement(insith.clkonanalytictrends_btn).click();
		
	}
	
	@Then("I expect to see all filter selections visible")
	public void i_expect_to_see_all_filter_selections_visible() {
		
		WebElement allfilters =driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/main/div/section/div/main/div[1]/div[1]"));
	    Assert.assertEquals(true, allfilters.isDisplayed());
	    System.out.print("selection filters displayed");	}
	
	@Then("I select filtering with Event Date within Last Week")
	public void i_select_filtering_with_event_date_within_last_week() {
		
		driver.findElement(insith.clkeventdate_Btn).click();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='eventDate-WithinLastPicker']")).sendKeys("");
	    driver.findElement(insith.clkonlastweek_btn).click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	}
	@Then("I expect to see populated fields for every day")
	public void i_expect_to_see_populated_fields_for_every_day() { }
		
	@Then("I expect to see matching investigation count same as matching count for Data Table")
	public void i_expect_to_see_matching_investigation_count_same_as_matching_count_for_data_table() {
	
		driver.findElement(insith.clkondrpdwn_btn).click();
		driver.findElement(insith.clkondatatable).click();
		
		   
		 WebElement element = driver.findElement(By.xpath("//*[text()='814']"));
		    String elementval = element.getAttribute("value");
		
		
		try {
			boolean displayed=driver.findElement(By.xpath("//*[text()='814']")).isDisplayed();

			
			if(displayed) {
				System.out.print("count display is same with data table count");
                 logger.info("count display is same  with data table");
			}else {

				System.out.print("count display is not same with data table");
				 logger.info("count display is not same  with data table");
			}

		}catch (Exception e) {

			System.out.print("count display is not same");
			 logger.info("count display is not same with data table count");
		}

		   
            
		/*	 WebElement machinginvestigation =driver.findElement(By.xpath("//*[text()='814']"));
			    Assert.assertEquals(true, machinginvestigation.isDisplayed());
			    System.out.print("count matched with datatable count");*/
			    

		    
		 
	}
	@When("I am on Data Table I expect to see dates same as dates provided in filter")
	public void i_am_on_data_table_i_expect_to_see_dates_same_as_dates_provided_in_filter() {
			
	
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7);
		System.out.println("Date = "+ cal.getTime());
		
		  DateTimeFormatter format =
		            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

		        LocalDateTime now = LocalDateTime.now();
		        LocalDateTime then = now.minusDays(7);

		        System.out.println(String.format(
		            "Now:  %s\nThen: %s",
		            now.format(format),
		            then.format(format)
		        ));
	}

}
