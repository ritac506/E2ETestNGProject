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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BasePage {

	public WebDriver driver;// best practice to use driver globally for clean code and access of Webdriver
							// for entire scope
	public Properties prop;

	public WebDriver InitDriver() throws IOException {
		
		
		
		 prop=new Properties();
		
		//System.getProperty("user.dir")  ==>prints dynamic current path to avoid hardcoding
		//we need to replace 'C:\\Users\\Rita\\eclipse-workspace\\E2EProject' to dynamic path
		//FileInputStream fis=new FileInputStream("C:\\Users\\Rita\\eclipse-workspace\\E2EProject\\src\\test\\java\\resources\\propertyFile");
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\propertyFile");

		prop.load(fis);
		
		
		
		//mvn test -Dbrowser=chrome : this we run from cmd and choose the browser, so we don't have to use propertyFile file
		
		//String browserName=System.getProperty("browser"); // for some reasons it didn't work
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		
		if (browserName.equalsIgnoreCase("chrome"))
				{
		
			//we need to replace hard coded location on desktop to dynamic (other users) with System.getProperty("user.dir")
			//first, i placed chromedriver.exe inside the project
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rita\\eclipse-workspace\\E2EProject\\src\\test\\java\\resources\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\resources\\chromedriver.exe");
		
			//to run tests in headless mode, we need to create ChromeOptions object
			ChromeOptions options=new ChromeOptions();//ex: we want to run in headless mode
			
			if (browserName.contains("headless"))
			{
			options.addArguments("--headless"); //run from cmd and check, it should run in backend		
			//	options.setHeadless(true);
			}
			driver = new ChromeDriver(options);//we pass variable of ChromeOptions object if we want some action, driver well recognize it and execute
			
		}
		else if (browserName.equals("firefox"))
		{
			//same manipulations as with chromedriver.exe
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\java\\resources\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			//IE code
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;//we returning webdriver back so we can use them in test cases
	
	}

	public void screenShot(String result) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\Rita\\eclipse-workspace\\E2EProject\\" + result + "screenshot.png"));
//		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(src, new File("C://test//"+result+"screenshot.png"));
	}

}
