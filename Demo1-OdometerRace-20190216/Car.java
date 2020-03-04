package com.company;

public class Car extends Vehicle implements Gears {
    int ratio;

    public Car(int speed, char symbol) {
        super(speed, symbol);
        ratio = 1;
    }

    public int getGearRatio() {
        return ratio;
    }

    public void setGearRatio(int ratio) {
        this.ratio = ratio;
    }
}
