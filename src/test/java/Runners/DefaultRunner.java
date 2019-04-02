package Runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resource\\Feature", glue = { "Steps" }, format = { "pretty",
		"html:target/cucumber" }, tags = "@Gmail")

public class DefaultRunner {

}
