/**
 * Binary search (Loop implementation)
 */

package com.example.algorithms.algorithms.searching;

public class BinarySearch {
    public static int rank(int key, int[] a) {
        if (null == a || a.length == 0) {
            return -1;
        }

        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
//            int mid = (left + right) / 2; // may overflow!
            int mid = left + (right - left) / 2;

            if (key < a[mid]) {
                right = mid - 1;
            } else if (key > a[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static int rank1(int key, int[] a) {
        if (null == a || a.length == 0) {
            return -1;
        }

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int val = a[mid];

            if (key > val) {
                lo = mid + 1;
            } else if (key < val) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
