package two;

import java.util.Stack;

public class ReversePolishNotation {
	public static void main(String[] args) {
 		System.out.println(evaluateRBN(new String[]{"12","3","-","4","*"}));
 		System.out.println(evaluateRBN(new String[]{"12","3","4","-","*"}));
	}
	public static String evaluateRBN(String[] pn) {
		Stack<String> stack = new Stack<String>();
 		for(int i=0 ; i<pn.length ; i++) {
			if(isOperator(pn[i])) {
				String operand1 = stack.pop();
				String operand2 = stack.pop();
				stack.push(""+evaluate(operand2, operand1, pn[i]));
			} else {
				stack.push(pn[i]);
			}
		}
 		return stack.pop();
	}
	private static int evaluate(String operand1, String operand2,
			String operator) {
		int opnd1 = Integer.parseInt(operand1);
		int opnd2 = Integer.parseInt(operand2);
		switch (operator) {
		case "+": return  opnd1 + opnd2;
		case "-": return  opnd1 - opnd2;
		case "*": return  opnd1 * opnd2;
		case "/": return  opnd1 / opnd2;
		}
		return 0;
	}
	public static boolean isOperator(String pn) {
		if ("+".equals(pn)
			|| "-".equals(pn)
			|| "*".equals(pn)
			|| "/".equals(pn)) return true;
		else
			return false;
	}
}
