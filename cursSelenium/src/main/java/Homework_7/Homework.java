package Homework_7;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.NavMenuPage;
import pages.SingleAuthorPage;
import utils.BaseTest;
import utils.Texts;

public class Homework extends BaseTest {

	@Parameters({ "dramaSkill", "biographySkill", "cookbooksSkill" })
	@Test
	public void validateAuthorSkills(String dramaSkill, String biographySkill, String cookbookSkill) {
		NavMenuPage navMenu = new NavMenuPage(driver);
		SingleAuthorPage singleAuthor = new SingleAuthorPage(driver);

		navMenu.navToSingleAuthorPage();

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(6))
				.pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
		wait.until(
				ExpectedConditions.textToBePresentInElement(driver.findElement(singleAuthor.dramaSkillNumber), "95%"));

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(singleAuthor.getSkillNumber(Texts.drama).equals(dramaSkill));
		sa.assertTrue(singleAuthor.getSkillNumber(Texts.biography).equals(biographySkill));
		sa.assertTrue(singleAuthor.getSkillNumber(Texts.cookbooks).equals(cookbookSkill));

	}
}
