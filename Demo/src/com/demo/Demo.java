package com.demo;

import java.util.*;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String args[]) {
        int[] A = {3,4,5,3,7};

        System.out.println(solution1(A));

    }

    public static int solution(int[] A) {

        int count = 0;
        List<Integer> arr = Arrays.stream(A).boxed().collect(Collectors.toList());

        // first check if its already in correct sequence
        boolean check = false;
        for (int j = 0; j < A.length-2 ; j++) {
            if ((arr.get(j) - arr.get(j + 1) > 0) && (arr.get(j + 1) - arr.get(j + 2) < 0)) {
                check = true;
            } else if ((arr.get(j) - arr.get(j + 1) < 0) && (arr.get(j + 1) - arr.get(j + 2) > 0)) {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        if (check) {
            return 0;
        }

        List<Integer> arrT = new ArrayList<Integer>();

        for (int i = 0; i < A.length; i++) {
//            arrT.clear();
//            arrT.addAll(arr);
            arrT.remove(i);
            int f = 0;
            boolean okay = false;
            while (f < A.length - 3) {
                if (!okay && f != 0) {
                    break;
                }
                if ((arrT.get(f) - arrT.get(f + 1) > 0) && (arrT.get(f + 1) - arrT.get(f + 2) < 0)) {
                    okay = true;
                } else if ((arrT.get(f) - arrT.get(f + 1) < 0) && (arrT.get(f + 1) - arrT.get(f + 2) > 0)) {
                    okay = true;
                } else {
                    okay = false;
                }
                f++;
            }
            if (okay) {
                count++;
            }
        }


    }

    public static int solution1(int[] A) {
        if (A.length < 3) {
            return A[0] != A[1] ? 0 : 1;
        }
        int count = 0;
        for (int i = 0; i < A.length - 2 ; i += 2) {
            int a = A[i];
            int b = A[i+1];
            int c = A[i + 2];
            if (!(a - b > 0 && b - c < 0) && !(a - b < 0 && b - c > 0)) {
                count ++;
            }
        }
        return count;
    }

}
