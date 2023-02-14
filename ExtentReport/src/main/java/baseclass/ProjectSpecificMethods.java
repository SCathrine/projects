package baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

//import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.PassExcelToFileName;

public class ProjectSpecificMethods {

	public RemoteWebDriver driver;
	public String filename,testname,testDiscription,Author,Category;
	public ExtentReports extent;
	public static ExtentTest createTest;
	
	//integrating extent report to POM
	//report needs to be integrated before all.
	@BeforeSuite
	public void startreport() {
		
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}
	
	@AfterSuite
	public void endreport() {
		
		extent.flush();
	}
	
	
	@BeforeClass
	public void testcaseDetails() {
		createTest = extent.createTest(testname,testDiscription);
		createTest.assignAuthor(Author);
		createTest.assignCategory(Category);
		
	}
	
	public void reportstep(String status,String msg) throws IOException {
		
		if(status.equalsIgnoreCase("pass")) {
			
			createTest.pass(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/shot"+takesnap()+".jpg").build());
		}
		else if(status.equalsIgnoreCase("fail")){
			
			createTest.fail(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/shot"+takesnap()+".jpg").build());
			throw new RuntimeException();
		}
		
	}
	
	
	public int takesnap() throws IOException {
		
		int random = (int) (Math.random()*999);
		File screenShotsAs=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/shot"+random+".jpg");
		FileUtils.copyFile(screenShotsAs, dest);
		
		return random;
	}

	@BeforeMethod
	public void preConditions() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	@AfterMethod
	public void postConditions() {
	
	driver.close();
}
	
	@DataProvider(name="fetchdata")
	public String[][] setData() throws IOException {
		
		
		return PassExcelToFileName.readData(filename);
	}
	
}
