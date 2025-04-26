package org.pom_TestCases;


import org.BaseUtility.startUp;
import org.GenericMethod.Dashboadpage;
import org.GenericMethod.Loginpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pom_Pages.LoginPage;
import org.propertiesUtility.PropertiesGeneric;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;


@Listeners(listeners.MyListeners.class)
public class LoginPageTestCases {
	
	private WebDriver driver;
	startUp bu;
	PropertiesGeneric pro;
	Loginpage lg =new Loginpage();
	Dashboadpage dp =new Dashboadpage();
	
	@BeforeMethod
	public void initBrowser() {
		bu = new startUp();
		driver= bu.startUp("chrome","https://staff.hmis.beta.thsystems.net.in/");
		
	}
	
	@AfterMethod
	public void closeBrowser() {
	//driver.close();
			
	}
	
  @Test()
  public void verifyLoginPage() throws InterruptedException {
	  LoginPage lp= new LoginPage(driver); 
	  SoftAssert sa = new SoftAssert();
	  lg.LoginField(driver);
      sa.assertAll();
	
	
	
		
	
  }

  
  

  
  
  
	  
	  
	 
  }

