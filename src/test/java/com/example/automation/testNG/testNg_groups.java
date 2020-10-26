package com.example.automation.testNG;

import org.testng.annotations.Test;

public class testNg_groups {
	
  @Test(groups = {"a","b"})
  public void test1() {
	  System.out.println("inside test1");
  }
  
  @Test(groups = {"c","d"})
  public void test2() {
	  System.out.println("inside test2");
  }
  
  @Test(groups = {"e","i"})
  public void test3() {
	  System.out.println("inside test3");
  }
  
  @Test(groups = {"d","u"})
  public void test4() {
	  System.out.println("inside test4");
  }
  
  @Test(groups = {"l","b"})
  public void test5() {
	  System.out.println("inside test5");
  }
}
