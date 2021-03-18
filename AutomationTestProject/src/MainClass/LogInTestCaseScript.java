package MainClass;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.SignIn;
import methods.Methods;
import utils.CreateBrowser;

public class LogInTestCaseScript {

	public WebDriver driver;
	public SignIn mainpage;
    //public Header headerObject; 
    public FileInputStream fs;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    
    @DataProvider (name = "data-provider")
    public Object[][] loginNames(){
    return new Object[][] {{"Snia@fdsjhv.kjbfdsf.dfdsh","Raman@123"},{"123vv23$@.com","Raman#123"} , {"123vv23$@.com","Raman32123"},{"123vv23$@.com","Raman43123"},{"123vv23$@.com","Ramands23"}};
    }
    
    @DataProvider (name = "data-provider2")
    public Object[][] validLoginNames(){
    return new Object[][] {{"vaishvi@123.c","1234567890"},{"vsdhfj@gmail.com","Akash@123"},{"Snia@fdsjhv.kjbfdsf.dfdsh","Raman@123"}};
    }
	
	@BeforeTest
	public void beforeTest() throws Exception {
		System.out.println("Am in beforeTest method");
		fs = new FileInputStream("C:\\Users\\akash.patel\\Desktop\\AutomationPractice\\Login.xlsx");
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheetAt(0);
	}
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		System.out.println("Am in beforeClass method");	
		driver=CreateBrowser.openBrowser(browser);
		Methods.maxWindow(driver);
		Methods.implicitWait(driver);
		driver.get("http://automationpractice.com/");
		mainpage = PageFactory.initElements(driver, SignIn.class);
		mainpage.setHomePageSignInButton();
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browser) {
		
	}
	
	@Test(priority=1 , dataProvider="data-provider")
	public void inValidEmailSearch(String userName , String password) throws InterruptedException{
		Row rowValid = sheet.getRow(8);
		Cell cellValid = rowValid.getCell(7);
		String validValuesFromExcel = cellValid.getStringCellValue();
		String[] validValues=validValuesFromExcel.split(",");
		/*
		 * for(int i=0;i<validValues.length;i++) { System.out.println(validValues[i]); }
		 */
 			mainpage.setEmailTextBox(userName);
 			mainpage.setPasswordTextBox(password);
			/*
			 * if(mainpage.divTagOfEmail.getAttribute("class").
			 * contentEquals("form-group form-error")) {
			 * System.out.println("Test case passed"); } else {
			 * System.out.println("Test case failed"); }
			 */
			 mainpage.submitButton.click();
			 Assert.assertEquals(mainpage.errorMessege.getText(), "Invalid email address.");
 			
 		
	}
	
	
	
	  @Test(priority=2 , dataProvider="data-provider2") 
	  public void validLogin(String username , String password) {
		    mainpage.setEmailTextBox(username);
			mainpage.setPasswordTextBox(password);
			mainpage.submitButton.click();
			Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Return to Home']")).isDisplayed(),true);
	  }
	 
	 
	
	@AfterMethod
	public void afterMethod() {
		//driver.quit();
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Am in afterClass method");
		driver.quit();
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Am in afterTest method");
	}

}
