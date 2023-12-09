package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Mylistener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test is started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is success");	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test is Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test is Failed but within success percentange ");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test is Failed with timeout");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test is On start");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test is Finished");
	}
	
}
