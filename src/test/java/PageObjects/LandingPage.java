package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By loginButton=By.xpath("//span[contains(text(),'Login')]");
	private By title=By.cssSelector(".text-center>h2");
	private By navbar=By.xpath("//nav[@class='navbar-collapse collapse']");
	
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public WebElement getLogin()
	{
		return driver.findElement(loginButton);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavbar()
	{
		return driver.findElement(navbar);
	}
	
	

}
