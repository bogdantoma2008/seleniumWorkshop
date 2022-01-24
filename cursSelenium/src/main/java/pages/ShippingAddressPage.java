package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressPage {

	public WebDriver driver;

	public ShippingAddressPage(WebDriver driver) {
		this.driver = driver;
	}

	public By countrySelector = By.id("shipping_country");
	public By stateSelector = By.id("shipping_state");

	public boolean selectByIndex(By dropdown, String setValue) {
		boolean found = false;
		Select selectDropdown = new Select(driver.findElement(dropdown));
		List<WebElement> options = selectDropdown.getOptions();

		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().equals(setValue)) {
				selectDropdown.selectByIndex(i);
				System.out.println("Found Country: " + options.get(i).getText());
				found = true;
				break;
			}
		}
		return found;
	}

	public boolean selectByValue(By dropdown, String setValue) {
		boolean found = false;
		try {
			Select selectDropdown = new Select(driver.findElement(dropdown));
			selectDropdown.selectByValue(setValue);
			found = true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
		}

		return found;
	}
}
