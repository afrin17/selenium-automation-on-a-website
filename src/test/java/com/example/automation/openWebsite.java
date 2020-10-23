package com.example.automation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class openWebsite {
	
	static WebDriver driver;
	static String url = "http://automationpractice.com/index.php";

	@BeforeAll
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\jar files\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void test() {
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
	}
	
	@AfterAll
	public static void tearDown() {
		driver.close();
	}
	

}
