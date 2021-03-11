import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class InvalidLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
		
		
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("http://automationpractice.com/");
		
		
		
		String signInXpath = "//a[contains(text(),'Sign in')]";
		WebElement signIn = driver.findElement(By.xpath(signInXpath));
		signIn.click();
		
		String emailInputId ="email";
		//Thread.sleep(3000);
		WebElement email = driver.findElement(By.id(emailInputId));
		email.click();
		email.clear();
		email.sendKeys("akashpatel@gmail.com");
		
		String passwordInputId = "passwd";
		WebElement password = driver.findElement(By.id(passwordInputId));
		password.click();
		password.clear();
		password.sendKeys("123456789");
		
		String signInButtonXpath ="//button[@id='SubmitLogin']/span";
		WebElement signInButton = driver.findElement(By.xpath(signInButtonXpath));
		signInButton.click();
		
		String errorXpath = "//li[contains(text(),'Authentication failed.')]";
		WebElement error = driver.findElement(By.xpath(errorXpath));
		String errorMessege = error.getText();
		if(errorMessege!=null) {
			System.out.println("Test case Passed");
		}
		else
			System.out.println("Test case failed");
	}

}
