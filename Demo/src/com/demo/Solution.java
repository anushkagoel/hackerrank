package com.demo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static String getWinner(final List<String> listOfBallots) {
        //Your code
        Map<String, Integer> frequencyMap = listOfBallots.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(i->1)));
        String winner = Collections.max(frequencyMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        int votesForWinner = frequencyMap.get(winner);
        if (frequencyMap.values().stream().filter(i -> i == votesForWinner).count() > 1) {
            return null;
        }
        return (votesForWinner <= listOfBallots.size() / 2) ? null : winner;

    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
//        if(A.length ==1) {
//            return 1;
//        }

        Arrays.sort(A);
        int low = 0;
        int high = A.length-1;
        int mid= 0;

        int i=low;
        int j= high;

        while(i < j) {
            mid = (i+j)/2;
            if(A[high] - A[mid] == A[mid] - A[low]){
                return A[high] - A[mid];
            }
            else if(A[high] - A[mid] > A[mid] - A[low]){
                i = mid+1;
            }
            else if(A[high] - A[mid] < A[mid] - A[low]){
                j = mid-1;
            }
        }
        return Math.min(A[mid]- A[low], A[high]-A[mid]);
    }

    public static void main(String args[]) {
        System.out.println(solution(new int[] {0, 44, 32, 30, 42, 18, 34, 16, 35}));
        // 0, 16, 18, 30, 32, 35, 42, 44
    }

}
