import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUp {

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
		
		String genderId = "uniform-id_gender1";
		WebElement gender = driver.findElement(By.id(genderId));
		gender.click();
		
		String customerFirstNameId = "customer_firstname";
		WebElement customerFirstName = driver.findElement(By.id(customerFirstNameId));
		customerFirstName.click();
		customerFirstName.clear();
		customerFirstName.sendKeys("Akash");
		
		String customerLastNameId = "customer_lastname";
		WebElement customerLastName = driver.findElement(By.id(customerLastNameId));
		customerLastName.click();
		customerLastName.clear();
		customerLastName.sendKeys("Akash");
		
		String passwordInputId = "passwd";
		WebElement password = driver.findElement(By.id(passwordInputId));
		password.click();
		password.clear();
		password.sendKeys("123456789");
		
		Select selectSt = new Select(driver.findElement(By.id("days")));
		selectSt.selectByValue("3");
		
		Select selectSt1 = new Select(driver.findElement(By.id("months")));
		selectSt1.selectByValue("2");
		
		Select selectSt2 = new Select(driver.findElement(By.id("years")));
		selectSt2.selectByValue("2021");
		
		String checkBox1Id = "newsletter";
		WebElement checkBox1 = driver.findElement(By.id(checkBox1Id));
		checkBox1.click();
		
		String checkBox2Id = "optin";
		WebElement checkBox2 = driver.findElement(By.id(checkBox2Id));
		checkBox2.click();
		
		String companyId = "company";
		WebElement company = driver.findElement(By.id(companyId));
		company.click();
		company.clear();
		company.sendKeys("Gateways");
		
		String addressId = "address1";
		WebElement address = driver.findElement(By.id(addressId));
		address.click();
		address.clear();
		address.sendKeys("B-81 , corporate house , judges bunglow road ,bodakdev");
		
		String address2Id = "address2";
		WebElement address2 = driver.findElement(By.id(address2Id));
		address2.click();
		address2.clear();
		address2.sendKeys("B-81 , corporate house , judges bunglow road ,bodakdev");
		
		String cityId = "city";
		WebElement city = driver.findElement(By.id(cityId));
		city.click();
		city.clear();
		city.sendKeys("Godhra");
		
		Select selectSt3 = new Select(driver.findElement(By.id("id_state")));
		selectSt3.selectByVisibleText("Colorado");
		
		String postCodeId = "postcode";
		WebElement postCode = driver.findElement(By.id(postCodeId));
		postCode.click();
		postCode.clear();
		postCode.sendKeys("38934");
		
//		Select selectSt4 = new Select(driver.findElement(By.id("id_country")));
//		selectSt4.selectByVisibleText("Colorado");
		
		String addInfoId = "other";
		WebElement addInfo = driver.findElement(By.id(addInfoId));
		addInfo.click();
		addInfo.clear();
		addInfo.sendKeys("Nothing");
		
		String phoneNoId = "phone";
		WebElement phoneNo = driver.findElement(By.id(phoneNoId));
	   	phoneNo.click();
	   	phoneNo.clear();
	   	phoneNo.sendKeys("08565897852");
	   	
	   	String mobilePhoneId = "phone_mobile";
	   	WebElement mobilePhone = driver.findElement(By.id(mobilePhoneId));
	   	mobilePhone.click();
	   	mobilePhone.clear();
	   	mobilePhone.sendKeys("9687963179");
	   	
	   	String aliasAddressId = "alias";
	   	WebElement aliasAddress = driver.findElement(By.id(aliasAddressId));
	   	aliasAddress.click();
	   	aliasAddress.clear();
	   	aliasAddress.sendKeys("Hiii I am B-81");

	   	String submitId = "submitAccount";
	   	WebElement submit = driver.findElement(By.id(submitId));
	   	submit.click();
		
	   	
	}

}
