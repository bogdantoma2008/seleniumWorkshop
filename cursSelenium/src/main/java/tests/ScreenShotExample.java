package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.ScreenShots;

public class ScreenShotExample extends BaseTest {

	@Test
	public void screenShotExample() throws Exception {
		try {

			driver.findElement(By.linkText("Carte care nu exista")).click();

		} catch (Exception e) {

			ScreenShots shot = new ScreenShots();
			shot.screenshot(driver);

			throw e;
		}

	}

}