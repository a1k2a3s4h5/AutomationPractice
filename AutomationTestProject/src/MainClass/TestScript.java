package MainClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Pages.ContactUs;
import methods.Methods;
import utils.CreateBrowser;

public class TestScript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=CreateBrowser.openBrowser("Edge");
		Methods.maxWindow(driver);
		Methods.implicitWait(driver);
		driver.get("http://automationpractice.com/");
		ContactUs mainpage = PageFactory.initElements(driver, ContactUs.class);
	    mainpage.setContactUs();
	    mainpage.setSubHeadid();
	    mainpage.setEmailID("Akashpatel@fbdshj.com");
	    mainpage.setInOrder("103456");
	    mainpage.setFileUpload("C:\\Users\\akash.patel\\Desktop\\screenshot1.jpg");
	    mainpage.setMessege("Hey i have a complain");
	    mainpage.setSubmitMessege();
	}

}
