package com.alphonso.generic;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;

public class RunLogic extends ExcelData
	{
	     static List<String> al = new ArrayList<String>();
         static int count = 0;
        
		 
	public static void Runcodelogic() throws InterruptedException, IOException
	{
		 file = new File("D:/ProjectManagement/Alphonso2/Data/input.xlsx" );
		 FileInputStream fis = new FileInputStream(file);
		 wbook = new XSSFWorkbook(fis);
		 sheet = wbook.getSheet("Asset");
		 lastrow = sheet.getLastRowNum();
		 
		 for(int i=1;i<=lastrow;i++)	
			
			
	  {
				try
				{		
			//Takes headend information from the sheet
			XSSFRow Row = sheet.getRow(i);
		
		    String Headend = Row.getCell(0).getStringCellValue();
		    asp.enterHeadend(Headend);
		
		    //Takes PAID information from the sheet
		    String paidID = Row.getCell(1).getStringCellValue();
		    asp.enterPaid(paidID);
		    
		    asp.clickOnAssetSearch(); 
		    asp.ScrollDown();
		    
		    //checks whether asset is PAID is present in Alphonso
		    boolean present = asp.checkActive();
		    System.out.println(present);
		    
		    //if asset is present it checks all the metadata information
		    if(present==true)
		    {    
		   	     al.add(paidID);
		   	     count = count+1;
		   	     
		    	//writes asset is present in excel
		    	 sheet.getRow(i).createCell(2).setCellValue("Asset is Present");
		    	 FileOutputStream fout=new FileOutputStream(file);
		    	 wbook.write(fout);
		    	 
		    
		        
		    	 //To check TMS ID
		    	String returnTMSID = asp.checkTMSID();
		    	String returnRootID = asp.checkRootID();
		  
		    	if(returnTMSID.isEmpty())
		    	{
		    		sheet.getRow(i).createCell(3).setCellValue("TMS ID not present");
			    	FileOutputStream foutTMS = new FileOutputStream(file);
			    	wbook.write(foutTMS);
		    	}
		    	
		    	else
		    	{
		    	sheet.getRow(i).createCell(3).setCellValue(returnTMSID);
		    	FileOutputStream foutTMS = new FileOutputStream(file);
		    	wbook.write(foutTMS);
		    	}
		    	
		    	if(returnRootID.isEmpty())
		    	{
		    		sheet.getRow(i).createCell(4).setCellValue("Root ID not present");
			    	FileOutputStream foutroot = new FileOutputStream(file);
			    	wbook.write(foutroot);
		    	}
		    	else
		    	{
		    		sheet.getRow(i).createCell(4).setCellValue(returnRootID);
			    	FileOutputStream foutroot = new FileOutputStream(file);
			    	wbook.write(foutroot);
		    	}
		    	 asp.clickOnInfo();
		    	 Thread.sleep(2000);
		    	  
		    	 //writes asset title in the excel
		    	 String assetTitle = assetinfo.getText();
		    	 sheet.getRow(i).createCell(5).setCellValue(assetTitle);
		    	 FileOutputStream fout1=new FileOutputStream(file);
		    	 wbook.write(fout1);
		    	 
		    	 //writes assets path in the excel
		    	 String assetpath = assetinfo.getPath();
		    	 sheet.getRow(i).createCell(6).setCellValue(assetpath);
		    	 FileOutputStream fout2=new FileOutputStream(file);
		    	 wbook.write(fout2);
		    	 Thread.sleep(2000);
		    	 
		    	 //writes asset license start date in the excel
		    	 String assetStartDate = assetinfo.getStartDate();
		    	 int datelen = assetStartDate.length();
		    	 String StartDate = assetStartDate.substring(0, datelen-15);
		    	 sheet.getRow(i).createCell(7).setCellValue(StartDate);
		    	 FileOutputStream fout3=new FileOutputStream(file);
		    	 wbook.write(fout3);
		    	 
		    	 //writes asset license end date in the excel
		    	 String assetEndDate = assetinfo.getLastDate();
		    	 int datelen1 = assetEndDate.length();
		    	 String EndDate = assetEndDate.substring(0, datelen1-15);
		    	 sheet.getRow(i).createCell(8).setCellValue(EndDate);
		    	 FileOutputStream fout4=new FileOutputStream(file);
		    	 wbook.write(fout4);
		    	 
		    	 //checks price
		    	 assetinfo.clickProperties();
		    	 		    	 
		    	 
		    	 //writes price name in excel.
		    	 String assetPrice = assetinfo.getPrice();
		    	 sheet.getRow(i).createCell(9).setCellValue(assetPrice);
		    	 FileOutputStream fout5 =new FileOutputStream(file);
		    	 wbook.write(fout5);
		    	 
		    	 //clear the field
		    	 assetinfo.clearField();
		    	 
		    	 //check for gracenotemapping status
		    	 assetinfo.enterGracenote();
		    	 
		    	 //get gracenote mapping
		    	 String gracenote = assetinfo.getGracenote();
		    	 sheet.getRow(i).createCell(10).setCellValue(gracenote);
		    	 FileOutputStream fout6 =new FileOutputStream(file);
		    	 wbook.write(fout6);
		    	 
		    	 driver.navigate().back();
		    	 driver.navigate().back();
		    	 
		    	 Thread.sleep(2000);
		    	
		    }
		    else
		    {
		    	//if the asset is not present writes asset not present
		    	sheet.getRow(i).createCell(2).setCellValue("Asset is not Present");
		    	FileOutputStream fout=new FileOutputStream(file);
		    	wbook.write(fout);
		    }
		   
		    //Removes the current headend and paid and checks for another asset
		    asp.RemoveHeadend();
		    Thread.sleep(1000);
		    asp.RemovePaid();
		    Thread.sleep(1000);
		  
	  }
	catch(Exception e)
				{
		
				}
	}
			
			System.out.println(al);
			System.out.println("The number of active assets = "+count);
	}
	
	
	 	
	}	
	


	
		 	 
	


