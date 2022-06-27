package com.nt.service;

public class LoginService {
	
	public String login(String username, String password) {
		if ((username == null || username.length() == 0) || (password == null || password.length() == 0)) {
			throw new IllegalArgumentException("Credentials can't be null");
		} else if (username.equalsIgnoreCase("Raja") && password.equalsIgnoreCase("Rani")) {
			return "Valid Creds";
		} else {
			return "Invalid Creds";
		}
	}
}
