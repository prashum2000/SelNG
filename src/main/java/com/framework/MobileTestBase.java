package com.framework;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.utils.Log;


public class MobileTestBase {
	
	protected WebDriverWait wait;
	protected RemoteWebDriver driver;
	
	
	@BeforeMethod (alwaysRun = true)
    @Parameters(value={"deviceName","platFormVersion","appPackage","appActivity","remoteURL"})
    public void setupTest (@Optional("Nokia-5") String deviceName,
    					   @Optional("9") String platFormVersion, 
    					   @Optional("com.google.android.calculator") String appPackage,
    					   @Optional("com.android.calculator2.Calculator") String appActivity,
    					   @Optional("http://127.0.0.1:4444/wd/hub") String remoteURL, 
    					   Method method) throws MalformedURLException {
		
		Log.startLog(method.getName());
		driver = setDriver(deviceName,platFormVersion,appPackage,appActivity,remoteURL);
        wait = new WebDriverWait(driver, 15);               
        
    }
 
    @AfterMethod (alwaysRun = true)
    public synchronized void tearDown(ITestResult testResult) throws Exception {         
    	String methodName	=	testResult.getName().toString().trim();
    	Log.endLog(methodName);
    	String path;
    	Log.info("Test status: "+ testResultStatus(testResult.getStatus())+" ,"+methodName);
    	try {
    		
    		if (testResult.getStatus() == ITestResult.FAILURE){
    			Log.info("Taking a screenshot as the test failed");
    			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    			path = "./target/screenshots/" +methodName+scrFile.getName();
    			FileUtils.copyFile(scrFile, new File(path));
    		} 		
    		
    	} catch (Exception e){
    		Log.info(ExceptionUtils.getStackTrace(e));
    	}
		
    	if (driver !=null){
    		driver.quit();     		     		
		}  	
    }
    
    @AfterClass (alwaysRun = true)
    public void terminate(){
    	driver.quit();
    	
    }
    
    	
	
	public RemoteWebDriver setDriver(String deviceName,String platFormVersion,String appPackage,String appActivity,String remoteURL){
			
			
			DesiredCapabilities caps = OptionsManager.getAndroidOptions();
			caps.setCapability("deviceName", deviceName);
			caps.setCapability("platFormVersion", platFormVersion);
			caps.setCapability("appPackage", appPackage);
			caps.setCapability("appActivity", appActivity);
			
			try {
				driver = (new RemoteWebDriver(new URL(remoteURL),caps));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			      
		
		 return driver;
	}
	
	/*public synchronized RemoteWebDriver getTLDriver () {
        return driver.get();
    }*/
	
	public void assertFailForRunTimeException(Exception e){
		Assert.fail("Run time Exceptin occured ==> "+ExceptionUtils.getStackTrace(e));
	}
	
	private String testResultStatus(int status) 
	{
		String result = "";
		switch (status) 
		{
		case ITestResult.SUCCESS :
			result = "PASS";
			break;
			
		case ITestResult.SUCCESS_PERCENTAGE_FAILURE:	
		case ITestResult.FAILURE :
			result = "FAIL";
			break;
			
		case ITestResult.SKIP :
			result = "SKIPPED";
			break;
			
		default:
			Log.info("Invalid result state : " + status );
			result = "INVALID RESULT STATE";
			break;
		}
		return result;
	}


}
