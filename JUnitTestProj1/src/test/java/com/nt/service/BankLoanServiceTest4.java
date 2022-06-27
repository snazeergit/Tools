package com.nt.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("BankLoanServiceTest4 class")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //Best  //it works with @Order
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
//@TestMethodOrder(MethodOrderer.Random.class) //Default
//@TestMethodOrder(MethodOrderer.Alphanumeric.class) //Deprecated //Same as MethodName 
public class BankLoanServiceTest4 {

	static BankLoanService service;

	@BeforeAll
	public static void beforeAllTestCases() {
		System.out.println("BeforeEach");
		service = new BankLoanService();
	}

	@AfterAll
	public static void afterAllTestCases() {
		System.out.println("AfterEach");
		service = null;
	}

	@Test
	@DisplayName("Test1:TestWithBigNubers")
	@Order(2)
	@Tag("UAT")
	public void testWithBigNubers(TestInfo info) {
		System.out.println("Test1.testWithBigNubers()");
		System.out.println(info.getClass() + " " + info.getTags() + " " + info.getDisplayName() + " "
				+ info.getTestClass().get().getName() + " " + info.getTestMethod().get().getName());
		float actual = service.calSimpleInterest(10000000, 2, 12);
		float expected = 2400000.0f;
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Test2:TestWithSmallNubers")
	@Order(-2)
	@Tag("PROD")
	public void testWithSmallNubers() {
		System.out.println("Test2.testWithSmallNubers()");
		float actual = service.calSimpleInterest(100000, 2, 12);
		float expected = 24000.12f;
		assertEquals(expected, actual, 0.50);
	}

	@Test
	@Disabled //This test case will be skipped
	@DisplayName("Test3:TestWithInvalidInputs") //To display the name in the Test resultsF
	@Order(10) // To run the Test cases in an Order, lesser the order, more the priority
	@Tag("DEV") //To execute the test cases in specific environments like prod , dev, uat and the env names are not fixed, In Run Configurations-> Configure include, exclude tags.
	public void testWithInvalidInputs() {
		System.out.println("Test3.testWithInvalidInputs()");
		assertThrows(IllegalArgumentException.class, () -> service.calSimpleInterest(0, 0, 0));
	}

	@Test
	@DisplayName("Test4:TestWithNoException")
	@Order(-5)
	@Tag("PROD")
	@Tag("UAT") //This test case will run in both prod and uat environments
	public void testForNoException() {

		System.out.println("Test3.testForNoException()");
		assertDoesNotThrow(() -> service.calSimpleInterest(10000, 4, 2));

	}

	@Test
	@DisplayName("Test5:TestWithTimer")
	@Order(5)
	@Tag("DEV")
	public void testWithTimer() {
		System.out.println("Test4.testWithTimer()");
		assertTimeout(Duration.ofMillis(3000), () -> service.timerMethod());
	}
}
