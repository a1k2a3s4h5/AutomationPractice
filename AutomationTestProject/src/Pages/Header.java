package Pages;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Header {

	public WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//header[@id='header']//div[@class='row']/a")
	public WebElement header;
	
	@FindBy(how=How.XPATH ,using="//a[@title='My Store']")
	public WebElement logo;
	
	@FindBy(id="search_query_top")
	public WebElement searchBar;
	
	@FindBy(how=How.XPATH, using="//button[@name='submit_search']")
	public WebElement searchButton;
	
	@FindBy(how=How.XPATH , using="//a[@title='View my shopping cart']")
	public WebElement cartBox;
	
	/*
	 * public void setHeader() { header.click(); }
	 */
	
	public void setLogo() {
		logo.click();
	}
	
	public void setSearchbar(String searchValue) {
		searchBar.click();
		searchBar.clear();
		searchBar.sendKeys(searchValue);
	}
	
	public void setSearchButton() {
		searchButton.click();
	}
	
	public void setCartBox(WebDriver driver) {
		Actions newAction = new Actions(driver);
		newAction.moveToElement(cartBox).click().perform();
	}
	
}
