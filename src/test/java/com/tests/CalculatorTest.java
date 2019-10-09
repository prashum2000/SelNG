package com.tests;

import org.testng.annotations.Test;

import com.framework.MobileTestBase;
import com.screens.CalculatorScreen;

public class CalculatorTest extends MobileTestBase {
	
	@Test
	public void test() {
		
		CalculatorScreen calculatorScreen = new CalculatorScreen(driver);
		calculatorScreen.enterNumber(8, 3, "Addition");
	}
	

}
