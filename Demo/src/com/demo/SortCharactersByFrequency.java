package com.demo;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {
        public String frequencySort(String s) {
            Map<Character, Integer> frequency = s.chars()
                    .mapToObj(c -> (char)c)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(i -> 1)));
            return frequency.entrySet().stream()
                    .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                    .map( e -> String.join("", Collections.nCopies(e.getValue(), String.valueOf(e.getKey()))))
                    .collect(Collectors.joining());

        }
}
