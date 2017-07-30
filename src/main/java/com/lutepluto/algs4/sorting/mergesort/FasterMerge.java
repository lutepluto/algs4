/**
 *
 */
package com.lutepluto.algs4.sorting.mergesort;

/**
 * Creative problem 2.2.10
 *
 * @author lute
 */
@SuppressWarnings("rawtypes")
public class FasterMerge {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = hi;

        for (int k = lo; k <= mid; k++) {
            aux[k] = a[k];
        }
        for (int k = mid + 1; k <= hi; k++) {
            aux[k] = a[hi - (k - mid - 1)];
        }

        for (int k = lo; k <= hi; k++) {
            if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j--];
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

}
