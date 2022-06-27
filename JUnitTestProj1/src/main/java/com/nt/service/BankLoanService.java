package com.nt.service;

public class BankLoanService {

	public float calSimpleInterest(float principle, float rate, float time) {
		if (principle <= 0 || rate <= 0 || time <= 0)
			throw new IllegalArgumentException("Invalid Input");

		return (principle * rate * time) / 100f;
	}

	public void timerMethod() {
		try {
			Thread.sleep(2000);//2 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
