package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Texts;

public class SingleAuthorPage {

	public WebDriver driver;

	public SingleAuthorPage(WebDriver driver) {
		this.driver = driver;
	}

	public By dramaSkillNumber = By.xpath("//div[@class='sc_skills_info']/div[text()='" + Texts.drama
			+ "']/parent::div/following-sibling::div[1]/descendant ::div[@class='sc_skills_total']");
	public By biographySkillNumber = By.xpath("//div[@class='sc_skills_info']/div[text()='" + Texts.biography
			+ "']/parent::div/following-sibling::div[1]/descendant ::div[@class='sc_skills_total']");
	public By cookbooksSkillNumber = By.xpath("//div[@class='sc_skills_info']/div[text()='" + Texts.cookbooks
			+ "']/parent::div/following-sibling::div[1]/descendant ::div[@class='sc_skills_total']");

	public String getSkillNumber(String skill) {
		return driver
				.findElement(By.xpath("//div[@class='sc_skills_info']/div[text()='" + skill
						+ "']/parent::div/following-sibling::div[1]/descendant ::div[@class='sc_skills_total']"))
				.getText();
	}

}
