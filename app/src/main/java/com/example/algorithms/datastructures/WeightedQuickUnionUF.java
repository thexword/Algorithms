/**
 * Union-Find
 */

package com.example.algorithms.datastructures;

public class WeightedQuickUnionUF {
    private int[] id; // access to component id (site indexed)
    private int[] size; // size of component for roots (site indexed)
    private int count; // number of components

    public WeightedQuickUnionUF(int N) {
        id = new int[N];
        size = new int[N];
        count = N;

        for (int i = 0; i < N; ++i) {
            id[i] = i;
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
        while (p != id[p]) { // follow links to find a root
            p = id[p];
        }

        return p;
    }

    public boolean union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return false;
        }

        // make smaller root point to larger one
        if (size[rootP] <= size[rootQ]) {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }

        --count;
        return true;
    }
}
