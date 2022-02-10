package com.example.algorithms.algorithms.graphs.MST;

public class Edge implements Comparable<Edge> {
    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return this.weight;
    }

    public int either() { // either of this edge’s vertices
        return v;
    }

    public int other(int i) { // the other vertex
        if (i == v) {
            return w;
        } else if (i == w) {
            return v;
        } else {
            throw new RuntimeException("Inconsistent edge");
        }
    }

    @Override
    public int compareTo(Edge o) {
        if (this.weight > o.weight) {
            return 1;
        } else if (this.weight < o.weight) {
            return -1;
        } else {
            return 0;
        }
    }
}
