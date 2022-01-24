package Homework_8;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.NavMenuPage;
import pages.ShippingAddressPage;
import utils.BaseTest;
import utils.ScreenShots;

public class Homework extends BaseTest {

	@Parameters({ "user", "pass", "userLoginName" })
	@Test(priority = 1)
	public void login(String user, String pass, String userLoginName) {
		NavMenuPage navMenuPage = new NavMenuPage(driver);
		navMenuPage.navToLogin().loginInAppAndWait(user, pass, userLoginName);
	}

	@Parameters({ "url-shipping" })
	@Test(priority = 2)
	public void navigateToShipping(String url) {
		navigateToUrl(url);
	}

	@Parameters({ "country", "state" })
	@Test(priority = 3)
	public void setCountryAndState(String country, String state) throws InterruptedException {
		ShippingAddressPage shippingPage = new ShippingAddressPage(driver);

		boolean foundCountry = shippingPage.selectByIndex(shippingPage.countrySelector, country);
		assertEquals(foundCountry, true, "Could not find country: " + country);

		boolean foundState = shippingPage.selectByValue(shippingPage.stateSelector, state);
		assertEquals(foundState, true, "Could not find state: " + state);
	}
}
