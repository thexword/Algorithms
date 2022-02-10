package com.example.algorithms.algorithms.graphs.MST;

public class Edge implements Comparable<Edge> {
    private int v;
    private int w;
    private int weight;

    public Edge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    double weight() {
        return this.weight;
    }

    int either() { // either of this edge’s vertices
        return v;
    }

    int other() { // the other vertex
        return w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
