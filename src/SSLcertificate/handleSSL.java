package SSLcertificate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class handleSSL {
	@Test
	public void handleCertificate() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM\\webdriver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();//to lauunch browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://cacert.org/");
		
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver.close();
		
		
		
		
	}
	
	

}
