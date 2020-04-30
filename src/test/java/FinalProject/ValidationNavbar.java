package FinalProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.BasePage;

//To do in TestNG project:

// adding xml file==> right click on project, TestNG, convert to TestNG,click next,ok
// adding sure fire plugin in pom.xml ==>'<artifactId>maven-surefire-plugin</artifactId>' (testng.xml)
// run test from cmd mvn commands (get in project directory, mvn compile, mvn test)
// adding logs (log4j)==> add 'org.apache.logging.log4j' dependency to pom.xml (trace, error)(log.info, debug, fatal, error)
// generating html reports
// screenshot on failure
// Jenkins integration


public class ValidationNavbar extends BasePage {
	
	@BeforeTest
	public void getLanding() throws IOException {
	driver = InitDriver();
	driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void NavigateToBasePage() throws IOException {
		

		LandingPage lp = new LandingPage(driver);
		
		
		//validating that navigation bar is displayed
		lp.getNavbar();
		Assert.assertTrue(lp.getNavbar().isDisplayed());
		
	}
	@AfterTest
	public void tearDown(){
		driver.close();
	}



}
