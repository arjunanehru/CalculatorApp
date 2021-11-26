package com.peerislands.assessment.calcApp;

import java.util.Stack;

import com.peerislands.assessment.calcApp.constants.CalcLogger;
import com.peerislands.assessment.calcApp.constants.OperatorConstants;
import com.peerislands.assessment.calcApp.constants.Util;

public class Calculate {
	public static Double performOperation(String instruction) throws Exception {
		try {
			CalcLogger.getLogger("Calculate").info("Entering performOperation");
			String expr = (instruction.contains(OperatorConstants.OPENPARANTHESIS)
					|| instruction.contains(OperatorConstants.CLOSEPARANTHESIS))
							? (instruction.replace(OperatorConstants.OPENPARANTHESIS, " ( ")
									.replace(OperatorConstants.CLOSEPARANTHESIS, " ) ").trim()
									.replaceAll(" +", OperatorConstants.SPACE))
							: instruction.trim().replaceAll(" +", " ");
			String[] expression = expr.split(OperatorConstants.SPACE);
			Stack<Double> operandStack = new Stack<Double>();
			Stack<String> operatorStack = new Stack<String>();

			for (int i = 0; i < expression.length; i++) {
				if (expression[i].equals(OperatorConstants.SPACE))
					continue;
				CalcLogger.getLogger("Calculate").info("Invoking Calculation");
				if (expression[i].matches(OperatorConstants.NUMCHECKREGEX)) {
					StringBuffer strBuffer = new StringBuffer();
					while (i < expression.length && expression[i].matches(OperatorConstants.NUMCHECKREGEX))
						strBuffer.append(expression[i++]);
					operandStack.push(Double.parseDouble((strBuffer.toString())));
					i--;
				}

				else if (expression[i].equals(OperatorConstants.OPENPARANTHESIS))
					operatorStack.push(expression[i]);

				else if (expression[i].equals(OperatorConstants.CLOSEPARANTHESIS)) {
					while (!(operatorStack.peek().equals(OperatorConstants.OPENPARANTHESIS)))
						operandStack.push(
								Compute.invokeCalculation(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
					operatorStack.pop();
				}

				else if (Util.validateOperator(expression[i])) {
					while (!operatorStack.empty() && Util.checkPrecedence(expression[i], operatorStack.peek()))
						operandStack.push(
								Compute.invokeCalculation(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
					operatorStack.push(expression[i]);
				}
			}

			while (!operatorStack.empty())
				operandStack
						.push(Compute.invokeCalculation(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
			return operandStack.pop();
		} catch (Exception e) {
			System.out.println("Some problem occurred!! Please check application log for more information!!");
			CalcLogger.getLogger("Calculate").info("ERROR - an exception occured in performOperation: " + e.getMessage());
		}
		return (double) 0;
	}
}
