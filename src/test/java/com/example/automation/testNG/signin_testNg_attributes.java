package com.example.automation.testNG;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class signin_testNg_attributes {
	
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
	
	@Test
	public void login() throws InterruptedException {
		
		driver.findElement(By.linkText("Sign in")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("email")).sendKeys("ab@d.com");
		Reporter.log("entering username");
		driver.findElement(By.id("passwd")).sendKeys("12345678");
		Reporter.log("entering password");
		driver.findElement(By.id("SubmitLogin")).click();
		Reporter.log("logging in");
		Thread.sleep(1000);
		
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Sign out")));
			System.out.println("Login success");
		}
		catch (Exception e) {
			System.out.println("Login failure");
		}
	}
	
	@Test(dependsOnMethods = {"login"})
	public void dashboard() {
		WebElement fullName = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));
		System.out.println("The name of the person who is currently logged in is : " + fullName.getText());		
	}
	
	@Test(dependsOnMethods = {"dashboard"}, enabled = false)
	public void orderHistory() {
		driver.findElement(By.linkText("Order history and details")).click();
	}
	
	@Test(dependsOnMethods = "dashboard", enabled = false)
	public void logout() {
		driver.findElement(By.linkText("Sign out")).click();
		Reporter.log("logging out");
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
