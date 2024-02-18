package com.genericUtils;

import java.io.File;


import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;



public class ListenerImpClass extends BaseClass implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result)
	{
		//step3 create test method
		test=report.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result)
	{
		//step4 log for pass Methods
		test.log(Status.PASS,result.getMethod().getMethodName()+"is passed");
		
	}
	
	public void onTestFailure(ITestResult result) {
		
		Object obj = result.getInstance();
		WebDriver driver=null;
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(obj);
		}
		
		catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch(IllegalAccessException e1)
		{
			e1.printStackTrace();
			
		}
		catch(NoSuchFieldException e1)
		{
			e1.printStackTrace();
		}
		catch(SecurityException e1)
		{
			e1.printStackTrace();
		}
		
		
		
		EventFiringWebDriver takescreenshot=new EventFiringWebDriver(driver);
		File source=takescreenshot.getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")
				+".//screenshot//"+result.getMethod().getMethodName()+
				"_"+JavaUtility.getSystemDate()+".PNG";
		File dest=new File(screenshotPath);
		try {
			Files.copy(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//step5:log for failure methods
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is Failed");
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(screenshotPath);
	
		/*	EventFiringWebDriver takesScreenshots = new EventFiringWebDriver(BaseClass.staticDriver);
		//TakesScreenshot takesScreenshots= (TakesScreenshot)driver;
		File src = takesScreenshots.getScreenshotAs(OutputType.FILE);
		String screenshotPath = "./screenshot/"+result.getMethod().getMethodName()+"_"+JavaUtility.getSystemDate()+".PNG";
		File dest = new File(screenshotPath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public void onTestSkipped(ITestResult result) {
		//step6 log for skip methods
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		//step1 Configuration
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+".//reports//extentreport_"+JavaUtility.getSystemDate()+".html");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Project1 Automation Report");
        htmlReporter.config().setReportName("Execution Report");
        //step2 attacking report and system info
        report = new ExtentReports();
        report.attachReporter(htmlReporter);
        report.setSystemInfo("OS", "Windows");
        report.setSystemInfo("URl", "http://localhost:8888");
        report.setSystemInfo("Platform", "Windows10");
        report.setSystemInfo("Reporter Name", "Shaibaz");
	}

	public void onFinish(ITestContext context) {
		//step7 flush the report
		report.flush();
		
	}

}
