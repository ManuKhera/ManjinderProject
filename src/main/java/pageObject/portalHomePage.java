package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalHomePage {
	WebDriver driver;
	public portalHomePage(WebDriver driver)
	{
	this.driver=driver;
	}
	By email=By.cssSelector("input[id='user_email']");
	By password=By.cssSelector("input[id='user_password']");
	By login=By.cssSelector("input[name='commit']");
	By forgetpassword=By.cssSelector("a[class='link-below-button']");
	
	public WebElement email()
	{
		return driver.findElement(email);
	}
	public WebElement password()
	{
		return driver.findElement(password);
	}
	public WebElement login()
	{
		return driver.findElement(login);
	}
	public ForgetPasswordPage forget()
	{
		driver.findElement(forgetpassword).click();
		return new ForgetPasswordPage(driver); 
	}
	
}
