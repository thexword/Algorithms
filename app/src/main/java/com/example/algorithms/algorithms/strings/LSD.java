/**
 * Least-Significant-Digit First
 */

package com.example.algorithms.algorithms.strings;

public class LSD {
    public static void LSD(String[] a, int W) {
        // Sort a[] on leading W characters.
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for (int d = W - 1; d >= 0; d--) { // Sort by key-indexed counting on dth char.
            int[] count = new int[R + 1];

            for (int i = 0; i < N; ++i) { // Compute frequency counts.
                count[a[i].charAt(d) + 1]++;
            }

            for (int r = 0; r < R; ++r) { // Transform counts to indices.
                count[r + 1] += count[r];
            }

            for (int i = 0; i < N; ++i) { // Distribute.
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            for (int i = 0; i < N; ++i) { // Copy back.
                a[i] = aux[i];
            }
        }

    }
}
