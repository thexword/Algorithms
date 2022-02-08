package com.example.algorithms.algorithms.graphs;

import com.example.algorithms.datastructures.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo; // last vertex on known path to this vertex
    private int s; // source

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;

        for (Integer w: G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> path = new Stack<>();

        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }

        path.push(s); // do not forget this
        return path;
    }
}
