package com.tests;

import org.testng.annotations.Test;

import com.bo.User;
import com.framework.TestBase;
import com.pages.ABAAdminRole;
import com.pages.ABAContactsPage;
import com.pages.ABAHomePage;
import com.pages.ABALoginPage;
import com.pages.ABAOrganization;
import com.pages.ABASchoolPage;
import com.pages.ABASiteVisitPage;
import com.pages.ABASurveyPage;
import com.utils.DataproviderForTest;
import com.utils.Log;

public class ABAStaffTest extends TestBase{
	
	
	/**
	 *  Test to validate Login functionality
	 *  Step 1 : Get into login page login as staff
	 *  Step 2 : Check for staff access to school
	 *  Step3 : Validating is user landed on School page 
	 * 
     */
		
		@Test(dataProvider = "staffData", dataProviderClass = DataproviderForTest.class)
		public void accessSchool(User user) {
			try {
			Log.info("TEST : validate the Staff access for school listing page");
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
		 *  Step 1 : Get into login page login as staff
		 *  Step 2 : Check for staff access to Contacts
		 *  Step3 : Validating is user landed on Contact listing page 
	     *  
	     */

			
			@Test(dataProvider = "staffData", dataProviderClass = DataproviderForTest.class)
			public void accessContacts(User user) {
				try {
				Log.info("TEST : validate the Staff access for contacts listing page");
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
			 *  Step 1 : Get into login page login as staff
			 *  Step 2 : Check for staff access to SiteVisit by clicking the site visit tab
			 *  Step3 : Validating is user landed on SiteVisit page 
			 *  
			 */
				
				@Test(dataProvider = "staffData", dataProviderClass = DataproviderForTest.class)
				public void accessSiteVisit(User user) {
					try {
					Log.info("TEST : validate the Staff access for site visit listing page");
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
				 *  Step 1 : Get into login page login as Staff
				 *  Step 2 : Check for Staff access to Survey  by clicking the Survey tab
				 *  Step3 : Validating is user landed on Survey page 
				 *  
				 */
					
					@Test(dataProvider = "staffData", dataProviderClass = DataproviderForTest.class)
					public void accessSurvey(User user) {
						try {
						Log.info("TEST : validate the Staff access for Survey listing page");
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
					 *  Step 1 : Get into login page login as Staff
					 *  Step 2 : Check for Staff access to Role listing page under Staff
					 *  
					 */	
					@Test(dataProvider = "staffData", dataProviderClass = DataproviderForTest.class)
					public void accessRole(User user) {
						try {
						Log.info("TEST : validate the Staff access for Role listing page under Admin link");
						ABALoginPage abalogin = new ABALoginPage(getTLDriver());
						abalogin.goToABALoginPage(testURL);
						ABAHomePage abaHome = abalogin.loginToABA(user.userName, user.passWord);
						abaHome.verifyUserLoggedOnToApplication(user);
				        ABAAdminRole AbaRole = abaHome.accessRole();
				        AbaRole.validateRoleHeading("Role List");
						}
						catch (Exception e) {
							assertFailForRunTimeException(e);
				}
			
					}

					/**
					 *  Test to validate Login functionality
					 *  Step 1 : Get into login page login as Staff
					 *  Step 2 : Check for Staff access to Organization listing page under Staff

					 *  
					 */
						
						@Test(dataProvider = "staffData", dataProviderClass = DataproviderForTest.class)
						public void accessOrganization(User user) {
							try {
							Log.info("TEST : validate the Staff access for Organization listing page");
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



