package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.ProjectSpecificMethods;
import pages.LoginPage;

public class LoginTc extends ProjectSpecificMethods {

	//public String filename,testname,testDiscription,Author,Category;
	
	@BeforeTest
	public void setfile() {
		
		filename="Logindata";
		testname="LoginTest";
		testDiscription="Testing login functionality";
		Author="Cathrine";
		Category="Regression test";
		
	}
	
	@Test(dataProvider="fetchdata")
	public void runLoginTC(String uname,String pwd) throws IOException {
		
        new LoginPage(driver)
        .enterUserName(uname)
        .enterPassword(pwd)
        .clickLogin();
        
        
	}

}
