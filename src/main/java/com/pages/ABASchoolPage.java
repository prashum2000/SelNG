package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ABASchoolPage extends BasePage{

	public ABASchoolPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
By locSchoolList = By.cssSelector("div.col-lg-6 h2[style =\"margin:8px 0px !important\"]");
	
	
	
	public void validateSchoolListPage(String expectedText) {
		Assert.assertTrue(isSchoolListPresent(),"Problem landing on contacts page ");
		String actualText = readText(locSchoolList);
		Assert.assertEquals(actualText, expectedText,"expected heading on contacts page : " + expectedText + "but page contains : " + actualText);
	}
	
	
	/**
	 * Tests for the presence of Contacts list heading
	 */
	
	public boolean isSchoolListPresent() {
	
		return isElementPresent(locSchoolList);
		
	}

}
