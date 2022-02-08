/**
 * Breadth First Path
 */

package com.example.algorithms.algorithms.graphs;

import com.example.algorithms.datastructures.Queue;
import com.example.algorithms.datastructures.Stack;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        marked[s] = true;
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);

        while (!queue.isEmpty()) {
            int v = queue.dequeue(); // Get new v from the Queue

            for (Integer w: G.adj(v)) {
                if (!marked[w]) {
                    queue.enqueue(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
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
