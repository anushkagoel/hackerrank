package com.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyCount {

    public static void main(String args[]) {

        String s = "abcabbhh";
                Map<Character, Integer> frequency = s.chars()
                        .mapToObj(c -> (char)c)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(i -> 1)));
                System.out.println(frequency.entrySet());

        Integer[] arr = {4,5,4,5,4,6};
        Stream<Integer> intStream = Stream.of(arr);
        Integer[] arr1 = (Integer[]) intStream.toArray();
        Map<Integer, Integer> frequencyInteger = Stream.of(arr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(i->1)));
        Integer frequestElement = frequencyInteger.entrySet().stream().max(Map.Entry.comparingByValue()).map(e-> e.getKey()).get();
        System.out.println(frequencyInteger.entrySet());


    }

    private static String find_embedded_word(List<String> words, String s) {

//        List<String> words1 = Arrays.asList("cat", "baby", "dog", "bird", "car");
        List<Character> frequency = s.chars().mapToObj(c-> (char) c).collect(Collectors.toList());
        //   Function.identity(), Collectors.summingInt(i -> 1)));
        for(String word: words) {
            List<Character> letters = word.chars().mapToObj(c-> (char) c).collect(Collectors.toList());
            if(frequency.containsAll(letters)) {
                return word;
            }
        }

        return null;

    }
}
