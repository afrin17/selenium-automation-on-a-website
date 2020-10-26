package com.example.automation.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demo01 {
  
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Inside before suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Inside after suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("inside before test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("inside after test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("inside before class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("inside after class");
	}
	
	@BeforeMethod
	public void beforMethod() {
		System.out.println("inside before method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("inside after method");
	}
	
	@Test
	public void test1() {
		System.out.println("inside test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("inside test 2");
	}
	
}
