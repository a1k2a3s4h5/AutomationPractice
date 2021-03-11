package MainClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import methods.Methods;
import Pages.Header;
import utils.CreateBrowser;

public class TestScriptOfHeader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver=CreateBrowser.openBrowser("Edge");
		Methods.maxWindow(driver);
		Methods.implicitWait(driver);
		driver.get("http://automationpractice.com/");
		
		Header headerObject = PageFactory.initElements(driver, Header.class);
		headerObject.setHeader();
		headerObject.setLogo();
		
		FileInputStream fs = new FileInputStream("C:\\Users\\akash.patel\\Desktop\\Homepage_main_section_test_cases.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row rowValid = sheet.getRow(15);
		Cell cellValid = rowValid.getCell(5);
		String validValuesFromExcel = cellValid.getStringCellValue();
		String[] validValues=validValuesFromExcel.split(",");
		//System.out.println(cellValid.getStringCellValue());
 		for(String ref:validValues) {
 			headerObject.setSearchbar(ref);
 			headerObject.setSearchButton();
 		}
 		Row rowInValid = sheet.getRow(19);
		Cell cellInValid = rowInValid.getCell(5);
		String inValidValuesFromExcel = cellInValid.getStringCellValue();
		String[] validInValues=inValidValuesFromExcel.split(",");
		for(String ref:validInValues) {
 			headerObject.setSearchbar(ref);
 			headerObject.setSearchButton();
 		}
		
		headerObject.setCartBox(driver);
	}

}
