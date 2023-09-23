package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;
import pages.EssenceAlertspages;
import pages.ManageInvestigationResolutionpages;
import utils.BaseTest;

public class ManagmentInvestigationResolution extends BaseTest {

	public ManageInvestigationResolutionpages invest = new  ManageInvestigationResolutionpages(driver);
	public static Duration timeout = Duration.ofSeconds(20);
	public WebDriverWait wait = new WebDriverWait(driver, timeout); 

	@When("I navigate to the <Selected Chart Investigation Resolution>")
	public void i_navigate_to_the_selected_chart_investigation_resolution() {

		// click on Managment dropdown btn
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(invest.ClkonManagment_btn).click();
		// click on investigation Resolution		
		driver.findElement(invest.ClkInvestigationResolution_btn).click();
	}









}
