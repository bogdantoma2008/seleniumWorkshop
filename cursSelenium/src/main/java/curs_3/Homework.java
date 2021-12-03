package curs_3;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class Homework extends BaseTest {

	@Test
	public void homework2() throws InterruptedException {
		List<WebElement> menuItems = driver.findElements(By.xpath("//li[contains(@class, 'sc_tabs_title')]"));
		WebElement theForestBook = null;

		for (WebElement menuItem : menuItems) {
			menuItem.click();
			System.out.println("Clicked on menu item with text: " + menuItem.getText());
			Thread.sleep(2000);

			theForestBook = driver.findElement(By.xpath(
					"//div[contains(@class, 'sc_column_item ') and not(ancestor::div[contains(@style, 'display: none')])]/h3/a[@href='the-forest']"));
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(theForestBook.isDisplayed());
			System.out.println("Checked if " + theForestBook.getText() + " is displayed");

		}

		if (theForestBook != null)
			theForestBook.click();
		Thread.sleep(1000);
		
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-forest/");
	}

}
