/**
 * Select the k largest item in the array
 */

package com.example.algorithms.algorithms.searching;

import com.example.algorithms.algorithms.sorting.Quick;
import com.example.algorithms.algorithms.sorting.Sort;

public class QuickSelect extends Sort {
    public static Comparable select(Comparable[] a, int k) {
        int N = a.length - 1;

        if (k < 0 || k > N) {
            return null;
        }

        Quick.shuffleArray(a);

        int lo = 0;
        int hi = N;

        while (lo < hi) {
            int j = Quick.partition(a, lo, hi);

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
}
