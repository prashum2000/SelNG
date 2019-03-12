package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ABAContactsPage extends BasePage{

	public ABAContactsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	By locContactList = By.cssSelector("div.col-lg-6 h2[style =\"margin:8px 0px !important\"]");
	
	
	
	public void validateContactPage(String expectedText) {
		Assert.assertTrue(isContactListPresent(),"Problem landing on contacts page ");
		String actualText = readText(locContactList);
		Assert.assertEquals(actualText, expectedText,"expected heading on contacts page : " + expectedText + "but page contains : " + actualText);
	}
	
	
	/**
	 * Tests for the presence of Contacts list heading
	 */
	
	public boolean isContactListPresent() {
	
		return isElementPresent(locContactList);
		
	}
	
}
