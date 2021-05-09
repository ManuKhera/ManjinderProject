package Academy.project;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgetPasswordPage;
import pageObject.LoginPage;
import pageObject.landingPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest()
	public void beforetest() throws IOException
	{
		driver=initializedriver();
		log.info("driver is initialized");
		
	}
	@Test(dataProvider="getdata")

	public void navigate(String username, String password) throws IOException, InterruptedException {
		driver.get(pro.getProperty("url"));
		log.info("url is open");
	

		
		//.................landingPage.......................//
		landingPage pj=new landingPage(driver);
		
		pj.sign().click();
		if(pj.popupsize()>0)
		{
			pj.popup().click();
		}
		//..................LoginPage..........................//
		LoginPage lg=new LoginPage(driver);
		
		lg.email().sendKeys(username);
		lg.password().sendKeys(password);
		lg.login().click();
		ForgetPasswordPage fp=lg.forget();
		fp.email().sendKeys(username);
		fp.sendme().click();
		
	}
	
		@DataProvider
		public Object[][] getdata()
		{
			Object[][] data = new Object[2][2];									//			int data[];
										//			data=new int[];
		data[0][0]="manukhattra13@gmail.com";
		data[0][1]="123456";
		data[1][0]="raminder@gmail.com";
		data[1][1]="789456";
		return data;
		}
		@AfterTest()
		public void test()
		{
			driver.close();
		}
}
