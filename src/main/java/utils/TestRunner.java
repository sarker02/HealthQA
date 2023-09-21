package utils;

import org.apache.log4j.PropertyConfigurator;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",glue="steps",
     monochrome=true,
     plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
     tags = "@heal-05"
		)
		
	
public class TestRunner {

}
