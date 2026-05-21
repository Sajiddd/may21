package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.HomePage;
import page.LoginPage;

public class ValidLogin extends BaseTest
{
	/* test class name should be same as manual test case name.
	 * for every manual test case we create respective test class
	 * no. of test class are equal to no.of manual test cases.
	 * 
	 * in every test class write the manual test case steps and call the respective POM class methods 
	 * for better under standing.
	 */
	
	/* data drive the test method.
	 * reading the data from the excel file in test method.
	 */
	@Test(priority = 1)
	public void testValidLogin()//test method name should be same as manual test case name.
	{
		//reading the data from the excel file using generic getData() method.
		String userName = Excel.getData(Excel_Path, "validLogin", 1, 0);
		String password=Excel.getData(Excel_Path, "validLogin", 1, 1);
		String expectedTitle=Excel.getData(Excel_Path, "validLogin",1, 2);
		
		LoginPage loginPage=new LoginPage(driver);
		//enter user name
		loginPage.setUserName(userName);
		
		//enter password
		loginPage.setPassword(password);
		
		//click on login button
		loginPage.clickOnLoginButton();
		
		//verify HomePage is Displayed or not
		HomePage homePage=new HomePage(driver);
		boolean result = homePage.verifyHomePageMsgIsDisplayed(wait, expectedTitle);
		
		//verifying and saying result pass or fail using Assertion.
		Assert.assertEquals(result, true);
	}
}
