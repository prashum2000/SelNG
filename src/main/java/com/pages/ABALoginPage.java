package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bo.User;
import com.utils.Log;

public class ABALoginPage extends BasePage {

	public ABALoginPage(WebDriver driver) {
		super(driver); 		
	}
	
	By locInputEmail = By.cssSelector("input.form-control#Username");
	By locInputPassword = By.cssSelector("input.form-control#Password");
	By locLoginButton = By.cssSelector("#loginButton");
	By locErrorMessageUsername = By.cssSelector("div.error.userError");
	By locUserNameErrorHide = By.cssSelector(".form-group .userError");
	By locErrorMessagePassword = By.cssSelector(" div.error.pwdError");
	By locPasswordErrorHide = By.cssSelector(".form-group .pwdError");
	By locErrorMessageLogin = By.cssSelector(".validation-summary-errors");
	
	
	
	public ABALoginPage goToABALoginPage(String testURL){
		Log.info("Navigating to : "+testURL);
		driver.navigate().to(testURL);
		return this;
	}
	
	/**
	 * Fill the data and clicks on login
	 * @param userName
	 * @param password
	 * @return ABAHomePage
	 */
	
	public ABAHomePage loginToABA(String userName, String password){
		
		writeText(locInputEmail, userName);
		writeText(locInputPassword, password);
		click(locLoginButton);
		return new ABAHomePage(driver);
		
	}
	
	/**
	 * verify the error message on missing of the username
	 * @param expectedErrorMessage
	 * @param user
	 */
	
	public void verifyUserNameMissingMessage(String expectedErrorMessage, User user){
		boolean eleHidden = isElementPresent(locUserNameErrorHide);
		String attributeStyling = driver.findElement(locUserNameErrorHide).getAttribute("style");
		Assert.assertTrue(eleHidden && attributeStyling.isEmpty());
		String errorMessage = readText(locErrorMessageUsername);
		Assert.assertEquals(errorMessage, expectedErrorMessage,"User Credentials used: "+user.userName+":"+user.passWord+"\r\nvalidation error message for invalid username login failed : ");
		
	}
	
	/**
	 * Verify the error message on missing of Password 
	 * @param expectedErrorMessage
	 * @param user
	 */
	
	public void verifyPasswordMissingMessage(String expectedErrorMessage,User user){
		boolean eleHidden = isElementPresent(locPasswordErrorHide);
		String attributeStyling = driver.findElement(locPasswordErrorHide).getAttribute("style");
		Assert.assertTrue(eleHidden && attributeStyling.isEmpty());
		String errorMessage = readText(locErrorMessagePassword);
		Assert.assertEquals(errorMessage, expectedErrorMessage,"User Credentials used: "+user.userName+":"+user.passWord+"\r\nvalidation error message for invalid password login failed : ");
	
	}
	
	/**
	 * verify error message on invalid login
	 * @param expectedErrorMessage
	 * @param user
	 */
	
	public void verifyErrorLoginMessage(String expectedErrorMessage,User user){
		Assert.assertTrue(isElementPresent(locErrorMessageLogin));
		String errorMessage = readText(locErrorMessageLogin);
		Assert.assertEquals(errorMessage, expectedErrorMessage,"User Credentials used: "+user.userName+":"+user.passWord+"\r\nvalidation error message for login failed : ");
		
	}
	
	
	
	public ABAHomePage getABAHomePage() {
		return new ABAHomePage (driver);
	}
	

	

}
