package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ContactUs {
	public WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//a[@title='Contact Us']")
	public WebElement contactUS;
	
	@FindBy(id="id_contact")
	public WebElement subHead;
	
	@FindBy(id="email")
	public WebElement emailInput;
	
	@FindBy(id="id_order")
	public WebElement orderRef;
	
	@FindBy(id="fileUpload")
	public WebElement fileUpload;
	
	@FindBy(id="message")
	public WebElement messege;

	@FindBy(id="submitMessage")
	public WebElement sendId;
	
	@FindBy(how = How.XPATH , using="//p[contains(text(),'Your message has been successfully')")
	public WebElement sucessMessege;
	
	public void setSubHeadid( ) {
		Select subHeadState = new Select(subHead);
		subHeadState.selectByVisibleText("Webmaster");
	}
	
	public void setContactUs() {
		contactUS.click();
	}
	
	public void setEmailID(String emailId) {
		emailInput.click();
		emailInput.clear();
		emailInput.sendKeys(emailId);
	}
	
	public void setInOrder(String orderRefValue) {
		orderRef.click();
		orderRef.clear();
		orderRef.sendKeys(orderRefValue);
	}
	
	public void setFileUpload(String path) {
	//leUploadId.click();
		//fileUploadId.clear();
		fileUpload.sendKeys(path);
	}
	
	public void setMessege(String userMessege) {
		messege.click();
		messege.clear();
		messege.sendKeys(userMessege);
	}

	public void setSubmitMessege() {
		sendId.click();
	}
	//public String subHeadId = "id_contact";
	//public String emailInputId ="email";
	//public String  ="id_order";
	//public String fileUploadId = "fileUpload";
	//public String messegeId = "message";
	//public String sendId = "submitMessage";
	//public String sucessMessegeXpath = "//p[contains(text(),'Your message has been successfully')]";
}
