package com.example.automation.testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class testNg_assertions {
	WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver","D:\\jar files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
	}
	
  @Test(description = "Logging in and working with assertion")
  @Severity(SeverityLevel.NORMAL)
  @Description("logging in the application and using hard assert and soft assert")
  @Story("Story name: to check assertion")
  public void login() throws InterruptedException {
	  
	  driver.findElement(By.linkText("Sign in")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("email")).sendKeys("ab@d.com");
		driver.findElement(By.id("passwd")).sendKeys("12345678");
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(1000);
		
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Sign out")));
			System.out.println("Login success");
			String username = driver.findElement(By.className("account")).getText();
			
//			HARD ASSERT
			
			Assert.assertEquals(username, "abcd xyz");
			System.out.println("assertEquals is true");
//			 if username exists or not
//			Assert.assertTrue(false, username);
			Assert.assertTrue(username.equals("abcd xyz"));
			System.out.println("assertTrue successful");
			
//			SOFT ASSERT
			
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(username, "abcd xyzd");
			System.out.println("soft assertEquals is true");
			softAssert.assertTrue(username.equals("abcd xyz"));
			System.out.println("soft assertTrue is false still it gets executed");
//			decides if the softAssertion test case passes or fails and is only for soft assertion
//			it will run as normal soft assertion but will show the result of failed assertion
			softAssert.assertAll();
			
//			as assertAll is failing hence sign out is not executed
			
			driver.findElement(By.linkText("Sign out")).click();
		}
		catch (Exception e) {
			System.out.println("Login failure");
		}
  }
}
