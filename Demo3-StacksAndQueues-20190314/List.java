package com.company;

public interface List {
    // Add data
    void append(int data);
    void prepend(int data);

    // Remove data
    void remove(int index);
    int pop();

    // Access data
    int at(int index);

    boolean empty();
}
