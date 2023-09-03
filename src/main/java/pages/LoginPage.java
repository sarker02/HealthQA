/**
 * 
 */
package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions ;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

/**
 * 
 */
public class LoginPage {

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
			this.driver = driver;
	}
	
	public By usernameTxt = By.xpath("//input[contains(@id, 'username')]");
	public By passwordTxt = By.xpath("//input[contains(@id, 'password')]");
	public By loginBtn = By.xpath("//input[contains(@value, 'Sign in')]");
	public By favoritesBtn = By.xpath("//*[contains(text(), 'Favorites')]");
	
}



