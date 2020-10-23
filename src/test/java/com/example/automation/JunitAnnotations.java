package com.example.automation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JunitAnnotations {

	@BeforeAll
	public static void beforeAll() {
		System.out.println("In before all class");
	}
	
	@BeforeEach
	public void beforeEach1() {
		System.out.println("in before class1");
	}
	
	@BeforeEach
	public void beforeEach2() {
		System.out.println("in before class2");
	}
	
	@Test
	public void test1() {
		System.out.println("in test1 class");
	}
	
	@Test
	public void test2() {
		System.out.println("in test2 class");
	}
	
	@AfterEach
	public void afterEach1() {
		System.out.println("in after class1");
	}
	
	@AfterEach
	public void afterEach2() {
		System.out.println("in after class2");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("in after all class");
	}

}
