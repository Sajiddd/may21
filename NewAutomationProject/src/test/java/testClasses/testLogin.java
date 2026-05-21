package testClasses;

import org.testng.annotations.Test;

import generic.BaseTest;

public class testLogin extends BaseTest {

	@Test
	public void test()
	{
		String title = driver.getTitle();
		System.out.println("app title is "+title);
	}
}
