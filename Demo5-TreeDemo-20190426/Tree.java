package com.company;

public class Tree {
    Node root;

    Tree() {
        root = null;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node<Integer> insert(int value, Node<Integer> root) {
        if (root == null) {
            // Insert the new node
            root = new Node<>(value);
            return root;
        }

        if (value < root.data) {
            root.left = insert(value, root.left);
            root.left.parent = root;
        } else if (value >= root.data) {
            root.right = insert(value, root.right);
            root.right.parent = root;
        }

        return root;
    }

    public boolean remove(int value) {
        // Find node to delete
        Node<Integer> parent = null;
        Node<Integer> current = root;

        while (current != null) {
            if (value < current.data) {
                parent = current;
                current = current.left;
            } else if (value > current.data) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }

        if (current == null) {
            return false; // Value to delete is not in the tree
        }

        // Current has no left child
        if (current.left == null) {
            // Link parent with right child of current node
            if (parent == null) {
                root = current.right;
            } else {
                if (value < parent.data) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        } else {
            // Current node does have a left child
            Node<Integer> parentOfRightmost = current;
            Node<Integer> rightmost = current.left;

            while (rightmost.right != null) {
                parentOfRightmost = rightmost;
                rightmost = rightmost.right;
            }

            // Replace data in current node
            current.data = rightmost.data;

            // Remove rightmost node
            if (parentOfRightmost.right == rightmost) {
                parentOfRightmost.right = rightmost.left;
            } else {
                // Parent of rightmost is the current node
                parentOfRightmost.left = rightmost.left;
            }

            return true;
        }

        return true;
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node<Integer> root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + ", ");
            inorder(root.right);
        }
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node<Integer> root) {
        if (root != null) {
            System.out.print(root.data + ", ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(Node<Integer> root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + ", ");
        }
    }

    public void rotateLeft(Node<Integer> n) {
        if (n.right == null) {
            return;
        }

        Node<Integer> oldRight = new Node<Integer>(n.right.data);
        oldRight.left = n.right.left;
        oldRight.right = n.right.right;

        n.right = n.right.left;

        if (n.parent == null) {
            root = oldRight;
        } else if (n.parent.left == n) {
            n.parent.left = oldRight;
        } else {
            n.parent.right = oldRight;
        }

        oldRight.left = n;
    }

    protected void rotateRight(Node<Integer> n) {
        if (n.left == null) {
            return;
        }

        Node<Integer> oldLeft = new Node<Integer>(n.left.data);
        oldLeft.left = n.left.left;
        oldLeft.right = n.left.right;

        n.left = oldLeft.right;

        if (n.parent == null) {
            root = oldLeft;
        } else if (n.parent.left == n) {
            n.parent.left = oldLeft;
        } else {
            n.parent.right = oldLeft;
        }
        oldLeft.right = n;
    }

    public int numberOfNodes() {
        return numberOfNodes(root);
    }

    public int numberOfNodes(Node<Integer> node) {
        if (node.left == null && node.right == null) {
            return 1;
        }

        if (node.left == null) {
            return numberOfNodes(node.right) + 1;
        }

        if (node.right == null) {
            return numberOfNodes(node.left) + 1;
        }

        return numberOfNodes(node.left) + numberOfNodes(node.right) + 1;
    }

    public int height() {
        return height(root);
    }

    public int height(Node<Integer> node) {
        if (node == null) {
            return 0;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // The following functions are borrowed from
    // https://rosettacode.org/wiki/Visualize_a_tree#Java for educational use.
    // Code is distributed under GNU Free Documentation License 1.2
    public void display() {
        final int height = 5, width = 64;

        int len = width * height * 2 + 2;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 1; i <= len; i++)
            sb.append(i < len - 2 && i % width == 0 ? "\n" : ' ');

        displayR(sb, width / 2, 1, width / 4, width, root, " ");
        System.out.println(sb);
    }

    private void displayR(StringBuilder sb, int c, int r, int d, int w, Node n,
                          String edge) {
        if (n != null) {
            displayR(sb, c - d, r + 2, d / 2, w, n.left, " /");

            String s = String.valueOf(n.data);
            int idx1 = r * w + c - (s.length() + 1) / 2;
            int idx2 = idx1 + s.length();
            int idx3 = idx1 - w;
            if (idx2 < sb.length())
                sb.replace(idx1, idx2, s).replace(idx3, idx3 + 2, edge);

            displayR(sb, c + d, r + 2, d / 2, w, n.right, "\\ ");
        }
    }
}

