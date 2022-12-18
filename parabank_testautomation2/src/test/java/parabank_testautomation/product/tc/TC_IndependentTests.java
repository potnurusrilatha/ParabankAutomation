package parabank_testautomation.product.tc;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import parabank_testautomation.product.po.PO_RLoan;
import parabank_testautomation.product.po.PO_UpdateContactInfo;
import parabank_testautomation.product.po.PO_Common;
import parabank_testautomation.product.po.PO_CommonRLoan;
import parabank_testautomation.product.po.PO_CommonUCInfo;
import parabank_testautomation.product.po.PO_Login;
import parabank_testautomation.product.po.PO_transferFunds;

import parabank_testautomation.utils.BrowserManager;
import parabank_testautomation.utils.Common;

public class TC_IndependentTests {
	
	protected String url="https://parabank.parasoft.com/parabank/index.htm";
	
	@Test
	public void t_01_validate_url_is_working(){
		WebDriver driver=BrowserManager.GetDriver("chrome", url);
			String actual=driver.getTitle();
			String expected="ParaBank | Welcome | Online Banking";
			Assert.assertEquals(actual,expected);
			Common.log("Pass","Url navigated: " +url);
			
			}
	@Test
		
			
	public void t_02_validate_parabank_login() {
		
		WebDriver driver=BrowserManager.GetDriver("chrome",url);
		//3.intialize the Page Object
		PO_Login PO_Login=PageFactory.initElements(driver, PO_Login.class);
		PO_Login.LoginIntoParaBank("john","demo");
					
					
		}

	@Test	
	public void t_03_Transfer_funds() {
		
		
		//********************************************************
		//********************SETUP*******************************
		//********************************************************
		WebDriver driver=BrowserManager.GetDriver("chrome", url);
		PO_Login PO_Login=PageFactory.initElements(driver, PO_Login.class);
		PO_Common PO_Common=PageFactory.initElements(driver, PO_Common.class);
		
         //**************************************************************
		//********************ACTUAL STEPS*******************************
		//***************************************************************
		
		PO_Login.LoginIntoParaBank("john", "demo");
			
                    String fromAccount="12456";
					String toAccount="13344";
					String amount="100";
					
					//TransferFunds clicked
					
					PO_Common.ClickOnTransferFunds();
					
					//TransferFunds Operation
					PO_transferFunds oTransferFunds=PageFactory.initElements(driver, PO_transferFunds.class);
					oTransferFunds.ValidateTransferFundsIsSuccessfull(fromAccount, toAccount, amount);
					
					//validations
					oTransferFunds.ValidateTransferFundsIsSuccessfull(fromAccount, toAccount,amount);
					

					//********************************************************
					//********************CLEAN UP*******************************
					//********************************************************
					BrowserManager.CloseBrowser(driver);
					
				}
	
	
	
	@Test
	public void t_04_Update_Contact_Info() {
		WebDriver driver=BrowserManager.GetDriver("chrome", url);
		PO_Login PO_Login=PageFactory.initElements(driver, PO_Login.class);
		PO_CommonUCInfo PO_CommonUCInfo=PageFactory.initElements(driver, PO_CommonUCInfo.class);
		PO_Login.LoginIntoParaBank("john", "demo");
		
		String FirstName="john";
	    String LastName="demo";
	    String Address= "1431 Main St";
	    String City="Beverly Hills";
	    String State="CA";
	    String ZipCode="90210";
	    String Phone="310-447-4121";
	    
	  //Update Profile Clicked
	    PO_UpdateContactInfo uUpdateProfile=PageFactory.initElements(driver, PO_UpdateContactInfo.class);
		uUpdateProfile.EnterTextInFristName("john");
		uUpdateProfile.EnterTextInLastName("demo");
		uUpdateProfile.EnterTextInAddress("1431 Main St");
		uUpdateProfile.EnterTextInCity("Beverly Hills");
		uUpdateProfile.EnterTextInState("CA");
		uUpdateProfile.EnterTextInZipCode("90210");
		uUpdateProfile.EnterTextInPhone("310-447-4121");
		uUpdateProfile.ClickOnUpdateProfileButton();
		
		//validations
		uUpdateProfile.ValidateUpdateProfileIsSuccessfull(FirstName,LastName,Address,City,State,ZipCode,Phone);
	    
		
		
		
	}
					  
	@Test
	public void t_05_Request_loan() {
		
		WebDriver driver=BrowserManager.GetDriver("chrome", url);
		PO_Login PO_Login=PageFactory.initElements(driver, PO_Login.class);
		PO_CommonRLoan PO_CommonRLoan=PageFactory.initElements(driver, PO_CommonRLoan.class);
		PO_Login.LoginIntoParaBank("john", "demo");
		
					String LoanAmount="100000";
					String DownPayment="5000";
					String FromAccount="13344";
					
					//Apply for a loan Clicked
					PO_RLoan PO_CommonRLoan1=PageFactory.initElements(driver, PO_RLoan.class);
					PO_CommonRLoan1.ClickOnApplyNowButton();
		
					//Amount Operations
					PO_RLoan  aApplyNow=PageFactory.initElements(driver, PO_RLoan.class);
					aApplyNow.EnterTextInLoanAmount("100000");
					aApplyNow.EnterTextInDownPayment("5000");
					aApplyNow.SelectAccountFrom("13344");
					aApplyNow.ClickOnApplyNowButton();

		
					//validations
					aApplyNow.ValidateApplyNowIsSuccessfull(FromAccount,LoanAmount,DownPayment);
					BrowserManager.CloseBrowser(driver);
		
		
	}
}
	