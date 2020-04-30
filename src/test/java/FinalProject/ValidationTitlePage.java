package FinalProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.BasePage;

public class ValidationTitlePage extends BasePage{
	
	private static final Logger log = (Logger) LogManager.getLogger(ValidationTitlePage.class.getName());
	
	
	
	@BeforeTest
	public void getLanding() throws IOException {
	driver = InitDriver();
	driver.get(prop.getProperty("url"));
	log.info("Driver is initialized");
	}
	
	@Test
	public void NavigateToFirstPage() throws IOException {
		
		LandingPage lp = new LandingPage(driver);
		//compare text from browser to actual value. In TestNG we use assertion methods
		String actual=lp.getTitle().getText();
		Assert.assertEquals(actual, "FEATURED COURSES");
		
		//validating that navigation bar is displayed
		lp.getNavbar();
		Assert.assertTrue(lp.getNavbar().isDisplayed());
		log.info("Navbar is displayed");
		
	}
	@AfterTest
	public void tearDown(){
		driver.close();
	}


	
}



