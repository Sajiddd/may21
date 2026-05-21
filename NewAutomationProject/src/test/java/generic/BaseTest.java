package generic;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bind.annotation.Default;

public class BaseTest implements InterfaceConstantVariables {

	public WebDriver driver;
	public WebDriverWait wait;
	
	@Parameters({"hubUrl","browserName"})
	@BeforeMethod
	public void openApp(String hubUrl,String browser) throws MalformedURLException
	{
//		//set the path of the driver executable file
//		WebDriverManager.chromedriver().setup();
//		//open the browser
//		driver=new ChromeDriver();
		
		//selenium grid integration. to run our test script on Remote Computer for Compatibility testing.
		URL url = new URL(hubUrl);
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName(browser);
		driver=new RemoteWebDriver(url,dc);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ITO));
		wait=new WebDriverWait(driver, Duration.ofSeconds(ETO));
		//enter the URL
		driver.get(appURL);
	}
	
	@AfterMethod
	public void closeApp() 
	{
		//close the application
		driver.close();
	}
}
