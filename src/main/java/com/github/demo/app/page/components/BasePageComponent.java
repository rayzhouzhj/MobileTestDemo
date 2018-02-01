package com.github.demo.app.page.components;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

import org.testng.Assert;

import com.github.testcommon.test.base.TestLogger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public abstract class BasePageComponent extends BaseComponentAction
{
	public TestLogger logger;

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
						
						Assert.fail("Failed due to page component initialization: " + this.getClass().getSimpleName());
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
	
	public BasePageComponent(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		logger = new TestLogger();
	}
	
	public int getY()
	{
		throw new RuntimeException("getY() is not implemented.");
	}
	
	public int getX()
	{
		throw new RuntimeException("getX() is not implemented.");
	}
}
