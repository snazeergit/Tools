package com.nt.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrinterTest {

	@Test
	public void testGetPrinter() {
		Printer p1 = Printer.getPrinter();
		Printer p2 = Printer.getPrinter();
		/*Assertions.assertNotNull(p1);
		Assertions.assertNotNull(p2);*/
		if (p1 == null || p2 != null)
			Assertions.fail("p1 and p2 references can not be null");//Fail the test with the given failure message. 
		Assertions.assertSame(p1, p2);
	}
}
