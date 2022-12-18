package parabank_testautomation.product.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import parabank_testautomation.utils.Common;

public class PO_CommonRLoan {
	// 1st Section
			WebDriver driver;
			
			// 2nd Paramatrized Constructor
			public PO_CommonRLoan(WebDriver driver) {
				this.driver=driver;
		}
			//3rd Section: locators
			@FindBy(how=How.LINK_TEXT,using="Request Loan")
			private WebElement link_Request_Loan;
			
				public void ClickOnRequestLoan() {
					link_Request_Loan.click();
					Common.log("Info","Request Loan Button Clicked");
				}

}
