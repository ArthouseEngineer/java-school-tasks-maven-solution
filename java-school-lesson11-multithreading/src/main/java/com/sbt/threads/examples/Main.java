package com.sbt.threads.examples;


import sun.nio.ch.ThreadPool;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Runnable task = () -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " Task" + new Date());
            }
        };


        Thread thread = new Thread(task, "new thread");
        thread.start();
        for (int i = 0; i < 10; ++i) {
            new Thread(task).start();
        }

         new Thread(task, "thread").start();

    }

}

