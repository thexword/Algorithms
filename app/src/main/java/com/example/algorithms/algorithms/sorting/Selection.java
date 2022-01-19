/**
 * Selection Sort
 */

package com.example.algorithms.algorithms.sorting;

public class Selection extends Sort {
    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; ++i) {
            int minIndex = i;

            for (int j = i + 1; j < N; ++j) {
                if (less(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }

            exch(a, i, minIndex);
        }
    }
}
