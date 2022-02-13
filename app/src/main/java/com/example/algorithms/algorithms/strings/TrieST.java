package com.example.algorithms.algorithms.strings;

public class TrieST<Value> {
    private static int R = 256; //radix
    private Node root; // root of trie

    private class Node<Value> {
        private Value val;
        private Node[] next = new Node[R];
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        // Change value associated with key if in subtrie rooted at x.
        if (x == null) {
            x = new Node();
        }

        if (d < key.length()) {
            char c = key.charAt(d); // Use dth key char to identify subtrie.
            x.next[c] = put(x.next[c], key, val, d + 1);
            return x;
        } else {
            x.val = val;
            return x;
        }
    }

    public Value get(String key) {
        Node x = get(root, key, 0);

        if (null == x) {
            return null;
        } else {
            return (Value) x.val;
        }
    }

    private Node get(Node x, String key, int d) {
        // Return value associated with key in the subtrie rooted at x.
        if (null == x) {
            return null;
        }

        if (d < key.length()) {
            char c = key.charAt(d); // Use dth key char to identify subtrie.
            return get(x.next[c], key, d+1);
        } else {
            return x;
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) {
            return 0;
        }

        int cnt = 0;

        if (x.val != null) {
            cnt++;
        }

        for (char c = 0; c < R; c++) {
            cnt += size(x.next[c]);
        }

        return cnt;
    }
}
