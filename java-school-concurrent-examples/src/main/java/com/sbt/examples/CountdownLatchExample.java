package com.sbt.examples;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchExample {
    public static long timeTask(int nThreads, final Runnable tasks) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        System.out.println("StartGate await");
                        try {
                            tasks.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                    }
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
        System.out.println(timeTask(10, () -> {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
    }
}
