/**
 * Connected Components
 */

package com.example.algorithms.algorithms.graphs;

public class CC {
    private boolean[] marked;
    private int[] id; // the component id which the vertex belongs to
    private int count; // the count of components

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];

        for (int s = 0; s < G.V(); ++s) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int s) {
        marked[s] = true;
        id[s] = count;

        for (Integer w: G.adj(s)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int count() {
        return count;
    }

    int id(int v) {
        return id[v];
    }
}
