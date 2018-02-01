package com.github.demo.app;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.framework.context.RunTimeContext;
import com.github.framework.context.TestingDevice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class BaseAppAction 
{
	public AppiumDriver<MobileElement> driver;
	public BaseAppAction(AppiumDriver<MobileElement> driver)
	{
		this.driver = driver;
	}
	
	public void swipeLeft(int count)
	{
		sleep(1000);
		
		for(int i = 0; i < count; i++)
		{
			// Swiping
			swipeLeft();
		}
	}

	public void swipeLeftAtY(int y)
	{
		// Swipe to the left to display previous article/section
		TouchAction action = new TouchAction(driver);

		if(RunTimeContext.isAndroidPlatform())
		{
			action.press(TestingDevice.get().getDeviceWidth() * 9 / 10, y)
			.waitAction(Duration.ofMillis(500))
			.moveTo(TestingDevice.get().getDeviceWidth() / 10, y)
			.release().perform();
			
			sleep(1000);
		}
		else
		{
			action.press(TestingDevice.get().getDeviceWidth() * 9 / 10, y)
			// TODO Bug for Appium touch action in x, y coordinate
			.moveTo(-TestingDevice.get().getDeviceWidth() * 8 / 10, 0)
			.release().perform();
			
			sleep(500);
		}
	}
	
	public void swipeLeft()
	{
		// Swipe to the left to display previous article/section
		TouchAction action = new TouchAction(driver);

		if(RunTimeContext.isAndroidPlatform())
		{
			action.press(TestingDevice.get().getDeviceWidth() * 9 / 10, TestingDevice.get().getDeviceHight() * 4 / 5)
			.waitAction(Duration.ofMillis(500))
			.moveTo(TestingDevice.get().getDeviceWidth() / 10, TestingDevice.get().getDeviceHight() * 4 / 5)
			.release().perform();
			
			sleep(1000);
		}
		else
		{
			action.press(TestingDevice.get().getDeviceWidth() * 9 / 10, TestingDevice.get().getDeviceHight() * 4 / 5)
			// TODO Bug for Appium touch action in x, y coordinate
			.moveTo(-TestingDevice.get().getDeviceWidth() * 8 / 10, 0)
			.release().perform();
			
			sleep(500);
		}
	}

	public void swipeRight(int count)
	{
		sleep(1000);
		
		for(int i = 0; i < count; i++)
		{
			// Swiping
			swipeRight();
		}
	}

	public void swipeRightAtY(int y)
	{
		// Swipe to the right to display previous article/section
		TouchAction action = new TouchAction(driver);

		if(RunTimeContext.isAndroidPlatform())
		{
			action.press(TestingDevice.get().getDeviceWidth() / 10, y)
			.waitAction(Duration.ofMillis(500))
			.moveTo(TestingDevice.get().getDeviceWidth() * 9 / 10, y)
			.release().perform();
			
			sleep(1000);
		}
		else
		{
			action.press(TestingDevice.get().getDeviceWidth() / 10, y)
			// TODO Bug for Appium touch action in x, y coordinate
			.moveTo(TestingDevice.get().getDeviceWidth() * 9 / 10, 0)
			.release().perform();
			
			sleep(500);
		}
	}
	
	public void swipeRight()
	{
		// Swipe to the right to display previous article/section
		TouchAction action = new TouchAction(driver);

		if(RunTimeContext.isAndroidPlatform())
		{
			action.press(TestingDevice.get().getDeviceWidth() / 10, TestingDevice.get().getDeviceHight() * 4 / 5)
			.waitAction(Duration.ofMillis(500))
			.moveTo(TestingDevice.get().getDeviceWidth() * 9 / 10, TestingDevice.get().getDeviceHight() * 4 / 5)
			.release().perform();
			
			sleep(1000);
		}
		else
		{
			action.press(TestingDevice.get().getDeviceWidth() / 10, TestingDevice.get().getDeviceHight() * 4 / 5)
			// TODO Bug for Appium touch action in x, y coordinate
			.moveTo(TestingDevice.get().getDeviceWidth() * 9 / 10, 0)
			.release().perform();
			
			sleep(500);
		}
	}

	public void scrollDown(int count)
	{
		for(int i = 0; i < count; i++)
		{
			// Swiping
			scrollDown();
		}
	}
	
	public void scrollDownOnScrollBar(int count)
	{
		for(int i = 0; i < count; i++)
		{
			// Swiping
			scrollDownOnScrollBar();
		}
	}

	public void scrollOnScrollBar(int startY, int endY, Duration duration)
	{
		TouchAction action = new TouchAction(driver);

		if(RunTimeContext.isAndroidPlatform())
		{
			action.press(TestingDevice.get().getDeviceWidth() / 2, startY)
			.waitAction(duration)
			.moveTo(TestingDevice.get().getDeviceWidth() / 2, endY)
			.release().perform();
			
			sleep(1000);
		}
		else
		{
			action.press(TestingDevice.get().getDeviceWidth() / 2, startY)
			.waitAction(duration)
			.moveTo(0, endY)
			.release().perform();
		}
	}
	
	public void scrollUp()
	{
		TouchAction action = new TouchAction(driver);

		if(RunTimeContext.isAndroidPlatform())
		{
			action.press(TestingDevice.get().getDeviceWidth() / 2, TestingDevice.get().getDeviceHight() / 10)
			.waitAction(Duration.ofMillis(500))
			.moveTo(TestingDevice.get().getDeviceWidth() / 2, TestingDevice.get().getDeviceHight() * 9 / 10)
			.release().perform();
			
			sleep(1000);
		}
		else
		{
			action.press(TestingDevice.get().getDeviceWidth() / 2, TestingDevice.get().getDeviceHight() / 10)
			.waitAction(Duration.ofMillis(200))
			.moveTo(0, TestingDevice.get().getDeviceHight() * 8 / 10)
			.release().perform();
		}
	}

	public void scrollDownOnScrollBar()
	{
		TouchAction action = new TouchAction(driver);

		if(RunTimeContext.isAndroidPlatform())
		{
			action.press(TestingDevice.get().getDeviceWidth() - 5, TestingDevice.get().getDeviceHight() * 7 / 10)
			.waitAction(Duration.ofMillis(2000))
			.moveTo(TestingDevice.get().getDeviceWidth() - 5, TestingDevice.get().getDeviceHight() / 10)
			.release().perform();
			
			sleep(1000);
		}
		else
		{
			action.press(TestingDevice.get().getDeviceWidth() - 5, TestingDevice.get().getDeviceHight() * 7 / 10)
			.waitAction(Duration.ofMillis(100))
			.moveTo(0, -(TestingDevice.get().getDeviceHight() * 8 / 10))
			.release().perform();
		}
	}
	
	public void scrollDown()
	{
		TouchAction action = new TouchAction(driver);

		if(RunTimeContext.isAndroidPlatform())
		{
			action.press(TestingDevice.get().getDeviceWidth() / 2, TestingDevice.get().getDeviceHight() * 7 / 10)
			.waitAction(Duration.ofMillis(2000))
			.moveTo(TestingDevice.get().getDeviceWidth() / 2, TestingDevice.get().getDeviceHight() / 10)
			.release().perform();
			
			sleep(1000);
		}
		else
		{
			action.press(TestingDevice.get().getDeviceWidth() / 2, TestingDevice.get().getDeviceHight() * 7 / 10)
			.waitAction(Duration.ofMillis(100))
			.moveTo(0, -(TestingDevice.get().getDeviceHight() * 8 / 10))
			.release().perform();
		}
	}
	
	public void tapOnScreen(int x, int y, int duration)
	{
		new TouchAction(driver).press(x, y).waitAction(Duration.ofMillis(duration)).release().perform();
	}
	
	public void sleep(long millis)
	{
		try 
		{
			Thread.sleep(millis);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Tap on the center of one element
	 * @param element
	 */
	public void tapOnElement(MobileElement element)
	{
		Dimension dimension = element.getSize();
		int x = element.getLocation().getX() + dimension.getWidth() / 2;
		int y = element.getLocation().getY() + dimension.getHeight() / 2;
		
		new TouchAction(driver).tap(x, y).perform();
	}
	
	public boolean waitForVisibility(WebElement element, long seconds)
	{
		try
		{
			new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOf(element));

			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean waitForVisibility(By element, long seconds)
	{
		try
		{
			new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOfElementLocated(element));

			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void acceptAlert()
	{
		WebDriverWait wait = new WebDriverWait(driver, 3);
		try 
		{
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
		} 
		catch (Exception e) 
		{
			System.err.println("no alert visible after 3 sec.");
		}
	}

	public void dismissAlert()
	{
		WebDriverWait wait = new WebDriverWait(driver, 3);
		try 
		{
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().dismiss();
		} 
		catch (Exception e) 
		{
			System.err.println("no alert visible after 3 sec.");
		}
	}
}
