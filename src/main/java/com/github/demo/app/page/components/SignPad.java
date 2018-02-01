package com.github.demo.app.page.components;

import org.openqa.selenium.support.CacheLookup;

import com.github.testcommon.test.base.page.element.CustomElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SignPad extends BasePageComponent
{
	public CustomElement Log = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(id = "com.android2.calculator3:id/fun_log")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public CustomElement RightParenthesis = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(id = "com.android2.calculator3:id/rparen")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public SignPad(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}

	@Override
	public boolean waitForVisible() 
	{
		return this.Log.waitForVisible();
	}
}
