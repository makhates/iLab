package com.iLab.runners;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty",
				"html:target/cucumber-reports" ,
				"json:target/cucumber.json"
		},
		tags="@smokedd",
		dryRun=false,
		features="src/test/resources/com/iLab/features/",
        glue="com/iLab/step_definitions")

public class TestRunner extends AbstractTestNGCucumberTests {

	@AfterClass
	public void teardown() {


	}
}