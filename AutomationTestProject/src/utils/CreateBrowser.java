package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateBrowser {
 public static WebDriver openBrowser(String browserName) {
	if(browserName.equalsIgnoreCase("Edge")){
		System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
		return(new EdgeDriver());
	}
	return null;
 }
}
