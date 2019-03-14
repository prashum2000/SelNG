package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ABAOrganization extends BasePage{

	public ABAOrganization(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
By locOrganizationList = By.cssSelector("div.col-lg-6 h2[style =\"margin:8px 0px !important\"]");
	
	
	
	public void validateOrganizationHeading(String expectedText) {
		Assert.assertTrue(isOrganizationListPresent(),"Problem landing on contacts page ");
		String actualText = readText(locOrganizationList);
		Assert.assertEquals(actualText, expectedText,"expected heading on Organization page : " + expectedText + "but page contains : " + actualText);
	}
	
	
	/**
	 * Tests for the presence of Organization list heading
	 */
	
	public boolean isOrganizationListPresent() {
	
		return isElementPresent(locOrganizationList);
		
	}

	}

