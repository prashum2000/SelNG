package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ABAAdminRole extends BasePage {

	public ABAAdminRole(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

By locRoleList = By.cssSelector("div.col-lg-6 h2[style =\"margin:8px 0px !important\"]");


public void validateRoleHeading(String expectedText) {
	Assert.assertTrue(isRoleListPresent(),"Problem landing on Role page ");
	String actualText = readText(locRoleList);
	Assert.assertEquals(actualText, expectedText,"expected heading on Role page : " + expectedText + "but page contains : " + actualText);
}



/**
 * Tests for the presence of Role list heading
 */

public boolean isRoleListPresent() {
	
	return isElementPresent(locRoleList);
}
}