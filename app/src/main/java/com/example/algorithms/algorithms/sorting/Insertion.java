/**
 * Insertion Sort
 */

package com.example.algorithms.algorithms.sorting;

public class Insertion extends Sort {
    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 1; i < N; ++i) {
            for (int j = i; j >= 1 && less(a[j], a[j - 1]); --j) {
                exch(a, j, j - 1);
            }
        }
    }
}
