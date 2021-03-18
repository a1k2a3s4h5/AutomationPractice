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
import org.testng.annotations.DataProvider;
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
		fs = new FileInputStream("C:\\Users\\akash.patel\\Desktop\\AutomationPractice\\Homepage_main_section_test_cases.xlsx");
		//workbook = new XSSFWorkbook(fs);
		//sheet = workbook.getSheetAt(0);
	}
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver=CreateBrowser.openBrowser(browser);
		Methods.maxWindow(driver);
		Methods.implicitWait(driver);
		driver.get("http://automationpractice.com/");
		headerObject = new Header(driver);//PageFactory.initElements(driver, Header.class);
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		
	}
	
	@DataProvider (name = "data-provider1")
	    public Object[] validSearchData(){
	    return new Object[] {"Dress","kurties","Pants"};
	}
	
	@DataProvider (name = "data-provider2")
    public Object[] invalidSearchData(){
    return new Object[] {"Hii","how are you","kem cho","Majama"};
    }
	
	@Test(priority=1 ,dataProvider="data-provider1")
	public void validSearch(String validVals){
		headerObject.header.click();
		headerObject.setLogo();
		/*
		 * Row rowValid = sheet.getRow(15); Cell cellValid = rowValid.getCell(5); String
		 * validValuesFromExcel = cellValid.getStringCellValue(); String[]
		 * validValues=validValuesFromExcel.split(",");
		 * //System.out.println(cellValid.getStringCellValue()); for(String
		 * ref:validValues) {
		 */
 			headerObject.setSearchbar(validVals);
 			headerObject.setSearchButton();
			/* } */
	}
	
	@Test(priority=2 , dataProvider="data-provider2")
	public void invalidSearch(String inValidVals) {
		headerObject.header.click();
		headerObject.setLogo();
		/*
		 * Row rowInValid = sheet.getRow(19); Cell cellInValid = rowInValid.getCell(5);
		 * String inValidValuesFromExcel = cellInValid.getStringCellValue(); String[]
		 * validInValues=inValidValuesFromExcel.split(","); for(String
		 * ref:validInValues) {
		 */
 			headerObject.setSearchbar(inValidVals);
 			headerObject.setSearchButton();
			/* } */
	}
	
	@AfterMethod
	public void afterMethod() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Am in afterTest method");
	}

	//headerObject.setCartBox(driver);
}
