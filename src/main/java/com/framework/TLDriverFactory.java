package com.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TLDriverFactory {
	
	
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	
	public synchronized static <S> void setDriver(String browser){
		
		if (browser.equals("chrome")) {
           
           // tlDriver = (ThreadLocal<WebDriver>)ThreadLocal.withInitial((Supplier<? extends S>) new ChromeDriver(OptionsManager.getChromeOptions()));
			tlDriver = ThreadLocal.withInitial(() -> new ChromeDriver(OptionsManager.getChromeOptions()));
        } 
	}
	
	public synchronized static WebDriver getTLDriver () {
        return tlDriver.get();
    }

}
