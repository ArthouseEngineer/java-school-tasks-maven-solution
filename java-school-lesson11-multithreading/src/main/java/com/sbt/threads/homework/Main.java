package com.sbt.threads.homework;

import com.sbt.threads.homework.threadpool.*;
import com.sbt.threads.homework.api.*;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutionManagerImpl executionManager = new ExecutionManagerImpl();

        IContext context = executionManager.execute(

                () ->
                        System.out.println("Все задачи выполнены!"),
                () ->
                {
                    throw new RuntimeException("Что-то пошло не так при выполнении задачи");
                },
                () ->
                {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Второй");
                },
                () ->
                {
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Третий");
                },
                () -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Четвертый");
                },
                () -> System.out.println("Пятый")
        );

        context.interrupt();

        System.out.println("Количество прерванных задач: " + context.getInterruptedTaskCount());

        System.out.println("Количество задач при выполенений которых выброшено исключение: " + context.getFailedTaskCount());

        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Количество выполненых задач на  текущий момент: " + context.getCompletedTaskCount());

        System.out.println("Завершены ли все задачи: " + context.isFinished());


        // Усыпми на немного и дадим время на завершение задачек

        try {
            TimeUnit.MILLISECONDS.sleep(1100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Количество выполненых задач на  текущий момент: " + context.getCompletedTaskCount());

        System.out.println("Успел завершить все задачи: " + context.isFinished());
    }
}
