import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		driver.get("http://automationpractice.com/");
		String contactUsXpath = "//a[@title='Contact Us']";
		WebElement contactUs = driver.findElement(By.xpath(contactUsXpath));
		contactUs.click();
		
		String subHeadId = "id_contact";
		Select subHead = new Select(driver.findElement(By.id(subHeadId)));
		subHead.selectByVisibleText("Webmaster");
		
		String emailInputId ="email";
		//Thread.sleep(3000);
		WebElement email = driver.findElement(By.id(emailInputId));
		email.click();
		email.clear();
		email.sendKeys("akashpatel");
		
		String orderRefId ="id_order";
		//Thread.sleep(3000);
		WebElement orderRef = driver.findElement(By.id(orderRefId));
		orderRef.click();
		orderRef.clear();
		orderRef.sendKeys("12345");
		
		String fileUploadId = "fileUpload";
		WebElement fileUpload = driver.findElement(By.id(fileUploadId));
		fileUpload.sendKeys("C:\\Users\\akash.patel\\Desktop\\screenshot1.jpg");
		
		String messegeId = "message";
		WebElement messege = driver.findElement(By.id(messegeId));
		messege.sendKeys("Hey I have complain.");
		
		String sendId = "submitMessage";
		WebElement send = driver.findElement(By.id(sendId));
		send.click();
		
		String sucessMessegeXpath = "//p[contains(text(),'Your message has been successfully')]";
		WebElement successMessege = driver.findElement(By.xpath(sucessMessegeXpath));
		String successMessegeText = successMessege.getText();
		if(successMessegeText!=null){
			System.out.println("Test case passed");
		}
		else
			System.out.println("Test case failed");	
	}

}
