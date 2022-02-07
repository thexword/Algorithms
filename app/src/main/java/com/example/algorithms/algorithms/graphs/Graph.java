/**
 * Graph (adjacency list implementation)
 */

package com.example.algorithms.algorithms.graphs;

import java.util.ArrayList;

public class Graph {
    private int V; // number of vertices
    private int E; // number of edges
    private ArrayList<ArrayList<Integer>> adj; // adjacency lists

    public Graph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = new ArrayList<>(V); // Create array of lists.

        for (int v = 0; v < V; v++) { // Initialize all lists
            adj.add(v, new ArrayList<Integer>()); // to empty.
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        ArrayList<Integer> listV = adj.get(v);
        listV.add(w);
        adj.add(v, listV); // Add w to v’s list.

        ArrayList<Integer> listW = adj.get(w);
        listW.add(v);
        adj.add(w, listW); // Add v to w’s list.

        E++;
    }

    public ArrayList<Integer> adj(int v) {
        return adj.get(v);
    }
}
