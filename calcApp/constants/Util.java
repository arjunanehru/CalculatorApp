package com.peerislands.assessment.calcApp.constants;

public class Util {
	public static boolean checkPrecedence(String expression, String operatorTop) throws Exception {
		try {
			if (operatorTop.equals(OperatorConstants.OPENPARANTHESIS)
					|| operatorTop.equals(OperatorConstants.CLOSEPARANTHESIS))
				return false;
			if (operatorTop.equals(OperatorConstants.SYMPOWER) || operatorTop.equals(OperatorConstants.POWER))
				return false;
			if ((expression.equals(OperatorConstants.INTO) || expression.equals(OperatorConstants.SYMINTO))
					|| (expression.equals(OperatorConstants.BY) || expression.equals(OperatorConstants.SYMBY))
					|| (expression.equals(OperatorConstants.MOD) || expression.equals(OperatorConstants.SYMMOD))
							&& ((operatorTop.equals(OperatorConstants.PLUS)
									|| operatorTop.equals(OperatorConstants.SYMPLUS))
									|| (operatorTop.equals(OperatorConstants.MINUS)
											|| operatorTop.equals(OperatorConstants.SYMMINUS))))
				return false;
			else
				return true;
		} catch (Exception e) {
			System.out.println("Some problem occurred!! Please check application log for more information!!");
			CalcLogger.getLogger("Util").info("ERROR - an exception occured in checkPrecedence: " + e.getMessage());
		}
		return false;
	}

	public static boolean validateOperator(String operator) throws Exception {
		try {
			if (operator.equals(OperatorConstants.PLUS) || operator.equals(OperatorConstants.SYMPLUS)
					|| operator.equals(OperatorConstants.MINUS) || operator.equals(OperatorConstants.SYMMINUS)
					|| operator.equals(OperatorConstants.INTO) || operator.equals(OperatorConstants.SYMINTO)
					|| operator.equals(OperatorConstants.BY) || operator.equals(OperatorConstants.SYMBY)
					|| operator.equals(OperatorConstants.MOD) || operator.equals(OperatorConstants.SYMMOD)
					|| operator.equals(OperatorConstants.POWER) || operator.equals(OperatorConstants.SYMPOWER))
				return true;
		} catch (Exception e) {
			System.out.println("Some problem occurred!! Please check application log for more information!!");
			CalcLogger.getLogger("Util").info("ERROR - an exception occured in validateOperator: " + e.getMessage());
		}
		return false;
	}

	public static String getOperator(String operatorTop) {
		try {
			switch (operatorTop) {
			case "plus":
			case "+":
				return OperatorConstants.PLUS;
			case "minus":
			case "-":
				return OperatorConstants.MINUS;
			case "into":
			case "*":
				return OperatorConstants.INTO;
			case "power":
			case "^":
				return OperatorConstants.POWER;
			case "by":
			case "/":
				return OperatorConstants.BY;
			case "mod":
			case "%":
				return OperatorConstants.MOD;
			default:
				return OperatorConstants.EMPTY;
			}
		} catch (Exception e) {
			System.out.println("Some problem occurred!! Please check application log for more information!!");
			CalcLogger.getLogger("Util").info("ERROR - an exception occured in getOperator: " + e.getMessage());
		}
		return OperatorConstants.EMPTY;
	}
}
