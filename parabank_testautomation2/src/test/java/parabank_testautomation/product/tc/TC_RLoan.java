package parabank_testautomation.product.tc;

import org.openqa.selenium.support.PageFactory;

import parabank_testautomation.product.po.PO_RLoan;


import parabank_testautomation.utils.BaseClassRLoan;

public class TC_RLoan extends BaseClassRLoan{
public void t_04_Request_LOan() {
		
				String LoanAmount="100000";
				String DownPayment="5000";
				String FromAccount="13344";
		
		//RequestLoan clicked
				PO_RLoan oPO_CommonRLoan=PageFactory.initElements(driver, PO_RLoan.class);
				oPO_CommonRLoan.ClickOnApplyNowButton();
		
		
		// Amount Operation
		PO_RLoan aApplyNow=PageFactory.initElements(driver, PO_RLoan.class);
		
		aApplyNow.EnterTextInLoanAmount("100000");
		aApplyNow.EnterTextInDownPayment("5000");
		aApplyNow.SelectAccountFrom("13344");
		aApplyNow.ClickOnApplyNowButton();

		
		//validations
		aApplyNow.ValidateApplyNowIsSuccessfull(FromAccount,LoanAmount,DownPayment);
		
		
	}

}
