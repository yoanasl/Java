package com.company;
import java.util.*;

public class Main {
    public static void SortArray(int[] arr1, int[] arr2) throws Exception {

        if (1 >= arr1.length || arr2.length >= 1000) {
            throw new Exception("Incorrect input! ");
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] < 0 && arr2[i] <= 1000) {
                throw new Exception("Incorrect input for first array ");
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] < 0 && arr2[i] <= 1000) {
                throw new Exception("Incorrect input for second array ");
            }
        }

        //  putting all elements of the arr 2 into hashmap's key
        // hashmap contains only unique keys, so it will automatically remove that duplicate element
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for (int n : arr2) {
            hashmap.put(n, 0);
        }

        //with the  list addToEnd we put numbers which do not occur in arr2
        List<Integer> addToEnd = new ArrayList<>();
        // increment value in hashmap for every duplicate element
        for (int n : arr1) {
            if (hashmap.containsKey(n)) {
                hashmap.put(n, hashmap.get(n) + 1);
            } else {
                addToEnd.add(n);
            }
        }
        // arrange them in ascending order
        Collections.sort(addToEnd);


        int[] result = new int[arr1.length];
        int index = 0;


        // in result array we sort number by getting order from arr2
        // and get value from hashmap for how times  dublicate numbers
        for (int n : arr2) {
            for (int i = 0; i < hashmap.get(n); i++) {
                result[index++] = n;
            }
        }

        // and now we add numbers which do not occur in arr2
        for (int n : addToEnd) {
            result[index++] = n;
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) throws Exception {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int arr2[] = {2, 1, 4, 3, 9, 6};
        SortArray(arr1, arr2);


    }
}















