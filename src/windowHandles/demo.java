package windowHandles;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class demo {
	@Test
	public void windowHandle() {

	System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM\\webdriver\\geckodriver.exe");
	WebDriver driver=new FirefoxDriver();//to launch browser
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://toolsqa.com/automation-practice-switch-windows/");//get URL
	
	//storing parent window
	String MainWindow=driver.getWindowHandle();
	System.out.println("Parent Page title:"+driver.getTitle());//verify main window
	
	//return all windows with String set
	Set <String>s=driver.getWindowHandles();
	//use iterator to switch within windows
	Iterator<String>i=s.iterator();
	
	//use while loops to compare between parent and child windows
	while(i.hasNext()) {
		
		String childWindows=i.next();
		
		if(!MainWindow.equalsIgnoreCase(childWindows)) {
			
			driver.switchTo().window(childWindows);
			//verify child window
			System.out.println("child windows:"+driver.getTitle());
			//close child windows
			driver.close();
		}
		
		//switch to parent window
		driver.switchTo().window(MainWindow);
		driver.quit();
	}
	
	
	
	
	}
	
	
	
}
