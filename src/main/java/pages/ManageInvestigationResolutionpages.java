package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageInvestigationResolutionpages {

	private WebDriver driver;

	public ManageInvestigationResolutionpages(WebDriver driver) {
		this.driver = driver;
	}

	public By ClkonManagment_btn = By.xpath("//*[text()='Management']");
	public By ClkInvestigationResolution_btn = By.xpath("//*[text()='Investigation Resolution']");

	
	
	
	
	
}
