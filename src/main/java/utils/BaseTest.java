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

public class BaseTest {

    public static WebDriver driver;
    //public static Logger logger = null;
    public static Logger logger = Logger.getLogger(BaseTest.class.getName());
    
    public void BaseTest() {
    	String log4jPath = "C:\\Users\\www.abcom.in\\eclipse-workspace\\HealthQA\\config\\log4j.properties";
    	PropertyConfigurator.configure(log4jPath);
    }
    
	@BeforeMethod
	public static void setup() {
        logger.info("Initializing broswer session");
		System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://solutions-qa.inductivehealth.com/home/");
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
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
		String destinationPath = "C:\\Users\\www.abcom.in\\eclipse-workspace\\HealthQA\\screenshots" + File.separator + pageName + ".png" ;

		// Copy the screenshot file to the specified destination
		try {
		    FileHandler.copy(screenshotFile, new File(destinationPath));
		    System.out.println("Screenshot saved: " + destinationPath);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	
}
