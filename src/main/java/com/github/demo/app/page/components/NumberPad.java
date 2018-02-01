package com.github.demo.app.page.components;

import java.util.List;

import org.openqa.selenium.support.CacheLookup;

import com.github.testcommon.test.base.page.element.ChildElement;
import com.github.testcommon.test.base.page.element.CustomElement;
import com.github.testcommon.test.base.page.element.CustomElementList;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class NumberPad extends BasePageComponent
{
	public CustomElement TapBase = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(id = "com.android2.calculator3:id/base")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public CustomElement Equal = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(id = "com.android2.calculator3:id/eq")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public CustomElement Digit0 = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(xpath = "//android.widget.Button[@text='0']")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public CustomElement Digit1 = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(xpath = "//android.widget.Button[@text='1']")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public CustomElement Digit2 = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(id = "com.android2.calculator3:id/digit_2")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public CustomElement Digit3 = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(id = "com.android2.calculator3:id/digit_3")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public CustomElement Digit4 = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(id = "com.android2.calculator3:id/digit_4")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public CustomElement Digit5 = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(id = "com.android2.calculator3:id/digit_5")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public CustomElement Digit6 = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(id = "com.android2.calculator3:id/digit_6")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public CustomElement Digit7 = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(id = "com.android2.calculator3:id/digit_7")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public CustomElement Digit8 = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(id = "com.android2.calculator3:id/digit_8")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public CustomElement Digit9 = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(id = "com.android2.calculator3:id/digit_9")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public CustomElementList DigitList = new CustomElementList()
	{
		@CacheLookup
		@AndroidFindBy(id = "com.android2.calculator3:id/pad_numeric")
		@iOSFindBy(accessibility = "id")
		public MobileElement root;

		@CacheLookup
		@AndroidFindBy(className = "android.widget.Button")
		@iOSFindBy(accessibility = "id")
		public List<ChildElement> elementList;
	};

	public CustomElement PlusButton = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(id = "com.android2.calculator3:id/op_add")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public CustomElement SignTapBar = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(id = "com.android2.calculator3:id/pad_advanced")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};
	
	public NumberPad(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}

	@Override
	public boolean waitForVisible() 
	{
		return this.TapBase.waitForVisible();
	}
}
