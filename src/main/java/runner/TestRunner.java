package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\rkpcu\\eclipse-workspace\\AutomationTestDemo\\src\\test\\resources\\featureFiles\\RestAPIGet.feature"
		,glue={"C:\\Users\\rkpcu\\eclipse-workspace\\AutomationTestDemo\\src\\test\\java\\Step\\stepDefinition.java"}
		)

public class TestRunner {

}
