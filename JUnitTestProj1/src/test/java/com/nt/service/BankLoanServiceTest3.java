package com.nt.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BankLoanServiceTest3 {

	static BankLoanService service;

	/*Runs only once before all the test cases automatically, 
	method name can be anything but it must be static*/
	@BeforeAll
	public static void beforeAllTestCases() {
		System.out.println("BeforeEach");
		service = new BankLoanService();
	}

	/*Runs only once after all the test case automatically, 
	method name can be anything but it must be static*/
	@AfterAll
	public static void afterAllTestCases() {
		System.out.println("AfterEach");
		service = null;
	}

	@Test
	public void testWithBigNubers() {
		System.out.println("Test1.testWithBigNubers()");
		float actual = service.calSimpleInterest(10000000, 2, 12);
		float expected = 2400000.0f;
		assertEquals(expected, actual);
	}

	@Test
	public void testWithSmallNubers() {
		System.out.println("Test2.testWithSmallNubers()");
		float actual = service.calSimpleInterest(100000, 2, 12);
		float expected = 24000.12f;
		assertEquals(expected, actual, 0.50);
	}

	@Test
	public void testWithInvalidInputs() {
		System.out.println("Test3.testWithInvalidInputs()");
		assertThrows(IllegalArgumentException.class, () -> service.calSimpleInterest(0, 0, 0));
	}

	@Test
	public void testForNoException() {

		System.out.println("Test3.testForNoException()");
		assertDoesNotThrow(() -> service.calSimpleInterest(10000, 4, 2));

	}

	@Test
	public void testWithTimer() {
		System.out.println("Test4.testWithTimer()");
		assertTimeout(Duration.ofMillis(11000), () -> service.timerMethod());
	}
}
