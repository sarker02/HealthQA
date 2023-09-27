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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InsightManagementPage;
import utils.BaseTest;

public class InsightManagementSteps extends BaseTest{

	public InsightManagementPage insith = new InsightManagementPage(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 
	public static Logger logger = Logger.getLogger(LoginSteps.class.getName());


	@When("I navigate to Disease Analytics & Trends")
	public void navigateToDiseaseAnalyticsTrends() {
		logger.info("Executing Step: I navigate to Disease Analytics & Trends");
		wait.until(ExpectedConditions.visibilityOfElementLocated(insith.clkonsurvilence_btn));
		driver.findElement(insith.clkonsurvilence_btn).click();
		driver.findElement(insith.clkonanalytictrends_btn).click();
	}

	@Then("I expect to see all filter selections visible")
	public void verifyAllFilterSelectionsVisible() {
		logger.info("Executing Step: I expect to see all filter selections visible");
		wait.until(ExpectedConditions.visibilityOfElementLocated(insith.allFilterTxt));
		WebElement allfilters =driver.findElement(insith.allFilterTxt);
		Assert.assertEquals(true, allfilters.isDisplayed());
		System.out.print("selection filters displayed");	
	}

	@Then("I select filtering with Event Date within Last Week")
	public void selectFilteringWithEventDateWithinLastWeek() {
		logger.info("Executing Step: I select filtering with Event Date within Last Week");
		wait.until(ExpectedConditions.visibilityOfElementLocated(insith.clkeventdate_Btn));
		driver.findElement(insith.clkeventdate_Btn).click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(insith.eventDateBtn));
		driver.findElement(insith.eventDateBtn).sendKeys("");
		driver.findElement(insith.clkonlastweek_btn).click();
	}

	@Then("I expect to see populated fields for every day")
	public void verifyPopulatedFieldsForEveryDay() {
		logger.info("Executing Step: I expect to see populated fields for every day");
	}

	@Then("I expect to see matching investigation count same as matching count for Data Table")
	public void verifyMatchingInvestigationCountSameAsMatchingCountForDataTable() {
		logger.info("Executing Step: I expect to see matching investigation count same as matching count for Data Table");
		
		//getting value of investigation item
		String investigationItems = driver.findElement(insith.investigationTxt).getText();
		System.out.print("Investigation Items=" + investigationItems);
		wait.until(ExpectedConditions.visibilityOfElementLocated(insith.clkondrpdwn_btn));
		driver.findElement(insith.clkondrpdwn_btn).click();
		driver.findElement(insith.clkondatatable).click();
		//getting value of investigation item
		wait.until(ExpectedConditions.visibilityOfElementLocated(insith.investigationTxt));
		String DataTableItems = driver.findElement(insith.dataTableItemTxt).getText();
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
	public void verifyDatesSameAsDatesProvidedInFilter() {
		logger.info("Executing Step: I am on Data Table I expect to see dates same as dates provided in filter");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7);
		System.out.println("Date = "+ cal.getTime());

		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

		LocalDateTime now = LocalDateTime.now();
		LocalDateTime then = now.minusDays(7);

		System.out.println(String.format(
				"Now:  %s\nThen: %s",
				now.format(format),
				then.format(format)
				)
				);
	}
}
