package MainClass;

import org.testng.annotations.Test;

import Pages.SignUp;
import methods.Methods;
import utils.CreateBrowser;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class SignUpTestScript {
  
	public WebDriver driver;
	public SignUp obj;
	public FileInputStream fs;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	
  @Test
  public void f() {
	  obj.createEmail.sendKeys("xyzwtz@gmail.com");
	  obj.createAccount.click();
	  for(int i=1;i<2;i++) {
		  Row rowValid = sheet.getRow(i);
		  Select daySelect = new Select(obj.day);
		  //System.out.println(String.valueOf((int)(rowValid.getCell(4).getNumericCellValue())));
		  daySelect.selectByValue(String.valueOf((int)(rowValid.getCell(4).getNumericCellValue())));  
		  Select monthSelect = new Select(obj.month);
		  monthSelect.selectByVisibleText(rowValid.getCell(5).getStringCellValue());
		  Select yearSelect = new Select(obj.year);
		  yearSelect.selectByValue(String.valueOf((int)(rowValid.getCell(6).getNumericCellValue())));
	  }
	  
	  
  }
  
  @Parameters("browser")
  @BeforeMethod
  public void beforeMethod(String browser) {
	    driver=CreateBrowser.openBrowser(browser);
		Methods.maxWindow(driver);
		Methods.implicitWait(driver);
		driver.get("http://automationpractice.com/");
		obj= PageFactory.initElements(driver, SignUp.class);
		obj.signIn.click();
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() throws Exception {
	    fs = new FileInputStream("C:\\Users\\akash.patel\\Desktop\\AutomationPractice\\DummyExcelForScript.xlsx");
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheetAt(0);
  }

  @AfterClass
  public void afterClass() {
  }

}
