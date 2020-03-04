package com.company;

public class LinkedList {
    public Node head;

    public LinkedList() {
        head = null;
    }

    // Add a node at the end of the list
    public void append(Node node) {
        if (empty()) {
            head = node;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = node;
        }
    }

    // Add a node at the beginning of the list
    public void prepend(Node node) {
        if (empty()) {
            head = node;
        } else {
            Node tmp = head;
            head = node;
            head.next = tmp;
        }
    }

    // Remove the node at the given index
    public void remove(int index) {
        Node currentNode = head;
        Node previousNode = null;

        if (empty()) {
            return;
        }

        // Remove head
        if (index == 0) {
            head = head.next;
            return;
        }

        // Traverse the linked list to the node prior to the specified index
        for (int i = 0; i < index; i++) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        // Leave if the end of the list is reached before the desired index
        if (currentNode == null || previousNode == null) {
            return;
        }

        previousNode.next = currentNode.next;
    }

    public Node peek() {
        if (empty()) {
            return null;
        }

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    public Node pop() {
        if (empty()) {
            return null;
        }

        Node currentNode = head;
        Node previousNode = null;
        while (currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if (previousNode == null) {
            // Remove head
            previousNode = head;
            head = null;
            return previousNode;
        }

        previousNode.next = null;

        return currentNode;

    }

    // Access data
    public Node at(int index) {
        Node currentNode = head;
        int currentIndex = 0;
        while (currentNode.next != null && currentIndex != index) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    public boolean empty() {
        return head == null;
    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }
}
