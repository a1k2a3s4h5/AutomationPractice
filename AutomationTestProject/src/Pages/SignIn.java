package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignIn {
		
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Sign in')]")
	public WebElement homePageSignInButton;
	
	@FindBy(how=How.ID,using="email")
	public WebElement emailTextBox;
	
	@FindBy(how=How.ID,using="passwd")
	public WebElement passwordTextBox;
	
	@FindBy(how=How.XPATH,using="//button[@id='SubmitLogin']/span")
	public WebElement singInButton;
	
	@FindBy(how=How.XPATH , using ="//input[@id='email']//parent::div")
	public WebElement divTagOfEmail;
	
	public void setHomePageSignInButton() {
	homePageSignInButton.click();	
	}
	
	public void setEmailTextBox(String sendKeyValue) {
		emailTextBox.click();
		emailTextBox.clear();
		emailTextBox.sendKeys(sendKeyValue);
	}
	
	public void setPasswordTextBox(String sendKeyValue) {
		passwordTextBox.click();
		passwordTextBox.clear();
		passwordTextBox.sendKeys(sendKeyValue);	
	}
	
	public void setSignInButton() {
		homePageSignInButton.click();
	}
	
}
