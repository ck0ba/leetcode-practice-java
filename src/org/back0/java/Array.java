package org.back0.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Array {

    public static void main(java.lang.String[] args) {
        // 0-sized arrays are sometimes useful, because caller doesn't need to check for NULL and can process the array in consistent way
        int[] zeroSizedArray = new int[0];
        int[] zeroSizedArray1 = {};

        // basic initialization
        int[] array = new int[20];
        int[] array1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // two-dimensional arrays:
        int[][] twoDimensionalArray = new int[10][10];
        int[][] twoDimensionalArray1 = new int[10][];
        int[][] twoDimensionalArray2 = {{1, 2, 3}, {1, 2}, {1, 3, 5}};

        // N-dimensional arrays:
        var nDimensionalArray = new int[10][10][10][10][2][2][2][2];

        // array
        var arrayLength = array.length;
        int[] arrayCopy = array.clone();

        // working with Arrays class
        Arrays.fill(array, 10);
        Arrays.sort(array1);
        Arrays.sort(new Integer[]{3, 1, 2, 3}, Collections.reverseOrder());
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 6);
        int indexOfSearchedElement = Arrays.binarySearch(array1, 5);

        // Custom methods
        fillMultiDimArray(nDimensionalArray, 1);
    }

    public static void fillMultiDimArray(Object array, int value) {
        if (array instanceof int[]) {
            Arrays.fill((int[]) array, value);
        } else {
            Object[] arr = (Object[]) array;

            for (Object subArray : arr) {
                fillMultiDimArray(subArray, value);
            }
        }
    }

}
