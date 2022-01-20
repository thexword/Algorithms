package com.example.algorithms.algorithms.sorting;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Quick extends Sort {
    public static void shuffleArray(Comparable[] ar)
    {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            exch(ar, index, i);
        }
    }

    public static void sort(Comparable[] a) {
        shuffleArray(a); // eliminate dependence on input
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo]; //partitioning item
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }

            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;
    }
}
