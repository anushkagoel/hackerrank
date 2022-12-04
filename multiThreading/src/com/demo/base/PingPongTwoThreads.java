package com.demo.base;

public class PingPongTwoThreads {
    static int[] arr;
    int counter = 0;
    static int N;

    public void printOdd() {
        synchronized (this) {
            while(counter < N) {
                while (counter % 2 == 1) {

                    try {
                        wait();
                    }
                    catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(arr[counter] + " ");
                counter++;
                // Notify to second thread
                notify();
            }
        }
    }

    public void printEven() {
        synchronized (this) {
            while(counter < N) {
                while (counter % 2 == 0) {

                    try {
                        wait();
                    }
                    catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(arr[counter] + " ");
                counter++;
                // Notify to second thread
                notify();
            }
        }

    }

    public static void main(String args[]) {
        arr= new int[]{4,7,9,10,-1,03,7};
        N= arr.length-1;
        PingPongTwoThreads obj = new PingPongTwoThreads();

        Thread t1 = new Thread(() -> obj.printEven());
        Thread t2 = new Thread(() -> obj.printOdd());

        t1.start();
        t2.start();
    }
}
