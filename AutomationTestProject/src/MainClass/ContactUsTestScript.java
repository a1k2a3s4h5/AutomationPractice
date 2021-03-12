package MainClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.ContactUs;
import methods.Methods;
import utils.CreateBrowser;

public class ContactUsTestScript {

	public WebDriver driver;
	public ContactUs mainpage;
	@BeforeTest
	public void beforeTest() {
		System.out.println("Am in beforeTest method");
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
		mainpage = PageFactory.initElements(driver, ContactUs.class);
	}
	
	@Test(priority=1)
	public void contactUsWithFillUpAllDetails(){
	    mainpage.setContactUs();
	    mainpage.setSubHeadid();
	    mainpage.setEmailID("Akashpatel@fbdshj.com");
	    mainpage.setInOrder("103456");
	    mainpage.setFileUpload("C:\\Users\\akash.patel\\Desktop\\screenshot1.jpg");
	    mainpage.setMessege("Hey i have a complain");
	    mainpage.setSubmitMessege();
	}
	
	@Test(priority=2)
	public void contactUsWIthNotFillingUpEmailAddress() {
		
	    mainpage.setContactUs();
	    mainpage.setSubHeadid();
	    //mainpage.setEmailID("Akashpatel@fbdshj.com");
	    mainpage.setInOrder("103456");
	    mainpage.setFileUpload("C:\\Users\\akash.patel\\Desktop\\screenshot1.jpg");
	    mainpage.setMessege("Hey i have a complain");
	    mainpage.setSubmitMessege();
	}
	@Test(priority=3)
	public void contactUsWithNotFillingOrderReferenceAndAttachFile() {
		mainpage.setContactUs();
	    mainpage.setSubHeadid();
	    mainpage.setEmailID("Akashpatel@fbdshj.com");
	    //mainpage.setInOrder("103456");
	    //mainpage.setFileUpload("C:\\Users\\akash.patel\\Desktop\\screenshot1.jpg");
	    mainpage.setMessege("Hey i have a complain");
	    mainpage.setSubmitMessege();
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Am in afterClass method");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Am in afterTest method");
	}

}
