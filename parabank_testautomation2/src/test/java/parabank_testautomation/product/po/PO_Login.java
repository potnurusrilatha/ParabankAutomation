package parabank_testautomation.product.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class PO_Login {
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
		}
		public void EnterPassword(String text) {
			txtbx_password.sendKeys(text);
		}
		public void ClicksubmitButton() {
			btn_submit.click();
			
		}
		
		
		
		
		
		
	}


