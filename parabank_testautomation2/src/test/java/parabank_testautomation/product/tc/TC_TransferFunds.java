package parabank_testautomation.product.tc;

import org.openqa.selenium.support.PageFactory;

import parabank_testautomation.product.po.PO_Common;
import parabank_testautomation.product.po.PO_transferFunds;
import parabank_testautomation.utils.BaseClass;

public class TC_TransferFunds extends BaseClass{
	public void t_03_Transfer_funds() {
		
		String fromAccount="12456";
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
		oTransferFunds.ValidateTransferFundsIsSuccessfull(fromAccount, toAccount,amount);
		
		
	}

		  
}


