package com.iqiyi.qixiu.cases;

import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iqiyi.qixiu.base.BaseTest;

public class LoginTest extends BaseTest {

	@Test
	public void Login() {
		{
			// 防止有升级提示框
			WebElement cancelText = session.findElementById("com.iqiyi.qixiu:id/dialog_cancel");
			if (cancelText != null) {
				cancelText.click();
			}
		}
		
		final WebElement tabMe = session.findElementById("com.iqiyi.qixiu:id/tabMe");
		tabMe.click();
		WebElement clickLogin = session.findElementById("com.iqiyi.qixiu:id/new_user_center_user_sign_in");
		clickLogin.click();

		WebElement etName = session.findElementById("com.iqiyi.qixiu:id/et_name");
		WebElement etPassword = session.findElementById("com.iqiyi.qixiu:id/et_password");

		etName.sendKeys("show_test_030@163.com");
		etPassword.sendKeys("123456");

		WebElement btLogin = session.findElementById("com.iqiyi.qixiu:id/bt_login");
		btLogin.click();

		WebDriverWait wait = new WebDriverWait(session, NETWORK_REQUEST_TIMEOUT);
		WebElement element = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				tabMe.click();
				return driver.findElement(By.id("com.iqiyi.qixiu:id/new_user_center_user_nickname"));
			}
		});

		Assert.assertNotNull(element);
	}
}