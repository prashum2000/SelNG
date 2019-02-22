package com.framework;

import java.net.MalformedURLException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.utils.Log;



public class TestBase {
	
	protected WebDriverWait wait;
	protected String testURL;
	protected String browser;
	private ThreadLocal<RemoteWebDriver> driver;
						
	@BeforeMethod
    @Parameters(value={"browser","baseURL","host"})
    public void setupTest (@Optional("chrome") String browser,@Optional("https://www.n11.com") String baseURL, @Optional("localHost") String host) throws MalformedURLException {
		Log.startLog();
		setDriver(browser,host);
        wait = new WebDriverWait(getTLDriver(), 15);
        testURL = baseURL;
        this.browser = browser;        
        
    }
 
    @AfterMethod
    public synchronized void tearDown() throws Exception {         
    	Log.endLog();
    	if (getTLDriver() !=null){
    		getTLDriver().quit();
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
