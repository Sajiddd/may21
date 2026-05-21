package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	
	@FindBy(xpath = "//strong[text()='Congratulations student. You successfully logged in!']")
	private WebElement homePageMsg;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/* method that waits till the page is loaded and 
	 * then verifies homePageMsg is displayed or not. by verifying the title of the page.
	 */
	public boolean verifyHomePageMsgIsDisplayed(WebDriverWait wait, String expectedTitle) 
	{
		try 
		{
			wait.until(ExpectedConditions.titleContains(expectedTitle));
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
		
	}
}
