package MainClass;

import org.testng.annotations.Test;

import Pages.proceedToCheckout;
import methods.Methods;
import utils.CreateBrowser;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class ProceedToCheckoutTestScript {
  
  public WebDriver driver;
  public proceedToCheckout obj;
	
  @Test
  public void f() {
	  
	  obj.signIn.click();
	  obj.emailInput.sendKeys("vaishvi@123.c");
	  obj.passswordInput.sendKeys("1234567890");
	  obj.submitButton.click();
	  Actions action = new Actions(driver);
	  action.moveToElement(obj.dropDown).moveToElement(obj.proceedToCheckoutButton).click().perform();
	  obj.proceedToCheckout2.click();
	  obj.proceedToCheckout3.click();
	  obj.proceedToCheckout4.click();
	  obj.checkBox.click();
	  obj.proceedToCheckout5.click();
  }
  
  @Parameters("browser")
  @BeforeMethod
  public void beforeMethod(String browser) {
	    driver=CreateBrowser.openBrowser(browser);
		Methods.maxWindow(driver);
		Methods.implicitWait(driver);
		driver.get("http://automationpractice.com/");
		obj = PageFactory.initElements(driver, proceedToCheckout.class);
  }

  @AfterMethod
  public void afterMethod() {
	  
  }

  @BeforeClass
  public void beforeClass() {
	  
  }

  @AfterClass
  public void afterClass() {
	  
  }

  @BeforeTest
  public void beforeTest() {
	  
  }

  @AfterTest
  public void afterTest() {
	  
  }

}
