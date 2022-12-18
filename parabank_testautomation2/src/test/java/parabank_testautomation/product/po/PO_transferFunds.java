package parabank_testautomation.product.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import parabank_testautomation.utils.Common;

public class PO_transferFunds {
	// 1st Section
			WebDriver driver;
			
			// 2nd Paramatrized Constructor
			public PO_transferFunds(WebDriver driver) {
				this.driver=driver;
		}
			/*//3rd Section: locators
			@FindBy(how=How.NAME,using="Transfer Funds")
			private WebElement link_transfer_funds;
			
				public void ClickOnTranferFunds() {
					link_transfer_funds.click();
				}*/
			
				//3rd Section: locators
				@FindBy(how=How.ID,using="amount")
				private WebElement  txtbx_amount;;
				
				@FindBy(how=How.ID,using="fromAccountId")
				private WebElement drop_down_from_account;
				
				@FindBy(how=How.ID,using="toAccountId")
				private WebElement drop_down_to_account;
				
				@FindBy(how=How.XPATH,using="//input[@value=' Transfer Funds']")
				private WebElement btn_submit;
				
				@FindBy(how=How.XPATH,using="//div[@ng-scope='showResult']")
				private WebElement dev_text_transfer_success_message;
				
				
				public void EnterTextInAmount(String text) {
					txtbx_amount.click();
					Common.log("info","Amount Entered in text :" + text );
				}
				public void SelectAccountFrom(String text) {
					Select list =new Select (drop_down_from_account);
					list.selectByVisibleText(text);
					Common.log("info","From Account Selected as :" + text );
				}
				public void SelectAccountto(String text) {
					Select list =new Select (drop_down_to_account);
					list.selectByVisibleText(text);
					Common.log("info","To Account Selected as :" + text );
				}
				public void ClickOnTransferFundsButton() {
					btn_submit.click();
					Common.log("info","Transfer Button Clicked :"  );
				}
				
				public void TransferFunds(String amount,String from,String to)
				{
					EnterTextInAmount(amount);
					SelectAccountFrom(from);
					SelectAccountto(to);
					ClickOnTransferFundsButton();
					
					
				}
				public void ValidateTransferFundsIsSuccessfull(String fromAccount,String ToAccount, Object amount) {
					String actual_message_content= dev_text_transfer_success_message.getText();
					
					//Transfer Complete Message
					if(actual_message_content.equals("Transfer Complete!")) {
						Assert.assertEquals(true, "Transfer Funds Message Is coming");
						Common.log("Pass","Transfer Complete!Message Is coming"  );
					}
							
					else {
						Common.log("Fail","Transfer Complete!Message Is Not coming"  );
						Assert.assertEquals(false, "Transfer Funds Message Is Not coming");
						
					}
					//From Account
					if(actual_message_content.equals(fromAccount)) {
						Assert.assertEquals(true, "From Account Is Correctly Displayed");
					}
							
					else {
						Assert.assertEquals(false, "From Account Is not Correctly Displayed");
						
					}
					//To Account
					if(actual_message_content.equals(ToAccount)) {
						Assert.assertEquals(true, "To Account Is Correctly Displayed");
					}
							
					else {
						Assert.assertEquals(false, "To Account Is not Correctly Displayed");
						
					}
					
					//Amount
					if(actual_message_content.equals(amount)) {
						Assert.assertEquals(true, "Amount Is correctly displayed");
					}
							
					else {
						Assert.assertEquals(false, "Amount Is  not correctly displayed");
						
					}
					
				}

}
