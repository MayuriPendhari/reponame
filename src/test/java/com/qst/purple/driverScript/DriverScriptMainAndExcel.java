package com.qst.purple.driverScript;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverScriptMainAndExcel {
	public static WebDriver d;
	//public static File f;
	public String driverLaunchData;
	public String Un;
	public String pw;
	static String ArrSteps[] = new String[5];
	public static void Launch()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Workspace\\chromedriver");
		d = new ChromeDriver();
		d.manage().window().maximize();
		
		
	}
	
	public static void excelRead() throws IOException
	{
		File f = new File("E:\\Framework.xlsx");
		FileInputStream fis = new FileInputStream(f);
		  XSSFWorkbook wb = new XSSFWorkbook(fis);
		  XSSFSheet sheet = wb.getSheet("Sheet1");
		  //reading of steps
		  
		  int m=0;
		  for (int k=0;k==0;k++)
		  {
			  for (int l=1;l<=4;l++)
			  {
				  	
				    ArrSteps[m]  = sheet.getRow(l).getCell(k).getStringCellValue();
				  //System.out.println();
				    System.out.println(ArrSteps[m]);
				  m++;
			  }
		  }
		 
		  // for reading xpath
		  String Readingforxpath[] = new String[5];
		  int n=0;
		  for(int i=1;i==1;i++)
		  {
			  for(int j=1;j<=4;j++)
			  {
				  Readingforxpath[n] = sheet.getRow(j).getCell(i).getStringCellValue();
				System.out.println(Readingforxpath[n]);
				n++;
				  
			  }
		  }
		  
	}
	
	public static void RunOnKeyWord()
	{
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		excelRead();
		//Launch();
	}

}
