package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features",glue={"stepDefinition"},plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests{

	
}
