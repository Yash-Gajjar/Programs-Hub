package com.practice;

public class RecursionPractice {
    public static void main(String[] args) {
//        Program to print pattern
        printPattern(6) ;
        System.out.println();
        printPatternNormally(6) ;
        System.out.println();
        printReversePattern(6) ;

    }

    private static void printReversePattern(int i) {

        for (int j = 0; j < i; j++) {
            System.out.print("* ");
        }
        System.out.println();
        if(i >0)
            printReversePattern(--i);
    }

    private static void printPatternNormally(int i) {
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < j; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printPattern(int i) {
        if(i>0)
            printPattern(--i);
        for (int j = 0; j < i; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
