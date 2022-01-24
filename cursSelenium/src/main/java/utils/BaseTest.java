package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest implements Texts{

	public WebDriver driver;

	@Parameters({ "url" })
	@BeforeClass
	public void setup(String url) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-96.0.4664.45.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("https://keybooks.ro/");
		driver.get(url);

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
