package MainClass;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
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
import Pages.Header;
import Pages.SignIn;
import methods.Methods;
import utils.CreateBrowser;

public class TesstScriptForLogIn {

	public WebDriver driver;
	public SignIn mainpage;
    //public Header headerObject; 
    public FileInputStream fs;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
	
	@BeforeTest
	public void beforeTest() throws Exception {
		System.out.println("Am in beforeTest method");
		fs = new FileInputStream("C:\\Users\\akash.patel\\Desktop\\AutomationPractice\\Login.xlsx");
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheetAt(0);
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
		mainpage = PageFactory.initElements(driver, SignIn.class);
		mainpage.setHomePageSignInButton();
	}
	
	@Test(priority=1)
	public void inValidEmailSearch() throws InterruptedException{
		Row rowValid = sheet.getRow(8);
		Cell cellValid = rowValid.getCell(7);
		String validValuesFromExcel = cellValid.getStringCellValue();
		String[] validValues=validValuesFromExcel.split(",");
		/*
		 * for(int i=0;i<validValues.length;i++) { System.out.println(validValues[i]); }
		 */
		
		for(int i=0;i<validValues.length;i++) {
 			mainpage.setEmailTextBox(validValues[i]);
 			mainpage.setPasswordTextBox("");
		
			  if(mainpage.divTagOfEmail.getAttribute("class").contentEquals("form-group form-error")) {
			  System.out.println("Test case passed"); } else {
			  System.out.println("Test case failed"); }
			 
 		}
	}
	
	
	/*
	 * @Test(priority=2) public void invalidSearch() {
	 * 
	 * }
	 */
	 
	
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
