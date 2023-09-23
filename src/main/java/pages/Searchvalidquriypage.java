package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Searchvalidquriypage {

	
	
	private WebDriver driver;

	public Searchvalidquriypage(WebDriver driver) {
		this.driver = driver;
	}

	public By clkonsearch_bar = By.xpath("//*[@id='default-search']");
	
	
}
