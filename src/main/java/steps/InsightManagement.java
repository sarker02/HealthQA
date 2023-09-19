package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BaseTest;

public class InsightManagement extends BaseTest {
	
	
	@When("I navigate to Disease Analytics & Trends")
	public void i_navigate_to_disease_analytics_trends() {
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/header/nav/div[2]/aside/div[5]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/header/nav/div[2]/aside/div[5]/div[2]/a[1]/button/span/div/div")).click();
		
	}
	@Then("I expect to see all filter selections visible")
	public void i_expect_to_see_all_filter_selections_visible() {
		
	}
	@Then("I select filtering with Event Date within Last Week")
	public void i_select_filtering_with_event_date_within_last_week() {
			}
	@Then("I expect to see populated fields for every day")
	public void i_expect_to_see_populated_fields_for_every_day() { }
		
	@Then("I expect to see matching investigation count same as matching count for Data Table")
	public void i_expect_to_see_matching_investigation_count_same_as_matching_count_for_data_table() {
			}
	@When("I am on Data Table I expect to see dates same as dates provided in filter")
	public void i_am_on_data_table_i_expect_to_see_dates_same_as_dates_provided_in_filter() {
			}

}
