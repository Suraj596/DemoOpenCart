package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "C:\\Users\\admin\\git_auto\\OpenCart-Workspace\\OpenCart\\Feature"
,glue = {"StepDefinition"}
,plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
)

public class Runner {
	
}
