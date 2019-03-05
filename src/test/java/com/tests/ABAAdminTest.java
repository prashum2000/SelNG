package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bo.User;
import com.framework.TestBase;
import com.pages.ABAHomePage;
import com.pages.ABAHomePage;
import com.pages.ABALoginPage;
import com.utils.DataproviderForTest;
import com.utils.Log;

public class ABAAdminTest extends TestBase{
	
/**
 *  Test to validate Login functionality
 *  Step 1 : Get into login page login as admin
 *  Step 2 : Check for admin access to school
 *  
 */
	
	@Test(dataProvider = "adminData", dataProviderClass = DataproviderForTest.class)
	public void accessSchool(User user) {
		try {
		Log.info("TEST : validate the Admin access for school listing page");
		ABALoginPage abalogin = new ABALoginPage(getTLDriver());
		abalogin.goToABALoginPage(testURL);
		ABAHomePage abaHome = abalogin.loginToABA(user.userName, user.passWord);
		abaHome.verifyUserLoggedOnToApplication(user);
		abaHome.accessSchool();
		}
		catch (Exception e) {
			assertFailForRunTimeException(e);
	
		}
		
	}
	
	/**
	 *  Test to validate Login functionality
	 *  Step 1 : Get into login page login as admin
	 *  Step 2 : Check for admin access to Contacts
	 *  
	 */
		
		@Test(dataProvider = "adminData", dataProviderClass = DataproviderForTest.class)
		public void accessContacts(User user) {
			try {
			Log.info("TEST : validate the Admin access for school listing page");
			ABALoginPage abalogin = new ABALoginPage(getTLDriver());
			abalogin.goToABALoginPage(testURL);
			ABAHomePage abaHome = abalogin.loginToABA(user.userName, user.passWord);
			abaHome.verifyUserLoggedOnToApplication(user);
			abaHome.accessContacts();
			}
			catch (Exception e) {
				assertFailForRunTimeException(e);
		
			}
			
		}
		
		/**
		 *  Test to validate Login functionality
		 *  Step 1 : Get into login page login as admin
		 *  Step 2 : Check for admin access to SiteVisit
		 *  
		 */
			
			@Test(dataProvider = "adminData", dataProviderClass = DataproviderForTest.class)
			public void accessSiteVisit(User user) {
				try {
				Log.info("TEST : validate the Admin access for school listing page");
				ABALoginPage abalogin = new ABALoginPage(getTLDriver());
				abalogin.goToABALoginPage(testURL);
				ABAHomePage abaHome = abalogin.loginToABA(user.userName, user.passWord);
				abaHome.verifyUserLoggedOnToApplication(user);
				abaHome.accessSiteVisit();
				}
				catch (Exception e) {
					assertFailForRunTimeException(e);
			
				}
				
			}
			
		

}
