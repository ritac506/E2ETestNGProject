package FinalProject;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import resources.BasePage;

public class HomePage_Test extends BasePage {
	
	@BeforeTest
	public void getLanding() throws IOException {
	driver = InitDriver();

	}

	@Test(dataProvider = "getData")
	public void NavigateToBasePage(String username, String password) throws IOException {
		
		driver.get(prop.getProperty("url"));

		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();

		LoginPage log = new LoginPage(driver);

		log.getEmail().sendKeys(username);
		log.getPassword().sendKeys(password);
		log.getSubmit().click();
	}
	@AfterTest
	public void tearDown(){
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		// first brackets stand for ROW=> how many sets should run (two sets of data==>
		// index will be 2)
		// second brackets stand for COLUMN=> how many values we sending for one set
		// (two values: username and passowrd) also index 2
		Object[][] data = new Object[2][2];

		// first row
		data[0][0] = "rie@asdf.com";
		data[0][1] = "1234";

		data[1][0] = "qwer@asfr.com";
		data[1][1] = "3456";

		return data;
	}
	


}
