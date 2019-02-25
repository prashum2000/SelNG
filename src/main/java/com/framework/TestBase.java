package com.framework;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
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
						
	@BeforeMethod
    @Parameters(value={"browser","baseURL","host"})
    public void setupTest (@Optional("chrome") String browser,@Optional("https://www.n11.com") String baseURL, @Optional("localHost") String host, Method method) throws MalformedURLException {
		
		Log.startLog(method.getName());
		setDriver(browser,host);
        wait = new WebDriverWait(getTLDriver(), 15);
        testURL = baseURL;
        this.browser = browser;        
        
    }
 
    @AfterMethod
    public synchronized void tearDown(ITestResult testResult) throws Exception {         
    	String methodName	=	testResult.getName().toString().trim();
    	Log.endLog(methodName);
    	String path;
    	
    	try {
    		
    		if (testResult.getStatus() == ITestResult.FAILURE){
    			Log.info("Test Status => "+testResult.getStatus());
    			File scrFile = ((TakesScreenshot)getTLDriver()).getScreenshotAs(OutputType.FILE);
    			path = "./target/screenshots/" +methodName+scrFile.getName();
    			FileUtils.copyFile(scrFile, new File(path));
    		} 		
    		
    	} catch (Exception e){
    		Log.info(ExceptionUtils.getStackTrace(e));
    	}
		
    	if (getTLDriver() !=null){
    		getTLDriver().close();     		     		
		}  	
    }     
    	
	
	@SuppressWarnings("deprecation")
	public synchronized <S> void setDriver(String browser,String host){
		
		if (host.equals("localHost")){
			
			if (browser.equals("chrome")) {           
		           
				driver = ThreadLocal.withInitial(() -> new ChromeDriver(OptionsManager.getChromeOptions()));
	        }
			
			if (browser.equals("firefox")){
				
				driver = ThreadLocal.withInitial(() -> new FirefoxDriver(OptionsManager.getFirefoxOptions()));
			}
		}
		
		 
	}
	
	public synchronized WebDriver getTLDriver () {
        return driver.get();
    }
	
	public void assertFailForRunTimeException(Exception e){
		Assert.fail("Run time Exceptin occured ==> "+ExceptionUtils.getStackTrace(e));
	}

}
