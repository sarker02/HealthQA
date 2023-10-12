package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import steps.LoginSteps;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import utils.ConfigPropertyReader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseTest {

    public static WebDriver driver;
    public static Logger logger = Logger.getLogger(BaseTest.class.getName());
    public static ConfigPropertyReader configReader = new ConfigPropertyReader();
	public static String browser_type = configReader.getProperty("browser");
	public static String firefox_driver_path = configReader.getProperty("firefox_driver_path");
	public static String chrome_driver_path = configReader.getProperty("chrome_driver_path");
	public static String site_url = configReader.getProperty("site_url");
	public static String project_root_dir = System.getProperty("user.dir");
  
	public static void setup() {
		if(browser_type.equalsIgnoreCase("firefox")) {
			logger.info("Initializing Firefox Broswer Session");
			driver = new FirefoxDriver();
		}
		else if(browser_type.equalsIgnoreCase("chrome")) {
			logger.info("Initializing Chrome Browser Session");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else{
			logger.info("Invalid browser type set. Please check config.properties file");
		}
		
		driver.get("https://solutions-qa.inductivehealth.com/");
		driver.manage().window().maximize();
		
	}
	
	public static void tearDown() {
		logger.info("Closing the browser session");
		driver.quit();
	}
	
	public static void captureScreenshot(String pageName) {
		
		// Cast WebDriver to TakesScreenshot
		TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

		// Capture the screenshot as a file
		File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);

		// Define the destination path and file name
		String destinationPath = project_root_dir + File.separator + "screenshots" + File.separator + pageName + ".png" ;

		// Copy the screenshot file to the specified destination
		try {
		    FileHandler.copy(screenshotFile, new File(destinationPath));
		    System.out.println("Screenshot saved: " + destinationPath);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	
}
