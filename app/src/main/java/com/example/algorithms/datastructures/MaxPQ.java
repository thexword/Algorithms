/**
 * Max Priority Queue
 */

package com.example.algorithms.datastructures;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public boolean insert(Key val) {
        if (N >= pq.length - 1) {
            return false;
        }

        N++;
        pq[N] = val;
        swim(N);
        return true;
    }

    public boolean delMax() {
        if (N == 0) {
            return false;
        }

        exch(1, N);
        N--;
        pq[N + 1] = null; // avoid loitering
        sink(1);
        return true;
    }

    private void swim(int k) {
        while (k > 1) {
            int j = k / 2;

            if (less(j, k)) {
                exch(j, k);
            } else {
                break;
            }

            k = j;
        }
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;

            if (j < N && less(j, j + 1)) {
                j++;
            }

            if (less(k, j)) {
                exch(k, j);
            } else {
                break;
            }

            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
