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

class registeringUser {

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
		
		driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("abce@d.com");
		driver.findElement(By.id("SubmitCreate")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		Thread.sleep(2000);
		
		// selecting gender radio button
		
		driver.findElement(By.id("id_gender2")).click();
		
		// entering name, keyword, password
		
		driver.findElement(By.id("customer_firstname")).sendKeys("abcd");
		driver.findElement(By.id("customer_lastname")).sendKeys("xyz");
		
		// will enter email id in the same field two times as already email was registered
		// for signing in so the same email will be used here in this field
		
		//driver.findElement(By.id("email")).sendKeys("ab@d.com");
	
		driver.findElement(By.id("passwd")).sendKeys("12345678");
		
		// selecting Date of birth from drop down
		
		WebElement date = driver.findElement(By.id("days"));
		Select selectDate = new Select(date);
		selectDate.selectByIndex(2);
		
		WebElement month = driver.findElement(By.id("months"));
		Select selectMonth = new Select(month);
		selectMonth.selectByValue("3");
		
		WebElement year = driver.findElement(By.id("years"));
		Select selectYear = new Select(year);
		selectYear.selectByValue("1987");
		
		// selecting a checkbox
		
		driver.findElement(By.id("newsletter")).click();
		
		// entering name and address
		
		driver.findElement(By.id("firstname")).sendKeys("abcd");
		driver.findElement(By.id("lastname")).sendKeys("xyz");
		driver.findElement(By.id("address1")).sendKeys("Manhattan, New York, USA");
		driver.findElement(By.id("city")).sendKeys("New York");
		
		// selecting state from drop down
		
		WebElement state = driver.findElement(By.id("id_state"));
		Select selectState = new Select(state);
		selectState.selectByValue("47");
		
		// entering pin code
		
		driver.findElement(By.id("postcode")).sendKeys("12354");
		
		//select country from drop down
		
		WebElement country = driver.findElement(By.id("id_country"));
		Select selectCountry = new Select(country);
		selectCountry.selectByValue("21");
		
		// entering information in the textarea
		
		driver.findElement(By.id("other")).sendKeys("We are using this credential for automating the given website");
		
		// entering mobile number
		
		driver.findElement(By.id("phone_mobile")).sendKeys("8974561236");
		
		// clearing the predefined value "My address" from the field
		
		driver.findElement(By.id("alias")).clear();
		
		driver.findElement(By.id("alias")).sendKeys("Home");
		
		// clicking on register button
		
		driver.findElement(By.id("submitAccount")).click();
		
		Thread.sleep(2000);
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@AfterAll
	public static void tearDown() {
		driver.close();
	}

}
