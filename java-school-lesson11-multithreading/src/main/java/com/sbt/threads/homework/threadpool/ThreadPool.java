package com.sbt.threads.homework.threadpool;

import com.sbt.threads.homework.api.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.State.NEW;


public class ThreadPool implements IContext {

    private final Object lock = new Object();
    private final List<Thread> threadPool;
    private volatile int nFailedTasks = 0;
    private volatile int nCompletedTask = 0;
    private volatile int nInterruptedTasks = 0;

    //TODO :: Почитать о Complitable future...

    public ThreadPool(Runnable callback, Runnable... tasks) {
        threadPool = new ArrayList<>();
        Barrier barrier = new Barrier(tasks.length);

        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("Необработанное исключение: " + e);
            synchronized (lock) {
                nFailedTasks++;
            }
        });

        for (Runnable task : tasks) {
            Thread newThread = createNewThread(task, barrier);
            threadPool.add(newThread);
            newThread.start();
        }

        new Thread(() -> {
            barrier.await();
            callback.run();
        }).start();
    }


    private Thread createNewThread(Runnable task, Barrier barrier) {
        return new Thread(() -> {
            try {
                if (Thread.interrupted()) {
                    synchronized (lock) {
                        nInterruptedTasks++;
                    }
                    return;
                }
                task.run();
                synchronized (lock) {
                    nCompletedTask++;
                }
            } finally {
                barrier.countDown();
            }
        });
    }


    @Override
    public int getCompletedTaskCount() {
        return nCompletedTask;
    }

    @Override
    public int getFailedTaskCount() {
        return nFailedTasks;
    }

    @Override
    public int getInterruptedTaskCount() {
        return nInterruptedTasks;
    }

    @Override
    public void interrupt() {
        threadPool.stream()
                .filter(thread -> thread.getState() == NEW)
                .forEach(Thread::interrupt);
    }

    @Override
    public boolean isFinished() {
        return threadPool.size() - nInterruptedTasks - nCompletedTask - nFailedTasks == 0;
    }
}
