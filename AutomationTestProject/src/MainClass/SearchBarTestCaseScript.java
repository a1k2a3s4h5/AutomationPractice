package MainClass;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

import methods.Methods;
import Pages.ContactUs;
import Pages.Header;
import utils.CreateBrowser;

public class SearchBarTestCaseScript {

	public WebDriver driver;
	public ContactUs mainpage;
    public Header headerObject; 
    public FileInputStream fs;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    
	@BeforeTest
	public void beforeTest() throws Exception {
		System.out.println("Am in beforeTest method");
		fs = new FileInputStream("C:\\Users\\akash.patel\\Desktop\\AutomationPractice\\Homepage_main_section_test_cases.xlsx");
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
		headerObject = PageFactory.initElements(driver, Header.class);
	}
	
	@Test(priority=1)
	public void validSearch(){
		headerObject.header.click();
		headerObject.setLogo();
		Row rowValid = sheet.getRow(15);
		Cell cellValid = rowValid.getCell(5);
		String validValuesFromExcel = cellValid.getStringCellValue();
		String[] validValues=validValuesFromExcel.split(",");
		//System.out.println(cellValid.getStringCellValue());
 		for(String ref:validValues) {
 			headerObject.setSearchbar(ref);
 			headerObject.setSearchButton();
 		}
	}
	
	@Test(priority=2)
	public void invalidSearch() {
		headerObject.header.click();
		headerObject.setLogo();
		Row rowInValid = sheet.getRow(19);
		Cell cellInValid = rowInValid.getCell(5);
		String inValidValuesFromExcel = cellInValid.getStringCellValue();
		String[] validInValues=inValidValuesFromExcel.split(",");
		for(String ref:validInValues) {
 			headerObject.setSearchbar(ref);
 			headerObject.setSearchButton();
 		}
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

	//headerObject.setCartBox(driver);
}
