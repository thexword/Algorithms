/**
 * Merge Sort
 */

package com.example.algorithms.algorithms.sorting;

public class Merge extends Sort {
    private static Comparable[] aux; // auxiliary array for merges (must be static!)

    public static void sort(Comparable[] a) { // Top-down mergesort
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int indexLeft = lo;
        int indexRight = mid + 1;

        for (int i = lo; i <= hi; ++i) {
            aux[i] = a[i];
        }

        for (int i = lo; i <= hi; ++i) {
            if (indexLeft > mid) {
                a[i] = aux[indexRight];
                ++indexRight;
            } else if (indexRight > hi) {
                a[i] = aux[indexLeft];
                ++indexLeft;
            } else if (less(aux[indexLeft], aux[indexRight])) {
                a[i] = aux[indexLeft];
                ++indexLeft;
            } else {
                a[i] = aux[indexRight];
                ++indexRight;
            }
        }
    }
}
