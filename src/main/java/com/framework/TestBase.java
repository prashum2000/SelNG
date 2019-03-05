package com.framework;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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



public class TestBase {
	
	protected WebDriverWait wait;
	protected String testURL;
	protected String browser;
	protected ThreadLocal<RemoteWebDriver> driver;
						
	@BeforeMethod (alwaysRun = true)
    @Parameters(value={"browser","baseURL","host","remoteURL"})
    public void setupTest (@Optional("chrome") String browser,@Optional("http://18.216.69.160:94/") String baseURL, @Optional("localHost") String host,@Optional("http://10.0.6.31:4444/wd/hub") String remoteURL, Method method) throws MalformedURLException {
		
		Log.startLog(method.getName());
		setDriver(browser,host,remoteURL);
        wait = new WebDriverWait(getTLDriver(), 15);
        testURL = baseURL;
        this.browser = browser;        
        
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
    			File scrFile = ((TakesScreenshot)getTLDriver()).getScreenshotAs(OutputType.FILE);
    			path = "./target/screenshots/" +methodName+scrFile.getName();
    			FileUtils.copyFile(scrFile, new File(path));
    		} 		
    		
    	} catch (Exception e){
    		Log.info(ExceptionUtils.getStackTrace(e));
    	}
		
    	if (getTLDriver() !=null){
    		getTLDriver().quit();     		     		
		}  	
    }
    
    @AfterClass (alwaysRun = true)
    public void terminate(){
    	getTLDriver().quit();
    	driver.remove();
    }
    
    	
	
	@SuppressWarnings("deprecation")
	public synchronized <S> void setDriver(String browser,String host,String remoteURL){
		
		if (host.equals("localHost")){
			
			if (browser.equals("chrome")) {           
		           
				driver = ThreadLocal.withInitial(() -> new ChromeDriver(OptionsManager.getChromeOptions()));
	        }
			
			if (browser.equals("firefox")){
				
				driver = ThreadLocal.withInitial(() -> new FirefoxDriver(OptionsManager.getFirefoxOptions()));
			}
		}
		
		if (host.equals("remoteHost")){
			
			driver = new ThreadLocal<RemoteWebDriver>();
			
			if (browser.equals("chrome")) {           
		        
				try {
					
					driver.set(new RemoteWebDriver(new URL(remoteURL),OptionsManager.getChromeOptions()));
				} catch (MalformedURLException e) {
					Log.info(ExceptionUtils.getStackTrace(e));
				}
	        }
			
			if (browser.equals("firefox")){
				
				try {
					driver.set(new RemoteWebDriver(new URL(remoteURL),OptionsManager.getFirefoxOptions()));
				} catch (MalformedURLException e) {
					Log.info(ExceptionUtils.getStackTrace(e)); 					
				}
			}
		}
		
		 
	}
	
	public synchronized RemoteWebDriver getTLDriver () {
        return driver.get();
    }
	
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
