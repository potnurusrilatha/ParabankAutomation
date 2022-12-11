package parabank_testautomation.product.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PO_Common {
	// 1st Section
			WebDriver driver;
			
			// 2nd Paramatrized Constructor
			public PO_Common(WebDriver driver) {
				this.driver=driver;
		}
			//3rd Section: locators
			@FindBy(how=How.LINK_TEXT,using="Tranfer Funds")
			private WebElement link_transfer_funds;
			
				public void ClickOnTranferFunds() {
					link_transfer_funds.click();
				}

}
