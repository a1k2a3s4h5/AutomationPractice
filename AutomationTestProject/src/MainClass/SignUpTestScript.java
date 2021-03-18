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
		  if(rowValid.getCell(0).getStringCellValue().contentEquals("Mr.")) {
			  obj.mr.click();
		  }
		  else {
			  obj.mrs.click();
		  }
		  
		  obj.firstName.sendKeys(rowValid.getCell(1).getStringCellValue());
		  obj.lastName.sendKeys(rowValid.getCell(2).getStringCellValue());
		  obj.password.sendKeys(rowValid.getCell(3).getStringCellValue());
		  obj.firstName2.sendKeys(rowValid.getCell(1).getStringCellValue());
		  obj.lastName2.sendKeys(rowValid.getCell(2).getStringCellValue());
		  obj.company.sendKeys(rowValid.getCell(9).getStringCellValue());
		  obj.address.sendKeys(rowValid.getCell(10).getStringCellValue());
		  obj.city.sendKeys(rowValid.getCell(11).getStringCellValue());
		  Select stateSelect= new Select (obj.state);
		  stateSelect.selectByVisibleText(rowValid.getCell(12).getStringCellValue());
		  obj.postCode.sendKeys(String.valueOf((int)(rowValid.getCell(13).getNumericCellValue())));
			/*
			 * Select countrySelect= new Select (obj.state);
			 * countrySelect.selectByVisibleText(rowValid.getCell(14).getStringCellValue());
			 */
		  obj.phone.sendKeys(String.valueOf((long)(rowValid.getCell(16).getNumericCellValue())));
		  obj.aliasAddress.sendKeys(rowValid.getCell(17).getStringCellValue());
		  
		  Select daySelect = new Select(obj.day);
		  //System.out.println(String.valueOf((int)(rowValid.getCell(4).getNumericCellValue())));
		  daySelect.selectByValue(String.valueOf((int)(rowValid.getCell(4).getNumericCellValue())));  
		  Select monthSelect = new Select(obj.month);
		  monthSelect.selectByVisibleText(rowValid.getCell(5).getStringCellValue());
		  Select yearSelect = new Select(obj.year);
		  yearSelect.selectByValue(String.valueOf((int)(rowValid.getCell(6).getNumericCellValue())));
		  
		  obj.submitAccount.click();
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
