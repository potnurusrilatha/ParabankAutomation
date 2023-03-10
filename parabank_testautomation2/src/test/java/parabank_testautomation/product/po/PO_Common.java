package parabank_testautomation.product.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import parabank_testautomation.utils.Common;

public class PO_Common {
	// 1st Section
			WebDriver driver;
			
			// 2nd Paramatrized Constructor
			public PO_Common(WebDriver driver) {
				this.driver=driver;
		}
			//3rd Section: locators
			@FindBy(how=How.LINK_TEXT,using="Transfer Funds")
			private WebElement link_transfer_funds;
			
				public void ClickOnTransferFunds() {
					link_transfer_funds.click();
					//Common.log("Info","Transfer Funds Button Clicked");
				}

}
