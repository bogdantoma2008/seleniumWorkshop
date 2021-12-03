package curs_3;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class GetExample extends BaseTest {

	@Test
	public void getExample() {
		List<WebElement> books = driver.findElements(By.cssSelector("h3[class*='sc_title']"));
		books.get(2).click();
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://keybooks.ro/shop/life-in-the-garden/";
		System.out.println(currentURL);
		
		assertEquals(currentURL, expectedURL);
		
		String currentPageTitle = driver.getTitle();
		String expectedPageTitle = "Life in the garden – Booklovers";
		assertEquals(currentPageTitle, expectedPageTitle);
		
		WebElement bookTitle = driver.findElement(By.cssSelector("h1[class*='product_title']"));
		String actualTitle = bookTitle.getText();
		String expectedTitle = "Life in the garden";
		
		assertEquals(actualTitle, expectedTitle);
		

	}
}
