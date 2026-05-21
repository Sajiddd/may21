package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class InvalidPasswordErrorMsg extends BaseTest
{
	@Test(priority = 3)
	public void testInvalidPasswordErrorMsg()
	{
		//data drive the test method
		String userName=Excel.getData(Excel_Path, "invalidPasswordErrorMsg", 1,0);
		String password=Excel.getData(Excel_Path, "invalidPasswordErrorMsg", 1, 1);
		
		LoginPage loginPage=new LoginPage(driver);
		//enter valid user name
		loginPage.setUserName(userName);
		//enter invalid password
		loginPage.setPassword(password);
		//click on login button
		loginPage.clickOnLoginButton();
		//verify invalid password error message is displayed or not.
		boolean result = loginPage.verifyInvalidPasswordErrorMsgIsDisplayed(wait);
		//verifying using Assertion
		Assert.assertEquals(result, true);
	}
	
}
