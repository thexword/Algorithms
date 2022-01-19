/**
 * Union-Find
 */

package com.example.algorithms;

public class UnionFind {
    private int[] a;
    private int[] size;
    private int count;

    public UnionFind(int N) {
        a = new int[N];
        size = new int[N];
        count = N;

        for (int i = 0; i < N; ++i) {
            a[i] = i;
        }

        for (int i = 0; i < N; ++i) {
            size[i] = 1;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        while (p != a[p]) {
            p = a[p];
        }

        return p;
    }

    public boolean union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return false;
        } else {
            if (size[rootP] <= size[rootQ]) {
                a[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                a[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }

            --count;
            return true;
        }
    }
}
