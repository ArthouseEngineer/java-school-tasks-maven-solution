package com.sbt.threads.homework.api;

public interface IExecutionManager {
    IContext execute(Runnable callback, Runnable... tasks);
}
