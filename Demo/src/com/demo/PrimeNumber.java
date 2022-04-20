package com.demo;

import java.util.Collections;
import java.util.stream.IntStream;

public class PrimeNumber {
    public static void main(String args[]) {
        int a = 1234;
        System.out.println(IntStream.rangeClosed(2, a/2).noneMatch(i -> a%i == 0));

        //Palindrome
        String s = "abc";
        System.out.println(IntStream.rangeClosed(0, s.length()/2).noneMatch(index -> s.charAt(index) != s.charAt(s.length()-index-1)));

        //sort map by comparing by value
//        sorted = budget .entrySet() .stream()
//        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
//        .collect( toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        //highest and second hightest paid employee
//        list.stream().sorted(Collections.reverseOrder()).distinct().limit(2).skip(1).get();
    }

}
