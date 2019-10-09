package com.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatorScreen extends BaseScreen {

	public CalculatorScreen (WebDriver driver){
		super(driver);
	}
	
	By locKeyNumberZero = By.id("com.google.android.calculator:id/digit_0");
	By locKeyNumberOne = By.id("com.google.android.calculator:id/digit_1");
	By locKeyNumberTwo = By.id("com.google.android.calculator:id/digit_2");
	By locKeyNumberThree = By.id("com.google.android.calculator:id/digit_3");
	By locKeyNumberFour = By.id("com.google.android.calculator:id/digit_4");
	By locKeyNumberFive = By.id("com.google.android.calculator:id/digit_5");
	By locKeyNumberSix = By.id("com.google.android.calculator:id/digit_6");
	By locKeyNumberSeven = By.id("com.google.android.calculator:id/digit_7");
	By locKeyNumberEight = By.id("com.google.android.calculator:id/digit_8");
	By locKeyNumberNine = By.id("com.google.android.calculator:id/digit_9");
	
	By locDevide = By.id("com.google.android.calculator:id/op_div");
	By locMultiply = By.id("com.google.android.calculator:id/op_mul");
	By locAdd = By.id("com.google.android.calculator:id/op_add");
	By locSubstract = By.id("com.google.android.calculator:id/op_sub");
	By locEqual = By.id("com.google.android.calculator:id/eq");
	By locResult = By.id("com.google.android.calculator:id/result");
	By locFormula = By.id("com.google.android.calculator:id/formula");
	
	public void enterNumber (int num1, int num2, String operation ){
		click(locKeyNumberEight);
		click(locKeyNumberFive);
		click(locMultiply);
	}
}
