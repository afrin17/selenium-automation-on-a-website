package com.example.automation;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({parameterization.class, screenshots.class})
public class testSuite {
	
	@Test
	public void test() {
		System.out.println("pass");
	}

}