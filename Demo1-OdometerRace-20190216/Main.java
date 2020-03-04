package com.company;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws java.lang.InterruptedException {
        Vehicle titanic = new Boat(2, 'T');
        Vehicle mountainBike = new Bike(1, 'B');
        Vehicle bmw = new Car(4, '#');

        for (int i = 0; i < 10; i++) {
            clearScreen();
            
            updateRace(titanic);
            updateRace(mountainBike);
            updateRace(bmw);

            TimeUnit.MILLISECONDS.sleep(500);
        }
    }

    public static void updateRace(Vehicle v) {
        v.updateDistanceTravelled();
        System.out.printf("%-" + v.getDistanceTravelled() + "s %s\n", "|", v.getSymbol());
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }

    public static void printDistanceOverTime(Odometer vehicle, int timeUnits) {
        System.out.println("---- New Vehicle ----");
        for (int i = 0; i < timeUnits; i++) {
            System.out.println(vehicle.getDistanceTravelled());
            vehicle.updateDistanceTravelled();
        }
    }
}
