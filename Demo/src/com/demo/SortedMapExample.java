package com.demo;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortedMapExample {

    public static void main(String args[]) {
        Integer[]  a = {7,8,2,4,8,1,9,0,7};
        Arrays.asList(a).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(i -> 1)))
                .entrySet().stream()
                .sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> System.out.print(e.getKey()));
    }
}
