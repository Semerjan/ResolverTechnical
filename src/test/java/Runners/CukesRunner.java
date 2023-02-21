package Runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {
                "html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        },
        features = {"src/test/resources/features"},
        glue = "Step_Definitions",
        dryRun = false,
        tags = "@Regression"


)
public class CukesRunner {

}
