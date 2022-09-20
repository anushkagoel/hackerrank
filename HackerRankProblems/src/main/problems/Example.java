package main.problems;

import java.util.Arrays;
import java.util.List;

public class Example {
    public static void main(String args[]) {
        List<Integer> arr = Arrays.asList(3,5,2,9,8,45,21);
        int target = 13;
        getTriplets(arr, target);
    }
    
    private static void getTriplets(List<Integer> arr, int target) {

        
        for(int i=0; i< arr.size(); i++) {
            int remainingSum = target - arr.get(i);
            for(int j =i+1; j<arr.size() ;j++) {
                if(arr.contains(remainingSum - arr.get(j))) {
                    int k = arr.indexOf(remainingSum - arr.get(j));
                    System.out.println(arr.get(i) + "" + arr.get(j) + "" + arr.get(k) );
                    break;
                }
            }
        }
        
    }
}
