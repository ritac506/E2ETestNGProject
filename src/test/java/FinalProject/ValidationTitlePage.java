package FinalProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.BasePage;

public class ValidationTitlePage extends BasePage{
	@Test
	public void NavigateToBasePage() throws IOException {
		driver = InitDriver();
		driver.get(prop.getProperty("url"));

		LandingPage lp = new LandingPage(driver);
		//compare text from browser to actual value. In TestNG we use assertion methods
		String actual=lp.getTitle().getText();
		Assert.assertEquals(actual, "FEATURED COURSES");
		
		//validating that navigation bar is displayed
		lp.getNavbar();
		Assert.assertTrue(lp.getNavbar().isDisplayed());
		
	}

	
}



