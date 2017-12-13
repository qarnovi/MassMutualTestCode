package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"html:target/htmlReport", "json:target/jsonReport/report.json"},
		features = "src/test/resources/features",
		glue = "stepDefinitions",
		tags = "@Test",
		dryRun = false
		)
public class CukesRunner {

}
