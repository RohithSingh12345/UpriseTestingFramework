package com.qa.listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.utilities.EReporter;

public class Listeners implements ITestListener {

	ExtentReports eReport;
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
	String testName= result.getName();
    extentTest = eReport.createTest(testName);
	extentTest.log(Status.INFO, testName+ " started executing");
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName= result.getName();
		extentTest.log(Status.PASS, testName+ " got executed successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName= result.getName();
		
		// As of now ss is not working need to debug it later
		//failing at line 56
		//need to attach screenshot whenever a test got failed
//		WebDriver driver = null;
//		try {
//			driver= (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
//			
//			e.printStackTrace();
//		}
//		File srcScreenShot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		
//		String destinationPath = System.getProperty("C:\\Users\\Rohith\\eclipse-workspace\\UpriseFramework\\screenshots"+testName+".png");
//		try {
//			FileHandler.copy(srcScreenShot, new File(destinationPath));
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//		extentTest.addScreenCaptureFromPath(destinationPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName+ " got failed");
//		System.out.println(testName+ " got failed");
//		System.out.println(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName= result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName+ " got skipped");
//		System.out.println(testName+ " got skipped");
//		System.out.println(result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		
		 eReport = EReporter.generateEReports();
	}

	@Override
	public void onFinish(ITestContext context) {
		eReport.flush();
	}

}
