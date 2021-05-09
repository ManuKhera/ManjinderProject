package Academy.project;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.landingPage;
import resources.base;

public class validateTitle extends base {
	public WebDriver driver;
	public landingPage pj ;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest()
	public void beforetest() throws IOException {
		driver = initializedriver();
		driver.get(pro.getProperty("url"));
	}

	@Test()

	public void navigate() throws IOException {

		// .................landingPage.......................//
		pj= new landingPage(driver);
		Assert.assertEquals(pj.gettext().getText(), "FEATURED COURSES");
		log.info("Text is displayed");
		Assert.assertTrue(pj.bar().isDisplayed());
		log.info("bar is displayed");
	}
	public void headerText() throws IOException
	{
		Assert.assertEquals(pj.newText().getText(), "Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		log.info("Text is displayed");
		
		

	}

	@AfterTest()
	public void test() {
		driver.close();
	}

}
