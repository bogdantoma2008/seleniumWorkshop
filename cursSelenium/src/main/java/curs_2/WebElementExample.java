package curs_2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebElementExample {
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
	public void test1() {
		WebElement logoSlogan = driver.findElement(By.className("logo_slogan"));
		System.out.println(logoSlogan.getText());
	}

	@Test(priority = 1)
	public void linkTextLocatorExample() {
		WebElement booksLink = driver.findElement(By.linkText("BOOKS"));
		booksLink.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/");
	}

	@Test(priority = 2)
	public void partialLinkTextLocatorExample() {
		WebElement cookingBook = driver.findElement(By.partialLinkText("Cooking"));
		cookingBook.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/cooking-with-love/");
	}

	@Test(priority = 3)
	public void classNameExample() throws InterruptedException {
		Thread.sleep(1500);
		WebElement productPrice = driver.findElement(By.className("price"));
		productPrice.isDisplayed();

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border:2px solid red')",
				productPrice);
	}

	@AfterClass
	public void cleanup() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
}
