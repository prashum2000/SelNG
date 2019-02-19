package com.framework;

import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsManager {
	
	public static ChromeOptions getChromeOptions(){
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--ignore-certificate-errors");
		chromeOptions.addArguments("--disable-popup-blocking");
		System.setProperty("webdriver.chrome.driver",Constants.DRIVER_CHROME+"chromedriver.exe");
		return chromeOptions;
	}

}
