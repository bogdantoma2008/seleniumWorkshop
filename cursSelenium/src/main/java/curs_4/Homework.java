package curs_4;

import static org.testng.Assert.*;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import utils.BaseTest;

public class Homework extends BaseTest {

	private WebElement getStarRating(int rating) {
		return driver.findElement(By.cssSelector("p[class='stars']>span>a[class='star-" + rating + "']"));
	}

	private String randomString(int len) {
		int leftLimit = 97;
		int rightLimit = 122;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		System.out.println(generatedString);
		return generatedString;
	}

	@Test
	private void test() throws InterruptedException {
		WebElement book = driver.findElement(By.cssSelector("a[href='the-forest']"));
		book.click();
		Thread.sleep(1000);

		WebElement tabReviews = driver.findElement(By.cssSelector("a[href='#tab-reviews']"));
		tabReviews.click();
		WebElement checkBox = driver.findElement(By.cssSelector("p[class='comment-form-cookies-consent']>input"));
		WebElement ratingStar = getStarRating(3);
		WebElement ratingComment = driver.findElement(By.cssSelector("textarea[id='comment']"));
		WebElement nameField = driver.findElement(By.cssSelector("input[id='author']"));
		WebElement emailField = driver.findElement(By.cssSelector("input[id='email']"));
		WebElement buttonSubmit = driver.findElement(By.cssSelector("input[id='submit']"));

		assertFalse(checkBox.isSelected());
		System.out.println("checkbox NOT selected");
		ratingStar.click();
		Thread.sleep(1000);
		ratingComment.sendKeys(randomString(25));
		Thread.sleep(1000);
		nameField.sendKeys("test name");
		Thread.sleep(1000);
		emailField.sendKeys("testEmail@test.local");
		Thread.sleep(1000);
		checkBox.click();
		Thread.sleep(1000);

		assertTrue(checkBox.isSelected());
		Thread.sleep(4000);
		buttonSubmit.click();
		Thread.sleep(4000);

		WebElement approvalMessage = driver
				.findElement(By.cssSelector("em[class='woocommerce-review__awaiting-approval']"));
		System.out.println(approvalMessage.getText());
		assertEquals(approvalMessage.getText(), "Your review is awaiting approval");

	}

}
