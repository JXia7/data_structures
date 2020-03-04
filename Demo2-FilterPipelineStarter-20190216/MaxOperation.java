package com.company;

public class MaxOperation implements Operation {
    MaxOperation() {}

    public Signal evaluate(Signal input) {
        int[] max = new int[1];
        int[] data = input.getData();

        max[0] = data[0];

        for (int i = 0; i < data.length; i++) {
            if (max[0] < data[i]) {
                max[0] = data[i];
            }
        }

        return new Signal(max);
    }
}
