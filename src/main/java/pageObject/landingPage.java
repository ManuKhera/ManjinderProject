package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
		public WebDriver driver;
		public landingPage(WebDriver driver) 
		{
			this.driver=driver;
		}
		private By signin=By.xpath("//span[contains(text(),'Login')]");
		private By gettext=By.xpath("//div[@class='text-center']/h2");
		private By bar=By.xpath("//div[@class='container']/nav/ul");
		private By newText=By.xpath("//div[@class='row']/div/p");
		private By popup=By.xpath("//button[contains(text(),'NO THANKS')]");
		
		public WebElement sign()
		{
			return driver.findElement(signin);
			
		}
		public WebElement gettext()
		{
			return driver.findElement(gettext);
		}
		public WebElement bar()
		{
			return driver.findElement(bar);
		}
		public WebElement newText()
		{
			return driver.findElement(newText);
		}
		public int popupsize()
		{
			return driver.findElements(popup).size();
		}
		public WebElement popup()
		{
			return driver.findElement(popup);
		}
		
		
}
