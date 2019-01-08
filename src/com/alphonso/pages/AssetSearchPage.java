package com.alphonso.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.alphonso.generic.BaseTest;
import com.alphonso.generic.ExcelData;
import com.gargoylesoftware.htmlunit.javascript.host.Window;

public class AssetSearchPage {
	
	@FindBy(xpath = "//span[.='VOD Asset Search']")
	private WebElement assetsearch;

	@FindBy(xpath = "/html/body/div[1]/al-menu/ch-menu/div/section/ac-search/div/al-vod-assets/div[1]/div/ac-filters/div/div[2]/form/div[1]/div[1]/div[2]/div/div/div/div/div/tags-input/div/div/input")
	private WebElement head;
	
	@FindBy(xpath = "//em[.='ctec_a6h1']")
	private WebElement headclick;
	
	@FindBy(xpath = "/html/body/div[1]/al-menu/ch-menu/div/section/ac-search/div/al-vod-assets/div[1]/div/ac-filters/div/div[2]/form/div[1]/div[4]/div/div/div/div/div/div/tags-input/div/div/input")
	private WebElement paid;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement search;
	
	@FindBy(xpath = "//i[@class='fa fa-info-circle']")
	private WebElement info;
	
	@FindBy(xpath = "//i[@class = 'fa fa-check text-success']")
	private WebElement Active;
	
	@FindBy(xpath ="/html/body/div[1]/al-menu/ch-menu/div/section/ac-search/div/al-vod-assets/div[2]/div/div[1]/ac-vod-assets-grid/ch-grid/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div[9]/div/span")
	private WebElement TMSID;
	
	@FindBy(xpath = "/html/body/div[1]/al-menu/ch-menu/div/section/ac-search/div/al-vod-assets/div[2]/div/div[1]/ac-vod-assets-grid/ch-grid/div[1]/div/div[1]/div[2]/div[2]/div/div/div/div[10]/div/span")
	private WebElement RootID;
	
	@FindBy(xpath = "//a[@ng-bind='::$$removeTagSymbol']")
	private WebElement removeheadendA6;
	
	//@FindBy(xpath = "//span[.='ctec_a7h2']/..//a[@class = 'remove-button ng-binding ng-scope']")
	//private WebElement removeheadendA7;
	
	@FindBy(xpath = "//label[.='Package Asset ID']/..//a[@class='remove-button ng-binding ng-scope']")
	private WebElement removepaid;
	
	public  AssetSearchPage(WebDriver driver)
	{
	Super(driver);
		PageFactory.initElements(driver,this);
	}

	private void Super(WebDriver driver)
	{
		// TODO Auto-generated method stub	
	}	
	public void clickOnSearch() throws InterruptedException
	{
		assetsearch.click();
		Thread.sleep(5000);

	}
	public void enterHeadend(String headend) throws InterruptedException
	{   
	    SoftAssert  sa = new SoftAssert();
		head.sendKeys(headend);
		Thread.sleep(2000);
		head.sendKeys(Keys.ENTER);
		
	}

	public void enterPaid(String paid1) throws InterruptedException
	{   
		paid.clear();
		paid.sendKeys(paid1);
		paid.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	public void RemoveHeadend()
	{
		removeheadendA6.click();
	}
	
	public void RemovePaid()
	{
		removepaid.click();
	}
	
	public void clickOnAssetSearch() throws InterruptedException
	{
		search.click();
		Thread.sleep(2000);
	}
	
	public static void ScrollDown() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)BaseTest.driver;
		js.executeScript("window.scrollBy(500,500)");
		Thread.sleep(2000);
		}
	public boolean checkActive()
	{
		boolean disp = Active.isDisplayed();
		return disp;
	}
	
	public void clickOnInfo()
	{
		info.click();
	}
	
	public String checkTMSID()
	{
		String tmsID = TMSID.getText();
		return tmsID;
		
	}
	
	public String checkRootID()
	{
		String rootid = RootID.getText();
		return rootid;
	}
	
	
	
}
