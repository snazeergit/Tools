package com.nt.service;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankLoanServiceTest2 {

	BankLoanService service;

	//runs before every test case automatically, method name can be anything
	@BeforeEach
	public void beforeEveryTestCase() {
		System.out.println("BeforeEach");
		service = new BankLoanService();

	}

	//runs after every test case automatically, method name can be anything
	@AfterEach
	public void afterEveryTestCase() {
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
		//When we provide positive inputs to service method it will not throw any exception 
		assertDoesNotThrow(() -> service.calSimpleInterest(10000, 4, 2));

	}

	
	@Test
	public void testWithTimer() {
		System.out.println("Test4.testWithTimer()");
		assertTimeout(Duration.ofMillis(11000), () -> service.timerMethod());

	}

}
