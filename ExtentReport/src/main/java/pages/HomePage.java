package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseclass.ProjectSpecificMethods;



public class HomePage extends ProjectSpecificMethods {

	public HomePage(RemoteWebDriver driver) {
		this.driver=driver;
	}


	public  HomePage verifyTitle() {
		
		System.out.println(driver.getTitle());
		return this;

	}
	


}
