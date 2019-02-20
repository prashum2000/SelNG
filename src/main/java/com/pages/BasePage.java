package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BasePage {
	
	public WebDriver driver;
	public WebDriverWait webDriverWait;
	
	public BasePage (WebDriver driver){
		this.driver = driver;
		webDriverWait = new WebDriverWait(driver, 15);
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
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texToWrite);
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
			e.printStackTrace();
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


}
