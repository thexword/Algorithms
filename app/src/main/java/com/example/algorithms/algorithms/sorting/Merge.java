/**
 * Merge Sort
 */

package com.example.algorithms.algorithms.sorting;

public class Merge extends Sort {
    private static Comparable[] aux; // auxiliary array for merges (must be static!)

    public static void sort_top_down(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        sort(a, 0, N - 1);
    }

    public static void sort_bottom_up(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];

        for (int size = 1; size < N; size *= 2) {
            for (int lo = 0; lo + size < N; lo += size * 2) {
                 merge(a, lo, lo + size - 1, Math.min(N - 1, lo + size * 2 - 1));
            }
        }
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) { // larger or equal!
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
