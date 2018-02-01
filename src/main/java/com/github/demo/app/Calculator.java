package com.github.demo.app;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import com.github.demo.app.pages.HomePage;
import com.github.demo.app.pages.BasePage;
import com.github.framework.context.RunTimeContext;
import com.github.framework.context.TestingDevice;
import com.github.framework.device.MobilePlatform;
import com.github.framework.device.logreader.AndroidLogReader;
import com.github.framework.utils.ADBShell;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Calculator extends BaseAppAction
{
	public HomePage HomePage;
	
	public static Calculator createInstance()
	{
		return new Calculator(TestingDevice.get().getDriver());
	}
	
	private Calculator(AppiumDriver<MobileElement> driver)
	{
		super(driver);

		Field[] fields = this.getClass().getDeclaredFields();
		for(Field field : fields)
		{
			// Skip NON-Page fields
			if(field.getType().getSuperclass() != BasePage.class)
			{
				continue;
			}

			try 
			{
				// Create page object instance and initialize page elements
				BasePage pageObject = (BasePage) field.getType().getConstructors()[0].newInstance(driver);
				pageObject.initPageElements();
				
				field.set(this, pageObject);
			} 
			catch (IllegalArgumentException | IllegalAccessException | InstantiationException
					| InvocationTargetException | SecurityException e) 
			{
				e.printStackTrace();
			}
		}
	}

	public AppiumDriver<MobileElement> getDriver()
	{
		return driver;
	}
	
	public void launch()
	{
		if(TestingDevice.getMobilePlatform() == MobilePlatform.ANDROID)
		{
			ADBShell.startApp(
					TestingDevice.getDeviceUDID(), 
					RunTimeContext.getInstance().getProperty("APP_PACKAGE"),
					RunTimeContext.getInstance().getProperty("APP_ACTIVITY"));
		}
	}

	public void kill()
	{
		if(TestingDevice.getMobilePlatform() == MobilePlatform.ANDROID)
		{
			ADBShell.killApp(TestingDevice.getDeviceUDID(), RunTimeContext.getInstance().getProperty("APP_PACKAGE"));
			sleep(2000);
			((AndroidLogReader)TestingDevice.get().getLogReader()).updateAppProcessID();
		}
	}

	public void sendToBackground(int seconds) 
	{
		driver.runAppInBackground(Duration.ofSeconds(seconds));
	}
	
	public void back() 
	{
		if(RunTimeContext.isAndroidPlatform())
		{
			((AndroidDriver<MobileElement>)driver).pressKeyCode(AndroidKeyCode.BACK);
		}
	}

	public void deeplink(String url)
	{
		driver.get(url);
	}
	
	/**
	 * Stop and clear
	 */
	public void resetApp() 
	{
		driver.resetApp();
	}
	
	public void reInstall() 
	{
		ADBShell.reinstallApp(TestingDevice.getDeviceUDID(), RunTimeContext.getApp().getAbsolutePath());
		this.launch();
	}
	
	public List<String> getLogs()
	{
		sleep(2000);
		return TestingDevice.get().getLogReader().getTrackingLogs();
	}
	
	public void clearLogs()
	{
		TestingDevice.get().getLogReader().getTrackingLogs();
	}
	
	public List<String> getLogs(int minLogEntryCount)
	{
		sleep(1000);
		List<String> logs = TestingDevice.get().getLogReader().getTrackingLogs();
		for(int i = 0; i < 10 && logs.size() < minLogEntryCount; i++)
		{
			sleep(1000);
			logs.addAll(TestingDevice.get().getLogReader().getTrackingLogs());
		}

		return logs;
	}
	
	public MobileElement waitForNotification(String expectedTitle)
	{
		sleep(10000);
		((AndroidDriver<MobileElement>)driver).openNotifications();
		this.waitForVisibility(driver.findElement(By.id("android:id/notification_main_column")), 3000);

		List<MobileElement> notifications = driver.findElements(By.id("android:id/notification_main_column"));
		MobileElement notificationTitle;
		String title;

		for(int i = 0; i < notifications.size(); i++)
		{
			notificationTitle = notifications.get(i).findElement(By.id("android:id/title"));
			title = notificationTitle.getText();
			System.out.println("Notification Title: " + title);
			if(title.equals(expectedTitle))
			{
				return notifications.get(i).findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text' or @resource-id='android:id/big_text']"));
			}
		}

		return null;
	}
	
	public void clearNotification()
	{
		AndroidDriver<MobileElement> androidDriver = (AndroidDriver<MobileElement>)driver;
		androidDriver.openNotifications();

		List<MobileElement> notifications = androidDriver.findElements(By.id("android:id/title"));
		for(int i = notifications.size() - 1; i >= 0; i--)
		{
			// Swipe to the right to display more sections
			TouchAction action = new TouchAction(androidDriver);
			// Use the 2nd last index as the last one would be out of bound(invisible)
			action.press(notifications.get(i)).waitAction(Duration.ofSeconds(1)).moveTo(0, 0).release().perform();
		}
	}
}
