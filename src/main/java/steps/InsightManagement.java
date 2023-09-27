package steps;

import java.time.Duration;
import java.time.LocalDate;
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
	public static Logger logger = Logger.getLogger(InsightManagement.class.getName());
	
	
	
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
	public void i_expect_to_see_matching_investigation_count_same_as_matching_count_for_data_table() throws InterruptedException {
	
		//getting value of investigation item
		String investigationItems = driver.findElement(By.xpath("//*[@class='pl-3 pt-1 text-gray-500 text-sm']")).getText();
		System.out.print("Investigation Items=" + investigationItems);
		
		Thread.sleep(3000);
		driver.findElement(insith.clkondrpdwn_btn).click();
		driver.findElement(insith.clkondatatable).click();
		
		//getting value of investigation item
		String DataTableItems = driver.findElement(By.xpath("//*[@class='pl-3 pt-1 text-gray-500 text-sm']")).getText();
		System.out.print("\n DataTable Items=" + DataTableItems);
			    
		//compare both values    
		
		try {
			
			
			if(investigationItems.equals(DataTableItems)) {
				System.out.print("\n Investigation and data table items are same");
                 logger.info("Investigation count display is same  with data table");
			}else {

				System.out.print("\n Investigation and data table items are not same");
				 logger.info("Investigation count display is not same  with data table");
			}

		}catch (Exception e) {

			System.out.print("\n Something is wrong:" +e);
			 logger.info("Error:" +e);
		}

		    
		 
	}
	
	@When("I am on Data Table I expect to see dates same as dates provided in filter")
	public void i_am_on_data_table_i_expect_to_see_dates_same_as_dates_provided_in_filter() {
			
	
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -6);
		System.out.println("Six Days Back Date = "+ cal.getTime());
		logger.info("Six Days Back Date = "+ cal.getTime());

		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		LocalDate now = LocalDate.now();
		LocalDate then = now.minusDays(6);

		System.out.println(String.format(
				"Now:%s\nThen:%s",
				now.format(format),
				then.format(format)
				));
		
		
		
		//get all dates from data table
		
		for (int i=3; i<=9; i++) {
			
			String tableDates = driver.findElement(By.xpath("//*[@class='table-auto w-full bg-white border border-gray-200 divide-y divide-gray-200']/thead/tr[2]/th["+ i +"]")).getText();
			
			//convert string to date
			LocalDate convertDate = LocalDate.parse(tableDates, format);
			
			//compare dates 
			if (then.equals(convertDate) ) {
				
				System.out.print("Row "+ i +" date value=" + convertDate + " is same \n");
				logger.info("Row "+ i +" date value=" + convertDate + " is same \n");
				
			}else {
			
				System.out.print("Row "+ i +" date value=" + convertDate + " is not same \n");
				logger.info("Row "+ i +" date value=" + convertDate + " is not same \n");
			}
			
			//add one day
			then = then.plusDays(1);
			
			
			
			
		}
		
		
	}
}


