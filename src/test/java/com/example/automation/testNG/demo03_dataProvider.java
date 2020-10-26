package com.example.automation.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class demo03_dataProvider {
  @Test(dataProvider = "credentials")
  public void f(String username, String password) {
	  
	  System.out.println("username is : " + username);
	  System.out.println("passsword is : " + password);
  }
  
  @DataProvider(name = "credentials")
  public Object[][] getData(){
	  Object[][] data = new Object[3][2];
	  
	  data[0][0] = "abcd";
	  data[0][1] = "1234";
	  
	  data[1][0] = "xyz";
	  data[1][1] = "6789";
	  
	  data[2][0] = "sqr";
	  data[2][1] = "5643";
	  
	  return data;
  }
}
