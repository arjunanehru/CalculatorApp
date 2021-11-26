package com.peerislands.assessment.calcApp;

import java.util.Scanner;
import com.peerislands.assessment.calcApp.constants.CalcLogger;

public class Calculator {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(
				"Hello there! This Calculator supports below operations: \n 1. Addition[plus|+] \n 2. Subtraction[minus|-] \n 3. Multiplication[into|*] \n 4. Division[by|/] \n 5. Modulus[mod|%]");
		System.out.println(
				"You may enter an expression.. For Example - 1 plus 2 by 3 or 1 + 2 / 3 \nPlease provide your input:");
		try {
			CalcLogger.getLogger("Main").info("Initializing Calculator...");
			String input = scanner.nextLine();
			CalcLogger.getLogger("Main").info("Input Received: " + input);
			if (!input.contains(" ")) {
				System.out.println(
						"OOPS! Couldn't understand the input. Please provide the valid instruction!!\nOperators & Operands should be separated by space..");
				CalcLogger.getLogger("Main").info("Invalid instruction.");
			} else
				System.out.println("Result is : " + Calculate.performOperation(input));
		} catch (Exception e) {
			System.out.println("Some problem occurred!! Please check application log for more information!!");
			CalcLogger.getLogger("Main").info("ERROR - an exception occured in main: " + e.getMessage());
		}
	}
}