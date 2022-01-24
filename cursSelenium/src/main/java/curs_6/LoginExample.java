package curs_6;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class LoginExample extends BaseTest {

	@Parameters({ "user", "pass" })
	@Test
	public void validLogin(String user, String pass) throws InterruptedException {
		System.out.println("Valid Login");

		WebElement loginButton = null;
		WebElement loginEmail = null;
		WebElement loginPass = null;

		loginButton = driver.findElement(By.className("popup_link"));

		assertTrue(loginButton.isDisplayed());

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border:2px solid red')",
				loginButton);

		loginButton.click();
		Thread.sleep(1000);

		loginEmail = driver.findElement(By.id("log"));
		loginPass = driver.findElement(By.id("password"));

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(loginEmail.isDisplayed());
		sa.assertTrue(loginPass.isDisplayed());

		loginEmail.sendKeys(user);
		loginPass.sendKeys(pass);

		WebElement loginButton2 = driver.findElement(By.xpath("//input[@type='submit' and @class='submit_button']"));
		loginButton2.click();
		sa.assertAll();
	}

	@Parameters({ "wronguser", "wrongpass" })
	@Test
	public void invalidLogin() {
		System.out.println("Invalid Login");
	}

}
