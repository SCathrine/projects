package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseclass.ProjectSpecificMethods;


public class LoginPage extends ProjectSpecificMethods{

	
	//create method for each action
	
	public LoginPage(RemoteWebDriver driver) {
	
		this.driver=driver;
}

	public LoginPage enterUserName(String uname) throws IOException {
		
		try {
				driver.findElement(By.id("username")).sendKeys(uname);
				reportstep("pass","username validated");
		}catch (Exception e) {
			
			reportstep("fail","username failed" +e);
		}
	
	//to pass driver control to other functions
	//create obj and then return the obj value to method
	
	// 1) LoginPage lp=new LoginPage(); 
	
	 //return lp; (or)
	// return new LoginPage();
	
	//no object created here and no memory wasteage
	// 2) return this;

	return this;
	
}
	
	public LoginPage enterPassword(String pwd) throws IOException {
		try {
			driver.findElement(By.id("password")).sendKeys(pwd);
			reportstep("pass","password validated");
		}catch (Exception e) {
			
			reportstep("fail","password failed" +e);
		}
		return this;

	}
	
	public WelcomePage clickLogin() throws IOException {
		try {
		driver.findElement(By.className("decorativeSubmit")).click();
		reportstep("pass","login success");
		}catch (Exception e) {
			
			reportstep("fail","login failed" +e);
		}
		//here control needs to move to next page.
		WelcomePage wp=new WelcomePage(driver);
		return new WelcomePage(driver);

	}

	

}



