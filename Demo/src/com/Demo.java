package com;

import java.util.*;
import java.util.function.Predicate;

public class Demo {
        public static void main(String args[]) {
                        randomInts(5);
                        randomInts(9, 50, 90);
//getStreamOfRandomInts(30, 50);
                }
//method that generates a stream of integers having size 5
                public static void randomInts(int num)
                {
                        Random random = new Random();
                        random.ints(num).forEach(System.out::println);
                }
//method that generates a stream of 9 integers between 50 to 90
                public static void randomInts(int num, int origin, int bound)
                {
                        Random random1 = new Random();
                        random1.ints(num, origin, bound).forEach(System.out::println);
                }{
                        randomInts(5);
                        randomInts(9, 50, 90);
//getStreamOfRandomInts(30, 50);
                }
        }


