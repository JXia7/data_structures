package com.company;

public class Signal {
    private int[] data;

    Signal(int[] data) {
        this.data = data;
    }

    int[] getData() {
        return data;
    }

    int length() {
        return data.length;
    }

    void print() {
        for (int i = 0; i < data.length-1; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println(data[data.length-1]);
    }
}
