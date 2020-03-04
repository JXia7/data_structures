package com.company;

public class Queue {
    private LinkedList storage;
    private int size;

    public Queue() {
        storage = new LinkedList();
        size = 0;
    }

    public Node remove() {
        size--;
        return storage.pop();
    }

    public void add(Node node) {
        size++;
        storage.prepend(node);
        System.out.println("Added " + node.data);
    }

    public int size() {
        return size;
    }
}
