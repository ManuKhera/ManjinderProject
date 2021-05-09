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

public class validateBar extends base{
	public WebDriver driver;
	landingPage pj;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest()
	public void beforetest() throws IOException
	{
		driver=initializedriver();
		log.info("driver is initialized");
		driver.get(pro.getProperty("url"));
		log.info("url is open");
	}
	
	
	@Test()

	public void navigate() throws IOException {

	

	
		//.................landingPage.......................//
		pj=new landingPage(driver);
		
		
		Assert.assertTrue(pj.bar().isDisplayed());
		log.info("successfully display");
		
}
	@AfterTest()
	public void test()
	{
		driver.close();
	}
}
