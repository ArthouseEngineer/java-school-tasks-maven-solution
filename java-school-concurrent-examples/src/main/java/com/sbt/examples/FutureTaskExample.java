package com.sbt.examples;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {

    public static void main(String[] args) {


        MyCallable callable1 = new MyCallable(1000);
        MyCallable callable2 = new MyCallable(2000);

        FutureTask<String> futureTask1 = new FutureTask<>(callable1);
        FutureTask<String> futureTask2 = new FutureTask<>(callable2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(futureTask1);
        executorService.execute(futureTask2);

        while (true) {
            try {
                if (futureTask1.isDone() && futureTask2.isDone()) {
                    System.out.println("All is Done!!!");
                    executorService.shutdown();
                    return;
                }
                if (!futureTask1.isDone()) {
                    System.out.println("FutureTask 1 output = " + futureTask1.get());
                }
                System.out.println("Waiting for future task2 to complete");
                System.out.println(futureTask2.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
