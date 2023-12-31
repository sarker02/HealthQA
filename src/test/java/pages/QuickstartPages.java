package pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuickstartPages {

	private WebDriver driver;

	public QuickstartPages(WebDriver driver) {
		this.driver = driver;
	}


	public By usernameTxt = By.xpath("//*[@id='username']");
	public By passwordTxt = By.xpath("//*[@id='password']");
	public By loginBtn = By.xpath("//*[@type='submit']");
	public By searchBox = By.xpath("//*[@id='default-search']");

	public By firstQuiry = By.xpath("/html/body/div[2]/ul/li[1]/a/div[2]");



}
