package com.demo;

import java.util.HashMap;

public class Anagrams {

    public static void main(String args[]) {
        String a = "abc";
        String b = "cba";
        System.out.println(checkAnagram(a,b));

    }

    static Boolean checkAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>(); //character -> frequency map
        for (int i = 0; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i))) {
                Integer value = map.get(a.charAt(i));
                map.put(a.charAt(i), value++);
            } else {
                map.put(a.charAt(i), 1);
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (map.containsKey(b.charAt(i))) {
                Integer value = map.get(b.charAt(i));
                if (value > 0)
                    map.put(b.charAt(i), --value);
                else
                    map.remove(b.charAt(i));
            }

        }
//        long count = map.entrySet().stream().filter(entry -> entry.getValue() > 0 || entry.getValue() < 0).count();
        return map.size() > 0 ? false: true;
    }
}
