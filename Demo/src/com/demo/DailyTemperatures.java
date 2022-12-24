package com.demo;

import java.util.Stack;

public class DailyTemperatures {

//    public int[] dailyTemperatures(int[] temperatures) {
//        Stack<Integer> stack = new Stack<>();
//        int[] answer = new int[temperatures.length];
//        int lastIndex = 0;
//        stack.push(temperatures[0]);
//        for(int i =1; i < temperatures.length; i++) {
//            int temp = temperatures[i];
//            if(!stack.isEmpty()) {
//                int element= stack.pop();
//                if(element > temp) {
//                    stack.push(element);
//                    lastIndex =
//                }
//            }
//        }
//    }

    public int[] dailyTemperatures(int[] temp) {
        int[] res = new int[temp.length];
        for (int i = temp.length - 2; i >= 0; i--) {
            int next = i + 1;
            while (next < temp.length && temp[next] <= temp[i]) {
                if (res[next] == 0) {
                    next = temp.length;
                    break;
                }
                next += res[next];
            }
            if (next < temp.length) res[i] = next - i;
        }
        return res;
    }
}
