package com.github.demo.app.pages;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

import org.openqa.selenium.support.CacheLookup;
import org.testng.Assert;

import com.github.demo.app.page.components.BasePageComponent;
import com.github.testcommon.test.base.TestLogger;
import com.github.testcommon.test.base.page.element.CustomElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public abstract class BasePage extends BasePageAction
{
	public TestLogger logger;

	public CustomElement BackButton = new CustomElement()
	{
		@CacheLookup
		@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Navigate up' or @content-desc='向上瀏覽'] | //android.widget.ImageButton[@content-desc='Navigate up' or @content-desc='向上瀏覽']")
		@iOSFindBy(accessibility = "navBar.backButton")
		public MobileElement element;
	};

	private AtomicBoolean isInitilized = new AtomicBoolean(false);
	
	public void initPageElements()
	{
		if(isInitilized.get() == false)
		{
			isInitilized.set(true);
			
			Field[] fields = this.getClass().getFields();
			for(Field field : fields)
			{
				// For page Object
				if(field.getType().getSuperclass().getSimpleName().equals("BasePageComponent"))
				{
					try 
					{
						// Create page object instance and initialize page elements
						BasePageComponent pageComponent = (BasePageComponent) field.getType().getConstructors()[0].newInstance(driver);
						pageComponent.initPageElements();
						
						field.set(this, field.getType().getConstructors()[0].newInstance(driver));
					}
					catch (Exception e) 
					{
						e.printStackTrace();
						
						Assert.fail("Failed due to page initialization: " + this.getClass().getSimpleName());
					}
				}
				else
				{
					// DO NOTHING
					// Skip All objects other than CustomElement and PageObject
				}
			}
		}
	}
	
	public BasePage(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		logger = new TestLogger();
	}
}
