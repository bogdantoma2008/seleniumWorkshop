package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.ShopPage;
import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class DropdownTest extends BaseTest {

	@Test
	public void dropdownFilterByValueExample() {
		ShopPage shopPage = navMenu.navToShop();
		shopPage.filterByValue("popularity");
		assertEquals(shopPage.getTheCurrentSelectedOption(), "Sort by popularity");
	}

	@Test
	public void dropdownFilterByIndexExample() {
		ShopPage shopPage = navMenu.navToShop();
		shopPage.filterByIndex(3);
		assertEquals(shopPage.getTheCurrentSelectedOption(), "Sort by latest2");
	}

	@Test
	public void dropdownFilterByVisibleTextExample() {
		ShopPage shopPage = navMenu.navToShop();
		shopPage.filterByVisibleText("Sort by price: high to low");
		assertEquals(shopPage.getTheCurrentSelectedOption(), "Sort by price: high to low");

	}

}