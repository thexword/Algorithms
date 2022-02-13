/**
 * Edge Weighted Directed Graph
 */

package com.example.algorithms.algorithms.graphs.SP;

import java.util.ArrayList;

public class EdgeWeightedDigraph {
    private int V;
    private int E;
    private ArrayList<ArrayList<DirectedEdge>> adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new ArrayList<>(V);

        for (int i = 0; i < adj.size(); ++i) {
            adj.add(i, new ArrayList<DirectedEdge>());
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        ArrayList<DirectedEdge> adjV  = adj.get(v);
        adjV.add(e);
        adj.set(v, adjV);
        E++;
    }

    public ArrayList<DirectedEdge> adj(int v) {
        return adj.get(v);
    }
}
