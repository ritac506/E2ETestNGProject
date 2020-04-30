package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	
	public WebDriver driver;//best practice to use driver globally for clean code and access of Webdriver for entire scope
	public Properties prop;
	
	public WebDriver InitDriver() throws IOException {
		
		
		
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Rita\\eclipse-workspace\\E2EProject\\src\\test\\java\\resources\\propertyFile");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if (browserName.equals("firefox"))
		{
			//code
		}
		else
		{
			//code
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;//we returning webdriver back so we can use them in test cases
	
	}


}
