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
import pages.FavoritePages;
import utils.BaseTest;

public class FavoritesintractChart extends BaseTest {

	public  FavoritePages favort = new  FavoritePages(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 
	public static Logger logger = Logger.getLogger(LoginSteps.class.getName());
	

		
	@When("I navigate to the {string} {string}")
	public void i_navigate_to_the(String string, String string2  ) {
		
		//select insight
		driver.findElement(By.xpath("//*[text()='"+string2+"']")).click();
		
		//select chart
		driver.findElement(By.xpath("//*[text()='"+ string+"']")).click();
	
	}
	
	
	@When("I select the about this data option")
	public void i_select_the_about_this_data_option() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// click on about this data
		//driver.findElement(favort.clkonaboutus_btn ).click();
	}
	@Then("I expect their to be a text about the chart")
	public void i_expect_their_to_be_a_text_about_the_chart() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// display about this data Text
		WebElement  text =driver.findElement(By.xpath("//*[@class='font-bold text-lg md:text-md mr-2']"));
		Assert.assertEquals(true,  text.isDisplayed());
		System.out.print("text is display same about this data");

	}
	@When("I Click the download button")
	public void i_click_the_download_button() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// click on download icon
		driver.findElement(By.xpath("//*[@class='h-6 text-ih-navy-700']")).click();
	}
	@Then("I expect their to be options to choose")
	public void i_expect_their_to_be_options_to_choose() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		try {
			boolean displayedoption1=driver.findElement(By.xpath("//*[text()='Export Chart Data (CSV)']")).isDisplayed();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			boolean displayedoption2 =driver.findElement(By.xpath("//*[text()='Export Line List (CSV)']")).isDisplayed();

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


	}







}