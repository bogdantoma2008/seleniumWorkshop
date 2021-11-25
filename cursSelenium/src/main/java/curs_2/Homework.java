package curs_2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Homework {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-96.0.4664.45.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("https://keytrainingtravelshop.herokuapp.com/login");
		driver.get("https://keybooks.ro/");
	}

	@Test(priority = 0)
	public void findElements() throws InterruptedException {
		WebElement loginButton = null;
		WebElement loginEmail = null;
		WebElement loginPass = null;

		loginButton = driver.findElement(By.className("popup_link"));

		assertTrue(loginButton != null);

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border:2px solid red')",
				loginButton);

		loginButton.click();
		Thread.sleep(1000);

		loginEmail = driver.findElement(By.id("log"));
		loginPass = driver.findElement(By.id("password"));

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(loginEmail != null);
		sa.assertTrue(loginPass != null);

		sa.assertAll();

		jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border:2px solid red')",
				loginEmail);
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border:2px solid red')",
				loginPass);

	}

	@AfterClass
	public void cleanup() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
}
