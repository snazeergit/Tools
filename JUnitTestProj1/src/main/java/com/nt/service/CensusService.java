package com.nt.service;

public class CensusService {

	public String exportData() {
		return "data exported";
	}

	public boolean isOdd(int number) {
		if (number % 2 == 0)
			return true;
		else
			return false;
	}

	public String sayHello(String user) {
		return "Hello " + user;
	}

	public boolean isEmpty(String str) {
		return str.isBlank();//Returns true if the string is empty or contains only white space codepoints,otherwise false.
	}
	
}
