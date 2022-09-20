package com.demo;

import java.util.Arrays;

public class DemoX {

    public static void main(String args[]) {
//        String s = "ABCCCCBCBA";
//        System.out.println(remove(s));
//        int[] arr = {0,3,7,2,5,8,4,6,0,1 };
        int[] arr = {100,102, 103, 104,4,200,1,3,2};
        //sorted
        Arrays.sort(arr);


        int max_length = 0;
        int maxElemnt = Integer.MIN_VALUE;
        int curr_length =0;

        for(int i =1 ; i< arr.length ; i++) {
            if(arr[i] == arr[i-1]+1) {
                curr_length += 1;
            }
            if(max_length <= curr_length) {
                max_length = curr_length;
                maxElemnt = arr[i];
                curr_length =0;
            }
        }
            System.out.println(maxElemnt);

    }

    static String remove(String s) {
        return removeDuplicates(s);
    }
    char lastChar;

    static String removeDuplicates(String s) {
        //base condition
//        if (s == null || s.length() <= 1) {
//            return s;
//        }
//        int i = 0;
//        while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
//            int j = i;
//            while (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
//                j++;
//            }
//            s = s.substring(0, i - 1);
//            return removeDuplicates(s.substring(j + 1));
////        }
//            if (s.charAt(0) == s.charAt(1)) {
//            }
//            char lastChar = i > 0 ? s.charAt(i - 1) : '\0';
//            String remainingString = removeDuplicates(s);
//
//
//            if (remainingString.length() == 0 && lastChar == s.charAt(0)) {
//                return remainingString;
//            }
//            if (remainingString.length() != 0 && lastChar == s.charAt(0)) {
//                return remainingString.substring(1);
//            }
//            return s + remainingString;
//        }
        return null;
    }
}

//Employee
