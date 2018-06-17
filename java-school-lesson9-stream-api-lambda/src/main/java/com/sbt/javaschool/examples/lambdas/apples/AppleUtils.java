package com.sbt.javaschool.examples.lambdas.apples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


/**
 * @author Nikita Makarov
 */

public class AppleUtils {

    /**
     * @param inputApples Исходный лист для фильтрации
     * @param predicate   Критерий отбора
     * @return Возвращает новый List<Apple> по заданному пользователем критерию отбора
     */
    public static List<Apple> filterApples(List<Apple> inputApples, Predicate<Apple> predicate) {
        List<Apple> apples = new ArrayList<>();

        for (Apple apple : inputApples) {
            if (predicate.test(apple)) {
                apples.add(apple);
            }
        }
        return apples;
    }

    public static List<Apple> filterApplesWithoutLambda(List<Apple> inputApples, IApplePredicate predicate) {
        List<Apple> apples = new ArrayList<>();

        for (Apple apple : inputApples) {
            if (predicate.test(apple)) {
                apples.add(apple);
            }
        }
        return apples;
    }

    public static void doWithApples(List<Apple> inputApples, Consumer<Apple> consumer) {
        for (Apple apple : inputApples) {
            consumer.accept(apple);
        }
    }

    public static void doWithApplesWithoutLambda(List<Apple> inputApples, IAppleConsumer consumer) {
        for (Apple apple : inputApples) {
            consumer.acept(apple);
        }
    }
}
