package com.alphonso.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.alphonso.generic.BaseTest;
import com.alphonso.pages.LoginPage;

@Test
public class AlphonsoLogin extends BaseTest {
	
	public void alphonsoLogin() throws InterruptedException, IOException
	{
	LoginPage lp = new LoginPage(driver);
	driver.get("http://alphonso-stackc.engprod-charter.net/alphonso-web/#/login/");
	Thread.sleep(2000);
	String username = readApplication("UserName");
	String password = readApplication("Password");
	lp.enterUsername(username);
	lp.enterPassword(password);
	lp.clickLogin();
	
}
}
