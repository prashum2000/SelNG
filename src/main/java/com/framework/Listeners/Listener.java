package com.framework.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.TestBase;


public class Listener extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		//to do
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//to do	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//to do		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//to do		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//to do		
	}

	@Override
	public void onStart(ITestContext context) {
		//to do		
	}

	@Override
	public void onFinish(ITestContext context) {
		//to do
		
	}

}
