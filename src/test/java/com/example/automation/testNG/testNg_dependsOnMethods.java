package com.example.automation.testNG;

import org.testng.annotations.Test;

public class testNg_dependsOnMethods {
  @Test
  public void login() {
	  System.out.println("logging in the application");
  }
  
  @Test(dependsOnMethods = {"login"})
  public void dashboard() {
	  System.out.println("viewing the dashboard");
  }
  
  @Test(dependsOnMethods = {"dashboard","login"})
  public void logout(){
	  System.out.println("logging out of the application");
  }
}
