package com.company;

public class Stack {
    private LinkedList storage;
    private int size;

    public Stack() {
        storage = new LinkedList();
        size = 0;
    }

    // Pop
    public Node remove() {
        Node node =  storage.pop();

        // Make sure the storage is not empty before decrementing size
        if (node != null) {
            size--;
        }

        return node;
    }

    // Push
    public void add(Node node) {
        size++;
        storage.append(node);
    }

    public int size() {
        return size;
    }
}
