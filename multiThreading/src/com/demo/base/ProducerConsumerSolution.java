package com.demo.base;

import java.util.LinkedList;

public class ProducerConsumerSolution {

    public static void main(String args[]) {
        LinkedList<Integer> sharedQueue = new LinkedList<>();
        int size = 4;
        Thread prodThread = new Thread(new Producer3(sharedQueue, size), "Producer");
        Thread consThread = new Thread(new Consumer3(sharedQueue, size), "Consumer");
        prodThread.start();
        consThread.start();
    }
}

class Producer3 implements Runnable {

    private final LinkedList sharedQueue;
    private final int SIZE;
    int i =0;

    public Producer3(LinkedList sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("Produced: " + ++i);
            try {
                produce(i);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException {

        //wait if the queue is full
        synchronized (sharedQueue) {
            while (sharedQueue.size() == SIZE) {
                    System.out.println("The queue is full " + Thread.currentThread().getName()
                                        + " is waiting , size: " + sharedQueue.size());

                    sharedQueue.wait();
            }
        //producing element and notify consumers
            sharedQueue.add(i);
            sharedQueue.notifyAll();
        }
    }
}

class Consumer3 implements Runnable {

    private final LinkedList sharedQueue;
    private final int SIZE;

    public Consumer3(LinkedList sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume());
                Thread.sleep(50);
            } catch (InterruptedException ex) {
//                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
    }

    private int consume() throws InterruptedException {
        //wait if the queue is empty
        synchronized (sharedQueue) {
            while (sharedQueue.isEmpty()) {
                    System.out.println("The queue is empty " + Thread.currentThread().getName()
                                        + " is waiting , size: " + sharedQueue.size());

                    sharedQueue.wait();
            }

            //Otherwise consume element and notify the waiting producer
            sharedQueue.notifyAll();
            return (Integer) sharedQueue.remove(0);
        }
    }
}
