package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {

    }

    public static int getMaxColors(List<Integer> prices, int money) {
        // Write your code here
        int max = 0;
        int left =0;
        int right = 0;
        while (right < prices.size()) {
            int temp = left;
            int total = 0;
            while (temp < right) { //we add up the prices from left (replaced by temp) to right index to see what the current total is
                total += prices.get(temp);
//                if (temp+1 == right) {
//                    total+=prices.get(right);
//                    break;
//                }
                temp++;
            }
            total+=prices.get(right);
            if (total <= money) { // if the total falls within budget, we set the max # of indexes shown by right-left+1
                max = Math.max(max, right-left+1);
            }

            if (total >money) { // if we exceeded budget, left moves up 1
                left++;
            } else { // if we haven't exceeded budget, we try one more index
                right++;
            }
        }

        return max;
    }


}

