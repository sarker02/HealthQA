package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvestigationManagmentpages {

	
	private WebDriver driver;

	public InvestigationManagmentpages(WebDriver driver) {
		this.driver = driver;
	}

	public By clkondiseassurvilence = By.xpath("//*[text()='Disease Surveillance']");
	public By clkonInvestigationmanagment_btn = By.xpath("//*[@href='/insights/epi/quality']");
	
	
	
	
	
	
	
}
