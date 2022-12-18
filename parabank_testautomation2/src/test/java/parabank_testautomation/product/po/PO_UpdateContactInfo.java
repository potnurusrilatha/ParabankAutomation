package parabank_testautomation.product.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import parabank_testautomation.utils.Common;

public class PO_UpdateContactInfo {
	// 1st Section
				WebDriver driver;
				
				// 2nd Paramatrized Constructor
				public PO_UpdateContactInfo(WebDriver driver) {
					this.driver=driver;
			}
				//3rd Section: locators
				@FindBy(how=How.ID,using="FirstName")
				private WebElement  txtbx_FirstName;
				
				@FindBy(how=How.ID,using="LastName")
				private WebElement txtbx_LastName;
				
				@FindBy(how=How.ID,using="Address")
				private WebElement txtbx_Address;
				
				@FindBy(how=How.ID,using="City")
				private WebElement txtbx_City;
				
				@FindBy(how=How.ID,using="State")
				private WebElement txtbx_State;
				
				@FindBy(how=How.ID,using="Zip Code")
				private WebElement txtbx_ZipCode;
				
				@FindBy(how=How.ID,using="Phone")
				private WebElement txtbx_Phone;
				
				@FindBy(how=How.XPATH,using="//input[@value=' Update Profile ']")
				private WebElement btn_submit;
			
				@FindBy(how=How.XPATH,using="//div[@ng-if='showResult']")
				private WebElement dev_text_Profile_Updated;

		
				
				public void EnterTextInFristName(String text) {
					txtbx_FirstName.click();
					Common.log("info","FirstName Entered in text :" + text );
				}
				public void EnterTextInLastName(String text) {
					txtbx_LastName.click();
					Common.log("info","LastName Entered in text :" + text );
				}
				public void EnterTextInAddress(String address) {
					txtbx_Address.click();
					Common.log("info","Address Entered in text :" + address );
				}
				public void EnterTextInCity(String text) {
					txtbx_City.click();
					Common.log("info","City Entered in text :" + text );
				}
				public void EnterTextInState(String text) {
					txtbx_Address.click();
					Common.log("info","State Entered in text :" + text );
				}
				public void EnterTextInZipCode(String zipCode) {
					txtbx_ZipCode.click();
					Common.log("info","ZipCode Entered in text :" + zipCode );
				}
				public void EnterTextInPhone(String phone) {
					txtbx_Phone.click();
					Common.log("info","Phone Entered in text :" + phone );
				}
				public void ClickOnUpdateProfileButton() {
					btn_submit.click();
					Common.log("info","UpdateProfile Clicked :"  );
				}
				public void UpdateContactInfo(String FirstName ,String LastName,String Address,String City, String State ,String ZipCode,String Phone  )
				{
					EnterTextInFristName(FirstName);
					EnterTextInLastName(LastName);
					EnterTextInAddress(Address);
					EnterTextInCity(City);
					EnterTextInState(State);
					EnterTextInZipCode(ZipCode);
					EnterTextInPhone(Phone);
					ClickOnUpdateProfileButton();
					
					
				}
				public void ValidateUpdateProfileIsSuccessfull(String FirstName,String LastName, String Address,String City, String State ,String ZipCode,String Phone  ) {
					String actual_message_content= dev_text_Profile_Updated.getText();
					
					//Profile  Updated
					if(actual_message_content.equals("Profile Updated")) {
						Assert.assertEquals(true, "Profile Updated Message Is coming");
						Common.log("Pass","Profile Update Message Is coming"  );
					}
					else {
						Common.log("Fail","Profile Updated Message Is Not coming"  );
						Assert.assertEquals(false, "Profile Updated  Message Is Not coming");
						
					}
				   //FirstName
					if(actual_message_content.equals(FirstName)) {
						Assert.assertEquals(true, "FirsName Is Correctly Displayed");
					}
							
					else {
						Assert.assertEquals(false, "FirstName Is not Correctly Displayed");
						
					}
					//LastName
					if(actual_message_content.equals(LastName)) {
						Assert.assertEquals(true, "LastName Is Correctly Displayed");
					}
							
					else {
						Assert.assertEquals(false, "LastName Is not Correctly Displayed");
						
					}
					//Address
					if(actual_message_content.equals(Address)) {
						Assert.assertEquals(true, "Address Is Correctly Displayed");
					}
							
					else {
						Assert.assertEquals(false, "Address Is not Correctly Displayed");
						
					}
					//City
					if(actual_message_content.equals(City)) {
						Assert.assertEquals(true, " City Is Correctly Displayed");
					}
							
					else {
						Assert.assertEquals(false, " City Is not Correctly Displayed");
						
					}
					//State
					if(actual_message_content.equals(State)) {
						Assert.assertEquals(true, " State Is Correctly Displayed");
					}
							
					else {
						Assert.assertEquals(false, " state Is not Correctly Displayed");
						
					}
					//ZipCode
					if(actual_message_content.equals(ZipCode)) {
						Assert.assertEquals(true, " ZipCode Is Correctly Displayed");
					}
							
					else {
						Assert.assertEquals(false, " ZipCode Is not Correctly Displayed");
						
					}
					//Phone
					if(actual_message_content.equals(Phone)) {
						Assert.assertEquals(true, " Phone Is Correctly Displayed");
					}
							
					else {
						Assert.assertEquals(false, " Phone Is not Correctly Displayed");
						
					}
					
					
					
					
				}


}
