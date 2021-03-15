package MainClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.addTocart;
import methods.Methods;
import utils.CreateBrowser;

public class addToCartButtonWorking {

	public WebDriver driver;
	public addTocart obj;
	
	@BeforeTest
	public void beforeTest() throws Exception {

	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Am in beforeClass method");	
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browser) {
		driver=CreateBrowser.openBrowser(browser);
		Methods.maxWindow(driver);
		Methods.implicitWait(driver);
		driver.get("http://automationpractice.com/");
		obj = PageFactory.initElements(driver, addTocart.class);
		obj.womenCategory.click();
	}
	
	@Test
	public void buttonTest() {
		Actions actions=new Actions(driver);
        actions.moveToElement(obj.tShirt).moveToElement(obj.addToCartButton).click().perform();
	//	
	}

	
	@AfterMethod
	public void afterMethod() {
		
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Am in beforeClass method");	
	}
	
	@AfterTest
	public void afterTest() throws Exception {

	}
	
}
