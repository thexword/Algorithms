/**
 * Huffman Trie
 */

package com.example.algorithms.algorithms.strings;

import java.util.PriorityQueue;

public class Huffman {
    private static int R = 256; // ASCII alphabet

    private static class Node implements Comparable<Node> {
        // Huffman trie node
        private char ch; // unused for internal nodes
        private int freq; // unused for expand
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    private static Node buildTrie(int[] freq)
    {
        // Initialize priority queue with singleton trees.
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (char c = 0; c < R; c++) {
            if (freq[c] > 0) {
                pq.add(new Node(c, freq[c], null, null));
            }
        }

        while (pq.size() > 1) {
            // Merge two smallest trees.
            Node x = pq.remove();
            Node y = pq.remove();
            Node parent = new Node('\0', x.freq + y.freq, x, y);
            pq.add(parent);
        }

        return pq.remove();
    }

    private static String[] buildCode(Node root) {
        // Make a lookup table from trie.
        String[] st = new String[R];
        buildCode(st, root, "");
        return st;
    }

    private static void buildCode(String[] st, Node x, String s) {
        // Make a lookup table from trie (recursive).
        if (x.isLeaf()) {
            st[x.ch] = s;
            return;
        }

        buildCode(st, x.left, s + '0');
        buildCode(st, x.right, s + '1');
    }
}
