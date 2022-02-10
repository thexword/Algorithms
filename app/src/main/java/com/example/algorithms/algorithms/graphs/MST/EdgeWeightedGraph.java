package com.example.algorithms.algorithms.graphs.MST;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class EdgeWeightedGraph {
    private int V;
    private int E;
    private ArrayList<ArrayList<Edge>> adj; // adjacency lists for edges

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new ArrayList<>(V);

        for (int v = 0; v < V; ++v) {
            adj.add(v, new ArrayList<Edge>());
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(Edge e) {
        E++;
        
        int v = e.either();
        int w = e.other(v);

        ArrayList<Edge> edgeV = adj.get(v);
        edgeV.add(e);
        adj.set(v, edgeV);

        ArrayList<Edge> edgeW = adj.get(w);
        edgeW.add(e);
        adj.set(w, edgeW);
    }

    public ArrayList<Edge> adj(int v) {
        return adj.get(v);
    }

    public ArrayList<Edge> edges() {
        ArrayList<Edge> b = new ArrayList<>();

        for (int v = 0; v < V; v++) {
            for (Edge e : adj.get(v)) {
                if (e.other(v) > v) { // avoid duplication
                    b.add(e);
                }
            }
        }

        return b;
    }
}
