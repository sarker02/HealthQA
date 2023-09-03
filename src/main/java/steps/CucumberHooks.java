package steps;

import io.cucumber.java.Before;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.cucumber.java.After;
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

    @After
    public void afterScenario(Scenario scenario) {
        // Log the scenario name after it finishes
    	tearDown();
        logger.info("Finished Scenario: " + scenario.getName());
    }
}