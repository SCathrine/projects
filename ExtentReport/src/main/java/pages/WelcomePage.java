package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseclass.ProjectSpecificMethods;



public class WelcomePage extends ProjectSpecificMethods {

	public WelcomePage(RemoteWebDriver driver) {
		this.driver=driver;
	}


	public HomePage clickCrmsfa() {
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		HomePage hp=new HomePage(driver);
		return new HomePage(driver);
	}

	
	public LoginPage clickLogout() {
		
		driver.findElement(By.linkText("Leads")).click();
		LoginPage lp=new LoginPage(driver);
		return new LoginPage(driver);

	}
}
