package com.framework.Listeners;
import java.util.List;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.utils.Constants;
import com.utils.ExcelUtil;
import com.utils.Log;


public class TestListener implements IInvokedMethodListener {

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		
		  if (testResult.getMethod().isTest()) {
		        //Change Failed to Skipped based on if it is a known failure
		        if (testResult.getStatus() == ITestResult.FAILURE) {
		        	String failedTestCaseName = testResult.getMethod().getMethodName();
		        	ExcelUtil excelUtil = new ExcelUtil(Constants.KNOWN_FAILURES);
		        	List<String> knownFailures = excelUtil.readStringValuesFromFirstColumn(); 		        	
		           
		        	if (testResult.getThrowable() != null && knownFailures.contains(failedTestCaseName)) {
		                if (testResult.getThrowable().getStackTrace() != null) {
		                        Log.info(failedTestCaseName+": is a known failure, marking it as Skipped");
		                        ITestContext tc = Reporter.getCurrentTestResult().getTestContext();
		                        tc.getFailedTests().addResult(testResult, Reporter.getCurrentTestResult().getMethod());
		                        tc.getFailedTests().getAllMethods().remove(Reporter.getCurrentTestResult().getMethod());
		                        Reporter.getCurrentTestResult().setStatus(ITestResult.SKIP);
		                        tc.getSkippedTests().addResult(testResult, Reporter.getCurrentTestResult().getMethod());
		                    //}
		                }
		            }
		        }
		  }
		
	}	

}
