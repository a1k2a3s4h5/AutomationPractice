import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class InvalidSignUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		driver.get("http://automationpractice.com/");
		
		String signInXpath = "//a[contains(text(),'Sign in')]";
		WebElement signIn = driver.findElement(By.xpath(signInXpath));
		signIn.click();
		
		String emailInputId = "email_create";
		WebElement emailInput = driver.findElement(By.id(emailInputId));
		emailInput.click();
		emailInput.clear();
		emailInput.sendKeys("akash@gmail.com");
		
		String createAnAccountId = "SubmitCreate";
		WebElement createAccount = driver.findElement(By.id(createAnAccountId));
		createAccount.click();
		
		String errorXpath = "//li[contains(text(),'An account using this')]";
		WebElement error = driver.findElement(By.xpath(errorXpath));
		String errorMessege = error.getText();
		if(errorMessege!=null) {
			System.out.println("Test case Passed");
		}
		else
			System.out.println("Test case failed");
	}

}
