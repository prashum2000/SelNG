package com.framework;

import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class TestBase {
	
	protected WebDriverWait wait;
		
	@BeforeMethod
    @Parameters(value={"browser"})
    public void setupTest (@Optional("chrome") String browser) throws MalformedURLException {
       
		TLDriverFactory.setDriver(browser);
        wait = new WebDriverWait(TLDriverFactory.getTLDriver(), 15);
    }
 
    @AfterMethod
    public synchronized void tearDown() throws Exception {
        
    	TLDriverFactory.getTLDriver().quit();
    }

}
