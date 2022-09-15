package vitiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test=report.createTest(methodName);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS,methodName+"--->PASSED");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		
		String methodName = result.getMethod().getMethodName();
		String screenShotName = methodName+"-"+jUtil.getSystemDateInFormat();
		
		test.log(Status.FAIL,methodName+"--->FAIL");
		test.log(Status.FAIL,result.getThrowable());
		
		try {
			String path = wUtil.takeScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		
		test.log(Status.SKIP,methodName+"--->FAIL");
		test.log(Status.SKIP,result.getThrowable());
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//Start of suite execution
		//Configure the extent reports
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("WASM-5-vtiger Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("vtiger Execution Report");
		
		report=new ExtentReports(); 
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-Platform", "windows");
		report.setSystemInfo("Base-Url", "http://localhost:8888");
		report.setSystemInfo("Reporter-Name", "Archanaa");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//End of suite execution
		report.flush();
		
	}
  
}
