package com.github.demo.app.pages;

import java.time.Duration;

import org.openqa.selenium.support.CacheLookup;

import com.github.demo.app.page.components.NumberPad;
import com.github.demo.app.page.components.SignPad;
import com.github.testcommon.test.base.page.element.CustomElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomePage extends BasePage {

	public NumberPad NumberPad;
	public SignPad SignPad;
	
	public CustomElement Formula = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(id = "com.android2.calculator3:id/formula")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public CustomElement Result = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(id = "com.android2.calculator3:id/result")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public HomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@Override
	public boolean waitForPageLoad() {
		return this.Formula.waitForVisible();
	}

	public void openSignTap()
	{
		TouchAction action = new TouchAction(driver);
		action.press(NumberPad.SignTapBar.get()).moveTo(NumberPad.Digit4.get()).waitAction(Duration.ofSeconds(1)).perform().release();
	}
}
