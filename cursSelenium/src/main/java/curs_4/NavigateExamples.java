package curs_4;

import org.testng.annotations.*;

import utils.BaseTest;

public class NavigateExamples extends BaseTest {
	@Ignore
	public void navigateExamples() throws InterruptedException {
		Thread.sleep(1000);
		driver.navigate().to("https://keyfood.ro/");
		Thread.sleep(1000);
		driver.get("https://www.emag.ro/");
		Thread.sleep(1000);
		driver.navigate().to("https://altex.ro/");
		driver.navigate().back();

	}

	@Test
	public void navigateBackFwExample() {

		driver.get("https://keybooks.ro/");
		driver.navigate().to("https://keybooks.ro/shop/");
		driver.navigate().back();
		driver.get("https://keybooks.ro/events_calendar/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}
}
