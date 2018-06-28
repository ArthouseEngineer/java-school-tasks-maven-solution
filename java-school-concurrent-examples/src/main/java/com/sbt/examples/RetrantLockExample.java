package com.sbt.examples;

import java.util.concurrent.locks.ReentrantLock;

public class RetrantLockExample {

    private static ReentrantLock lockExample = new ReentrantLock(false);

    private static void print(String tag, String s) {
        System.out.println(Thread.currentThread().getName() + " " + tag + ": " + s);
    }

    private static class AcquiereLock implements Runnable {
        @Override
        public void run() {

            try {
                int threadNumber = Integer.parseInt(Thread.currentThread().getName());


                lockExample.lock();
                    print("AcquiereLock Runnable", "Try lock ok");

                    print("AcquiereLock Runnable", "Try lock false");

                if (threadNumber < 5) {
                    Thread.sleep(1000);
                } else {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockExample.unlock();
                print("AcquiereLock example", "Unlock");
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            Thread t = new Thread(new AcquiereLock(), String.valueOf(i));
            t.start();
        }
    }

}
