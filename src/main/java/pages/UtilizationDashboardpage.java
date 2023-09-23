package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UtilizationDashboardpage {

	
	
	private WebDriver driver;

	public UtilizationDashboardpage(WebDriver driver) {
		this.driver = driver;
	}

	public By clkondiseassurvillence_btn = By.xpath("//*[text()='Disease Surveillance']");
	public By clkonUtilizationdashboard_btn = By.xpath("//*[@href='/insights/epi/utilization']");
	

	
}
