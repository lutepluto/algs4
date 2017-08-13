/**
 *
 */
package com.lutepluto.algs4.searching.bst;

/**
 * @author lute
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {

        private Key key;

        private Value value;

        private Node left, right;

        private int size;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }

    }

    public void put(Key key, Value value) {
        put(root, key ,value);
    }

    private void put(Node root, Key key, Value value) {
        Node node = new Node(key, value, 1);
        if (root == null) {
            root = node;
        } else {
            int re = root.key.compareTo(key);
            if (re < 0) {
                put(root.right, key , value);
            } else if (re > 0) {
                put(root.left, key, value);
            } else {
                root.value = value;
            }
            root.size = size(root.left) + size(root.right) + 1;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node root, Key key) {
        if (root == null) {
            return null;
        }
        int re = root.key.compareTo(key);
        if (re < 0) {
            return get(root.right, key);
        } else if (re > 0) {
            return get(root.left, key);
        } else {
            return root.value;
        }
    }

    public void delete(Key key) {
        delete(root, key);
    }

    private Node delete(Node root, Key key) {
        if (root == null) {
            return null;
        }
        int re = root.key.compareTo(key);
        if (re < 0) {
            root.right = delete(root.right, key);
        } else if (re > 0) {
            root.left = delete(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            Node tmp = root;
            root = min(root.right);
            root.left = tmp.left;
            root.right = deleteMin(tmp.right);
        }
        root.size = size(root.left) + 1 + size(root.right);
        return root;
    }

    public boolean contains(Key key) {
        Value value = get(key);
        return value != null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        return root == null ? 0 : root.size;
    }

    public Key min() {
        Node min = min(root);
        return min == null ? null : min.key;
    }

    private Node min(Node root) {
        return root == null ? null : min(root.left);
    }

    public Key max() {
        Node max = max(root);
        return max == null ? null : max.key;
    }

    private Node max(Node root) {
        return root == null ? null : max(root.right);
    }

    public Key floor(Key key) {
        return floor(root, key);
    }

    private Key floor(Node root, Key key) {
        if (root == null) {
            return null;
        }
        int re = root.key.compareTo(key);
        if (re > 0) {
            return floor(root.left, key);
        } else if (re == 0) {
            return root.key;
        } else {
            Key theKey = floor(root.right, key);
            return theKey == null ? root.key : theKey;
        }
    }

    public Key ceiling(Key key) {
        return ceiling(root, key);
    }

    private Key ceiling(Node root, Key key) {
        if (root == null) {
            return null;
        }
        int re = root.key.compareTo(key);
        if (re < 0) {
            return ceiling(root.right, key);
        } else if (re == 0) {
            return root.key;
        } else {
            Key theKey = ceiling(root.left, key);
            return theKey == null ? root.key : null;
        }
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node root, Key key) {
        if (root == null) {
            return 0;
        }
        int re = root.key.compareTo(key);
        if (re < 0) {
            return size(root.left) + 1 + rank(root.right, key);
        } else if (re == 0) {
            return size(root.left);
        } else {
            return rank(root.left, key);
        }
    }

    public Key select(int n) {
        return select(root, n);
    }

    private Key select(Node root, int n) {
        if (root == null) {
            return null;
        }
        int re = rank(root.key);
        if (re < n) {
            return select(root.right, n - re - 1);
        } else if (re == n) {
            return root.key;
        } else {
            return select(root.left, n);
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);
        root.size = size(root.left) + 1 + size(root.right);
        return root;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node root) {
        if (root.right == null) {
            return root.left;
        }
        root.right = deleteMax(root.right);
        root.size = size(root.left) + 1 + size(root.right);
        return root;
    }

    public int size(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("low key can not be null");
        if (hi == null) throw new IllegalArgumentException("high key can not be null");

        if (lo.compareTo(hi) > 0) {
            return 0;
        }
        if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        }
        return size() - rank(lo);
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    public Iterable<Key> keys() {
        return null;
    }

}
