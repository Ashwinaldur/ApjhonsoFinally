package com.alphonso.generic;

import java.io.File;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alphonso.pages.AssetInformationPage;
import com.alphonso.pages.AssetSearchPage;

public class  ExcelData extends BaseTest  

{
	 static AssetSearchPage asp = new AssetSearchPage(driver);
	 static AssetInformationPage assetinfo = new AssetInformationPage(driver);
	 static XSSFWorkbook wbook ;
	 static XSSFSheet sheet;
	 static int lastrow;
	 static File file;
	
	public static void assetSearch() throws IOException, InterruptedException  
	{	
		asp.clickOnSearch();

		} 
	}  
	
