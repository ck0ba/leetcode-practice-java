package org.back0.java;

import java.util.*;
import java.util.stream.IntStream;

public class CollectionsTesting {
    public static void main(String[] args) {
        arrayApi();
        stringApi();

        collectionListApi();
        collectionQueueApi();
        collectionSetApi();

        mapApi();

        enumApi();

        streamApi();
    }

    private static void arrayApi() {
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

    private static void stringApi() {
        var strBuilder = new StringBuilder();


//        sb.setLength(sb.length() - 1);
//        INEFFICIENT (as it does system.arraycopy) -> sb.deleteCharAt(sb.length() - 1)
        strBuilder.deleteCharAt(1);


        char[] chars = {'a', 'b'};
        String string = new String(chars);

        // We can encapsulate the String construtor call by using String.valueOf() or String.copyValueOf() which internally does the same thing
        String string1 = String.valueOf(chars);
        String string2 = String.copyValueOf(chars);

        char[] a = string.toCharArray();
        String str = new String(a);
        String str1 = String.valueOf(a);

        String revert = new StringBuffer(str).reverse().toString();

        var sb = new StringBuilder();

        char initialChar = sb.charAt(0);
        sb.setCharAt(0, 's');
        sb.deleteCharAt(0);
        sb.length();

        // Check if a character c is a digit
        // Character.isDigit(c)

        // str.indexOf(pattern) >= 0;

        /*
        String[] words = paragraph.split("[!?',;. ]”);  // do not forget to append space if needed
        or
        String[] words = paragraph.split("\\W”); // split on any non-word characte

         */
    }

    private static void collectionListApi() {
        List<String> places = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
        List<String> places1 = Collections.singletonList("Buenos Aires");

        ArrayList<String> places2 = new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 8);
        Collections.max(list.subList(0, 6));

//        int[] ints = list.toArray();
        int[][] ints1 = list.toArray(new int[list.size()][]);

        int[] ints = list.stream().mapToInt(i -> i).toArray();
        int[] ints2 = list.stream().mapToInt(Integer::intValue).toArray();
        // Source : https://stackoverflow.com/questions/960431/how-to-convert-listinteger-to-int-in-java

        // int[] to list - JAVA 8
        int[] int4s = {1, 2, 3};
        List<Integer> list1 = Arrays.stream(ints).boxed().toList();
        List<Integer> list2 = IntStream.of(ints).boxed().toList();

        Integer[] values = {1, 3, 7};
        List<Integer> readOnly = Arrays.asList(values);
        List<Integer> list3 = new ArrayList<Integer>(Arrays.asList(values));
    }

    private static void collectionQueueApi() {
    }

    private static void collectionSetApi() {
    }

    private static void mapApi() {
        Map<String, String> phone = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
    }

    private static void enumApi() {
    }

    private static void streamApi() {
        int[] tab = {12, 1, 21, 8};
        int min = Arrays.stream(tab).min().getAsInt();
        int max = Arrays.stream(tab).max().getAsInt();

        Integer[] num = {2, 4, 7, 5, 9};
        int min1 = Collections.min(Arrays.asList(num));

        var countMap = new HashMap<Integer, Integer>() {{
            put(1, 2);
            put(2, 3);
        }};

        Collections.max(countMap.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
        countMap.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        Collections.max(countMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();


        int[] arr = {1, 2, 3, 4};
        int sum = Arrays.stream(arr).sum(); //prints 10

        // Arrays.stream(intArray, startInclusive, endExclusive).sum()
        int sum1 = Arrays.stream(new int[]{1, 2, 3, 4}, 0, 2).sum(); //prints 3
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
