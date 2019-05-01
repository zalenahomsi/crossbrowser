package captcha;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CaptchaValidation  { 
	//declariing variables
	private WebDriver driver;
	private String baseURL=" https://www.in.ckgs.us/home/index";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\webdriver\\chromedriver.exe");
		 driver=new ChromeDriver();//to launch chrome browser
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		
		 
		 
	}
	
	@Test
	public void TestPageTitle() throws Exception { 
		 driver.get(baseURL);
			System.out.println("page title homepage:"+driver.getTitle());
		driver.findElement(By.xpath("//button[@title=\"Close (Esc)\"]")).click();
		 driver.findElement(By.xpath("//*[@id=\"home\"]/div[2]/header/div/div/div[6]/div/nav/ul[2]/li/a")).click();
		// Locate 'Current Passport Number' text box by cssSelector: tag and name attribute
		WebElement passportNo = driver.findElement(By.cssSelector("input[name='currentPassportNo']"));
		// Clear the default placeholder or any value present
		passportNo.clear();
		// Enter/type the value to the text box
		passportNo.sendKeys("123456789");
		//prompting user to enter captcha
		String captcha=JOptionPane.showInputDialog("Please enter the captcha value:");
		driver.findElement(By.id("recaptcha_response_field")).sendKeys(captcha);			
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception{
		driver.close();
	}

}
