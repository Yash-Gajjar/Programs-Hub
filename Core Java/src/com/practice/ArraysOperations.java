package com.practice;

public class ArraysOperations {

    //    Constant Variable for size of an array
    private static final int SIZE_OF_ARRAY = 10;

    public static void main(String[] args) {

//        One Dimensional array
//        There are multiple ways to declare the array
        int[] ages = {21, 24, 43, 54};
        int[] ages2 = new int[]{1, 2, 3, 4};
        int[] ages1 = new int[SIZE_OF_ARRAY];
        ages1[0] = 12;
        ages1[1] = 16;
        ages1[2] = 22;
        int ages3[] = new int[SIZE_OF_ARRAY];

//        Two Dimensional Array
//        There are multiple ways to declare the array
        int[][] mat = {{1, 2}, {2, 3}, {4, 5}};

        int mat1[][] = new int[SIZE_OF_ARRAY][SIZE_OF_ARRAY];
        mat1[0] = new int[SIZE_OF_ARRAY];
        mat1[1] = new int[]{1, 2, 3};

//        Looping through one dimensional array
//        Using normal for loop
        for (int i = 0; i < ages.length; i++)
            System.out.println("Age: " + ages[i]);
        System.out.println();

//        Using for each loop
        for (int age : ages)
            System.out.println("Age: " + age);
        System.out.println();

//        Looping through two dimensional array
//        Using normal for loop
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                System.out.println("Value: " + mat[i][j]);
        System.out.println();

//        Using for each loop
        for (int[] col : mat)
            for (int row : col)
                System.out.println("Value: " + row);
        System.out.println();

    }
}
