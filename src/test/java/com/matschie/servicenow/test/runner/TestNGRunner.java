package com.matschie.servicenow.test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = {"src/test/java/com/matschie/servicenow/features/incident.feature"},
		          glue = {"com.matschie.step.servicenow.definitions"},
		          dryRun = false
		         )
public class TestNGRunner extends AbstractTestNGCucumberTests {

}