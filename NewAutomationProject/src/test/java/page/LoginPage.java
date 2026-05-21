package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//POM class for faceBook page.
//for each web page we should create respective POM class.
public class LoginPage 
{
	//storing or declaring the web elements in the POM class
	@FindBy(id = "username")
	private WebElement userNameTextBox;
	
	@FindBy(name = "password")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[text()='Your username is invalid!']")
	private WebElement invalidUserNameErrorMsg;
	
	@FindBy(xpath = "//div[text()='Your password is invalid!']")
	private WebElement invalidPasswordErrorMsg;
	
	//initializing the web elements using constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilizing the web elements using getters/setters methods.
	public void setUserName(String userName)
	{
		userNameTextBox.sendKeys(userName);
	}
	
	public void setPassword(String password)
	{
		passwordTextBox.sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	//verifying invalidUserNameErrorMsg is displayed or not
		public boolean verifyInvalidUserNameErrorMsgIsDisplayed(WebDriverWait wait)
		{
			try
			{
				wait.until(ExpectedConditions.visibilityOf(invalidUserNameErrorMsg));
				return true;
			}
			catch (Exception e) {
				return false;
			}
		}
	
	//verifying invalidPasswordErrorMsg `is displayed or not
	public boolean verifyInvalidPasswordErrorMsgIsDisplayed(WebDriverWait wait)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(invalidPasswordErrorMsg));
			return true;
		}
		catch (Exception e) {
			return false;
		}
		
	}
}
