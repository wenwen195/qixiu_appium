package com.iqiyi.qixiu.base;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

	protected static AndroidDriver<WebElement> session = null;
	protected static final int NETWORK_REQUEST_TIMEOUT = 20;
	protected static final int LAUNCH_TIMEOUT = 10;

	@BeforeClass
	public static void setup() {
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("device", "android");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("deviceName", "EVA-AL10");
			capabilities.setCapability("app",
					"D:/qiyi-live/app/build/outputs/apk/app-debug.apk");
			session = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			session.manage().timeouts().implicitlyWait(LAUNCH_TIMEOUT, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
	
	@AfterClass
	public static void TearDown() {
		if (session != null) {
			session.quit();
		}
		session = null;
	}
}
