/**
 * Heap sort
 */

package com.example.algorithms.algorithms.sorting;

public class HeapSort extends Sort {
    public static void sort(Comparable[] a) {
        int N = a.length - 1;

        for (int k = (N - 1) / 2; k >= 0; k--) {
            sink(a, k, N);
        } // heap construction

        while (N > 0) {
            exch(a, 0, N);
            N--;
            sink(a, 0, N);
        } // sortdown
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (k * 2 + 1 <= N) {
            int j = k * 2 + 1;

            if (j < N && less(a[j], a[j + 1])) {
                j++;
            }

            if (less(a[k], a[j])) {
                exch(a, k, j);
            } else {
                break;
            }

            k = j;
        }
    }
}
