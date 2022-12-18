package parabank_testautomation.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class BrowserManager{
	
	public static WebDriver GetDriver(String browserType,String url) {
		WebDriver driver=null;
		
		
		if(browserType.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srilatha\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
					
			}else if(browserType.equals("firefox")) {
				//driver=firefox();
				
			}
		driver.get(url);
		String expected="ParaBank | Accounts Overview";
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected);
		Common.log("Pass","url navigaated:" +url);
		return driver;
	}
	public static void CloseBrowser(WebDriver driver) {
		driver.quit();
		Common.log("info", "Driver Closed");
	}

	

}
