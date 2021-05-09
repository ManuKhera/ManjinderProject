package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	
	public WebDriver driver;
	public Properties pro;
	
	 public WebDriver initializedriver() throws IOException
	 {	
		 pro=new Properties();
		 FileInputStream fis=new FileInputStream("C:\\Users\\ramin\\eclipse-workspaceNew\\project\\src\\main\\java\\resources\\file.properties");
		 pro.load(fis);
		 String name=pro.getProperty("browser");
		 System.out.println(name);
		 if(name.contains("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", "Ndriver\\chromedriver.exe");
			 ChromeOptions options=new ChromeOptions();
			 if(name.contains("headless"))
			 {
			
			 options.addArguments("headless");
			 }
				 driver=new ChromeDriver(options);
			 
		 }
		 else
		 {
			 System.out.println("File not found");
		 }
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		 
		
		 return driver;
		 
	 }
	 
	 public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException

	 {
		 

	 TakesScreenshot ts=(TakesScreenshot) driver;

	 File source =ts.getScreenshotAs(OutputType.FILE);

	 String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";

	 FileUtils.copyFile(source,new File(destinationFile));

	 return destinationFile;

	 }
	 
}
