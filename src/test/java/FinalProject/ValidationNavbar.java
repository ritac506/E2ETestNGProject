package FinalProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.BasePage;

public class ValidationNavbar extends BasePage {
	@Test
	public void NavigateToBasePage() throws IOException {
		driver = InitDriver();
		driver.get(prop.getProperty("url"));

		LandingPage lp = new LandingPage(driver);
		
		
		//validating that navigation bar is displayed
		lp.getNavbar();
		Assert.assertTrue(lp.getNavbar().isDisplayed());
		
	}


}
