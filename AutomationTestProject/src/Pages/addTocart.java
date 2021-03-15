package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class addTocart {

	@FindBy(how=How.XPATH,using="//a[text()='Women']")
	public WebElement womenCategory;
	
	@FindBy(how=How.XPATH,using="//img[@alt='Faded Short Sleeve T-shirts']")
	public WebElement tShirt;
	
	@FindBy(how=How.XPATH,using="//a[@class='button ajax_add_to_cart_button btn btn-default']/span[text()='Add to cart']")
	public WebElement addToCartButton;
}
