package com.alphonso.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.alphonso.pages.LoginPage;

public  abstract class BaseTest implements AutoConstant{
 public static  WebDriver driver ;
 
 
 public String readApplication(String key) throws IOException
 {
	 Properties obj = new Properties();
	 String Propertypath = "D:/ProjectManagement/Alphonso2/src/src/com/alphonso/objectrepository/application.properties";
	 FileInputStream objfile = new FileInputStream(Propertypath);
	 obj.load(objfile);
	 return obj.getProperty(key);
	}
 
 
  @BeforeSuite
	public void precondition() throws IOException, InterruptedException
	{   
		System.setProperty(gecko_key, gecko_value);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
  
  	@AfterSuite
	public void postcondition()
	
	{
		driver.close();
	}

}
