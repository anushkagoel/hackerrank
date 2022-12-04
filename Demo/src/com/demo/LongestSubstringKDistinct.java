package com.demo;

public class LongestSubstringKDistinct {

    public int findMinSubArray(int Sum, int[] arr) {
        int length = 0;
        int sumtillHere =0;
        int startIndex= 0;

        for(int i =0; i<arr.length; i++) {
            sumtillHere += arr[i];
            //slide window
            while(sumtillHere >= Sum) {
                length = Math.min(length, i-startIndex+1);
                sumtillHere-= arr[startIndex];
                startIndex ++;
            }
        }
        return length;
    }
}
