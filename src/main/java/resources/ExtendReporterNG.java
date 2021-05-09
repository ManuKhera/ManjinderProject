package resources;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {
	static ExtentReports extend ;
	@BeforeTest
	public static ExtentReports config()
	{
	String path =System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	
	
	 extend=new ExtentReports();
	extend.attachReporter(reporter);
	extend.setSystemInfo("Tester", "Manjinder");
	return extend;
}
}