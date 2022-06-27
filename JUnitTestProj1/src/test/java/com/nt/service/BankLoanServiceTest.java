package com.nt.service;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import org.junit.jupiter.api.Test;

//NOte: Order of the test methods getting invoked is random

public class BankLoanServiceTest {

	@Test
	public void testWithBigNubers() {

		System.out.println("Test1.testWithBigNubers()");
		BankLoanService service = new BankLoanService();
		float actual = service.calSimpleInterest(10000000, 2, 12);
		float expected = 2400000.0f;
		//To check expected and actual results are matching or not, if does not match test case will Fail
		assertEquals(expected, actual);

		//assertEquals(expected, actual, "Type your User Friendly message that will be displayed in Failure Trace");

		//the maximum amount difference that is allowed between expected and actual results 10
		//assertEquals(expected, actual,10);
	}

	@Test
	public void testWithSmallNubers() {

		System.out.println("Test2.testWithSmallNubers()");
		BankLoanService service = new BankLoanService();
		float actual = service.calSimpleInterest(100000, 2, 12);
		float expected = 24000.12f;
		//To check expected and actual results are matching, if does not matches test case will Fail
		assertEquals(expected, actual, 0.50);
		//here 0.5 is the delta value i.e the amount difference that is allowed between expected and actual results
	}

	@Test
	public void testWithInvalidInputs() {

		System.out.println("Test3.testWithInvalidInputs()");
		BankLoanService service = new BankLoanService();
		//To check Expected exception has come or not, if we use assertEquals instead of assertThrows then test case will give you Error instead of a Failure 
		assertThrows(IllegalArgumentException.class, () -> service.calSimpleInterest(0, 0, 0));

	}
	
	@Test
	public void testForNoException() {

		System.out.println("Test3.testForNoException()");
		BankLoanService service = new BankLoanService();
		//When we provide positive inputs to service method it will not throw any exception 
		assertDoesNotThrow(() -> service.calSimpleInterest(10000, 4, 2));

	}

	@Test
	public void testWithTimer() {

		System.out.println("Test4.testWithTimer()");
		BankLoanService service = new BankLoanService();
		//This test case will fails if the service method takes more than 5 seconds else succeeds. 
		assertTimeout(Duration.ofMillis(5000), () -> service.timerMethod());

	}

}
