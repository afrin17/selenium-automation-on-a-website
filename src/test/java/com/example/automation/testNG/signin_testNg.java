package com.example.automation.testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class signin_testNg {
	
	WebDriver driver;
  
	@BeforeSuite
	@Parameters({"browser","url"})
	public void setop(@Optional("Firefox")String browserName, String url) {
		
		switch (browserName) {
		case "IE":
			System.out.println("Currently not used for implementation");
			break;
			
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "D:\\jar files\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			break;
			
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\jar files\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			break;
		}
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[4][2];
		
		data[0][0] = "ab@d.com";
		data[0][1] = "12345678";
		
		data[1][0] = "a@d.com";
		data[1][1] = "12345678";
		
		data[2][0] = "abce@d.com";
		data[2][1] = "12345678";
		
		data[3][0] = "abc@d.com";
		data[3][1] = "12345678";
		
		return data;
	}
	
	@Test(dataProvider = "getData")
	public void login(String username, String password) throws InterruptedException {
		
		driver.findElement(By.linkText("Sign in")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(1000);
		
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Sign out")));
			System.out.println("Login success");
			driver.findElement(By.linkText("Sign out")).click();
		}
		catch (Exception e) {
			System.out.println("Login failure");
		}
		finally {
			driver.findElement(By.linkText("Sign in")).click();
		}
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
