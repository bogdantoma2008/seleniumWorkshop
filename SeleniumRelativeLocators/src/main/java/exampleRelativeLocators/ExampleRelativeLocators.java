package exampleRelativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExampleRelativeLocators {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() {		
		//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver =  new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://keybooks.ro/");	

	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
	@Test
	public void relativeLocators() throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		// WebElement price10_20 = driver.findElement(By.xpath("$10.20"));
		
		WebElement price10_20 = driver.findElement(RelativeLocator.with(By.xpath("//h5[contains(text(), '$10.20')]"))
				.toLeftOf(By.xpath("//h5[contains(text(), '$15.99')]")));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border: 4px solid red;')", price10_20);
		
		Thread.sleep(4000);

		
		WebElement firstPrice10_20 = driver.findElement(RelativeLocator.with(By.xpath("//h5[contains(text(), '$10.20')]"))
				.toRightOf(By.xpath("//h5[contains(text(), '$15.05')]")));
		jse.executeScript("arguments[0].setAttribute('style', 'background:blue; border: 4px solid red;')", firstPrice10_20);
		
		Thread.sleep(4000);
		
		
		WebElement textBoox = driver.findElement(RelativeLocator.with(By.xpath("//a[contains(text(), 'It’s a really strange story')]"))
				.below(By.xpath("//img[contains(@src, 'book12')]")));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border: 4px solid red;')", textBoox);

		Thread.sleep(4000);
		
		////div[@class='wpb_wrapper']
		
		WebElement authorName = driver.findElement(RelativeLocator.with(By.xpath("//div[@class='wpb_wrapper']"))
				.near(textBoox));
		jse.executeScript("arguments[0].setAttribute('style', 'background:pink; border: 4px solid red;')", authorName);
		
		Thread.sleep(4000);

		
		WebElement contactPhone = driver.findElement(RelativeLocator.with(By.xpath("//div[@class='contact_phone_in_top']"))
				.toRightOf(By.xpath("//div[@class='top_panel_top_user_area']")));
		jse.executeScript("arguments[0].setAttribute('style', 'background:pink; border: 4px solid red;')", contactPhone);

		Thread.sleep(4000);
		
		WebElement cart = driver.findElement(RelativeLocator.with(By.xpath("//span"))
				.below(contactPhone));
		jse.executeScript("arguments[0].setAttribute('style', 'background:purple; border: 4px solid red;')", cart);

		Thread.sleep(4000);

	}
	
	
	
	
	
	

}