package curs_5;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XPathExamples extends BaseTest {

	@Test(priority = 1)
	public void xpathLoginExample() throws InterruptedException {
		WebElement loginMenu = driver.findElement(By.xpath("//li[@class='menu_user_login']"));
		loginMenu.click();
		WebElement username = driver.findElement(By.xpath("//input[@id='log' or @name='log']"));
		username.sendKeys("TestUser");

		WebElement password = driver.findElement(By.xpath("//input[@id='password' and @name='pwd']"));
		password.sendKeys("12345@67890");

		WebElement remember = driver.findElement(By.xpath("//input[@id='rememberme' and @type='checkbox']"));
		remember.click();

		WebElement buttonSubmit = driver.findElement(By.xpath("//input[@value='Login']"));
		buttonSubmit.click();
		Thread.sleep(4000);

		WebElement usernameAfterLogin = driver.findElement(By.xpath("//span[@class='user_name']"));
		assertEquals(usernameAfterLogin.getText(), "Test User");
	}

	@Test(priority = 2, dependsOnMethods = "xpathLoginExample")
	public void testAccountDetails() {
		navigateToAccount();

		WebElement recentOrders = driver.findElement(By.xpath("//a[contains(text(), 'recent orders')]"));
		recentOrders.click();

		WebElement orderTableHeader = driver.findElement(By.xpath(
				"//th[contains(@class, 'woocommerce-orders-table__header woocommerce-orders-table__header-order-number')]"));
		orderTableHeader.isDisplayed();

		//cssSelector --> td[class*='woocommerce-orders-table__cell'][data-title='Order'] a[href*='1674']
		WebElement orderNumber = driver.findElement(By.xpath(
				"//td[contains(@class,'woocommerce-orders-table__cell')][@data-title='Order']/a[contains(text(),'1674')]"));
		orderNumber.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/account/view-order/1674/");
	}
	
	@Test (priority = 3)
	public void testShopExamples() {
		//  --> //div[@class='star-rating']/span[not(contains(@style, 'width:100%'))]/ancestor::div[@class='post_content']//child::a[@href='https://keybooks.ro/shop/life-in-the-garden/']
		
		//  --> //div[@class='star-rating']/span[not(contains(@style, 'width:100%'))]
	}

}
