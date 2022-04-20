package com.demo;

public class Demo {
    static Integer c =1;
    public static void main(String args[]) {
        for(int i =0; i<5; i++) {
            Integer num = rand();
            System.out.println(num);
        }
    }

    static Integer rand() {
        return (31*(c++) +  (31*(c) % 21));
    }
}
