package stepsdefenition;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/OnlinerTest.feature",
        glue = {"stepsdefenition"},
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json","json:target/cucumber-reports/CucumberTestReport.json"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
