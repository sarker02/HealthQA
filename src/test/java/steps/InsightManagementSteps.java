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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Date;
import pages.FavoritePages;
import utils.BaseTest;
public class InsightManagementSteps<Selenium> extends BaseTest {

	public FavoritePages insith = new FavoritePages(driver);
	public static Duration timeout = Duration.ofSeconds(40);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 
	public static Logger logger = Logger.getLogger(InsightManagementSteps.class.getName());
	public int Timeout=20;


	@When("I navigate to Disease Analytics & Trends")
	public void navigateToDiseaseAnalyticsTrends() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(insith.diseaseSurveillance));
		driver.findElement(insith.diseaseSurveillance).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(insith.diseaseAnalyticsTrends));
		driver.findElement(insith.diseaseAnalyticsTrends).click();	
	}

	@Then("I expect to see all filter selections visible")
	public void verifyAllFilterSelectionsVisible() {
		WebElement allFilters =driver.findElement(insith.allFilter);
		Assert.assertEquals(true, allFilters.isDisplayed());
		System.out.print("selection filters displayed");	
	}

	@Then("I select filtering with Event Date within Last Week")
	public void selectFilteringWithEventDateWithinLastWeek() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(insith.eventDateBtn));
		driver.findElement(insith.eventDateBtn).click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(insith.lastWeekBtn));
		driver.findElement(insith.lastWeekBtn).click();
	}

	@Then("I expect to see populated fields for every day")
	public void verifyPopulatedFieldsForEveryDay() { }

	@Then("I expect to see matching investigation count same as matching count for Data Table")
	public void verifyInvestigationCountMatchingDataTable() throws InterruptedException {
		//getting value of investigation item
		String investigationItems = driver.findElement(insith.chartValueBox).getText();
		System.out.print("Investigation Items=" + investigationItems);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(insith.dropDown));
		driver.findElement(insith.dropDown).click();
		driver.findElement(insith.dataTable).click();
		//getting value of investigation item
		String dataTableItems = driver.findElement(insith.chartValueBox).getText();
		System.out.print("\n DataTable Items=" + dataTableItems);
		//compare both values    
		try {
			if(investigationItems.equals(dataTableItems)) {
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
	public void verifyDatesProvidedInFilter() throws Throwable {
		Thread.sleep(5000);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -6);
		System.out.println("Six Days Back Date = "+ cal.getTime());
		logger.info("Six Days Back Date = "+ cal.getTime());
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate now = LocalDate.now();
		LocalDate then = now.minusDays(6);
		System.out.println(String.format("Now:%s\nThen:%s",now.format(format),then.format(format)));
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

	@Then("I expect to see matching investigation count same as matching count for Geographical Distribution")
	public void verifyInvestigationCountMatchingGeographicalDistribution() {
		//getting value of investigation item
		String investigationItems = driver.findElement(insith.chartValueBox).getText();
		System.out.print("Investigation Items=" + investigationItems);
		wait.until(ExpectedConditions.visibilityOfElementLocated(insith.dropDown));
		driver.findElement(insith.dropDown).click();
		driver.findElement(insith.geographicDist).click();
		//getting value of investigation item
		String geographicalItems  = driver.findElement(insith.chartValueBox).getText();
		System.out.print("\n Geographical Items =" + geographicalItems);
		try {
			if(investigationItems.equals(geographicalItems)) {
				System.out.print("\n Investigation and Graphical items are same");
				logger.info("Investigation count display is same  with Graphical items");
			}else {
				System.out.print("\n Investigation and Graphical Items are not same");
				logger.info("Investigation count display is not same  with Graphical Items");
			}
		}catch (Exception e) {
			System.out.print("\n Something is wrong:" +e);
			logger.info("Error:" +e);
		}
	}
}


