/**
 *
 */
package com.lutepluto.algs4.fund.bqs;

import edu.princeton.cs.algorithms.Stack;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Exercise 1.3.4
 *
 * @author lute
 */
public class Parentheses {

    public static void main(String[] args) {
        Stack<String> left = new Stack<>();
        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            for (String item : line.split("")) {
                if (item.equals("(") || item.equals("{") || item.equals("[")) {
                    left.push(item);
                } else if (item.equals(")") || item.equals("}") || item.equals("]")) {
                    if (left.isEmpty()) {
                        left.push(item);
                    } else {
                        String lastLeft = left.peek();
                        if ((item.equals(")") && lastLeft.equals("(")) ||
                                (item.equals("}") && lastLeft.equals("{")) ||
                                (item.equals("]") && lastLeft.equals("["))) {
                            left.pop();
                        }
                    }
                }
            }
            StdOut.println(left.isEmpty());
            while (!left.isEmpty()) {
                left.pop();
            }
        }
    }

}
