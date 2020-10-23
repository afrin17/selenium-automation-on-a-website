package com.example.automation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

class signin {

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
	public void test() throws InterruptedException {		
		driver.findElement(By.linkText("Sign in")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("email")).sendKeys("ab@d.com");
		driver.findElement(By.id("passwd")).sendKeys("12345678");
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(1000);
		
	}
	
	@AfterAll
	public static void tearDown() {
		driver.close();
	}

}
