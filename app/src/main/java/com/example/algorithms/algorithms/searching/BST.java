package com.example.algorithms.algorithms.searching;

public class BST<Key extends Comparable<Key>, Value> {
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

    public Value minimum() {
        return minimum(root);
    }

    public Value minimum(Node node) {
        if (null == node) {
            return null;
        }

        if (node.left != null) {
            return minimum(node.left);
        } else {
            return node.value;
        }
    }

    public Value maximum() {
        return maximum(root);
    }

    public Value maximum(Node node) {
        if (null == node) {
            return null;
        }

        if (node.right != null) {
            return maximum(node.right);
        } else {
            return node.value;
        }
    }

    public Value floor(Key key) {
        return floor(root, key);
    }

    public Value floor(Node node, Key key) {
        if (null == node) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp > 0) {
            Value value = floor(node.right, key);

            if (null == value) {
                return node.value;
            } else {
                return value;
            }
        } else if (cmp < 0) {
            return floor(node.left, key);
        } else {
            return node.value;
        }
    }

    public Value ceiling(Key key) {
        return ceiling(root, key);
    }

    public Value ceiling(Node node, Key key) {
        if (null == node) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            Value value = ceiling(node.left, key);

            if (null == value) {
                return node.value;
            } else {
                return value;
            }
        } else if (cmp > 0) {
            return ceiling(node.right, key);
        } else {
            return node.value;
        }
    }
}
