package com.practice;

public class VariableLengthArguments {
    public static void main(String[] args) {
        displaySum(1, 2, 3);
        displaySum(1, 2, 3, 4, 5);
        displaySum(1, 2, 3, 4, 5, 6, 7, 8);
    }

    private static void displaySum(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Sum Of " + numbers.length + " Numbers is: " + sum);
    }
}
