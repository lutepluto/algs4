/**
 *
 */
package com.lutepluto.algs4.fund.bqs;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * @author lute
 */
public class FixedCapacityStackOfStrings {

    private String[] a;

    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        this.a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Exercise 1.3.1
     *
     * @return
     */
    public boolean isFull() {
        return N == a.length;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }

}
