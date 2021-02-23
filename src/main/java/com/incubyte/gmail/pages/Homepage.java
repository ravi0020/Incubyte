package com.incubyte.gmail.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.incubyte.gmail.utility.WebUtil;

public class Homepage {

	private  Logger logger = LoggerFactory.getLogger(LoginPage.class);

	
	final By MAIL_BOX_LINK	= By.xpath("//b[@id='navbar-mail-dot']/..");
	
	
	public void clickOnMailBoxLink(){
		
		WebUtil.click(WebUtil.findElement(MAIL_BOX_LINK));
		logger.info("Click on mail box link in header on homepage");
	}
	

	
}
