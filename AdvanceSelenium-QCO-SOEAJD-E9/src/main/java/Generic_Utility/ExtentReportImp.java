package Generic_Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImp {


	public class ExtentReportImp implements ITestListener 
	{
		ExtentReports report;
		ExtentTest test;

	
		public void onTestStart(ITestResult result) 
		{
			test=report.createTest(result.getMethod().getMethodName());
		}
		
		public void onTestSuccess(ITestResult result)
		{
			test.log(Status.PASS, result.getMethod().getMethodName());
			test.log(Status.PASS, result.getThrowable());
		}
		
		public void onTestFailure(ITestResult result)
		
		{
			test.log(Status.FAIL, result.getMethod().getMethodName());
			test.log(Status.FAIL, result.getThrowable());
			
			System.out.println("----------------Iam Taking ScreenShot----------");
			String screenshot= null;
			try {
				screenshot = Webdriver_Utility.takescreenShot(BaseClass.sdriver, result.getMethod().getMethodName());
				
			} catch (Throwable e) {
				e.printStackTrace();
			}
			test.addScreenCaptureFromPath(screenshot);
		}
		
		public void onTestSkipped(ITestResult result)
		
		{
			test.log(Status.SKIP, result.getMethod().getMethodName());
			test.log(Status.SKIP, result.getThrowable());
		}
		
		public void onStart(ITestContext context)
		{
			Java_Utility jlib = new Java_Utility();
			int rannum = jlib.getRannum();
			ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentsReportFile/Report"+rannum+".html");
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("AutomatinTesting");
			spark.config().setReportName("Subhani");
			report=new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("platform", "windows10");
			report.setSystemInfo("excutedBy", "Subhani");
			report.setSystemInfo("reviwed", "Ram");
			
			
		}
		public void onFinish(ITestContext context)
		{
			report.flush();
		}
		
		
		
	}

}
