package curs_5;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.BaseTest;

public class JsAlertsExample extends BaseTest {

	@Test(priority = 0)
	private void jsExample() throws InterruptedException {
		driver.findElement(By.cssSelector("button[onclick*='Alert']")).click();
		Thread.sleep(3000);
		
		Alert alertJS = driver.switchTo().alert();
		alertJS.accept();
		
		String result = driver.findElement(By.id("result")).getText();
		assertEquals(result, "You successfully clicked an alert");
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 1)
	private void confirmJSExample() throws InterruptedException {
		driver.findElement(By.cssSelector("button[onclick*='Confirm']")).click();
		Thread.sleep(3000);
		
		Alert alertJS = driver.switchTo().alert();
		alertJS.dismiss();
		
		String result = driver.findElement(By.id("result")).getText();
		assertEquals(result, "You clicked: Cancel");
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 2)
	private void confirmJSPromptExample() throws InterruptedException {
		driver.findElement(By.cssSelector("button[onclick*='Prompt']")).click();
		Thread.sleep(3000);
		
		Alert alertJS = driver.switchTo().alert();
		alertJS.sendKeys("test test");
		alertJS.accept();
		
		String result = driver.findElement(By.id("result")).getText();
		assertEquals(result, "You entered: test test");
		Thread.sleep(3000);
		
	}



}
