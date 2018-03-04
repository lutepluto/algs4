/**
 *
 */
package com.lutepluto.algs4.fund.bqs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.lutepluto.algs4.utils.StringUtils;

import edu.princeton.cs.algorithms.LinkedStack;
import edu.princeton.cs.introcs.StdOut;

/**
 * Exercise 1.3.10
 *
 * @see <a href="http://interactivepython.org/runestone/static/pythonds/BasicDS/InfixPrefixandPostfixExpressions.html">Infix, Prefix and Postfix Expressions</a>
 * @author lute
 */
public class InfixToPostfix {

    @SuppressWarnings("serial")
    private final static Map<String, Integer> PRECEDENCE = new HashMap<String, Integer>() {{
        put("+", 0);
        put("-", 0);
        put("*", 1);
        put("/", 1);
    }};

    /**
     * @param expr
     * @return
     */
    public String convert(String expr) {
        LinkedStack<String> operators = new LinkedStack<>();
        LinkedList<String> result = new LinkedList<>();

        for (String e : expr.split("")) {
            if (StringUtils.isNumber(e)) {
                result.add(e);
            } else if (e.equals("(")) {
                operators.push(e);
            } else if (e.equals(")")) {
                String op = operators.pop();
                while (!op.equals("(")) {
                    result.add(op);
                    op = operators.pop();
                }
            } else if (StringUtils.isOperator(e)) {
                while (!operators.isEmpty() &&
                    StringUtils.isOperator(operators.peek()) &&
                    PRECEDENCE.get(operators.peek()) >= PRECEDENCE.get(e)
                ) {
                    result.add(operators.pop());
                }
                operators.push(e);
            }
        }
        while (!operators.isEmpty()) {
            result.add(operators.pop());
        }
        return connect(result);
    }

    /**
     * @param list
     * @return
     */
    private String connect(LinkedList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        StdOut.println(new InfixToPostfix().convert("1+2*3+4"));
        StdOut.println(new InfixToPostfix().convert("(1+2)*(3+4)"));
    }

}
