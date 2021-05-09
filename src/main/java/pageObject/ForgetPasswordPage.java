package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPasswordPage {
	WebDriver driver;
	public ForgetPasswordPage(WebDriver driver)
	{
	this.driver=driver;
	}
	By email=By.cssSelector("input[id='user_email']");
	By Sendme=By.cssSelector("input[type='submit']");
	
	
	public WebElement email()
	{
		return driver.findElement(email);
	}
	public  WebElement sendme()
	{
		 return driver.findElement(Sendme);
		 
	
		
	}
	
}
