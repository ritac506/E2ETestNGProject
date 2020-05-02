package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	
	private By loginButton=By.xpath("//span[contains(text(),'Login')]");
	private By featCourses=By.cssSelector(".text-center>h2");
	private By navbar=By.xpath("//nav[@class='navbar-collapse collapse']");
	private By header=By.xpath("//h3[contains(text(),'An Academy to learn Everything about Testing')]");
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public WebElement getLogin()
	{
		return driver.findElement(loginButton);
	}
	
	public WebElement checkFeatCourses()
	{
		return driver.findElement(featCourses);
	}
	
	public WebElement getNavbar()
	{
		return driver.findElement(navbar);
	}
	public WebElement validateHeader()
	{
		return driver.findElement(header);
	}
	
	

}
