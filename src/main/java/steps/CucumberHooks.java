package steps;

import io.cucumber.java.Before;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.BaseTest;


public class CucumberHooks extends BaseTest {
	
	public static Logger logger = Logger.getLogger(LoginSteps.class.getName());
	
	
    @Before
    public void beforeScenario(Scenario scenario) {
        // Log the scenario name before it starts
        setup();
        logger.info("Executing Scenario: " + scenario.getName());
    }

    
    @AfterStep
    public void addScrenshots(Scenario scenario) {
		final byte [] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshotAs, "image/png", scenario.getName());
    }
    
    @After
    public void afterScenario(Scenario scenario) {
        // Log the scenario name after it finishes
    	
		boolean failed = scenario.isFailed();
		System.out.print("isFail?:"+failed);
		
		if (failed) {
			final byte [] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotAs, "image/png", scenario.getName());
		}
    	tearDown();
        logger.info("Finished Scenario: " + scenario.getName());
    }
}