
package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bo.User;
import com.utils.Log;


public class ABAHomePage extends BasePage {
	

	public ABAHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	By locContactButton = By.cssSelector("a.MenuItem[href=\"/Contact/Index\"]");
	By locSchoolButton = By.cssSelector("a.MenuItem[href=\"/School/Index\"]");
	By locAdminButton = By.cssSelector("a.MenuItem[href=\"#Admin\"]");
	By locSiteVisitButton = By.cssSelector("a.MenuItem[href=\"/SiteVisit/Index\"]");
	//By locSurveyButton = By.cssSelector("a.MenuItem[href=\"/Contact/Index\"]");
	By locWelcometext = By.xpath("//*[@class=\"m-r-sm text-muted welcome-message\"]");
	
	/**
	 * Tests for user access Contacts link

	 * @return
	 */
	
	public ABAContacts accessContacts(){
		Assert.assertTrue(isContactLinkPresent(),"Contacts is not present for the logged user ");
		click(locContactButton);
		String title = getTitle();
		Assert.assertEquals(title, "Contact List","Expected to navigate to Contacts page but navigated to :"+ title);
		return new ABAContacts(driver);
	}
	
	/**
	 * Tests for user access School link

	 * @return
	 */
	public ABASchools accessSchool(){
		Assert.assertTrue(isSchoolLinkPresent(),"School is not present for the logged user ");
		click(locSchoolButton);
		String title = getTitle();
		Assert.assertEquals(title, "School List","Expected to navigate to School List but navigated to :"+ title);
		return new ABASchools(driver);
	}
	
	/**
	 * Tests for user access SiteVisit link

	 * @return
	 */
	public ABASiteVisit accessSiteVisit(){
		Assert.assertTrue(isSiteVisitLinkPresent(),"Site Visit is not present for the logged user ");
		click(locSiteVisitButton);
		String title = getTitle();
		Assert.assertEquals(title, "Site Vist List","Expected to navigate to Site Vist List page but navigated to :"+ title);
		return new ABASiteVisit(driver);
	}
	
	/**
	 * Tests for user access Admin link

	 * @return
	 */
	public void accessAdmin(){
	
		click(locAdminButton);
		String title = getTitle();
		Assert.assertEquals(title, "Index","");
	}
	
	/**
	 * Tests for the presence of Contacts link
	 */
	
	public boolean isContactLinkPresent() {
	
		return isElementPresent(locContactButton);
		
	}
	
	/**
	 * Tests for the presence of School link
	 */
	public boolean isSchoolLinkPresent() {
		
		return isElementPresent(locSchoolButton);
		
	}
	
	/**
	 * Tests for the presence of Admin link
	 */
	public boolean isAdminLinkPresent() {
		
		return isElementPresent(locAdminButton);
		
	}
	
	/**
	 * Tests for the presence of Site Visit link
	 */
	public boolean isSiteVisitLinkPresent() {
		
		return isElementPresent(locSiteVisitButton);
		
	}

	
	/**
	 * Function to verify does user logged on to Application
	 * checks for the welcome text on the dashboard
	 */
	public void verifyUserLoggedOnToApplication(User user) {
		
		String welcomeText = readText(locWelcometext);
		
		String userLoggedIn = "Welcome"+" "+user.firstName+ " "+user.lastName;
		Assert.assertEquals(welcomeText, userLoggedIn,"Expected Login of user: "+ user.lastName+"\r\n : but logged in user :" + welcomeText );	
		
	}

	

}
