package com.demo;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TopKfrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Integer[] ever = IntStream.of( nums ).boxed().toArray( Integer[]::new );
        Map<Integer, Integer> frequency = Stream.of(ever)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(i->1)));

        return frequency.entrySet().stream()
                .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                .limit(k)
                .map(e-> e.getKey())
                .mapToInt(i->i).toArray();
    }
}
