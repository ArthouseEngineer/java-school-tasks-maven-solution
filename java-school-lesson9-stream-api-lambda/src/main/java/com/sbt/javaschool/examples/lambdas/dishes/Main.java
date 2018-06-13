package com.sbt.javaschool.examples.lambdas.dishes;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        List<Dish> menu = Arrays.asList(

                new Dish(700, "FISH", "prawns", false),
                new Dish(400, "FISH", "salmon", false),
                new Dish(350, "OTHER", "french fries", true),
                new Dish(220, "OTHER", "rice", true),
                new Dish(200, "OTHER", "season fruit", true),
                new Dish(850, "OTHER", "pizza", false),
                new Dish(900, "MEAT", "pork", false),
                new Dish(1100, "MEAT", "beef", false),
                new Dish(600, "MEAT", "chicken", false)
        );

        List<String> FullCaloriesDish = menu.stream()
                .filter(dish -> dish.getCalories() > 50)
                .map(Dish::getType)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(FullCaloriesDish);




      /*  List<String> lowCaloriesDishesGroups = menu.stream()
                .filter(dish -> dish.getCalories() < 500) // Промежуточные
                .map(Dish::getType) // пром
                .distinct() // Промеежуточная
                .collect(Collectors.toList()); // Терминальная
        System.out.println(lowCaloriesDishesGroups); */


        List<String> words = Arrays.asList("Hello world");

    /*    List<String> distinctLetter = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(distinctLetter); */

        IntSummaryStatistics menuStatistics = menu.stream()
                .collect(Collectors.summarizingInt(Dish::getCalories));

    }
}
