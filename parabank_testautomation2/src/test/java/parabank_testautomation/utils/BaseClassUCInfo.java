package parabank_testautomation.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClassUCInfo {
	protected WebDriver driver=null;
	protected String url="https://parabank.parasoft.com/parabank/index.htm";
	
	@BeforeSuite
	public void BeforeSuite1() {
		//configurations-chromedriver path settings
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srilatha\\Downloads\\chromedriver_win32\\chromedriver.exe");
      }
	
	

   
	@BeforeClass
	public void BeforeClass() {
		//1.open chrome
				driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				Common.log("info","Chrome Driver Invoked And maximized");
		
	}
	@AfterClass
	public void AfterClass() {
		 //driver.quit();
			//Reporter.log("Browser quit",true);
}
}