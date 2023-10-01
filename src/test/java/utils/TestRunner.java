package utils;

import java.io.File;

import org.apache.log4j.PropertyConfigurator;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.BeforeClass;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",glue="steps",
     monochrome=true,
     tags = "@Smoke",
     plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestRunner {
	private static ConfigPropertyReader configReader = new ConfigPropertyReader();
	private static String project_root_dir = configReader.getProperty("project_root_dir");  
	
    @BeforeClass
    public static void setup() {
        // Initialize Log4j
    	String log4jPath = project_root_dir + File.separator + "config" + File.separator  + "log4j.properties";
    	PropertyConfigurator.configure(log4jPath);
    }
	
}

