/**
 * Binary Search Tree
 */

package com.example.algorithms.algorithms.searching;

import android.util.Log;

public class BST<Key extends Comparable<Key>, Value> {
    private static final String TAG = "Algorithms_BST";

    private class Node {
        Key key;
        Value value;
        int N; // nodes in subtree rooted here
        Node left;
        Node right;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    private Node root;

    public int size() {
        return size(root);
    }

    public int size(Node node) {
        if (null == node) {
            return 0;
        } else {
            return node.N;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node node, Key key) {
        if (null == node || null == key) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp > 0) {
            return get(node.right, key);
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return node.value;
        }
    }

    public void put(Key key, Value value) {
        if (null == key || null == value) {
            return;
        }

        root = put(root, key, value);
    }

    public Node put(Node node, Key key, Value value) {
        if (null == node) {
            return new Node(key, value, 1);
        }

        int cmp = key.compareTo(node.key);

        if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }

        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key minimum() {
        Node node = minimum(root);

        if (node != null) {
            return node.key;
        } else {
            return null;
        }
    }

    public Node minimum(Node node) {
        if (null == node) {
            return null;
        }

        if (node.left != null) {
            return minimum(node.left);
        } else {
            return node;
        }
    }

    public Key maximum() {
        Node node = maximum(root);

        if (node != null) {
            return node.key;
        } else {
            return null;
        }
    }

    public Node maximum(Node node) {
        if (null == node) {
            return null;
        }

        if (node.right != null) {
            return maximum(node.right);
        } else {
            return node;
        }
    }

    public Key floor(Key key) {
        Node node = floor(root, key);

        if (node != null) {
            return node.key;
        } else {
            return null;
        }
    }

    public Node floor(Node node, Key key) {
        if (null == node || null == key) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp > 0) {
            Node temp = floor(node.right, key);

            if (null == temp) {
                return node;
            } else {
                return temp;
            }
        } else if (cmp < 0) {
            return floor(node.left, key);
        } else {
            return node;
        }
    }

    public Key ceiling(Key key) {
        Node node = ceiling(root, key);

        if (node != null) {
            return node.key;
        } else {
            return null;
        }
    }

    public Node ceiling(Node node, Key key) {
        if (null == node || null == key) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            Node temp = ceiling(node.left, key);

            if (null == temp) {
                return node;
            } else {
                return temp;
            }
        } else if (cmp > 0) {
            return ceiling(node.right, key);
        } else {
            return node;
        }
    }

    public Key select(int num) {
        return select(root, num);
    }

    public Key select(Node node, int num) {
        if (null == node) {
            return null;
        }

        int sizeLeft = size(node.left);
        if (sizeLeft > num) {
            return select(node.left, num);
        } else if (sizeLeft < num) {
            return select(node.right, num - sizeLeft - 1);
        } else {
            return node.key;
        }
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    public int rank(Node node, Key key) {
        if (null == node || null == key) {
            return -1;
        }

        int cmp = key.compareTo(node.key);

        if (cmp > 0) {
            int num = rank(node.right, key);
            if (num != -1) {
                return size(node.left) + 1 + num;
            } else {
                return -1;
            }
        } else if (cmp < 0) {
            return rank(node.left, key);
        } else {
            return size(node.left);
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    public Node deleteMin(Node node) {
        if (null == node) {
            return null;
        }

        if (node.left != null) {
            node.left = deleteMin(node.left);
        } else {
            return node.right; // node.right may be null
        }

        node.N = size(node.left) + size(node.right) + 1;

        return node;
    }

    public void delete(Key key) {
        if (null == key) {
            return;
        }

        root = delete(root, key);
    }

    public Node delete(Node node, Key key) {
        if (null == node) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp > 0) {
            Node right = delete(node.right, key);

            if (null != right) {
                node.right = right;
            }
        } else if (cmp < 0) {
            Node left = delete(node.left, key);

            if (null != left) {
                node.left = left;
            }
        } else {
            if (null == node.left) {
                return node.right;
            }

            if (null == node.right) {
                return node.left;
            }

            Node temp = node;
            node = minimum(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }

        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void print() {
        print(root);
    }

    public void print(Node node) {
        if (null == node) {
            return;
        }

        print(node.left);
        Log.d(TAG, "key: " + node.key + ", value: " + node.value);
        print(node.right);
    }

    public Iterable<Key> keys() {
        return keys(minimum(), maximum());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        com.example.algorithms.datastructures.Queue<Key> queue = new com.example.algorithms.datastructures.Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    public void keys(Node node, com.example.algorithms.datastructures.Queue queue, Key lo, Key hi) {
        if (null == node || null == queue || null == lo || null == hi) {
            return;
        }

        int cmpLeft = lo.compareTo(node.key);
        int cmpRight = hi.compareTo(node.key);

        if (cmpLeft < 0) {
            keys(node.left, queue, lo, hi);
        }

        if (cmpLeft <= 0 && cmpRight >= 0) {
            queue.enqueue(node.key);
        }

        if (cmpRight > 0) {
            keys(node.right, queue, lo, hi);
        }
    }
}
