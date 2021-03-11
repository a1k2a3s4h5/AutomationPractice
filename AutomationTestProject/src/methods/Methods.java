package methods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Methods {

	
	public static void maxWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public static void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
}
