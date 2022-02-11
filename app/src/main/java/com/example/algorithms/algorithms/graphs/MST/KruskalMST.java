/**
 * Kruskal's Minimum Spanning Tree
 */

package com.example.algorithms.algorithms.graphs.MST;

import com.example.algorithms.datastructures.WeightedQuickUnionUF;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class KruskalMST {
    private ArrayDeque<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new ArrayDeque<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(G.edges());
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(G.V());

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.remove(); // Get min weight edge on pq
            int v = e.either();
            int w = e.other(v);

            if (uf.connected(v, w)) {
                continue; // Ignore ineligible edges.
            }

            uf.union(v, w); // Merge components.
            mst.add(e); // Add edge to mst.
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}