package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuickstartPages {

	
	private WebDriver driver;

	public QuickstartPages(WebDriver driver) {
		this.driver = driver;
	}

	
	public By usernameTxt = By.xpath("//*[@id='username']");
	public By passwordTxt = By.xpath("//*[@id='password']");
	public By loginBtn = By.xpath("//*[@type='submit']");
	public By clkonsearc_box = By.xpath("//*[@id='default-search']");
	
	public By clkonfirstquiry = By.xpath("/html/body/div[2]/ul/li[1]/a/div[2]");
	
	


	
	
}
