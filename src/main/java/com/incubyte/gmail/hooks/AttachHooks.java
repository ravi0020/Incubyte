package com.incubyte.gmail.hooks;

import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.incubyte.gmail.configure.Config;
import com.incubyte.gmail.utility.WebUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class AttachHooks {

	private static Logger logger = LoggerFactory.getLogger(AttachHooks.class);
	public static WebDriver driver;
	
	@Before
	public void setUp(Scenario scenario) {
		logger.info("Execution started setup initializing ...");
		Config.loadConfig();
		logger.info("Running Scenario :"+scenario.getName());
		
	}

    @After
	public void tearDown(Scenario scenario) {
		driver =WebUtil.driver;
		driver.quit();
		logger.info("Browser getting closed");
	}
	
}