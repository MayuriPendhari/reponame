package com.qst.purple.driverScript;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.util.SheetUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverScriptMainAndExcel {
	public static WebDriver d;
	//public static File f;
	//public String driverLaunchData;
	//public String Un;
	//public String pw;
	public static String ArrSteps[];
	public static int Sheet2Row;
	 
	public static int rowCount;
	
	public static void Launch()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Workspace\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		
		
	}
	public static void Open_URL()
	{
		d.get("http://newtours.demoaut.com/");
	}
	
	public static void excelRead() throws IOException
	{
		File f = new File("E:\\Framework.xlsx");
		FileInputStream fis = new FileInputStream(f);
		  XSSFWorkbook wb = new XSSFWorkbook(fis);
		  XSSFSheet sheet = wb.getSheet("Sheet1");
		 XSSFSheet Sh = wb.getSheet("Sheet1");
		  
		  Sheet2Row = Sh.getLastRowNum();
		  System.out.println(Sheet2Row);
		  for(int p=0;p<=Sheet2Row;p++)
		  {
			  rowCount = sheet.getRow(0).getLastCellNum();
			  ArrSteps = new String[rowCount];
			  System.out.println(rowCount);
		  }
		 
		public static void network()
		{
		  //reading of steps
		  int m=0;
		  for (int k=0;k==0;k++)
		  {
			  for (int l=0;l<=rowCount-1;l++)
			  {
				  	
				    ArrSteps[m]  = sheet.getRow(k).getCell(l).getStringCellValue();
				  //System.out.println();
				    System.out.println(ArrSteps[m]);
				  m++;
			  }
		  }
		  
		  System.out.println(m);
		 
		  for(int n=1;n<=m;n++)
		  {
			  String step = ArrSteps[n];
			  if (step.equals("Launch"))
			  {
				  Launch();
			  }
		  else if(step.equals("Open _URL"))
		  {
			  Open_URL();
		  }
		  else if(step.equals("EnterUserName"))
		  {
			  d.findElement(By.xpath("//*[@name = 'userName']")).sendKeys("Tutorial1");
		  }
		  else if (step.equals("EnterPassword"))
		  {
			  d.findElement(By.xpath("//*[@name = 'password']")).sendKeys("Tutorial1");
		  }
		  else if(step.equals("Login"))
		  {
			  d.findElement(By.xpath("//*[@value ='Login']")).click();
		  }
		  } 
		  
	}
	}
	private static void network() {
		// TODO Auto-generated method stub
		
	}
	private static void execute() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		excelRead();
		
		//Launch();
	}

}
