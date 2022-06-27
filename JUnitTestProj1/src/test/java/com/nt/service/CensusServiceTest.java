package com.nt.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CensusServiceTest {

	@Disabled
	// Test case will executed 10 times with each execution name as using below template, variable names are fixed here
	@RepeatedTest(value = 10, name = "execution of {displayName}-{currentRepetition}/{totalRepetitions}")
	@DisplayName("Test Export Data")
	public void testExportData() {
		CensusService service = new CensusService();
		Assertions.assertEquals("data exported", service.exportData());
	}

	@Disabled
	@RepeatedTest(10) // Test case will executed 10 times
	@DisplayName("Test Data")
	public void testExportDataRepeatNoName() {
		CensusService service = new CensusService();
		Assertions.assertEquals("data exported", service.exportData());
	}

	@Disabled
	@DisplayName("Test isOdd")
	@ParameterizedTest
	@ValueSource(ints = { 1, 23, 4, 5, 6, 7, 8, 9, 10 })
	public void testIsOdd(int num) {
		CensusService service = new CensusService();
		Assertions.assertTrue(service.isOdd(num));
	}

	@Disabled
	@DisplayName("Test sayHello")
	@ParameterizedTest
	@ValueSource(strings = { "nazeer", "sardar", "dilshad" })
	public void testSayHellow(String user) {
		CensusService service = new CensusService();
		Assertions.assertEquals("Hello " + user, service.sayHello(user));
	}

	@DisplayName("Test isEmpty")
	@ParameterizedTest
	@ValueSource(strings = { "", " ", "dilshad" }) // This works along with @ParameterizedTest, 
	//here the service method returns false only for dilshad so the third test case will fail, blank space is considered as empty by service method isBlank().
	@NullSource //inputs the null value to the variable str hence it will return error check service method.
	@EmptySource // inputs empty value 
	//@NullAndEmptySource // @NullAndEmptySource = @NullSource + @EmptySource
	public void testIsEmpty(String str) {
		CensusService service = new CensusService();
		Assertions.assertTrue(service.isEmpty(str));
	}

}
