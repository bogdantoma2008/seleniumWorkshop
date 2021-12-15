package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	public WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-96.0.4664.45.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://keybooks.ro/");
		// driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}

	@AfterClass
	public void cleanup() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}

	public void navigateToAccount() {
		driver.get("https://keybooks.ro/account/");
	}
	
	public void navigateToShop() {
		driver.get("https://keybooks.ro/shop/");
	}
}
