package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class proceedToCheckout {
	
	@FindBy(how=How.CLASS_NAME , using="login")
	public WebElement signIn;
	
	@FindBy(how=How.ID , using="email")
	public WebElement emailInput;
	
	@FindBy(how=How.ID , using="passwd")
	public WebElement passswordInput;
	
	@FindBy(how=How.ID , using="SubmitLogin")
	public WebElement submitButton;
	
	@FindBy(how=How.XPATH , using="//span[text()='2']")
	public WebElement dropDown;
	
	@FindBy(how=How.XPATH , using="//a[@id='button_order_cart']")
	public WebElement proceedToCheckoutButton;
	
	@FindBy(how=How.XPATH , using="//div[@id='layer_cart']//span[contains(text(),'Proceed to checkout')]")
	public WebElement proceedToCheckout2;
	
	@FindBy(how=How.XPATH , using="//p[@class='cart_navigation clearfix']//span[text()='Proceed to checkout']")
	public WebElement proceedToCheckout3;
	
	@FindBy(how=How.XPATH , using="//p[@class='cart_navigation clearfix']//span[text()='Proceed to checkout']")
	public WebElement proceedToCheckout4;
	
	@FindBy(how=How.XPATH , using="//p[@class='cart_navigation clearfix']//span[contains(text(),'Proceed to checkout')]")
	public WebElement proceedToCheckout5;
	
	@FindBy(how=How.ID , using="cgv")
	public WebElement checkBox ;
}
