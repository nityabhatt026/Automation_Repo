package com.appdirect.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		Reporter.log("Test Started");
		
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test Successed");
		
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log("Failed Test Name:"+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("Skipped Test Name:"+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("Success Percentage :"+result.SUCCESS_PERCENTAGE_FAILURE);
		
	}

	public void onStart(ITestContext context) {
		Reporter.log("Process Started");
		
	}

	public void onFinish(ITestContext context) {
		
		Reporter.log("Process finished");
	}

}
