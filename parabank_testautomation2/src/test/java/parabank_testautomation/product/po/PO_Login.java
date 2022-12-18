package parabank_testautomation.product.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


import parabank_testautomation.utils.Common;



public class PO_Login extends Common  {
	
	   // 1st Section
		WebDriver driver;
		
		// 2nd Paramatrized Constructor
		public PO_Login(WebDriver driver) {
			this.driver=driver;
	}
		//3rd Section: locators
		@FindBy(how=How.NAME,using="username")
		private WebElement txtbx_username;
		
		@FindBy(how=How.NAME,using="password")
		private WebElement txtbx_password;
		
		@FindBy(how=How.XPATH,using="//*[@id=\"loginPanel\"]/form/div[3]/input") 
		private WebElement btn_submit;
		
		//4th section -methods
		public void EnterUserName(String text) {
			txtbx_username.sendKeys(text);
			Common obj =new Common();
			Common.log("Info", "Username entered:" + text);
		}
		public void EnterPassword(String text) {
			txtbx_password.sendKeys(text);
			Common obj=new Common();
			Common.log("Info", "Password entered:" + text);
		}
		public void ClicksubmitButton() {
			btn_submit.click();
			Common.log("Info","Submit Button Clicked");
			
			}
		
		//*********KW Layer **********//
		
		
		public void LoginIntoParaBank(String u,String p)
		{
			EnterUserName(u);
			EnterPassword(p);
			ClicksubmitButton();
			//6.Validation-Title
			String expected="ParaBank | Accounts Overview";
			String actual=driver.getTitle();
			Assert.assertEquals(actual, expected);
			
			if(expected.equals(actual)) {
				System.out.println("login Successfull.");
				Assert.assertTrue(true);
				Common.log("Pass","Page Title Correctly Displayed");
			}else {
				System.out.println("loging failed.");
			Common.log("Fail","Page Title not Displayed");
				Assert.assertTrue(false);
				
			}
		}
		
}
		
		
		
		
		
	


