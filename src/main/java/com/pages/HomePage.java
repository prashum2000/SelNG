package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) { 		
		super(driver); 		
	}
	
	By locSignInButton = By.cssSelector(".btnSignIn");
	
	public HomePage goToHomePage(String testURL){
		driver.navigate().to(testURL);
		return this;
	}
	
	public LoginPage goToLoginPage(){
		click(locSignInButton);
		return new LoginPage(driver);
		
	}

}
