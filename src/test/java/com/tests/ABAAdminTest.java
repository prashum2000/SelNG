package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bo.User;
import com.framework.TestBase;
import com.pages.ABAAdminRole;
import com.pages.ABAContactsPage;
import com.pages.ABAHomePage;
import com.pages.ABAHomePage;
import com.pages.ABALoginPage;
import com.pages.ABAOrganization;
import com.pages.ABASchoolPage;
import com.pages.ABASiteVisitPage;
import com.pages.ABASurveyPage;
import com.utils.DataproviderForTest;
import com.utils.Log;

public class ABAAdminTest extends TestBase{
	
/**
 *  Test to validate Login functionality
 *  Step 1 : Get into login page login as admin
 *  Step 2 : Check for admin access to school
 *  Step3 : Validating is user landed on School page 
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
		abaSchool.validateSchoolListHeading("School List");
		}
		catch (Exception e) {
			assertFailForRunTimeException(e);
	
		}
		
	}
	
	/**
	 *  Test to validate Login functionality
	 *  Step 1 : Get into login page login as admin
	 *  Step 2 : Check for admin access to Contacts
	 *  Step3 : Validating is user landed on Contact listing page 
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
			abaContact.validateContactHeading("Contacts List");
			}
			catch (Exception e) {
				assertFailForRunTimeException(e);
		
			}
			
		}
		
		/**
		 *  Test to validate Login functionality
		 *  Step 1 : Get into login page login as admin
		 *  Step 2 : Check for admin access to SiteVisit  by clicking the site visit tab
		 *  Step3 : Validating is user landed on sitevisit listing page 
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
				abaSiteVisit.validateSiteVisitListHeading("Site Visit List");
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
					ABASurveyPage abaSurvey = abaHome.accessSurvey();
					abaSurvey.validateSurveyHeading("Survey Results");
					}
					catch (Exception e) {
						assertFailForRunTimeException(e);
					}
				
					}
				
					/**
					 *  Test to validate Login functionality
					 *  Step 1 : Get into login page login as admin
					 *  Step 2 : Check for admin access to Role listing page under Admin
					 *  
					 */	
					@Test(dataProvider = "adminData", dataProviderClass = DataproviderForTest.class)
					public void accessRole(User user) {
						try {
						Log.info("TEST : validate the Admin access for Role listing page under Admin link");
						ABALoginPage abalogin = new ABALoginPage(getTLDriver());
						abalogin.goToABALoginPage(testURL);
						ABAHomePage abaHome = abalogin.loginToABA(user.userName, user.passWord);
						abaHome.verifyUserLoggedOnToApplication(user);
				        ABAAdminRole abarole = abaHome.accessRole();
						abarole.validateRoleHeading("Role List");
						}
						catch (Exception e) {
							assertFailForRunTimeException(e);
				}
			
					}



/**
 *  Test to validate Login functionality
 *  Step 1 : Get into login page login as admin
 *  Step 2 : Check for admin access to Organization listing page under Admin

 *  
 */
	
	@Test(dataProvider = "adminData", dataProviderClass = DataproviderForTest.class)
	public void accessOrganization(User user) {
		try {
		Log.info("TEST : validate the Admin access for Organization listing page");
		ABALoginPage abalogin = new ABALoginPage(getTLDriver());
		abalogin.goToABALoginPage(testURL);
		ABAHomePage abaHome = abalogin.loginToABA(user.userName, user.passWord);
		abaHome.verifyUserLoggedOnToApplication(user);
		ABAOrganization organization = abaHome.accessOrganization();
		organization.validateOrganizationHeading("Organization List");
		}
		catch (Exception e) {
			assertFailForRunTimeException(e);
		}
	
	}
	
	}