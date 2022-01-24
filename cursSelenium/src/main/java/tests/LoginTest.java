package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NavMenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {

	@Parameters({ "user", "pass" })
	@Test
	public void loginTest(String username, String password) {

		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateToLogin();

		// LoginPage loginPage = new LoginPage(driver);

		// loginPage.setUsername(username);
		// loginPage.setPassword(password);
		// loginPage.clickSubmitButton();

		LoginPage loginPage = navMenu.navToLogin();
		loginPage.loginInApp(username, password);

	}

	@Parameters({ "user", "pass" })
	// @Test
	public void invalidLoginTest(String username, String password) {

		NavMenuPage navMenu = new NavMenuPage(driver);
		navMenu.navigateToLogin();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(username);
		loginPage.setPassword(password);
		loginPage.clickSubmitButton();

	}

}