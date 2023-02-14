package baseclass;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnExtentReport {

	public static void main(String[] args) throws IOException {
		
		//setting the file path with dummy html file.
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/Result.html");
		
		//add history of the previous result/reports
		reporter.setAppendExisting(true);
		//to get the actual data.
		ExtentReports extent = new ExtentReports();
		
		//to attach the actual data to result html file.
		extent.attachReporter(reporter);
		
		//to report the required testcases
		ExtentTest createTest = extent.createTest("LoginTest","to validate the login functinalities");
		createTest.pass("testcase is passed",MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/men.jpg").build());
		createTest.pass("testcase is failled",MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/mens.jpg").build());
		
		//to assign category of the test
		createTest.assignCategory("smoke");
		createTest.assignAuthor("cathrine");
		
		//mandatory step
		extent.flush();
	}

}
