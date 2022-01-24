package utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.NavMenuPage;

public class BaseTest {

	public WebDriver driver;
	public NavMenuPage navMenu;

	@Parameters({ "url" })
	@BeforeClass
	public void setUp(String url) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_97.0.4692.71.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.get(url);

		navMenu = new NavMenuPage(driver);

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
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