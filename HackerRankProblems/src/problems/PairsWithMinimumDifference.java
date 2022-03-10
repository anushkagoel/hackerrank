package problems;

import java.util.*;
import java.util.stream.Collectors;

public class PairsWithMinimumDifference {

    public static void main(String args[]) {
        List<Integer> numbers = Arrays.asList(4,-2,-1,3);
        int n = numbers.size();
        List<Integer> sortedList = numbers.stream().sorted().collect(Collectors.toList());
        int minAbs = Integer.MAX_VALUE;
        Map<Integer, List<String>> pairMap = new HashMap<>();

        for(int i=0; i<n-1; i++) {
            int pairAbsDiff =0;
            if(sortedList.get(i)< 0 && sortedList.get(i+1)< 0 || sortedList.get(i)>0 && sortedList.get(i+1)>0)
                pairAbsDiff = Math.abs(sortedList.get(i) - sortedList.get(i));
            else
                pairAbsDiff = Math.abs(sortedList.get(i))+ Math.abs(sortedList.get(i));

            if(pairAbsDiff < minAbs) {
                minAbs = pairAbsDiff;
                pairMap.put(minAbs, Arrays.asList(sortedList.get(i) + " " + sortedList.get(i+1)));
            }
            else if(pairAbsDiff == minAbs) {
                //multiple pairs sharing the minimum difference)
                if(pairMap.containsKey(pairAbsDiff)) {
                    List<String> pairs = pairMap.get(pairAbsDiff).stream().collect(Collectors.toList());
                    pairs.add(sortedList.get(i) + " " + sortedList.get(i+1));
                    pairMap.put(minAbs, pairs);
                }else{
                    pairMap.put(minAbs, Arrays.asList(sortedList.get(i) + " " + sortedList.get(i+1)));
                }

            }
        }
        for(String s: pairMap.get(minAbs)){
            System.out.println(s);
        }
    }


}
