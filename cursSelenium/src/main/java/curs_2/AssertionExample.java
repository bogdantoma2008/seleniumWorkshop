package curs_2;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionExample {
	
	@Test
	public void softAssert() {
		SoftAssert sa = new SoftAssert();
		System.out.println("softAssert_1");
		sa.assertTrue(true);
		System.out.println("softAssert_2");
		sa.assertAll();
	}
	
	@Test
	public void hardAssert() {
		System.out.println("hardAssert_1");
		assertTrue(true);
		System.out.println("hardAssert_2");
	}
}
