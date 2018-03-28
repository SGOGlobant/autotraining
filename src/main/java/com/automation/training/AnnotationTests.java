package com.automation.training;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class AnnotationTests {
	
//	@Test
//	public void testConcact() {
//		String a = "I love ";
//		String b = "test automation";
//		String resultado = a + b;	
//		Assert.assertEquals(resultado, "I love test automation");
//	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Running Before Test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Running After Tests");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("Login to the app");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("Logout to the app");
	}
	
//	@Test
//	public void testConcact() {
//		System.out.println("Test 1");
//	}
////	
//	@Test
//	public void testCount() {
//		System.out.println("Test 1");
//	}
	
	@Test(groups = {"grupo1"})
	public void testEqualsIgnoreCase() {
		String a = "hOla MuNDO";
		String b = "hola mundo";
		Assert.assertTrue(a.equals(b));
	}
	
	@Test(groups = {"group1", "group2"})
	public void testConcact() {
		String a = "I love";
		String b = " test automation";
		String resultado = a + b;
		Assert.assertEquals(resultado, "I love test automation");
	}
	
	@Test(groups = {"grupo2"})
	public void testCount() {
		String a = "I love";
		Assert.assertEquals(a.length(), 6);
	}
}
