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

			//Navigate to URL
			driver.get(url);
			String actual=driver.getTitle();
			String expected="ParaBank | Welcome | Online Banking";
			Assert.assertEquals(actual,expected);
			Common.log("Pass","Url navigated: " +url);
		
		}

@Test
	
		
public void t_02_validate_parabank_login() {

			    
				
				//intialize the Page Object
				PO_Login obj=PageFactory.initElements(driver, PO_Login.class);
				//Enter UserName
				obj.EnterUserName("john");
				//Enter Password
				obj.EnterPassword("demo");
				// Click Submit Button
				obj.ClicksubmitButton();
				
				
				//Validation-Title
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
	
				//Enter fromAccount
				String fromAccount="13344";
				//Enter toAccount
				String toAccount="13344";
				//Enter amount
				String amount="100";
				//Intialize the Page Object
				PO_Common oPO_Common=PageFactory.initElements(driver, PO_Common.class);
				//TransferFunds clicked
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
	
	            //Enter the FirstName
				String FirstName="john";
				//Enter the LastName
				String LastName="demo";
				//Enter the Address
				String Address= "1431 Main St";
				//Enter the City
				String City="Beverly Hills";
				//Enter the State
				String State="CA";
				//Enter the Zipcode
				String ZipCode="90210";
				//Enter the Phone
				String Phone="310-447-4121";
	
				//Intialize the Page Object
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
	
	            //Enter the LoanAmount
				String LoanAmount="10000";
				 //Enter the DownAmount
				String DownPayment="500";
				 //Enter the FromAccount
				String FromAccount="13344";
				//Intialize the Page Object
				PO_RLoan oPO_CommonRLoan=PageFactory.initElements(driver, PO_RLoan.class);
				//Apply for a loan Clicked
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

	
	
	
	
	
	


