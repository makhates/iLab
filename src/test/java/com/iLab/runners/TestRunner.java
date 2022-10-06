package com.iLab.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {
				"pretty",
				"html:target/cucumber" ,
				"json:target/cucumber"
		},
		tags="@dealx",
		dryRun=false,
		features="src/test/resources/com/iLab/features/",
        glue="com/iLab/step_definitions")

public class TestRunner extends AbstractTestNGCucumberTests {

	@AfterClass
	public void teardown() {


	}
}