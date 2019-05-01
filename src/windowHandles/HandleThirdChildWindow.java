package windowHandles;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HandleThirdChildWindow {
	

	@Test
	
	public void windowHandleTest() {
		System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM\\webdriver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();//to lauunch browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.naukri.com/");//get URL
		
	//verify main window page title
		System.out.println("homepage title:"+driver.getTitle());
		
	//storing main window id with window handles
		String MainWindow=driver.getWindowHandle();
		
		//Storing all child windows with set 
		Set<String>s=driver.getWindowHandles();
		
		//use iterator to switch between windows
		Iterator <String> i=s.iterator();
		
		// print the count of windows
		System.out.println(s.size());
		
		String firstwin=i.next();//main window
		String secondwin=i.next();//first window
		String thirdwin=i.next();//2nd window
		String fouthwin=i.next();//3rd window
		
		
		driver.switchTo().window(fouthwin);
		System.out.println("third window page title:"+driver.getTitle());
				
				
				
				
				
				
				
				
				
				
				
	}

}
