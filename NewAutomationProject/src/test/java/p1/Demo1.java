package p1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1 {
	
	@Test(priority = 1)
	public void test()
	{
		//set the path of chromeDriver executable file
		WebDriverManager.chromedriver().setup();
		//open the browser
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.com");
		String title=driver.getTitle();
		Reporter.log(title,true);
		Reporter.log("my first maven project",true);
	}

}
