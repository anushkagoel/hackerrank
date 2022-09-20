package com.demo.base;

import java.util.LinkedList;

public class ProducerConsumer {

    public static void main(String args[]) {
        LinkedList<Integer> ll = new LinkedList<>();
        Thread t1 = new Thread(() -> new Producer(ll,5));
        Thread t2 = new Thread(() -> new Consumer(ll));
        t1.start();
        t2.start();
    }
}

class Producer implements Runnable {
    private LinkedList<Integer> ll;
    private int capacity;
    int i=0;

    public Producer(LinkedList<Integer> ll, int capacity) {
        this.ll = ll;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Produced: " + i++);
            produce(i);
        }
    }

    public void produce(int value)  {
        synchronized (ll) {
            while (ll.size() == capacity) {
                try {
                    ll.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ll.add(i);
            ll.notifyAll();
        }
    }
}

class Consumer implements Runnable{
    private LinkedList<Integer> ll;

    public Consumer(LinkedList<Integer> ll) {
        this.ll = ll;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume());
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }

    public int consume() {
        synchronized (ll) {
            while (ll.size() == 0) {
                try {
                    ll.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ll.notifyAll();
            return ll.removeFirst();
        }
    }
}


