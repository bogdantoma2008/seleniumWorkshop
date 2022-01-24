package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShopPage {


	WebDriver driver;
	WebElement dropdown;
	Select selectDropdown;
	public ShopPage(WebDriver driver) {
		this.driver = driver;
	}


	public By orderDropDown = By.name("orderby");



	public void filterByValue(String value) {
		dropdown = driver.findElement(orderDropDown);
		selectDropdown =  new Select(dropdown);
		selectDropdown.selectByValue(value);
		System.out.println("Selected the value :" + value);
	}

	public void filterByIndex(int index) {
		dropdown = driver.findElement(orderDropDown);
		selectDropdown = new Select(dropdown);
		selectDropdown.selectByIndex(index);
		System.out.println("Selected the index :" + index);

	}

	public void filterByVisibleText(String visibleText) {
		dropdown = driver.findElement(orderDropDown);
		selectDropdown = new Select(dropdown);	
		selectDropdown.selectByVisibleText(visibleText);
		System.out.println("Selected the visibleText :" + visibleText);

	}

	public String getTheCurrentSelectedOption() {
		dropdown = driver.findElement(orderDropDown);
		selectDropdown = new Select(dropdown);	
		String elementText = selectDropdown.getFirstSelectedOption().getText();
		System.out.println("The current selected option is :" + elementText);
		return elementText;

	}



}