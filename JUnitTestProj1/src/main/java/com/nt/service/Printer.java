package com.nt.service;

public class Printer {

	//private static Printer INSTANCE = new Printer();
	private static Printer INSTANCE = new Printer();

	private Printer() {
	}

	public static Printer getPrinter() {
		return INSTANCE;
	}

}
