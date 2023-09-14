package steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BaseTest;

public class Searchvalidquiry extends BaseTest {
	
	@When("I search for the following \\(People, Investigation, Lab Reports \\(ALL SEPARATELY) \\{ENTER RANDOM CHARACTER STRING}")
	public void i_search_for_the_following_people_investigation_lab_reports_all_separately() {
		driver.findElement(By.xpath("//*[@id='default-search']")).click();
		driver.findElement(By.xpath("//*[@id='default-search']")).sendKeys("qqww");

	}
	@Then("I Expect to see the �No Result Found� in quick search query")
	public void i_expect_to_see_the_no_result_found_in_quick_search_query() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
		WebElement notfound=driver.findElement(By.xpath("//*[text()='No results found']"));
		    Assert.assertEquals(true, notfound.isDisplayed());
		    System.out.print("no result found");
	}

}
