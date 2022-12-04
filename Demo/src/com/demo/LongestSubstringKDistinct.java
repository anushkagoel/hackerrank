package com.demo;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    public int LongestSubstringKDistinct(int k, String s) {
        int length = 0;
        int lenTillHere =0;
        int startIndex= 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i =0; i< s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            //slide window
            while(map.size() > k) {
                map.put(s.charAt(startIndex), map.get(s.charAt(startIndex)) -1);
                if(map.get(s.charAt(startIndex)) == 0) {
                    map.remove(s.charAt(startIndex));
                }
                startIndex++;
            }
            length = Math.min(length, i-startIndex+1);
        }
        return length;
    }
}
