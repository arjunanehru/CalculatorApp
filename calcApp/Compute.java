package com.peerislands.assessment.calcApp;

import com.peerislands.assessment.calcApp.constants.CalcLogger;
import com.peerislands.assessment.calcApp.constants.OperatorConstants;
import com.peerislands.assessment.calcApp.constants.Util;
import com.peerislands.assessment.calcApp.services.CalcService;
import com.peerislands.assessment.calcApp.services.Operation;

public class Compute {
	public static double invokeCalculation(String operatorTop, double val1, double val2) throws Exception {
		CalcService oper = new Operation();
		try {
			CalcLogger.getLogger("Compute").info("Entering invokeCalculation");
			String operator = Util.getOperator(operatorTop);
			CalcLogger.getLogger("Compute").info("Invoking Operation: " + operator);
			switch (operator) {
			case OperatorConstants.PLUS:
				return oper.Add(val1, val2);
			case OperatorConstants.MINUS:
				return oper.Subtract(val1, val2);
			case OperatorConstants.INTO:
				return oper.Multiply(val1, val2);
			case OperatorConstants.POWER:
				return oper.Exponent(val1, val2);
			case OperatorConstants.BY:
				if (val2 == 0)
					throw new UnsupportedOperationException("Cannot divide by zero");
				return oper.Divide(val1, val2);
			case OperatorConstants.MOD:
				if (val2 == 0)
					throw new UnsupportedOperationException("Cannot divide by zero");
				return oper.Mod(val1, val2);
			}
		} catch (Exception e) {
			System.out.println("Some problem occurred!! Please check application log for more information!!");
			CalcLogger.getLogger("Compute").info("ERROR - an exception occured in invokeCalculation: " + e.getMessage());
		}
		return 0;
	}
}
