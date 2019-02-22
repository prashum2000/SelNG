package com.tests;


import org.testng.annotations.Test;

import com.framework.TestBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.Log;

public class LoginTest extends TestBase {
	
	@Test
	public void invalidLoginTest_InvalidUserNameInvalidPassword(){
		
		try {
			
			String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
			Log.info("Starting test: "+ nameofCurrMethod);
			HomePage homePage = new HomePage(getTLDriver());
			homePage.goToHomePage(testURL);
			LoginPage loginPage = homePage.goToLoginPage();
			loginPage.loginToApplication("asdfdsfdsf", "sdfdsfad");
			loginPage.verifyLoginUserName("sdfadfsd");
			loginPage.verifyLoginPassword("sdfasdfsd");
			
		} catch (Exception e){
			
			assertFailForRunTimeException(e);
		} 	
		
	}
	
	@Test
	public void invalidLoginTest_EmptyUserNameEmptyPassword(){
		
		try { 
			
			String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
			Log.info("Starting test: "+ nameofCurrMethod);			
			HomePage homePage = new HomePage(getTLDriver());
			homePage.goToHomePage(testURL);
			LoginPage loginPage = homePage.goToLoginPage();
			loginPage.loginToApplication("", "");
			loginPage.verifyLoginUserName("sdfadfsd");
			loginPage.verifyLoginPassword("sdfasdfsd");  			
			
		} catch (Exception e){
			
			assertFailForRunTimeException(e);
			
		} 	
		
	}

}
