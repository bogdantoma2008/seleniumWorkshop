package curs_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSeleniumScript {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-96.0.4664.45.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://keybooks.ro/");
	}
	
	@Test
	public void test1() throws InterruptedException {
		String webPageTitle = driver.getTitle();
		System.out.println(webPageTitle);
		
		String logoSlogan = driver.findElement(By.className("logo_slogan")).getText();
		System.out.println(logoSlogan);
	}
	
	@AfterClass
	public void cleanup() {
		driver.quit();
	}

}
