package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;
import pages.InvestigationManagmentpages;
import utils.BaseTest;
import java.time.Duration;
import java.time.Duration;
public class InvestigationManagment extends BaseTest {
	
	public InvestigationManagmentpages ivestmanagment = new InvestigationManagmentpages(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout);
	

	@When("I navigate to the <Selected Chart Investigation Managment>")
	public void i_navigate_to_the_selected_chart_investigation_managment() {
	   
		driver.findElement(ivestmanagment.clkondiseassurvilence).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(ivestmanagment.clkonInvestigationmanagment_btn).click();
		
		
	}


	

/*	@When("I Click the download button on investigation page")
	public void i_click_the_download_button_on_investigation_page() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		js.executeScript("window.scrollBy(215,450)");
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Thread.sleep(10000);
	driver.findElement(By.cssSelector("#headlessui-menu-button-\\:re\\: > svg")).click();
	//	WebElement ele = driver.findElement(By.xpath("(//*[@aria-expanded='false'])/*[2]"));
		//((JavascriptExecutor) driver).executeScript("arguments[2].click();", ele);

	
	}*/




	

	
	
	
	
}
