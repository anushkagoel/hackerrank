package com.demo.base;

public class EvenOddSynchronizedBlock {
        int counter = 1;
        static int N;

        public void printOdd() {
            synchronized (this) {
                while(counter <N) {
                    while (counter % 2 == 1) {

                        try {
                            wait();
                        }
                        catch (
                                InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(counter + " ");

                    // Increment counter
                    counter++;

                    // Notify to second thread
                    notify();
                }
            }
        }

        public void printEven() {
            synchronized (this) {
                while(counter <N) {
                    while (counter % 2 == 0) {

                        try {
                            wait();
                        }
                        catch (
                                InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(counter + " ");

                    // Increment counter
                    counter++;

                    // Notify to second thread
                    notify();
                }
            }

        }

    public static void main(String args[]) {
        N= 10;
        EvenOddSynchronizedBlock obj = new EvenOddSynchronizedBlock();

        Thread t1 = new Thread(() -> obj.printEven());
        Thread t2 = new Thread(() -> obj.printOdd());

        t1.start();
        t2.start();
    }
}
