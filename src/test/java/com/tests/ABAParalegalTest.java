package com.tests;

import org.testng.annotations.Test;

import com.bo.User;
import com.framework.TestBase;
import com.pages.ABAHomePage;
import com.pages.ABALoginPage;
import com.pages.ABASiteVisitPage;
import com.utils.DataproviderForTest;
import com.utils.Log;

public class ABAParalegalTest extends TestBase {
	
	
	/**
	 *  Test to validate Login functionality
	 *  Step 1 : Get into login page login as paralegal member
	 *  Step 2 : Check for paralegal as access to SiteVisit list by clicking the site visit tab
	 *  Step3 : Validating is user landed on sitevisit page 
	 *  
	 */
	
	@Test(dataProvider = "paralegalData", dataProviderClass = DataproviderForTest.class)
	public void accessSiteVisit(User user) {
		try {
		Log.info("TEST : validate the paralegal member access for site visit listing page");
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

}
