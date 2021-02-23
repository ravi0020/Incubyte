package com.incubyte.gmail.utility;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.incubyte.gmail.configure.Config;



public class WaitUtil {

	private static Logger logger = LoggerFactory.getLogger(WebUtil.class);
	private static WebDriver driver	= WebUtil.driver;


	public static WebElement waitUntillElementPresent(WebElement element,int...timeOutSeconds) {
		int timeOut = (timeOutSeconds.length == 0) ? com.incubyte.gmail.configure.Config.getDefaultWait() : timeOutSeconds[0];
		WebElement element2 = new WebDriverWait(WebUtil.driver, timeOut).until(ExpectedConditions.visibilityOf(element));
		return element2;

	}

	/**
	 * wait till element clickable
	 * 
	 * @param element
	 */
	public static WebElement waitUntillElementClickable(WebElement element ,int...timeOutSeconds) {
		int timeOut = (timeOutSeconds.length == 0) ? Config.getDefaultWait() : timeOutSeconds[0];
		WebElement element2 = new WebDriverWait(WebUtil.driver, timeOut)
				.until(ExpectedConditions.elementToBeClickable(element));
		return element2;

	}
	
	/**
	 * wait till text not present
	 * 
	 * @param element
	 * @param value
	 * @return
	 */
	public static boolean waitUntillTextPresent(WebElement element, String value,int...timeOutSeconds) {

		waitUntillElementPresent(element);
		int timeOut = (timeOutSeconds.length == 0) ? Config.getDefaultWait() : timeOutSeconds[0];
		boolean status = new WebDriverWait(WebUtil.driver, timeOut)
				.until(ExpectedConditions.textToBePresentInElement(element, value));

		Assert.assertTrue(status);
		return status;
	}

	/**
	 * wait till element disappear
	 * 
	 * @param element
	 * @return boolean
	 */
	public static boolean waitUntillElementDisappear(WebElement element,int...timeOutSeconds) {

		int timeOut = (timeOutSeconds.length == 0) ? Config.getDefaultWait() : timeOutSeconds[0];
		boolean status = new WebDriverWait(WebUtil.driver, timeOut).until(ExpectedConditions.invisibilityOf(element));

		if (status) {

			return true;
		} else {

			return false;
		}
	}
	
	public static boolean waitUntillAttributeToBe(WebElement element,String attr,String value,int...timeOutSeconds) {

		int timeOut = (timeOutSeconds.length == 0) ? Config.getDefaultWait() : timeOutSeconds[0];
		boolean status = new WebDriverWait(WebUtil.driver, timeOut).until(ExpectedConditions.attributeContains(element, attr, value));

		if (status) {

			return true;
		} else {

			return false;
		}
	}

	/**
	 * verify element is visible on the page
	 * 
	 * @param element
	 * @param timeOutSeconds
	 * @return
	 */
	 
	public static boolean isElementVisible(WebElement element, int... timeOutSeconds) {
		try {
			int timeOut = (timeOutSeconds.length == 0) ? Config.getDefaultWait() : timeOutSeconds[0];

			WebDriverWait wait = new WebDriverWait(WebUtil.driver, timeOut);
			element = wait.until(ExpectedConditions.visibilityOf(element));
			if (element != null) {
				logger.info("WebElement:" + element + " is present on the page");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("WebElement:" + element + " is not present on the page");
		}
		return false;
	}
	public static boolean isElementEnabled(WebElement element, int... timeOutSeconds) {
		try {
			int timeOut = (timeOutSeconds.length == 0) ? Config.getDefaultWait() : timeOutSeconds[0];

			WebDriverWait wait = new WebDriverWait(WebUtil.driver, timeOut);
			element = wait.until(ExpectedConditions.visibilityOf(element));
			if (element.isEnabled()) {
				logger.info("WebElement:" + element + " is present on the page");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("WebElement:" + element + " is not present on the page");
		}
		return false;
	}

	/**
	 * verify element is visible on the page
	 * 
	 * @param locator
	 * @param timeOutSeconds
	 * @return
	 */
	public static boolean isElementVisible(By locator, int... timeOutSeconds) {
		try {
			int timeOut = (timeOutSeconds.length == 0) ? Config.getDefaultWait() : timeOutSeconds[0];
			WebDriverWait wait = new WebDriverWait(WebUtil.driver, timeOut);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			if (element != null) {
				logger.info("Element is visible on page located by locator:" + locator);
				return true;
			}
		} catch (Exception e) {
			logger.info("Element not present using locator:" + locator);

		}
		return false;
	}

	/**
	 * 
	 * verify element present on page
	 * 
	 * @param element
	 * @param timeOutSeconds
	 * @return
	 */
	public static boolean isElementPresent(By element, int... timeOutSeconds) {
		int timeOut = (timeOutSeconds.length == 0) ? Config.getDefaultWait() : timeOutSeconds[0];
		try {
			WebDriverWait wait = new WebDriverWait(WebUtil.driver, timeOut);
			if (wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(element))))
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void waitForPageToLoad(String link) {
		try {
			logger.info("start of "+link+" page to load");
			JavascriptExecutor jsExecuter = (JavascriptExecutor) driver;
			Function<WebDriver, Boolean> readyState = (WebDriver e) -> (Boolean)jsExecuter
					.executeScript("return (document.readyState == 'complete' && jQuery.active == 0)");
			WebDriverWait wait = new WebDriverWait(driver, Config.getDefaultWait());
			wait.until(readyState);
			logger.info("end of "+link+" page to load");
		} catch (Exception error) {
			logger.error("error in "+link+" page to load");
			error.printStackTrace();
		}
	}
	
	
	
}
