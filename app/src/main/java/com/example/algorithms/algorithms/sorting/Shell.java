/**
 * Shell Sort
 */

package com.example.algorithms.algorithms.sorting;

public class Shell extends Sort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int step = 1;

        while (step < N / 3) {
            step = 3 * step + 1;
        }

        while (step >= 1) {
            for (int i = step; i < N; ++i) {
                for (int j = i; j >= step && less(a[j], a[j - step]); j -= step) {
                    exch(a, j, j - step);
                }

                step /= 3;
            }
        }
    }
}
