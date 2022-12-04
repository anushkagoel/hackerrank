package com.demo;

public class MaxSubArraySumOfKSize {
    public int maxMaxSubArraySum(int k, int[] arr) {
        int maxSumSoFar= Integer.MIN_VALUE;
        int maxSumtillHere =0;
        int startIndex= 0;

        for(int i =0; i<arr.length; i++) {
            maxSumtillHere += arr[i];
            //slide window
            if(i >= k-1) {
                maxSumSoFar = Math.max(maxSumSoFar, maxSumtillHere);
                startIndex ++;
                maxSumtillHere-= arr[i];
            }
        }
        return maxSumSoFar;
    }
}
