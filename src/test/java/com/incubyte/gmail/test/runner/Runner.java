package com.incubyte.gmail.test.runner;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "resources",
        monochrome = true,
        plugin = {
                "progress", "html:target/cucumber-report/Gmail",
                "json:target/cucumber-report/cucumber.json",
                "rerun:rerun/Gmail_failed_scenarios.txt"},
        glue = "com.incubyte.gmail",
        dryRun=false,
        tags={"@Test"}
        )

public class Runner extends AbstractTestNGCucumberTests { 
 
	
	
	
}

