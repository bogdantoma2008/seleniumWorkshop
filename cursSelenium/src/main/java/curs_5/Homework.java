package curs_5;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

public class Homework extends BaseTest {

	@Test(priority = 0)
	public void findAndAddToCart() throws InterruptedException {
		WebElement iconSearch = driver
				.findElement(By.xpath("//button[@type='submit'  and contains(@class,'icon-search')]"));
		WebElement textBoxSearch = driver
				.findElement(By.xpath("//input[@type='text'  and contains(@class,'search_field')]"));

		iconSearch.click();
		textBoxSearch.sendKeys("The story about me");
		textBoxSearch.sendKeys(Keys.ENTER);

		WebElement buttonLoadMore = driver.findElement(By.xpath("//span[@class='viewmore_text_1']"));
		System.out.println("Found Load More: " + buttonLoadMore.getText());
		WebElement bookOfInterest = null;

		while (bookOfInterest == null) {
			try {
				bookOfInterest = driver
						.findElement(By.xpath("//div[@class='post_thumb' and @data-title='The story about me']"));
			} catch (NoSuchElementException e) {
				Thread.sleep(1500);
				buttonLoadMore.click();
			}
		}

		bookOfInterest.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-story-about-me/");

		WebElement buttonAddToCart = driver.findElement(By.xpath("//button[@name='add-to-cart']"));
		buttonAddToCart.click();
		Thread.sleep(1500);

		WebElement actionMessage = driver.findElement(By.xpath("//div[@class='woocommerce-message']"));
		assertTrue(actionMessage.getText().contains("“The story about me” has been added to your cart."));

		WebElement buttonViewCart = driver.findElement(By.xpath("//div[@class='woocommerce-message']/a"));
		buttonViewCart.click();
		Thread.sleep(1000);

		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/cart/");
	}

	@Test(dependsOnMethods = "findAndAddToCart")
	public void checkCart() throws InterruptedException {
		WebElement inputQuantity = driver.findElement(By.xpath("//input[@class='input-text qty text']"));
		inputQuantity.clear();
		inputQuantity.sendKeys("2");
		WebElement buttonUpdateCart = driver.findElement(By.xpath("//button[@name='update_cart']"));
		buttonUpdateCart.click();
		Thread.sleep(1500);
		
		WebElement actionMessage = driver.findElement(By.xpath("//div[@class='woocommerce-message']"));
		assertEquals(actionMessage.getText(), "Cart updated.");
		
		WebElement buttonProceedToCheckout = driver.findElement(By.xpath("//div[@class='wc-proceed-to-checkout']/a"));
		buttonProceedToCheckout.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/checkout/");
		
		WebElement textBilling = driver.findElement(By.xpath("//h3[text()='Billing details']"));
		WebElement additionalInformation = driver.findElement(By.xpath("//h3[text()='Additional information']"));
		
		assertTrue(textBilling.isDisplayed());
		assertTrue(additionalInformation.isDisplayed());
		
	}
}
