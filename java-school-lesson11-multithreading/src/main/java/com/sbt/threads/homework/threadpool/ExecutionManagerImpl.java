package com.sbt.threads.homework.threadpool;

import com.sbt.threads.homework.api.*;


public class ExecutionManagerImpl implements  IExecutionManager {

    @Override
    public IContext execute(Runnable callback, Runnable... tasks) {
        return  new ThreadPool(callback,tasks);
    }
}
