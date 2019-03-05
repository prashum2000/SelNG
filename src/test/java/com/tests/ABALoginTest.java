package com.tests;


import org.testng.annotations.Test;

import com.bo.User;
import com.framework.TestBase;
import com.pages.ABAHomePage;
import com.pages.ABALoginPage;
import com.utils.DataproviderForTest;

public class ABALoginTest extends TestBase{
	
	
	/**
	 *  Test to validate Login functionality
	 *  Step 1 : Get into login page
	 *  Step 2 : Enter User name and password
	 *  Step 3 : Click on login
	 */
	@Test(dataProvider = "adminData", dataProviderClass = DataproviderForTest.class)
	public void validLoginTest(User user){
		try {
		
		ABALoginPage abalogin = new ABALoginPage(getTLDriver());
		abalogin.goToABALoginPage(testURL);
		abalogin.loginToABA(user.userName, user.passWord);
		ABAHomePage abaHomePage = abalogin.getABAHomePage();
		abaHomePage.verifyUserLoggedOnToApplication(user);
		
		}
		catch (Exception e) {
			assertFailForRunTimeException(e);
		
		}
	}
	
	/**
	 *  Test to validate the error message on missing of Username in login
	 *  Step 1 : Get into login page
	 *  Step 2 : Enter only password 
	 *  Step 3 : Click on login
	 */
		@Test
		public void validLoginTest_UsenameMissing(){
			try {
			
			User user = new User();
			user.userName = "";
			user.passWord = "admin";
			ABALoginPage abalogin = new ABALoginPage(getTLDriver());
			abalogin.goToABALoginPage(testURL);
			abalogin.loginToABA(user.userName,user.passWord);
			abalogin.verifyUserNameMissingMessage("Please enter your Username",user);
			
			}
			catch (Exception e) {
				assertFailForRunTimeException(e);
			
			}
		

		}
		
		/**
		 *  test to validate the error message on missing of password in login
		 *  Step 1 : Get into login page
		 *  Step 2 : Enter only username 
		 *  Step 3 : Click on login
		 */
		@Test
		public void validLoginTest_PasswordMissing(){
			try {
			User user = new User();
			user.userName = "admin";
			user.passWord = "";
			ABALoginPage abalogin = new ABALoginPage(getTLDriver());
			abalogin.goToABALoginPage(testURL);
			abalogin.loginToABA(user.userName,user.passWord);
			abalogin.verifyPasswordMissingMessage("Please enter your Password",user);
			
			}
			catch (Exception e) {
				assertFailForRunTimeException(e);
			
			}
		

		}
		/**
		 *  test to validate the error message on Zero login
		 *  Step 1 : Get into login page
		 *  Step 2 : leave the username and password blank
		 *  Step 3 : Click on login
		 */
		@Test
		public void zeroLoginTest(){
			try {
			User user = new User();
			user.userName = "";
			user.passWord = "";
			ABALoginPage abalogin = new ABALoginPage(getTLDriver());
			abalogin.goToABALoginPage(testURL);
			abalogin.loginToABA(user.userName,user.passWord);
			abalogin.verifyUserNameMissingMessage("Please enter your Username",user);
			abalogin.verifyPasswordMissingMessage("Please enter your Password",user);
			
			}
			catch (Exception e) {
				assertFailForRunTimeException(e);
			
			}
		

		}
		
		/**
		 *  Invalid login test
		 *  Step 1 : Get into login page
		 *  Step 2 : Enter wrong credentials
		 *  Step 3 : Click on login
		 */
		@Test
		public void invalidLogin_ABAAdmin(){
			try {
			User user = new User();
			user.userName = "admin";
			user.passWord = "admin";
			ABALoginPage abalogin = new ABALoginPage(getTLDriver());
			abalogin.goToABALoginPage(testURL);
			abalogin.loginToABA(user.userName,user.passWord);
			abalogin.verifyErrorLoginMessage("Invalid Username or Password. Please try again.",user);
			
			}
			catch (Exception e) {
				assertFailForRunTimeException(e);
			
			}
		

		}
		
		
}
