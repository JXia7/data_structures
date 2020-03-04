package com.company;

public class Node<T> {
    Node next;
    T data;

    Node() {
        next = null;
    }

    Node(T data) {
        next = null;
        this.data = data;
    }
}
