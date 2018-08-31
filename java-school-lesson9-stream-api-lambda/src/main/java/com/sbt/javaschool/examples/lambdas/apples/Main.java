package com.sbt.javaschool.examples.lambdas.apples;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static final String GREEN_COLOR = "green";
    private static final String RED_COLOR = "green";

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(
                new Apple(120, GREEN_COLOR),
                new Apple(190, RED_COLOR),
                new Apple(190, GREEN_COLOR),
                new Apple(120, RED_COLOR),
                new Apple(170, GREEN_COLOR),
                new Apple(170, RED_COLOR)
        );


        System.out.println("***************************Fun with Predicates***************************\n");

        System.out.println("Big Apples without lambda expression!");
        System.out.println(AppleUtils.filterApplesWithoutLambda(inventory, new ApplePredicate()) + "\n");

        System.out.println("Big Apples with anonymous class");
        System.out.println(AppleUtils.filterApplesWithoutLambda(inventory, new IApplePredicate() {
            @Override
            public boolean test(Apple a) {
                return a.getWeight() > 150;
            }
        }) + "\n" );

        System.out.println("Big Apples with Lambda expression!");
        System.out.println(AppleUtils.filterApples(inventory,apple -> apple.getWeight() > 150) + "\n");


        System.out.println("Only green apples with lambda");
        System.out.println(AppleUtils.filterApples(inventory, apple -> "green".equals(apple.getColor())) + "\n");


        System.out.println("***************************Fun with Consumers*************************** \n");

        System.out.println("Print all apples");
        AppleUtils.doWithApples(inventory,System.out::println);
        System.out.println();

        inventory.sort(Comparator.comparing(Apple::getWeight));

        // К исходному объекту применен компоратор, яблоки теперь храняться в отсортированном виде.
        System.out.println("Print mutable inventory \n");
        // TODO РАЗОБАРТЬСЯ С Consumer!
        //AppleUtils.doWithApples(inventory, System.out::println);
        AppleUtils.doWithApplesWithoutLambda(inventory,System.out::println);
    }
}
