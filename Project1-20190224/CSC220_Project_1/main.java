package com.company;


import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        LinkedList history = new LinkedList();
        do {
            runCalculator(history);
        } while (goAgain());
    }

    public static void runCalculator(LinkedList history) {
        calculatorBegin();

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        int mainResult;

        if (option == 1) {
            mainResult = resultAdd();
            history.append(new Node(mainResult));
        } else if (option == 2) {
            mainResult = resultSub();
            history.append(new Node(mainResult));
        } else if (option == 3) {
            mainResult = resultMul();
            history.append(new Node(mainResult));
        } else if (option == 4) {
            double divResult = resultDiv();
            history.append(new Node(divResult));
        } else {
            System.out.println();
            System.out.println("History: ");
            Node node = history.at(0);
            while (node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }
    }

    public static void calculatorBegin() {
        System.out.println();
        System.out.println("which operation would you like to perform?");
        System.out.println("Select an option: ");
        System.out.println("1) Addition");
        System.out.println("2) Subtraction");
        System.out.println("3) Multiplication");
        System.out.println("4) Division");
        System.out.println("5) See History");
        System.out.println();
        System.out.print("Option: ");
    }

    public static int firstNumber() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number:");
        int firstNumber = input.nextInt();
        return firstNumber;
    }

    public static int secondNumber() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter second number:");
        int secondNumber = input.nextInt();
        return secondNumber;
    }

    public static int resultAdd() {
        System.out.println();
        System.out.println("Performing Addition.");
        int firstNumber = firstNumber();
        int secondNumber = secondNumber();
        int result = firstNumber + secondNumber;
        System.out.println();
        System.out.printf("%d + %d = %d\n", firstNumber, secondNumber, result);
        return result;
    }

    public static int resultSub() {
        System.out.println();
        System.out.println("Performing Subtraction.");
        int firstNumber = firstNumber();
        int secondNumber = secondNumber();
        int result = firstNumber - secondNumber;
        System.out.println();
        System.out.printf("%d - %d = %d\n", firstNumber, secondNumber, result);
        return result;
    }

    public static int resultMul() {
        System.out.println();
        System.out.println("Performing Multiplication.");
        int firstNumber = firstNumber();
        int secondNumber = secondNumber();
        int result = firstNumber * secondNumber;
        System.out.println();
        System.out.printf("%d * %d = %d\n", firstNumber, secondNumber, result);
        return result;
    }

    public static double resultDiv() {
        System.out.println();
        System.out.println("Performing Division.");
        int firstNumber = firstNumber();
        int secondNumber = secondNumber();
        if(secondNumber == 0) {
            System.out.println();
            System.out.println("Not a valid divisor!");
            return Double.MAX_VALUE;
        }
        double result = firstNumber / (1.0*secondNumber);
        System.out.println();
        System.out.printf("%d / %d = %f\n", firstNumber, secondNumber, result);
        return result;
    }

    public static boolean goAgain() {
        System.out.println();
        System.out.printf("Continue? (y/n): ");
        Scanner input = new Scanner(System.in);
        String yORn = input.next();
        boolean goAgain = false;
        if (yORn.equals("y")) {
            goAgain = true;
        }
        return goAgain;
    }
}
