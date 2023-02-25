package com.demo;



/*Given a List of time intervals in any order,
merge all overlapping intervals into one and output should have only mutually exclusive intervals.

        Input: Intervals = {{1,3},{2,4},{6,8},{9,10}}
        Output: {{1, 4}, {6, 8}, {9, 10}}

        Input: Intervals = {{6,8},{1,9},{2,4},{4,7}}
        Output: {{1, 9}}*/


//
/*1) sort the interval based on start
2) Use stack to store non - overlapping intervals (initial first pair)
2) Iterate the input 1 to n
   if(start < stack.top())
       stack.push(element);
   else
       Pair pair = stack.peek();
       pair.end = element.end;
       stack.pop();
       stack.push(pair);

4) Return the elements from stack.  */

import java.util.*;

class Intervals {

    int start;
    int end;

    Intervals(int start , int end) {
        this.start = start;
        this.end = end;
    }
}

public class MergeIntervals {


    private void getNonOverlappingIntervals(List<Intervals> intervals) {
        Collections.sort(intervals, new Comparator<Intervals>() {
            @Override
            public int compare(Intervals o1, Intervals o2) {
                return o1.start - o2.start;
            }
        });

        Stack<Intervals> stack = new Stack<>();

        if(!intervals.isEmpty()){
            stack.push(intervals.get(0));
        }

        for(int i=1; i<intervals.size(); i++) {
            int start = intervals.get(i).start;
            if(start < stack.peek().end) {
                Intervals pair = stack.pop();
                pair.end = Math.max(pair.end, intervals.get(i).end);
                stack.push(pair);
            } else {
                stack.push(intervals.get(i));
            }
        }
        for(Intervals interval : stack) {
            System.out.println(interval.start + " "+ interval.end);
        }

    }

    public static void main(String args[]) {

        //{{1,3},{2,4},{6,8},{9,10}}
        //{{6,8},{1,9},{2,4},{4,7}}
        List<Intervals> intervals = new ArrayList<>();
        Intervals one = new Intervals(1,3);
        Intervals two = new Intervals(2,4);
        Intervals three = new Intervals(6,8);
        Intervals four = new Intervals(9,10);
        MergeIntervals test = new MergeIntervals();
        intervals.add(one);
        intervals.add(two);
        intervals.add(three);
        intervals.add(four);
        test.getNonOverlappingIntervals(intervals);
    }
}