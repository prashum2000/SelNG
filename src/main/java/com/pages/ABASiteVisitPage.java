package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ABASiteVisitPage extends BasePage {

	public ABASiteVisitPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

By locSiteVisitList = By.cssSelector("div.col-lg-6 h2[style =\"margin: 8px 0px !important;\"]");
	
	
	
	public void validateSiteVisitListPage(String expectedText) {
		Assert.assertTrue(isSiteVisitListPresent(),"Problem landing on sitevist page ");
		String actualText = readText(locSiteVisitList);
		Assert.assertEquals(actualText, expectedText,"expected heading on contacts page : " + expectedText + "but page contains : " + actualText);
	}
	
	
	/**
	 * Tests for the presence of site visit list heading
	 */
	
	public boolean isSiteVisitListPresent() {
	
		return isElementPresent(locSiteVisitList);
		
	}
}
