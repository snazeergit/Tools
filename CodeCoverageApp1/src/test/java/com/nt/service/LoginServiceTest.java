package com.nt.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LoginServiceTest {
	private LoginService service = new LoginService();

	@Test
	public void testWithValidCredentials() {
		String result = service.login("Raja", "Rani");
		assertEquals("test1", "Valid Creds", result);
	}

	@Test
	public void testWithInValidCredentials() {
		String result = service.login("Raja", "Rambha");
		assertEquals("test2", "Invalid Creds", result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWithNoCredentials() {
		service.login("", "");
	}
}
