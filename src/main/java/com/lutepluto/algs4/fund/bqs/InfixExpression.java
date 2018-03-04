/**
 *
 */
package com.lutepluto.algs4.fund.bqs;

import edu.princeton.cs.algorithms.Stack;
import edu.princeton.cs.introcs.StdOut;

/**
 * Exercise 1.3.9
 *
 * @author lute
 */
public class InfixExpression {

    private final static String[] OPERATORS = {"+", "-", "*", "/"};

    public String doInfix(String expr) {
        Stack<String> operators = new Stack<>();
        Stack<String> operands = new Stack<>();

        for (String s : expr.split("")) {
            if (contains(s)) {
                operators.push(s);
            } else if (isNumeric(s)) {
                operands.push(s);
            } else if (s.equals(")")) {
                String rightOp = operands.pop();
                String leftOp = operands.pop();
                String operator = operators.pop();
                operands.push("(" + leftOp + operator + rightOp + s);
            }
        }

        return operands.pop();
    }

    private boolean contains(String s) {
        for (String op : OPERATORS) {
            if (s.equals(op)) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        StdOut.println(new InfixExpression().doInfix("1+2)*3-4)*5-6)))"));
    }

}
