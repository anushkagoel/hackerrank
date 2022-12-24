package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString rev= new ReverseString();
        System.out.print(rev.reverseWords("  hello world  "));
    }
    public String reverseWords(String s) {
        String[] a = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i= a.length; i>0; i--) {
            if(!a[i-1].isEmpty()){
                sb.append(a[i-1]).append(" ");
            }
        }
        return sb.deleteCharAt(sb.length()-1).toString();

//        List<String> sList = Arrays.stream(a).filter(str-> !str.isEmpty()).collect(Collectors.toList());
//        return IntStream.rangeClosed(1, sList.size())
//                .mapToObj(i -> sList.get(sList.size()- i)).collect(Collectors.joining(" "));

    }
}
