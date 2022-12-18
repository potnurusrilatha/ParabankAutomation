package parabank_testautomation.product.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import parabank_testautomation.utils.Common;
import parabank_testautomation.utils.CommonRLoan;

public class PO_RLoan {
	WebDriver driver;
	// 2nd Paramatrized Constructor
				public PO_RLoan(WebDriver driver) {
					this.driver=driver;
				}	
					//3rd Section: locators
					@FindBy(how=How.ID,using="LoanAmount")
					private WebElement  txtbx_LoanAmount;
					
					@FindBy(how=How.ID,using="DownPayment")
					private WebElement txtbx_DownPayment;
					
					@FindBy(how=How.ID,using="FromAccount	")
					private WebElement drop_down_From_account;
					
					@FindBy(how=How.XPATH,using="//input[@value=' Apply Now ']")
					private WebElement btn_submit;
					
					@FindBy(how=How.XPATH,using="//div[@ng-If='showResult']")
					private WebElement dev_text_Loan_Request_Processed;

					
					
					public void EnterTextInLoanAmount(String text) {
						txtbx_LoanAmount.click();
						CommonRLoan.log("info","LoanAmount Entered in text :" + text );
					}
					public void EnterTextInDownPayment(String text) {
						txtbx_DownPayment.click();
						CommonRLoan.log("info","DownPayment Entered in text :" + text );
					}
					
					public void SelectAccountFrom(String text) {
						Select list =new Select (drop_down_From_account);
						list.selectByVisibleText(text);
						CommonRLoan.log("info","From Account Selected as :" + text );
					}
					public void ClickOnApplyNowButton() {
						btn_submit.click();
						CommonRLoan.log("info","Apply Now Button Clicked :"  );
					}
					
							public void ApplyNow(String LoanAmount,String DownPayment,String FromAccount)
							{
								EnterTextInLoanAmount(LoanAmount);
								EnterTextInDownPayment(DownPayment);
								SelectAccountFrom(FromAccount);
								ClickOnApplyNowButton();
								
								
							}
							public void ValidateApplyNowIsSuccessfull(Object amount,String fromAccount,Object amount1) {
								String actual_message_content= dev_text_Loan_Request_Processed.getText();
								
								//Loan Amount Complete Message
								if(actual_message_content.equals("Loan RequestProcessed")) {
									Assert.assertEquals(true, " Loan Request Message Is coming");
									Common.log("Pass","Loan RequestProcessed Message Is coming"  );
								}
										
								else {
									Common.log("Fail","Loan RequestProcessed Message Is Not coming"  );
									Assert.assertEquals(false, "Loan RequestProcessed Message Is Not coming");
									
								}
								//Amount
								if(actual_message_content.equals(amount)) {
									Assert.assertEquals(true, "Amount Is correctly displayed");
								}
										
								else {
									Assert.assertEquals(false, "Amount Is  not correctly displayed");
									
								}
								//Loan Amount
								if(actual_message_content.equals(amount1)) {
									Assert.assertEquals(true, "Amount Is correctly displayed");
								}
										
								else {
									Assert.assertEquals(false, "Amount Is  not correctly displayed");
									
								}
								
							  //From  Account
								if(actual_message_content.equals(fromAccount)) {
									Assert.assertEquals(true, "From Account Is Correctly Displayed");
								}
										
								else {
									Assert.assertEquals(false, "From Account Is not Correctly Displayed");
									
								}
								
							}
							

}		
							
						
						



