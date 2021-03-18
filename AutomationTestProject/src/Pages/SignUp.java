package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUp {
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Sign in')]")
	public WebElement signIn;
	
	@FindBy(how=How.ID,using="id_gender1")
	public WebElement mr;
	
	@FindBy(how=How.ID,using="id_gender2")
	public WebElement mrs;

	@FindBy(how=How.ID,using="email_create")
	public WebElement createEmail;
	
	@FindBy(how=How.ID,using="SubmitCreate")
	public WebElement createAccount;

	@FindBy(how=How.XPATH,using="//div[@id='create_account_error']/ol/li")
	public WebElement createAccountError;
	
	/*
	 * @FindBy(how=How.ID,using="uniform-id_gender2") public WebElement mrs;
	 */

	@FindBy(how=How.ID,using="customer_firstname")
	public WebElement firstName;
	
	@FindBy(how=How.ID,using="firstname")
	public WebElement firstName2;
	
	@FindBy(how=How.ID,using="lastname")
	public WebElement lastName2;

	@FindBy(how=How.ID,using="customer_lastname")
	public WebElement lastName;

	@FindBy(how=How.ID,using="passwd")
	public WebElement password;

	@FindBy(how=How.ID,using="days")
	public WebElement day;

	@FindBy(how=How.ID,using="months")
	public WebElement month;

	@FindBy(how=How.ID,using="years")
	public WebElement year;

	@FindBy(how=How.ID,using="company")
	public WebElement company;

	@FindBy(how=How.ID,using="address1")
	public WebElement address;

	@FindBy(how=How.ID,using="city")
	public WebElement city;

	@FindBy(how=How.ID,using="id_state")
	public WebElement state;

	@FindBy(how=How.ID,using="postcode")
	public WebElement postCode;
	
	@FindBy(how=How.ID,using="phone_mobile")
	public WebElement phone;

	@FindBy(how=How.ID,using="alias")
	public WebElement aliasAddress;

	@FindBy(how=How.ID,using="submitAccount")
	public WebElement submitAccount;
	
	@FindBy(how=How.XPATH,using="//div[@class='header_user_info']//span")
	public WebElement profile;
	
	@FindBy(how=How.XPATH,using="//div[@class='alert alert-danger']/ol/li")
	public WebElement signinError;
	
	
}
