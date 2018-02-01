package com.github.demo.app.page.components;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.demo.app.BaseAppAction;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public abstract class BaseComponentAction extends BaseAppAction 
{
	public BaseComponentAction(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}

    public abstract boolean waitForVisible();
    
    public boolean waitForVisibility(WebElement element, long seconds)
    {
    	try
    	{
    		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    		new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOf(element));
           
           return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    	finally
    	{
    		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	}
    }
    
    public boolean waitForElementToAppear(By locator, int secondsToWait) 
    {
        try
    	{
        	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        	
        	new WebDriverWait(driver, secondsToWait).until(ExpectedConditions.presenceOfElementLocated(locator));
           
           return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
        finally
        {
        	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }
    
    public boolean waitForElementToDisAppear(WebElement element, int secondsToWait) 
    {
        try
    	{
        	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        	
        	new WebDriverWait(driver, secondsToWait).until(ExpectedConditions.invisibilityOf(element));
           
           return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
        finally
        {
        	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }
}
