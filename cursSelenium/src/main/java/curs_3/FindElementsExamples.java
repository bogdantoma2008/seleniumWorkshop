package curs_3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class FindElementsExamples extends BaseTest {

	@Test
	public void testFindElements() throws InterruptedException {
		List<WebElement> bookPictures = driver.findElements(By.cssSelector("figure[class*='sc_image']"));

		for (WebElement element : bookPictures) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

			jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border:4px solid red')",
					element);
			Thread.sleep(100);

		}
	}

	@Test(priority = 1)
	public void testFindElements2() throws InterruptedException {

		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);

		List<WebElement> books = driver.findElements(By.cssSelector("h3[class*='sc_title']"));
		books.get(2).click();

		Thread.sleep(4000);

		System.out.println(books.size());
		currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
	}
}
