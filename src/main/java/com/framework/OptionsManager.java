package com.framework;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.utils.Constants;

public class OptionsManager {
	
	public static ChromeOptions getChromeOptions(){
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--ignore-certificate-errors");
		chromeOptions.addArguments("--disable-popup-blocking");
		System.setProperty("webdriver.chrome.driver",Constants.DRIVER_PATH+"chromedriver.exe");
		return chromeOptions;
	}
	
	public static DesiredCapabilities getFirefoxOptions(){
		
		System.setProperty("webdriver.gecko.driver",Constants.DRIVER_PATH+"geckodriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
		desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, 1);
		desiredCapabilities.setCapability("marionette", true);
		return desiredCapabilities;
	}
	
	public static DesiredCapabilities getAndroidOptions(){
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("noReset","false");
		return desiredCapabilities;
	}

}
