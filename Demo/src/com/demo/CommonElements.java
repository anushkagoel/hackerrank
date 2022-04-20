package com.demo;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class CommonElements {
    public static void main(String[] args) {
        String[] s1 = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "FOUR"};
        String[] s2 = {"THREE", "FOUR", "FIVE", "SIX", "SEVEN", "FOUR"};
        Set<String> result = Arrays.asList(s1).stream()
                .distinct()
                .filter(Arrays.asList(s2)::contains)
                .collect(Collectors.toSet());
        System.out.println(result);     //OUTPUT : [THREE, FOUR, FIVE]
    }
}