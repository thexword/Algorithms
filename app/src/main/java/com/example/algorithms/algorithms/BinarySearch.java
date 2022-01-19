/**
 * Binary search (Loop implementation)
 */

package com.example.algorithms.algorithms;

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
}
