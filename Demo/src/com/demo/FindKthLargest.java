package com.demo;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindKthLargest {
        public int findKthLargest(int[] nums, int k) {
            Integer[] ever = IntStream.of( nums ).boxed().toArray( Integer[]::new );
            Map<Integer, Integer> frequency = Stream.of(ever)
                    .sorted((a,b) -> b.compareTo(a))
                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.summingInt(i->1)));
            for(Map.Entry<Integer, Integer> entry : frequency.entrySet()){
                if(k <= entry.getValue()) {
                    return entry.getKey();
                } else {
                    k -= entry.getValue();
                }
            }
            return -1;
        }

        public static void main(String args[]) {
            FindKthLargest demo = new FindKthLargest();
            demo.findKthLargest(Arrays.asList(3,2,1,5,6,4).stream().mapToInt(i->i).toArray(), 2);
        }
}
