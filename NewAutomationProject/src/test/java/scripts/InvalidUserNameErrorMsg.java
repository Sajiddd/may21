package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class InvalidUserNameErrorMsg extends BaseTest
{
	@Test(priority = 2)
	public void testInvalidUserNameErrorMsg()
	{
		//data drive the test method
		String userName=Excel.getData(Excel_Path, "invalidUserNameErrorMsg", 1, 0);
		String password=Excel.getData(Excel_Path, "invalidUserNameErrorMsg", 1, 1);
		
		LoginPage loginPage=new LoginPage(driver);
		//enter invalid user name
		loginPage.setUserName(userName);
		//enter valid password
		loginPage.setPassword(password);
		//click on login button
		loginPage.clickOnLoginButton();
		//verify invalid user name error message is displayed or not
		boolean result = loginPage.verifyInvalidUserNameErrorMsgIsDisplayed(wait);
		//verifying using Assertion
		Assert.assertEquals(result, true);
	}
}
