/**
 * Abstract base class for sort
 */

package com.example.algorithms.algorithms.sorting;

import android.util.Log;

public abstract class Sort {
    private static final String TAG = "Algorithms_Sort";

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; ++i) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }

        return true;
    }

    public static void show(Comparable[] a) {
        Log.d(TAG, "length: " + a.length);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a.length; ++i) {
            sb.append(a[i]).append(" ");
        }

        Log.d(TAG, sb.toString());
    }
}
