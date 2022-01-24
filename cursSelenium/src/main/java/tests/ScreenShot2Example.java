package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.ShopPage;
import utils.BaseTest;

public class ScreenShot2Example extends BaseTest {

	@Test
	public void screenShotExample() {
		ShopPage shopPage = navMenu.navToShop();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop2/");

	}

}