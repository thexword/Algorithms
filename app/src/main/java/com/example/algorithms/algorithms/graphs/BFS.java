/**
 * Breadth First Search
 */

package com.example.algorithms.algorithms.graphs;

import com.example.algorithms.datastructures.Queue;

public class BFS {
    private boolean[] marked;
    private int count;

    public BFS(Graph G, int s) {
        marked = new boolean[G.V()];
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        marked[s] = true;
        count++;

        Queue<Integer> vertex = new Queue<>();
        vertex.enqueue(s);

        while (!vertex.isEmpty()) {
            int v = vertex.dequeue(); // Get new v from the Queue

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
