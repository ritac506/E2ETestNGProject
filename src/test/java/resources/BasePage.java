package resources;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BasePage {
	
	public WebDriver driver;//best practice to use driver globally for clean code and access of Webdriver for entire scope
	public Properties prop;
	
	public WebDriver InitDriver() throws IOException {
		
		
		
		 prop=new Properties();
		
		//System.getProperty("user.dir")  ==>prints dynamic current path to avoid hardcoding
		//we need to replace 'C:\\Users\\Rita\\eclipse-workspace\\E2EProject' to dynamic path
		//FileInputStream fis=new FileInputStream("C:\\Users\\Rita\\eclipse-workspace\\E2EProject\\src\\test\\java\\resources\\propertyFile");
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\propertyFile");

		prop.load(fis);
		
		
		
		//mvn test -Dbrowser=chrome
		
		//String browserName=System.getProperty("browser");
		String browserName=prop.getProperty("browser");
		
		
		if (browserName.equalsIgnoreCase("chrome"))
		{
			//we need to replace hard coding location on desktop to dynamic (other users) with System.getProperty("user.dir")
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\resources\\chromedriver.exe");
			
			driver = new ChromeDriver();
			
		}
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rita\\Pictures\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			//code
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;//we returning webdriver back so we can use them in test cases
	
	}
	public void screenShot(String result) throws IOException {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File("C:\\Users\\Rita\\eclipse-workspace\\E2EProject\\"+result+"screenshot.png"));
//		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(src, new File("C://test//"+result+"screenshot.png"));
	}


}
