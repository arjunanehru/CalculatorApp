package com.peerislands.assessment.calcApp.services;

public class Operation implements CalcService {

	public double Add(double a, double b) {
		return a + b;
	}

	public double Subtract(double a, double b) {
		return a - b;
	}

	public double Multiply(double a, double b) {
		return a * b;
	}

	public double Divide(double a, double b) {
		return a / b;
	}

	public double Mod(double a, double b) {
		return a % b;
	}

	public double Exponent(double a, double b) {
		return Math.pow(a, b);
	}
}
