package com.framework.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.utils.Log;

public class Retry implements IRetryAnalyzer{
	
	private int retryCount = 0;
    private int maxRetryCount = 1;

	@Override
	public boolean retry(ITestResult result) {
		
		if (retryCount < maxRetryCount) {
			
            Log.info("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount+1) + " time(s).");
            retryCount++;
            return true;
        }
        return false;
    }
    
    public String getResultStatusName(int status) {
    	String resultName = null;
    	if(status==1)
    		resultName = "SUCCESS";
    	if(status==2)
    		resultName = "FAILURE";
    	if(status==3)
    		resultName = "SKIP";
		return resultName;
    }
	
}
