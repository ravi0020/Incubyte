package com.incubyte.gmail.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.incubyte.gmail.configure.Config;
import com.incubyte.gmail.utility.WebUtil;

public class LoginPage {
	
	private  Logger logger = LoggerFactory.getLogger(LoginPage.class);
	
	final By USERNAME_INPUT = By.xpath("//input[@id='login-username']");
	final By PASSWORD_INPUT = By.xpath("//input[@id='login-passwd']");
	final By NEXT_BUTTON	= By.xpath("//*[@id='login-signin']");

	
	public void doLogin(){
		
		// enter email id
		WebUtil.sendKeys(WebUtil.findElement(USERNAME_INPUT), Config.getUserName("ravi"));
		logger.info(" Username: "+Config.getUserName("ravi") +"entered on the login page");		
		WebUtil.click(WebUtil.findElement(NEXT_BUTTON));
		logger.info("click on next button on the login page");
				
		// enter password
		WebUtil.sendKeys(WebUtil.findElement(PASSWORD_INPUT), Config.getPassword("ravi"));
		logger.info(" Password: "+Config.getPassword("ravi") +"entered on the login page");		
		WebUtil.click(WebUtil.findElement(NEXT_BUTTON));
		logger.info("click on next button on the login page");
	}
	
	
}
