package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bo.User;
import com.framework.TestBase;
import com.pages.ABAContactsPage;
import com.pages.ABAHomePage;
import com.pages.ABAHomePage;
import com.pages.ABALoginPage;
import com.pages.ABASchoolPage;
import com.pages.ABASiteVisitPage;
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
		ABASchoolPage abaSchool = abaHome.accessSchool();
		abaSchool.validateSchoolListPage("School List");
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
			Log.info("TEST : validate the Admin access for contacts listing page");
			ABALoginPage abalogin = new ABALoginPage(getTLDriver());
			abalogin.goToABALoginPage(testURL);
			ABAHomePage abaHome = abalogin.loginToABA(user.userName, user.passWord);
			abaHome.verifyUserLoggedOnToApplication(user);
			ABAContactsPage abaContact = abaHome.accessContacts();
			abaContact.validateContactPage("Contacts List");
			}
			catch (Exception e) {
				assertFailForRunTimeException(e);
		
			}
			
		}
		
		/**
		 *  Test to validate Login functionality
		 *  Step 1 : Get into login page login as admin
		 *  Step 2 : Check for admin access to SiteVisit  by clicking the site visit tab
		 *  Step3 : Validating is user landed on sitevisit page 
		 *  
		 */
			
			@Test(dataProvider = "adminData", dataProviderClass = DataproviderForTest.class)
			public void accessSiteVisit(User user) {
				try {
				Log.info("TEST : validate the Admin access for sitevist listing page");
				ABALoginPage abalogin = new ABALoginPage(getTLDriver());
				abalogin.goToABALoginPage(testURL);
				ABAHomePage abaHome = abalogin.loginToABA(user.userName, user.passWord);
				abaHome.verifyUserLoggedOnToApplication(user);
				ABASiteVisitPage abaSiteVisit = abaHome.accessSiteVisit();
				abaSiteVisit.validateSiteVisitListPage("Site Visit List");
				}
				catch (Exception e) {
					assertFailForRunTimeException(e);
			
				}
				
			}
			
			/**
			 *  Test to validate Login functionality
			 *  Step 1 : Get into login page login as admin
			 *  Step 2 : Check for admin access to Survey  by clicking the Survey tab
			 *  Step3 : Validating is user landed on Survey page 
			 *  
			 */
				
				@Test(dataProvider = "adminData", dataProviderClass = DataproviderForTest.class)
				public void accessSurvey(User user) {
					try {
					Log.info("TEST : validate the Admin access for Survey listing page");
					ABALoginPage abalogin = new ABALoginPage(getTLDriver());
					abalogin.goToABALoginPage(testURL);
					ABAHomePage abaHome = abalogin.loginToABA(user.userName, user.passWord);
					abaHome.verifyUserLoggedOnToApplication(user);
					ABASiteVisitPage abaSiteVisit = abaHome.accessSiteVisit();
					abaSiteVisit.validateSiteVisitListPage("Survey Results");
					}
					catch (Exception e) {
						assertFailForRunTimeException(e);
				
					}
					
				}
			
		

}
