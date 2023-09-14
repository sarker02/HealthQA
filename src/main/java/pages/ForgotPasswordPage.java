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
public class ForgotPasswordPage {

	private WebDriver driver;

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	public By usernameTxt = By.xpath("//input[contains(@id, 'username')]");
	public By forgotPasswordHeaderMsg = By.xpath("//div[contains(@id,'instructions')]");
	public By submitBtn = By.xpath("//input[contains(@value,'Submit')]");


}
