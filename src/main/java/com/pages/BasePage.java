package com.pages;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import com.utils.Log;


public class BasePage {
	
	public WebDriver driver;
	
	
	public BasePage (WebDriver driver){
		this.driver = driver; 		
		
	}
	
	/**
	 * click element
	 * @param by
	 */
	public void click (By by){
		waitForVisibilityOfElementLocatedBy(by);
		driver.findElement(by).click();
	}
	
	/**
	 * returns text associated with the element
	 */	
	public String readText(By by){
		waitForVisibilityOfElementLocatedBy(by);
		return driver.findElement(by).getText().trim();
	}
	
	/**
	 * writes texts into an inputbox
	 */
	public void writeText(By by, String texToWrite){
		waitForVisibilityOfElementLocatedBy(by);
		WebElement element = findElement(by);
		element.clear();
		element.sendKeys(texToWrite);
	}
	
	/**
	 * waits for invisibility of element 
	 * Asserts fail when elements fails to become visible
	 * @param by
	 */
	
	public void waitForVisibilityOfElementLocatedBy(By by){
		
		try {
			
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(50, TimeUnit.SECONDS)
					.pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);						
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));	

		} catch (Exception e){
			Log.info("Exception occurred: " +ExceptionUtils.getStackTrace(e));
			Assert.fail("Timed out waiting for element==> "+by);
		}
	}
	
	/**
	 * waits for invisibility of element 
	 * Asserts fail when elements fails to become invisible
	 * @param by
	 */
	public void waitForInvisibilityOfElementLocatedBy(By by){
		
		try {
			
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(50, TimeUnit.SECONDS)
					.pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);						
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));	

		} catch (Exception e){
			e.printStackTrace();
			Assert.fail("Timed out waiting for element to be invisible==> "+by);
		}
	}
	
	/**
	 * waits for invisibility of element 
	 * Asserts fail when elements fails to become invisible
	 * @param by
	 */
	public void waitForElementToBeClickable(By by){
		
		try {
			
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(50, TimeUnit.SECONDS)
					.pollingEvery(200, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);						
			wait.until(ExpectedConditions.elementToBeClickable(by));	

		} catch (Exception e){
			e.printStackTrace();
			Assert.fail("Timed out waiting for element to be clickable==> "+by);
		}
	}
	
	/**
	 * Returns true if element present
	 * Returns false if element not present
	 * @param by
	 * @return
	 */
	public boolean isElementPresent(By by){
		try { 			
			driver.findElement(by);
			return true; 			
		} catch (NoSuchElementException NSE){
			Log.info("No such element ==>"+ExceptionUtils.getStackTrace(NSE));
			return false;
		}
	}
	
	/**
	 * Finds and returns an element
	 * Returns null if not found
	 * @param by
	 * @return
	 */
	public WebElement findElement (By by){
		
		if (isElementPresent(by)){
			
			return driver.findElement(by);
			
		} else {
			
			return null;
		}
	}
	
	/**
	 * returns tittle of the present page
	 * Returns null if not found
	 * 
	 * @return
	 */
	public String getTitle(){
		
		return driver.getTitle();
	}
	
	/**
	 * returns the current URL
	 * @return
	 */
	public String getUrl() {
		return driver.getCurrentUrl();
				
	}
	
	
}
