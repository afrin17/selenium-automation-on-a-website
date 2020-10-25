package com.example.automation;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class parameterization {

	static WebDriver driver;
	static String url = "http://automationpractice.com/index.php";

	@BeforeAll
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\jar files\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	
	@Test
	public void test() throws InterruptedException, IOException {		
		
		// path of the excel file
		// filePath does not work
		//String filePath = System.getProperty("D:\\codes\\Book1.xlsx");
		
		FileInputStream filestream = new FileInputStream("D:\\\\codes\\\\Book1.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(filestream);
		XSSFSheet sheet = workbook.getSheet("credentials");
		
		//System.out.println(sheet);
		
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
//		System.out.println(rowCount);
		
		//System.out.println((int)sheet.getRow(1).getCell(1).getNumericCellValue());
		
		driver.findElement(By.linkText("Sign in")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		for(int i = 1; i <= rowCount; i++) {
			
			driver.findElement(By.id("email")).sendKeys(String.valueOf(sheet.getRow(i).getCell(0).getStringCellValue()));
			
			driver.findElement(By.id("passwd")).sendKeys(""+(int)sheet.getRow(i).getCell(1).getNumericCellValue());
			
			Thread.sleep(2000);
			
			driver.findElement(By.id("SubmitLogin")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.linkText("Sign out")).click();
			
		}
		filestream.close();
	}
	
	@AfterAll
	public static void tearDown() {
		driver.close();
	}

}
