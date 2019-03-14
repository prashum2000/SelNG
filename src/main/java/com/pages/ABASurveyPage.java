package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ABASurveyPage extends BasePage{

	public ABASurveyPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	By locSurveyResults = By.cssSelector("div.col-lg-6 h2[style =\"margin:8px 0px !important\"]");
	
	
	
	public void validateSurveyHeading(String expectedText) {
		Assert.assertTrue(isContactListPresent(),"Problem landing on Survey page ");
		String actualText = readText(locSurveyResults);
		Assert.assertEquals(actualText, expectedText,"expected heading on Survey page : " + expectedText + "but page contains : " + actualText);
	}
	
	
	/**
	 * Tests for the presence of Survey list heading
	 */
	
	public boolean isContactListPresent() {
	
		return isElementPresent(locSurveyResults);
		
	}
	
}
