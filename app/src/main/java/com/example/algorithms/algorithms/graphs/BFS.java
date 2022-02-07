/**
 * Breadth First Search
 */

package com.example.algorithms.algorithms.graphs;

import com.example.algorithms.datastructures.Queue;
import com.example.algorithms.datastructures.Stack;

public class BFS {
    private boolean[] marked;
    private int count;

    public BFS(Graph G, int s) {
        marked = new boolean[G.V()];
        bfs(G, s);
    }

    private void bfs(Graph G, int v) {
        marked[v] = true;
        count++;

        Queue<Integer> vertex = new Queue<>();
        vertex.enqueue(v);

        while (!vertex.isEmpty()) {
            vertex.dequeue();
            for (Integer w: G.adj(v)) {
                if (!marked[w]) {
                    vertex.enqueue(w);
                    marked[w] = true;
                    count++;
                }
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
