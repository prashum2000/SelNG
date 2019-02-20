package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver); 		
	}
	
	By locInputEmail = By.cssSelector("#email");
	By locInputPassword = By.cssSelector("#password");
	By locLoginButton = By.cssSelector("#loginButton");
	By locErrorMessageUsername = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
    By locErrorMessagePassword = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div ");
	
	
	public void loginToApplication(String userName, String password){
		
		writeText(locInputEmail, userName);
		writeText(locInputPassword, password);
		click(locLoginButton);
	}
	
	public LoginPage verifyLoginUserName(String expectedErrorMessage){
		String errorMessage = readText(locErrorMessageUsername);
		Assert.assertEquals(errorMessage, expectedErrorMessage,"");
		return this;
	}
	
	public LoginPage verifyLoginPassword(String expectedErrorMessage){
		String errorMessage = readText(locErrorMessagePassword);
		Assert.assertEquals(errorMessage, expectedErrorMessage,"");
		return this;
	}

}
