package com.incubyte.gmail.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.incubyte.gmail.configure.DataGenerator;
import com.incubyte.gmail.utility.WebUtil;

public class InboxMailPage {
	
	private  Logger logger = LoggerFactory.getLogger(InboxMailPage.class);


	final By COMPOSE_BUTTON = By.xpath("//a[@data-test-id='compose-button']");
	final By TO_INPUT = By.xpath("//input[@id='message-to-field']");
	final By SUBJECT_INPUT = By.xpath("//input[@data-test-id='compose-subject']");
	final By MESSAGE_BODY_INPUT = By.xpath("//div[@id='editor-container']/div");
	final By SEND_BUTTON = By.xpath("//button[@data-test-id='compose-send-button']");
	final By ATTACHEMENT_BUTTON = By.xpath("//button[@data-test-id='icon-btn-attach']");
	final By ATTACH_FILE_COMPUTER_LINK = By.xpath("//li[@data-test-id='attach-from-computer-list-btn']");


	public void clickOnComposeButton(){
		
		WebUtil.click(WebUtil.findElement(COMPOSE_BUTTON));
		logger.info("Click on compose button on homepage");
		
	}
	
	public void enterToReciepentOfComposeMail(){
		
		String value = DataGenerator.generateAplhaString(4)+"@"+DataGenerator.generateAplhaString(3)+".com";
		
		WebUtil.sendKeys(WebUtil.findElement(TO_INPUT), value);
		logger.info("value :"+value+" enter in to reciepent on compose mail page ");
	}
	
	public void enterSubjectOfComposeMail(){
		
		String subject =  "Sub_"+DataGenerator.generateAlphaNumericString(5);
		WebUtil.sendKeys(WebUtil.findElement(SUBJECT_INPUT),subject);
		logger.info("Subject :"+subject+" enter on compose mail page ");
	}
	
	public void enterMessageOfComposeMail(){
		
		WebUtil.sendKeys(WebUtil.findElement(MESSAGE_BODY_INPUT),DataGenerator.generateAlphaNumericString(20));
		logger.info("Message entered on compose mail page ");
		
	}
	
	public void clickOnSendButton(){
		
		WebUtil.click(WebUtil.findElement(SEND_BUTTON));
		logger.info("Click on send button on compose mail page");
	}
	
	public void uploadFile(String path) throws InterruptedException, AWTException{
		
		//Attach file
		StringSelection sel = new StringSelection( path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		System.out.println("selection" +sel);
		Robot rb = new Robot();
		Thread.sleep(1000);
		rb.delay(3000);
		    
		System.out.println("Open Goto window");

	     // press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	 
	    // for pressing and releasing Enter
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);

		
	}
	
	public void clickOnAttachButton(){
		
		WebUtil.click(WebUtil.findElement(ATTACHEMENT_BUTTON));
		logger.info("Click on attachement button on compose mail page");
	}
	
	public void clickOnAttachFileFromComputerButton(){
		
		WebUtil.click(WebUtil.findElement(ATTACH_FILE_COMPUTER_LINK));
		logger.info("Click on attach file from computer button on compose mail page");
	}
}

