package com.demo;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseArray {

    public static void main(String args[]) {
//        * Reverse array without using additional array
        Integer[] arr = {4,6,7,8,9,2};
        Arrays.stream(IntStream.rangeClosed(1, arr.length)
                .mapToObj(i -> arr[arr.length - i]).toArray())
                .forEach(System.out::println);
    }
}
