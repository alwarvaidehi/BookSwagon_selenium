package steps;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.BasePage;


public class SharedStep extends BasePage{
	
	@BeforeTest
	public void getnameMethod(ITestContext context)
	{
		extentTest=	extentreports.createTest(context.getName());
	}
	
	@BeforeSuite  // this method will be excuted before suite begins its execution
	public void InitalizeExtentReport()
	{
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("BookSwagOnReport.html");
		extentreports = new ExtentReports();
		extentreports.attachReporter(sparkreporter);
		// on the report display more information about OS, browser, java etc
		extentreports.setSystemInfo("OS", System.getProperty("os.name"));
		extentreports.setSystemInfo("JAVA", System.getProperty("java.version"));
		
	}

	@AfterSuite
	public void generateReports() throws IOException
	{
		extentreports.flush();
		Desktop.getDesktop().browse(new File("BookSwagOnReport.html").toURI());
	}
	@AfterMethod
	public void generateTestStatus(Method m,ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE )
		{
		

			System.out.println("Capture Screenshot");
			extentTest.fail(result.getThrowable());
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destFile=new File("./screenshots/BookSwagOnFailure.png");
			FileUtils.copyFile(srcFile,destFile);
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(m.getName() + " is passed");
		}
	}
	

}
