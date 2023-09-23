package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageUserActivitypages {

	
	
	private WebDriver driver;

	public ManageUserActivitypages(WebDriver driver) {
		this.driver = driver;
	}

	

	public By clkonManagment_btn = By.xpath("//*[text()='Management']");
	public By clkonuserActivity_btn = By.xpath("//*[text()='User Activity']");


	
	
	
	
}
