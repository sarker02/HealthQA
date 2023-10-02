/**
 * 
 */
package pages;

import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions ;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import steps.LoginSteps;
import steps.QuickSearch;
import utils.JsonDataReader;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class LoginPage {

	private WebDriver driver;
	public HomePage homePage = new HomePage(driver);
	public static Duration timeout;
	public WebDriverWait wait;
	public static Logger logger = Logger.getLogger(LoginPage.class.getName());
	private JSONObject jsonData;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		timeout = Duration.ofSeconds(30); 
		wait = new WebDriverWait(driver, timeout);
	}

	public By usernameTxt = By.xpath("//input[contains(@id, 'username')]");
	public By passwordTxt = By.xpath("//input[contains(@id, 'password')]");
	public By loginBtn = By.xpath("//input[contains(@value, 'Sign in')]");
	public By invalidLoginMsg = By.xpath("//span[contains(@id,'userMessageText')]");
	
	public By forgotPasswordLink = By.xpath("//a[contains(text(),'Forgot your password')]");
	
	public By forgotPwdCnfMsg = By.xpath("//span[contains(@id,'userMessageText')]");

	

	public void login() throws InterruptedException {
		logger.info("Performing login operation");
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTxt));
		jsonData = JsonDataReader.readData("valid_credentials.json");
		driver.findElement(usernameTxt).sendKeys((String)jsonData.get("username"));
		driver.findElement(passwordTxt).sendKeys((String)jsonData.get("password"));
		driver.findElement(loginBtn).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		WebElement Epitraxinductive= driver.findElement(By.xpath("//*[text()='Epitrax Inductive']"));
		Assert.assertEquals(true, Epitraxinductive.isDisplayed());
		System.out.print("Epitraxinductive text is displayed");
	}
	
	
}






