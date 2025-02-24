package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
			
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	    @Override		
	    public void onStart(ITestContext arg0) {					
	    	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
			String repName="Test-Report-"+timeStamp+".html";
			
			htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/"+repName);//specify location of the report
			
			htmlReporter.config().setDocumentTitle("RestAsuuerd Automation Project"); // Tile of report
			htmlReporter.config().setReportName("Pet Store User API Functional Test Automation Report"); // name of the report
		//	htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
			htmlReporter.config().setTheme(Theme.DARK);
	    	
			extent=new ExtentReports();
			
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host name","localhost");
			extent.setSystemInfo("Application", "Pet Store User API");
			extent.setSystemInfo("Operating System", System.getProperty("os.name"));
			extent.setSystemInfo("User", System.getProperty("user.name"));
			extent.setSystemInfo("Environemnt","QA");
			extent.setSystemInfo("user","Sagar");
			
			
	    	
	    }		

	   
	    @Override		
	    public void onTestSuccess(ITestResult result) {					
	        	
	    	test=extent.createTest(result.getName());
	    	test.createNode(result.getName());
	    	test.assignCategory(result.getMethod().getGroups());
	    	test.log(Status.PASS, "Test Case Passed");

	    }

	    @Override		
	    public void onTestFailure(ITestResult result) {					
	    	test=extent.createTest(result.getName());
	    	test.createNode(result.getName());
	    	test.assignCategory(result.getMethod().getGroups());
	    	test.log(Status.FAIL, "Test Case Failed");
	    	test.log(Status.FAIL, result.getThrowable().getMessage());

	    }	
	    
	    @Override		
	    public void onTestSkipped(ITestResult result) {					
	    	test=extent.createTest(result.getName());
	    	test.createNode(result.getName());
	    	test.assignCategory(result.getMethod().getGroups());
	    	test.log(Status.SKIP, "Test Case Skiped");
	    	test.log(Status.SKIP, result.getThrowable().getMessage());

	    }		
	    @Override		
	    public void onFinish(ITestContext result) {					
	        		extent.flush();
	    }
	  
}
