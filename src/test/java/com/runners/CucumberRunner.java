package com.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features/" }, glue = { "stepdefinitions" }, plugin = { "pretty",
		"html:target/cucumber-html-reports", "json:target/cucumber-html-reports/cucumber.json",
		"junit:target/cucumber-html-reports/cucumber.xml",
		"rerun:target/failed_scenarios.txt" }, tags = { "not @skipTest", "@run" })
public class CucumberRunner extends BaseTestRunner {
}
