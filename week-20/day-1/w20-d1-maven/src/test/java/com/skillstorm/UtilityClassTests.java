package com.skillstorm;

// Assertions are things we hypothesize should be true
// if one is, we pass the test; if not, we fail the test
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UtilityClassTests {
	
	public static UtilityClass ucGlobal;
	
	// this executes once when this test class is loaded
	// useful for loading a resource we might need for many tests
	// must be static
	@BeforeClass
	public static void startup() {
		System.out.println("Running startup() in @BeforeClass...");
		ucGlobal = new UtilityClass("Global Test Object", 0);
	}
	
	// this executes once before each test method
	@Before
	public void setup() {
		System.out.println("Running setup() in @Before...");
	}

	// this annotation specifies an individual test
	@Test
	public void constructionTest() {
		System.out.println("Running constructionTest() in @Test...");
		UtilityClass uc = new UtilityClass("Name", 123);
		
		// this test a boolean condition in the parentheses
		assertTrue(uc instanceof UtilityClass && uc.getName().equals("Name") && uc.getId() == 123);
	}
	
	@Test
	public void oneRandomTest() {
		System.out.println("Running oneRandomTest() in @Test...");
		ucGlobal.randomInteger(10);
		
		assertTrue(ucGlobal.getId() <= 10);
	}
	
	@Test
	public void multiRandomTest() {
		System.out.println("Running multiRandomTest() in @Test...");
		
		LinkedList<Integer> ll = new LinkedList<>();
		
		for (int i = 0; i < 100000; i++) {
			ucGlobal.randomInteger(10000);
			ll.add(ucGlobal.getId());
		}
		
		int highest = ll.stream().reduce(0, (a, b) -> {
			if (a > b) return a;
			else return b;
		});
		
		System.out.println(highest);
		
		assertTrue(highest <= 10000);	
	}
	
	@Test
	public void defaultSwitch() {
		
		System.out.println("Running defaultSwitch() in @Test...");
		
		try {
			ucGlobal.threeOptions("Test");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(1, ucGlobal.getId());
	}
	
	@Test
	public void exceptionSwitch() {
		System.out.println("Running exceptionSwitch() in @Test...");
		
		assertThrows(Exception.class, () -> ucGlobal.threeOptions(""));
	}
	
	@Test
	public void methuselahTest() {
		System.out.println("Running methuselahTest() in @Test...");
		
		try {
			ucGlobal.threeOptions("Methuselah");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals("Methuselah", ucGlobal.getName());
	}
	
	// this executes once after each test method
	@After
	public void exit() {
		System.out.println("Running exit() in @After...");
	}
	
	// this executes once after all test methods have run
	// this is useful for closing out resources we've used in multiple tests
	// must be static
	@AfterClass
	public static void shutdown() {
		System.out.println("Running shutdown() in @AfterClass...");
		ucGlobal = null;
	}

}
