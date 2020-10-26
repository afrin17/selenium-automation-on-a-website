package com.example.automation.testNG;

import org.testng.annotations.Test;

public class testNg_priority_enabled {
  @Test(priority = 2, enabled = false)
  public void test1() {
	  System.out.println("inside test1");
  }
  
  @Test(priority = 1, enabled = false)
  public void test2() {
	  System.out.println("inside test2");
  }
  
  @Test(priority = 0)
  public void test3() {
	  System.out.println("inside test3");
  }
  
  @Test(priority = 1, enabled = true)
  public void test4() {
	  System.out.println("inside test4");
  }
  
  @Test(priority = 2)
  public void test5() {
	  System.out.println("inside test5");
  }
}
