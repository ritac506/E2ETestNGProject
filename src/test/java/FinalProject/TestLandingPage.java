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


//To do in TestNG project:

//adding xml file==> right click on project, TestNG, convert to TestNG,click next,ok
//adding sure fire plugin in pom.xml ==>'<artifactId>maven-surefire-plugin</artifactId>' (testng.xml)
//run test from cmd mvn commands (get in project directory, mvn compile, mvn test)
//adding logs (log4j)==> add 'org.apache.logging.log4j' dependency to pom.xml (trace, error)(log.info, debug, fatal, error)
//generating html reports
//screenshot on failure
//Jenkins integration

public class TestLandingPage extends BasePage{
	
	private static final Logger log = (Logger) LogManager.getLogger(TestLandingPage.class.getName());
	
	
	
	@BeforeTest
	public void getLanding() throws IOException {
	driver = InitDriver();
	driver.get(prop.getProperty("url"));
	log.info("Driver is initialized");
	}
	
	LandingPage lp;
	
	
	@Test(testName = "checking Featured Courses message")
	public void Test1() throws IOException {
		
		 lp = new LandingPage(driver);
		//compare text from browser to actual value. In TestNG we use assertion methods
		String actual=lp.getTitle().getText();
		Assert.assertEquals(actual, "FEATURED COURSES");
		
		
	}
	@Test (testName=" checking navigation bar")
	public void validateTitle() throws IOException {
		
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



