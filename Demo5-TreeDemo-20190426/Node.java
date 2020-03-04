package com.company;

public class Node<T> {
    Node<T> left;
    Node<T> right;
    Node<T> parent;
    T data;

    Node() {
        left = null;
        right = null;
        parent = null;
    }

    Node(T data) {
        left = null;
        right = null;
        parent = null;
        this.data = data;
    }
}
