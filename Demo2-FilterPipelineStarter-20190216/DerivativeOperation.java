package com.company;

public class DerivativeOperation implements Operation {
    DerivativeOperation() {}

    public Signal evaluate(Signal input) {
        int[] data = input.getData();
        int[] derivative = new int[data.length-1];

        for (int i = 1; i < data.length; i++) {
            derivative[i-1] = data[i] - data[i-1];
        }

        return new Signal(derivative);
    }
}
