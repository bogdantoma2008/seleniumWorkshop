package curs_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Texts;

import utils.BaseTest;

public class Homework extends BaseTest {

	@Parameters({ "name", "email", "subject", "message" })
	@Test
	public void script(String name, String email, String subject, String message) {
		WebElement nameField = driver.findElement(By.xpath("//input[@name='your-name']"));
		WebElement emailField = driver.findElement(By.xpath("//input[@name='your-email']"));
		WebElement subjectField = driver.findElement(By.xpath("//input[@name='your-s']"));
		WebElement messageField = driver.findElement(By.xpath("//textarea[@name='your-message']"));
		WebElement buttonSendMessage = driver
				.findElement(By.xpath("//input[@type='submit' and contains(@class, 'wpcf7')]"));
		WebElement confirmationField = driver.findElement(By.xpath("//div[contains(@class, 'wpcf7-response')]"));

		nameField.sendKeys(name);
		emailField.sendKeys(email);
		subjectField.sendKeys(subject);
		messageField.sendKeys(message);

		buttonSendMessage.click();

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(confirmationField.getText().equals(Texts.messageSentConfirmation));

	}
}
