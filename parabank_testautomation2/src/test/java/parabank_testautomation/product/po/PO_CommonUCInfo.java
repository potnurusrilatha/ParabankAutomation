package parabank_testautomation.product.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import parabank_testautomation.utils.Common;

public class PO_CommonUCInfo {
	// 1st Section
				WebDriver driver;
				
				// 2nd Paramatrized Constructor
				public PO_CommonUCInfo(WebDriver driver) {
					this.driver=driver;
			}
				//3rd Section: locators
				@FindBy(how=How.LINK_TEXT,using="Update Contact Info")
				private WebElement link_Update_Contact_Info;
				
					public void ClickOnUpdateContactInfo() {
						link_Update_Contact_Info.click();
						Common.log("Info","Update Contact info Button Clicked");
					}


}
