package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.Log;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) { 		
		super(driver); 		
	}
	
	By locSignInButton = By.cssSelector(".btnSignIn");
	
	public HomePage goToHomePage(String testURL){
		Log.info("Navigating to Home Page: "+testURL);
		driver.navigate().to(testURL);
		return this;
	}
	
	public LoginPage goToLoginPage(){
		Log.info("Clicking "+locSignInButton+ "to land on sign in page");
		click(locSignInButton);
		return new LoginPage(driver);
		
	}

}
