package com.sbt.examples;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class CountdownLatchExample {


    private static final Set<Integer> set = new HashSet<Integer>();

    public static synchronized void add(Integer i) {
        set.add(i);
    }

    public synchronized void remove(Integer i) {
        set.remove(i);
    }

    public static void addTenThings() {
        Random r = new Random();
        for (int i = 0; i < 10; i++)
            add(r.nextInt());
        System.out.println("DEBUG: added ten elements to" + set);
    }

    public static long timeTask(int nThreads, final Runnable tasks) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(() -> {
                try {
                    startGate.await();
                    System.out.println("StartGate await");
                    try {
                        tasks.run();
                    } finally {
                        endGate.countDown();
                        System.out.println("Start Gate open");
                    }
                } catch (InterruptedException e) {
                }
            }, String.valueOf(i));
            t.start();
        }

        Thread.sleep(1000);
        long start = System.currentTimeMillis();
        startGate.countDown();
        endGate.await();
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(timeTask(10, new Runnable() {
            @Override
            public void run() {
                addTenThings();
            }
        }));

        /*   System.out.println(timeTask(10, () -> {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));*/
    }
}
