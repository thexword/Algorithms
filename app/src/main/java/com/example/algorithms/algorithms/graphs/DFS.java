/**
 * Depth First Search
 */

package com.example.algorithms.algorithms.graphs;

public class DFS {
    private boolean[] marked;
    private int count;

    public DFS(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;

        for (Integer w: G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    boolean marked(int w) {
        return marked[w];
    }

    int count() {
        return count;
    }
}
