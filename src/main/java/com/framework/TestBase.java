package com.framework;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class TestBase {
	
	protected WebDriverWait wait;
	protected String testURL;
	protected WebDriver driver;
		
	@BeforeMethod
    @Parameters(value={"browser","baseURL"})
    public void setupTest (@Optional("chrome") String browser,@Optional("https://www.n11.com") String baseURL) throws MalformedURLException {
       
		TLDriverFactory.setDriver(browser);
        wait = new WebDriverWait(TLDriverFactory.getTLDriver(), 15);
        testURL = baseURL;
        driver = TLDriverFactory.getTLDriver();
        
    }
 
    @AfterMethod
    public synchronized void tearDown() throws Exception {         
    	TLDriverFactory.getTLDriver().quit();
    }

}
