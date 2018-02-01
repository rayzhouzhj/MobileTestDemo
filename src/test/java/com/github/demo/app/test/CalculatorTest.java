package com.github.demo.app.test;

import org.testng.annotations.Test;

import com.github.demo.app.Calculator;
import com.github.demo.test.base.ProjectBaseTest;
import com.github.framework.annotations.InstallApp;
import com.github.testcommon.test.base.TestDataManager;

public class CalculatorTest extends ProjectBaseTest
{
	/**
	 * Install Calculator and start testing
	 */
	@InstallApp // Use this annotation to install new app
	@Test(groups = "testCalculator")
	public void testCalculatorWithNewApp()
	{
		logger.logInfo("Get device data for user: " + TestDataManager.getUserData().getUserName());
		
		App = Calculator.createInstance();
		
		if(App.HomePage.waitForPageLoad())
		{
			logger.logPass("Calculator is launched successfully.");
		}
		else
		{
			// Fail the test and stop execution
			logger.logFatalError("Fail to launch calculator.");
		}
		
		App.HomePage.NumberPad.DigitList.getElementByName("1").click();
		App.HomePage.NumberPad.DigitList.getElementByName("2").click();
		App.HomePage.NumberPad.DigitList.getElementByName("9").click();
		
		App.HomePage.NumberPad.PlusButton.click();
		
		App.swipeLeft();
		App.HomePage.SignPad.waitForVisible();
		App.HomePage.SignPad.Log.click();
		App.swipeRight();
		
		App.HomePage.NumberPad.Digit1.click();
		App.HomePage.NumberPad.Digit0.click();
		
		App.swipeLeft();
		App.HomePage.SignPad.RightParenthesis.click();
		App.swipeRight();
		
		App.HomePage.NumberPad.Equal.click();
		
		String result = App.HomePage.Formula.getText();
		if("130".equals(result))
		{
			logger.logPass("Result is 130 as expected.");
		}
		else
		{
			logger.logFail("Unexpected result found, expected: 130, current value: " + result);
		}
		
		System.out.println("testCalculator completed");
	}
	
	/**
	 * Use existing Calculator and start testing
	 */
	@Test(groups = "testCalculator")
	public void testCalculatorWithExistingApp()
	{
		logger.logInfo("Get device data for user: " + TestDataManager.getUserData().getUserName());
		
		App = Calculator.createInstance();
		
		if(App.HomePage.waitForPageLoad())
		{
			logger.logPass("Calculator is launched successfully.");
		}
		else
		{
			// Fail the test and stop execution
			logger.logFatalError("Fail to launch calculator.");
		}
		
		App.HomePage.NumberPad.DigitList.getElementByName("1").click();
		App.HomePage.NumberPad.DigitList.getElementByName("2").click();
		App.HomePage.NumberPad.DigitList.getElementByName("9").click();
		
		App.HomePage.NumberPad.PlusButton.click();
		
		App.swipeLeft();
		App.HomePage.SignPad.waitForVisible();
		App.HomePage.SignPad.Log.click();
		App.swipeRight();
		
		App.HomePage.NumberPad.Digit1.click();
		App.HomePage.NumberPad.Digit0.click();
		
		App.swipeLeft();
		App.HomePage.SignPad.RightParenthesis.click();
		App.swipeRight();
		
		App.HomePage.NumberPad.Equal.click();
		
		String result = App.HomePage.Formula.getText();
		if("130".equals(result))
		{
			logger.logPass("Result is 130 as expected.");
		}
		else
		{
			logger.logFail("Unexpected result found, expected: 130, current value: " + result);
		}
		
		System.out.println("testCalculator completed");
	}
}
