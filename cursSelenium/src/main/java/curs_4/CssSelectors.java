package curs_4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CssSelectors extends BaseTest {

	@Test
	public void testCssSelectors() {
		// id --> #
		WebElement loginPopUp = driver.findElement(By.cssSelector("#menu_user"));
		System.out.println(loginPopUp.getText());

		// class --> ,
		WebElement logoSlogan = driver.findElement(By.cssSelector(".logo_slogan"));
		System.out.println(logoSlogan.getText());

		// any attribute --> []
		WebElement updatesTitle = driver.findElement(By.cssSelector("h3[style='text-align:center;color:#ffffff;']"));
		System.out.println(updatesTitle.getText());

		WebElement titleInspire = driver.findElement(By.cssSelector("div.column-1_2 h3.sc_title_underline"));
		WebElement titleInspire2 = driver.findElement(By.cssSelector("div[class*='column-1_2'] h3.sc_title_underline"));
		WebElement titleInspire3 = driver
				.findElement(By.cssSelector("div[class*='column-1_2'] h3[class*='sc_title_underline']"));
		System.out.println(titleInspire.getText());
		System.out.println(titleInspire2.getText());
		System.out.println(titleInspire3.getText());

		// div.column-1_2>div[class*='wpb_text_column']>div[class*='wpb_wrapper'] ->
		// instabil, cresc sansele ca sa apara erori pentru ca sunt mai multe elemente
		// care se pot schimba
		// div.column-1_2 div[class*='wpb_wrapper']

		WebElement quote = driver.findElement(By.cssSelector("div.column-1_2 div[class*='wpb_wrapper']"));
		System.out.println(quote.getText());

		// input[id='log'][type='text'][name='log']
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	/*	WebElement loginPopup = driver.findElement(By.cssSelector("a[class*='popup_link']"));
		loginPopup.click();

		WebElement element = driver.findElement(By.cssSelector("input[id='log']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border:2px solid red')",
				element);
		// jsExecutor.executeScript("arguments[0].setAttribute('name', 'log3')",
		// element);

		WebElement username = driver.findElement(By.cssSelector("input[id='log'][type='text'][name='log']"));
		username.sendKeys("TestUser");

		// or
		WebElement passelement = driver.findElement(By.cssSelector("input[id='password']"));
		jsExecutor.executeScript("arguments[0].setAttribute('type', 'password3')", passelement);
		WebElement password = driver.findElement(By.cssSelector("input[id='password'],[type=password],[name='pwd']"));
		password.sendKeys("12345@67890");
		WebElement submitButton = driver.findElement(By.cssSelector("input[class='submit_button'][type=submit]"));
		submitButton.click();*/

		// contains
		WebElement bookTitle = driver.findElement(By.cssSelector("h3[class*='sc_title_regular']"));
		System.out.println(bookTitle.getText());

		// contains word h3[class~='sc_title']
		WebElement discoverBooks = driver.findElement(By.cssSelector("a[class~='sc_button_style_filled']"));
		System.out.println(discoverBooks.getText());

		// starts with a[href^='the']
		WebElement bookStartingWith = driver.findElement(By.cssSelector("a[href^='its']"));
		System.out.println(bookStartingWith.getText());

		// ends with a[href$='garden']
		WebElement bookEndingWith = driver.findElement(By.cssSelector("a[href$='garden']"));
		System.out.println(bookEndingWith.getText());

		// li[class*='sc_tabs_title']:not([aria-selected='true'])
		// li[class*='sc_tabs_title']:not([class*='ui-state-active'])
		// li[class*='sc_tabs_title']:not([.ui-state-active])
		List<WebElement> menuTabs = driver
				.findElements(By.cssSelector("li[class*='sc_tabs_title']:not([aria-selected='true'])"));
		for (WebElement menuElement : menuTabs) {
			jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border:2px solid red')",
					menuElement);
		}
		
		//nth-child
				WebElement menuTab2 = driver
						.findElement(By.cssSelector("li[class*='sc_tabs_title']:not([aria-selected='true']):nth-child(2)"));
				jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: green; border:2px solid red')",
						menuTab2);
	}

}
