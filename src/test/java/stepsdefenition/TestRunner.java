package stepsdefenition;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/OnlinerTest.feature",
        glue = {"stepsdefenition"},
        plugin = {"pretty"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
