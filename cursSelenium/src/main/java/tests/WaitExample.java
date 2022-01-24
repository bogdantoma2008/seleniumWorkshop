package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.NavMenuPage;

public class WaitExample {

	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		// System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		// driver.get("https://keybooks.ro/");
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

		// navMenu = new NavMenuPage(driver);

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}

	@Test
	public void testWait() throws InterruptedException {

		driver.findElement(By.tagName("button")).click();
		WebElement finsih = driver.findElement(By.id("finish"));
		// Thread.sleep(5000);

		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.textToBePresentInElement(finsih, "H!"));

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(6))
				.pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.textToBePresentInElement(finsih, "H!"));

		assertEquals(finsih.getText(), "Hello World!");

	}

}