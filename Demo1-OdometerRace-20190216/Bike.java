package com.company;

public class Bike extends Vehicle implements Gears{
    int ratio;

    public Bike(int speed, char symbol) {
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
