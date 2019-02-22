package com.tests;

import org.testng.annotations.Test;

import com.framework.TestBase;
import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginTest extends TestBase {
	
	@Test
	public void invalidLoginTest_InvalidUserNameInvalidPassword(){
		
		try {
			
			HomePage homePage = new HomePage(getTLDriver());
			homePage.goToHomePage(testURL);
			LoginPage loginPage = homePage.goToLoginPage();
			loginPage.loginToApplication("asdfdsfdsf", "sdfdsfad");
			loginPage.verifyLoginUserName("sdfadfsd");
			loginPage.verifyLoginPassword("sdfasdfsd");
			
		} catch (Exception e){
			e.printStackTrace();
		} 	
		
	}
	
	@Test
	public void invalidLoginTest_EmptyUserNameEmptyPassword(){
		
		try { 
								
			HomePage homePage = new HomePage(getTLDriver());
			homePage.goToHomePage(testURL);
			LoginPage loginPage = homePage.goToLoginPage();
			loginPage.loginToApplication("", "");
			loginPage.verifyLoginUserName("sdfadfsd");
			loginPage.verifyLoginPassword("sdfasdfsd");
			
		} catch (Exception e){
			e.printStackTrace();
		} 	
		
	}

}
