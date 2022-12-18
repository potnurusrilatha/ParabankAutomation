package parabank_testautomation.product.tc;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import parabank_testautomation.product.po.PO_RLoan;
import parabank_testautomation.product.po.PO_UpdateContactInfo;
import parabank_testautomation.product.po.PO_Common;
import parabank_testautomation.product.po.PO_Login;
import parabank_testautomation.product.po.PO_transferFunds;
import parabank_testautomation.utils.BaseClass;
import parabank_testautomation.utils.Common;

import org.testng.Assert;

public class TC_Login extends BaseClass {
	
	
@Test
public void t_01_validate_url_is_working(){

			//2.Navigate to URL
			driver.get(url);
			String actual=driver.getTitle();
			String expected="ParaBank | Welcome | Online Banking";
			Assert.assertEquals(actual,expected);
			Common.log("Pass","Url navigated: " +url);
		
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
					Common.log("Pass","Page Title Correctly Displayed");
				}else {
					System.out.println("loging failed.");
				Common.log("Fail","Page Title not Displayed");
					Assert.assertTrue(false);
					
				}
	}

@Test	
public void t_03_Transfer_funds() {
				
				String fromAccount="13344";
				String toAccount="13344";
				String amount="100";
				//TransferFunds clicked
				PO_Common oPO_Common=PageFactory.initElements(driver, PO_Common.class);
				oPO_Common.ClickOnTransferFunds();
				
				//TransferFunds Operation
				PO_transferFunds oTransferFunds=PageFactory.initElements(driver, PO_transferFunds.class);
				oTransferFunds.EnterTextInAmount("100");
				oTransferFunds.SelectAccountFrom("13344");
				oTransferFunds.SelectAccountto("13344");
				oTransferFunds.ClickOnTransferFundsButton();
				
				//validations
				oTransferFunds.ValidateTransferFundsIsSuccessfull(fromAccount,toAccount,amount);
				
				
			}


@Test
public void t_04_Update_Contact_Info() {
	
				String FirstName="john";
				String LastName="demo";
				String Address= "1431 Main St";
				String City="Beverly Hills";
				String State="CA";
				String ZipCode="90210";
				String Phone="310-447-4121";
	
				// Apply for Update Profile
				PO_UpdateContactInfo oPO_CommonUCInfo=PageFactory.initElements(driver, PO_UpdateContactInfo.class);
				oPO_CommonUCInfo.ClickOnUpdateProfileButton();
	
				//Update Profile operations
	
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
	
				String LoanAmount="10000";
				String DownPayment="500";
				String FromAccount="13344";
				//Apply for a loan Clicked
				PO_RLoan oPO_CommonRLoan=PageFactory.initElements(driver, PO_RLoan.class);
				oPO_CommonRLoan.ClickOnApplyNowButton();
	
				//Amount Operations
				PO_RLoan  aApplyNow=PageFactory.initElements(driver, PO_RLoan.class);
				aApplyNow.EnterTextInLoanAmount("100000");
				aApplyNow.EnterTextInDownPayment("5000");
				aApplyNow.SelectAccountFrom("13344");
				aApplyNow.ClickOnApplyNowButton();

	
				//validations
				aApplyNow.ValidateApplyNowIsSuccessfull(FromAccount,LoanAmount,DownPayment);
				
	
	
}

	
}

	
	
	
	
	
	


