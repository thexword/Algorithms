package com.example.algorithms.algorithms.strings;

import com.example.algorithms.datastructures.Queue;

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

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> queue = new Queue<>();
        collect(get(root, pre, 0), pre, queue);
        return queue;
    }

    private void collect(Node node, String pre, Queue<String> queue) {
        if (null == node) {
            return;
        }

        if (node.val != null) {
            queue.enqueue(pre);
        }

        for (char c = 0; c < R; ++c) {
            collect(node.next[c], pre + c, queue);
        }
    }

    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> queue = new Queue<>();
        collect(root, "", pat, queue);
        return queue;
    }

    private void collect(Node node, String pre, String pat, Queue<String> queue) {
        if (null == node) {
            return;
        }

        int d = pre.length();

        if (d == pat.length()) {
            if (node.val != null) {
                queue.enqueue(pre);
            }

            return;
        }

        char next = pat.charAt(d);

        for (char c = 0; c < R; c++) {
            if (next == '.' || next == c) {
                collect(node.next[c], pre + c, pat, queue);
            }
        }
    }

    public String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node x, String s, int d, int length) {
        if (x == null) {
            return length;
        }

        if (x.val != null) {
            length = d;
        }

        if (d == s.length()) {
            return length;
        }

        char c = s.charAt(d);
        return search(x.next[c], s, d+1, length);
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) {
            return null;
        }

        if (d < key.length()) {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        } else {
            x.val = null;
        }

        if (x.val != null) {
            return x;
        }

        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) {
                return x;
            }
        }

        return null;
    }
}
