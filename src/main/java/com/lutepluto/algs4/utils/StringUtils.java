/**
 *
 */
package com.lutepluto.algs4.utils;

/**
 * @author lute
 */
public class StringUtils {

    private static final String[] OPERATORS = {"+", "-", "*", "/"};

    /**
     * Checks the specified string is an operator.
     *
     * @param s
     * @return
     */
    public static boolean isOperator(String s) {
        for (String operator : OPERATORS) {
            if (s.equals(operator)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks the string is a number or not.
     *
     * @param s
     * @return
     */
    public static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
