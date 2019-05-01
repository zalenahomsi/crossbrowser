package parallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserScript {
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser)throws Exception{
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM\\webdriver\\geckodriver-v0.24.0-win32\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\webdriver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
	}
	
	@Test
	public void testMultipleBrowser() {
		driver.get("http://demo.guru99.com/V4/");
		//Find user name
				driver.findElement(By.name("uid")).sendKeys("guru99");
			//Find password
		driver.findElement(By.name("password")).sendKeys("guru99");
				
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
