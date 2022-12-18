package parabank_testautomation.product.tc;

import org.openqa.selenium.support.PageFactory;


import parabank_testautomation.product.po.PO_UpdateContactInfo;

import parabank_testautomation.utils.BaseClass;
import parabank_testautomation.utils.BaseClassUCInfo;

public class TC_UpdateContactInfo extends BaseClassUCInfo {
public void t_05_Update_Contact_Info() {
	
	    String FirstName="john";
	    String LastName="demo";
	    String Address= "1431 Main St";
	    String City="Beverly Hills";
	    String State="CA";
	    String ZipCode="90210";
	    String Phone="310-447-4121";
		
		
		//Update Profile clicked
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


}
