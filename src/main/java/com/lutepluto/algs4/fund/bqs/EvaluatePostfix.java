/**
 *
 */
package com.lutepluto.algs4.fund.bqs;

import com.lutepluto.algs4.utils.StringUtils;

import edu.princeton.cs.algorithms.Stack;
import edu.princeton.cs.introcs.StdOut;

/**
 * Exercise 1.3.11
 *
 * @author lute
 */
public class EvaluatePostfix {

    /**
     * @param postfix
     * @return
     */
    public int evaluate(String postfix) {
        Stack<String> operands = new Stack<>();

        for (String s : postfix.split("")) {
            if (StringUtils.isNumber(s)) {
                operands.push(s);
            } else if (StringUtils.isOperator(s)) {
                int right = Integer.parseInt(operands.pop());
                int left = Integer.parseInt(operands.pop());
                int result = 0;
                switch (s) {
                    case "+":
                        result = left + right;
                        break;
                    case "-":
                        result = left - right;
                        break;
                    case "*":
                        result = left * right;
                        break;
                    case "/":
                        result = left / right;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator [" + s + "]");
                }
                operands.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(operands.pop());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        StdOut.println(new EvaluatePostfix().evaluate(new InfixToPostfix().convert("1+2*3+4")));
        StdOut.println(new EvaluatePostfix().evaluate(new InfixToPostfix().convert("(1+2)*(3+4)")));
        StdOut.println(new EvaluatePostfix().evaluate(new InfixToPostfix().convert("1+2+3+4")));
    }

}
