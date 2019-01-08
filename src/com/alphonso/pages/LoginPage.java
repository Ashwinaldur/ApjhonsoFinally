package com.alphonso.pages;

import net.bytebuddy.implementation.bind.annotation.Super;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	private static final String Webdriver = null;

	@FindBy(name = "username")
	private WebElement user;
	
	@FindBy(name = "password")
	private WebElement pass;
	
	@FindBy(xpath = "//button[.='Login']")
	private WebElement login;
	
	public  LoginPage(WebDriver driver)
	{
	Super(driver);
		PageFactory.initElements(driver,this);
	}
	private void Super(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	public void enterUsername(String username1) throws InterruptedException
	{
		user.sendKeys(username1);
		Thread.sleep(2000);
	}
	public void enterPassword(String password1) throws InterruptedException
	{
		pass.sendKeys(password1);
		Thread.sleep(2000);
	}
	public void clickLogin() throws InterruptedException
	{
		Thread.sleep(2000);
		login.click();
	}
}