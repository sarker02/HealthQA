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
import steps.QuickSearchSteps;
import utils.JsonDataReader;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
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
	
	public By forgotPasswordHeaderMsg = By.xpath("//div[contains(@id,'instructions')]");
	public By submitBtn = By.xpath("//input[contains(@value,'Submit')]");


	

	public void login() throws InterruptedException {
		logger.info("Performing login operation");
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTxt));
		jsonData = JsonDataReader.readData("user_role_credentials.json");
		String user_role = System.getProperty("user_role", "IH-POWER");
		JSONObject credentials = (JSONObject) jsonData.get(user_role);
		driver.findElement(usernameTxt).sendKeys((String)credentials.get("username"));
		driver.findElement(passwordTxt).sendKeys((String)credentials.get("password"));
		driver.findElement(loginBtn).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        String user_fullname = (String) credentials.get("fullname");
        List<WebElement> user_elements = driver.findElements(By.xpath("//*[(text())='" + user_fullname + " ']"));
        Assert.assertFalse(!user_elements.isEmpty(), "Expected user name is displayed after login");
             
             
             
	}
}
	
	
	







