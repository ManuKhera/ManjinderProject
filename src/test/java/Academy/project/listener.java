package Academy.project;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtendReporterNG;
import resources.base;

public class listener extends base implements ITestListener {
	ExtentReports extend=ExtendReporterNG.config();
	ExtentTest test;
	ThreadLocal<ExtentTest> extendtest=new ThreadLocal<ExtentTest>();
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extend.flush();
	}
	public void onStart(ITestContext context) {
			
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extendtest.get().fail(result.getThrowable());
		WebDriver driver=null;
		String testmethodname=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		try {
			extendtest.get().addScreenCaptureFromPath(getScreenShotPath(testmethodname,driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onTestStart(ITestResult result) {
		test=extend.createTest(result.getMethod().getMethodName());
		extendtest.set(test);
	}


	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extendtest.get().log(Status.PASS, "pass successfully");
		
	}

}
