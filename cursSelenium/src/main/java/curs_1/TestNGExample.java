package curs_1;

import org.testng.annotations.*;

public class TestNGExample {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}

	@Test
	public void test1() {
		System.out.println("Test 1");
	}

	@Test
	public void test2() {
		System.out.println("Test 2");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}
}
