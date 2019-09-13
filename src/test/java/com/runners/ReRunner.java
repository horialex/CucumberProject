package com.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "@target/failed_scenarios.txt" },
							glue = { "stepdefinitions" },
							plugin= {"pretty", "html:target/cucumber-html-reports", "json:target/cucumber-html-reports/cucumber.json", "junit:target/cucumber-html-reports/cucumber.xml"},
							monochrome = false,
							strict = true,
							dryRun = false,
							tags = { "not @skipTest", "@run" })
public class ReRunner extends BaseTestRunner{

}
