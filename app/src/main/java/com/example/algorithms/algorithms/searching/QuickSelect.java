/**
 * Select the k largest item in the array
 */

package com.example.algorithms.algorithms.searching;

import android.util.Log;

import com.example.algorithms.algorithms.sorting.Sort;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSelect extends Sort {
    public static Comparable select(Comparable[] a, int k) {
        int N = a.length - 1;

        if (k < 0 || k > N) {
            return null;
        }

        shuffleArray(a);

        int lo = 0;
        int hi = N;

        while (lo < hi) {
            int j = partition(a, lo, hi);

            if (j == k) {
                return a[k];
            } else if (j > k) {
                hi = j - 1;
            } else {
                lo = j + 1;
            }
        }

        return a[k]; //  lo == hi == k, Can not return null!

//        while (lo <= hi) {
//            int j = partition(a, lo, hi);
//
//            if (j == k) {
//                return a[k];
//            } else if (j > k) {
//                hi = j - 1;
//            } else {
//                lo = j + 1;
//            }
//        }
//
//        return null; // Never reach here!
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo]; // partitioning item
        int i = lo + 1;
        int j = hi;

        while (true) {
            while (i < hi && less(a[i], v)) {
                ++i;
            }

            while (j > lo && less(v, a[j])) {
                --j;
            }

            if (i >= j) {
                break;
            }

            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;
    }

    private static void shuffleArray(Comparable[] ar)
    {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            exch(ar, index, i);
        }
    }
}
