package Onliner.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Onliner/features/OnlinerTest.feature",
        glue = {"Onliner/stepsdefenition"},
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json","json:target/cucumber-reports/CucumberTestReport.json"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
