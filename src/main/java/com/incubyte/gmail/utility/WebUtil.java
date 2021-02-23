package com.incubyte.gmail.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.incubyte.gmail.configure.Config;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebUtil {

	public static WebDriver driver;

	private static Logger logger = LoggerFactory.getLogger(WebUtil.class);


	@SuppressWarnings("deprecation")
	public static WebDriver openBrowser() {

		WebDriverManager.chromedriver().setup();
	
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Config.getDefaultWait(), TimeUnit.SECONDS);

		return driver;
	}

	public static void openUrl(String url) {

		driver.get(url);
		logger.info("Navigate to Url :" + url);
	}

	public static WebElement findElement(By locator, int... timeOutSeconds) {

		WebElement element = null;
		int timeOut = (timeOutSeconds.length == 0) ? Config.getDefaultWait() : timeOutSeconds[0];
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		logger.info("Located element using locator:" + locator);
		return element;
	}

	/**
	 * get javaScript Executor
	 * 
	 * @param NA
	 */
	public static JavascriptExecutor getJavaScriptExecutor() {

		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

		return javascriptExecutor;
	}

	/**
	 * Scroll element into view.
	 * 
	 * @param element
	 */
	public static void scrollIntoView(WebElement element) {

		try {
			getJavaScriptExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
			Reporter.log("Scroll into element" + element + " view ");

		} catch (Exception e) {
			Assert.fail("Element " + element + " not found.");
		}
	}

	public static void click(WebElement element, int... timeOutSeconds) {
		int timeOut = (timeOutSeconds.length == 0) ? Config.getDefaultWait() : timeOutSeconds[0];
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	/**
	 * Forces click on an element that is otherwise invisible to WebDriver due
	 * to hidden attribute or other issue.
	 * 
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		try {
			getJavaScriptExecutor().executeScript("arguments[0].click();", element);

		} catch (Exception e) {
			Assert.fail("Element " + element + " not found.");
		}
	}

	public static Actions getActions() {

		return new Actions(driver);

	}

	/**
	 * action click on an element that is otherwise invisible to WebDriver due
	 * to hidden attribute or other issue.
	 * 
	 * @param element
	 */
	public static void actionClick(WebElement element) {
		try {
			getActions().click(element).perform();

		} catch (Exception e) {
			Assert.fail("Element " + element + " not found.");
		}
	}

	/**
	 * Try multiple ways of clicking into an element
	 * 
	 * @param webElement
	 */
	public static void superClick(WebElement webElement) {
		try {

			scrollIntoView(webElement);
			webElement.click();
		} catch (Exception e) {

			scrollIntoView(webElement);
			jsClick(webElement);
		}
	}

	public static void sendKeys(WebElement element, String value, int... timeOutSeconds) {
		int timeOut = (timeOutSeconds.length == 0) ? Config.getDefaultWait() : timeOutSeconds[0];
		if (WaitUtil.isElementVisible(element, timeOut)) {
			element.clear();
			element.sendKeys(value);
			logger.info("Entering value:" + value + " in field located by webelement:" + element);
		} else
			logger.error("Element:" + element + " not visible.");
	}


}
