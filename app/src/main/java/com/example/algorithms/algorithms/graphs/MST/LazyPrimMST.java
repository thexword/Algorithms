/**
 * Prim's Minimum Spanning Tree algorithm
 */

package com.example.algorithms.algorithms.graphs.MST;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class LazyPrimMST {
    private boolean[] marked; // MST vertices
    private ArrayDeque<Edge> mst; // MST edges
    private PriorityQueue<Edge> pq; // crossing (and ineligible) edges

    public LazyPrimMST(EdgeWeightedGraph G) {
        marked = new boolean[G.V()];
        mst = new ArrayDeque<>();
        pq = new PriorityQueue<>();

        visit(G, 0); // assumes G is connected

        while (!pq.isEmpty()) {
            Edge e = pq.remove(); // Get the edge with smallest weight
            int v = e.either();
            int w = e.other(v);

            if (marked[v] && marked[w]) {
                continue; // Skip if ineligible.
            }

            mst.add(e); // Add edge to tree.

            if (!marked[v]) {
                visit(G, v); // Add vertex to tree
            }

            if (!marked[w]) {
                visit(G, w); // (either v or w).
            }
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        // Mark v and add to pq all edges from v to unmarked vertices.
        marked[v] = true;

        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.add(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}
