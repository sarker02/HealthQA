package steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BaseTest;

public class FavoritesintractChart extends BaseTest {




	@When("I navigate to the <Selected Chart>")
	public void i_navigate_to_the_selected_chart() {

		driver.findElement(By.xpath("//*[text()='Disease Surveillance']")).click();

		driver.findElement(By.xpath("//*[text()='Disease Analytics and Trends']")).click();



		driver.findElement(By.xpath("//*[text()='Event Date']")).click();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id='eventDate-WithinLastPicker']")).sendKeys("");
		driver.findElement(By.xpath("//*[text()='Within the last 1 Week']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/main/div/section/div/main/div[1]/div[2]/div/div[2]/div/div/div[2]/div")).click();
		driver.findElement(By.xpath("//*[text()='Data Table']")).click();

	}
	@When("I select the about this data option")
	public void i_select_the_about_this_data_option() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// click on about this data
		driver.findElement(By.xpath("//*[text()='About this data']")).click();
	}
	@Then("I expect their to be a text about the chart")
	public void i_expect_their_to_be_a_text_about_the_chart() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// display about this data Text
		WebElement  text =driver.findElement(By.xpath("//*[@style='opacity: 1; height: auto;']"));
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
		boolean displayedoption1=driver.findElement(By.xpath("//*[text()='Export Chart Data (CSV)']")).isDisplayed();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean displayedoption2 =driver.findElement(By.xpath("//*[text()='Export Line List (CSV)']")).isDisplayed();

	}







}
