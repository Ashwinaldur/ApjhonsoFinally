package com.alphonso.tests;



import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.alphonso.generic.BaseTest;
import com.alphonso.generic.ExcelData;
import com.alphonso.generic.RunLogic;


 @Test
 public class AlphonsoSearchAsset extends BaseTest
 {
	
	 public void alphonsoSearch() throws InterruptedException, IOException	 
	 {  
		 
		 ExcelData.assetSearch();
	     RunLogic.Runcodelogic();

	 }
	 
	
	 }
 
 