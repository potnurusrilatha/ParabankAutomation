package parabank_testautomation.product.tc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import parabank_testautomation.product.po.PO_Common;
import parabank_testautomation.product.po.PO_Login;
import parabank_testautomation.product.po.PO_transferFunds;

import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;


public class TC_Login {
	WebDriver driver=null;
	String url="https://parabank.parasoft.com/parabank/index.htm";
	
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
				Reporter.log("Chrome Driver Invoked And maximized",true);
		
	}
	@AfterClass
	public void AfterClass() {
		 driver.quit();
			Reporter.log("Browser quit",true);
		
		
	}
	
@Test
	public void t_01_validate_url_is_working(){

		//2.Navigate to URL
		driver.get(url);
		String actual=driver.getTitle();
		String expected="ParaBank | Welcome | Online Banking";
		Assert.assertEquals(actual,expected);
		Reporter.log("Url navigated: " +url,true);
		
		}
	
		
@Test
			public void t_02_validate_parabank_login() {

			    
				
				//3.intialize the Page Object
				PO_Login obj=PageFactory.initElements(driver, PO_Login.class);
				obj.EnterUserName("john");
				obj.EnterPassword("demo");
				obj.ClicksubmitButton();
				
				
				//6.Validation-Title
				String expected="ParaBank | Accounts Overview";
				String actual=driver.getTitle();
				Assert.assertEquals(actual, expected);
				
				if(expected.equals(actual)) {
					System.out.println("login Successfull.");
					Assert.assertTrue(true);
					Reporter.log("Page Title Correctly Displayed",true);
				}else {
					System.out.println("loging failed.");
					Reporter.log("Page Title not Displayed",true);
					Assert.assertTrue(false);
					
				}
	}
			
@Test
			public void t_03_transfer_funds() {
				
				String fromAccount="13344";
				String toAccount="13344";
				String amount="100";
				//TransferFunds clicked
				PO_Common oPO_Common=PageFactory.initElements(driver, PO_Common.class);
				oPO_Common.ClickOnTranferFunds();
				
				//TransferFunds Operation
				PO_transferFunds oTransferFunds=PageFactory.initElements(driver, PO_transferFunds.class);
				oTransferFunds.EnterTextInAmount("100");
				oTransferFunds.SelectAccountFrom("13344");
				oTransferFunds.SelectAccountto("13344");
				oTransferFunds.ClickOnTransferFundsButton();
				
				//validations
				oTransferFunds.ValidateTransferFundsIsSuccessfull(fromAccount, toAccount,amount);
				
				
			}

				  
}
