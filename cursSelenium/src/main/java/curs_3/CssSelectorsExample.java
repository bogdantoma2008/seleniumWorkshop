package curs_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CssSelectorsExample extends BaseTest {

	@Test
	public void cssExamples() {
		WebElement login = driver.findElement(By.cssSelector("#menu_user"));
		System.out.println(login.getText());

		WebElement textAllanGreen = driver.findElement(By.cssSelector("div.wpb_wrapper p")); // selector nu foarte
																								// stabil
		System.out.println(textAllanGreen.getText());

		WebElement selectedMenu = driver.findElement(
				By.cssSelector("li[class*='sc_tabs_title'][class*='ui-tabs-active'][aria-selected='true']"));
		
		System.out.println(selectedMenu.getText());
	}
}
