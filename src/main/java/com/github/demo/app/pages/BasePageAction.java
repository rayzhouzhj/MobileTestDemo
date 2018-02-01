package com.github.demo.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.demo.app.BaseAppAction;
import com.github.framework.context.RunTimeContext;
import com.github.testcommon.test.constants.MatchOption;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public abstract class BasePageAction extends BaseAppAction 
{

	public BasePageAction(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}

    public abstract boolean waitForPageLoad();
    
    public boolean waitForVisibility(WebElement element)
    {
    	return waitForVisibility(element, 10);
    }
    
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
    
    public boolean waitForClickable(WebElement element, int secondsToWait) 
    {
        try
    	{
        	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        	
        	new WebDriverWait(driver, secondsToWait).until(ExpectedConditions.elementToBeClickable(element));
           
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
    
	public MobileElement getTextViewByText(MobileElement container, String findByText, MatchOption option)
	{

		List<MobileElement> list = container.findElements(By.className("android.widget.TextView"));
		String text;
		for(MobileElement element : list)
		{
			text = element.getText();
			System.out.println("Find Option: " + text);
			if((option == MatchOption.Exact && text.equals(findByText))
					|| (option == MatchOption.Contains && text.toLowerCase().contains(findByText)))
			{
				return element;
			}
		}

		return null;
	}

	public void back()
	{
		if(RunTimeContext.isAndroidPlatform())
		{
			((AndroidDriver<MobileElement>)driver).pressKeyCode(AndroidKeyCode.BACK);
		}
		else
		{
			driver.findElement(ByAccessibilityId.id("navBar.backButton")).click();
		}
	}
}
