package com.company;

public class Vehicle implements Odometer {
    protected int speed;
    protected int position;
    protected char symbol;

    public Vehicle(int speed, char symbol) {
        this.speed = speed;
        this.symbol = symbol;
        position = 0;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDistanceTravelled() {
        return position;
    }

    public void updateDistanceTravelled() {
        position += speed;
    }

    public char getSymbol() {
        return symbol;
    }
}
