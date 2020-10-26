package com.example.automation.testNG;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class demo02_parameter_optional {
	
	@BeforeClass
	@Parameters({"browser","URL"})
	public void Setup(@Optional("Firefox")String browser1, String url) {
		System.out.println("Browser : "+ browser1);
		System.out.println("AUT link : "+ url);
	}
  @Test
  public void f() {
  }
}
