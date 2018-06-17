package com.sbt.javaschool.lesson9.homework;

import com.sbt.javaschool.lesson9.homework.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {


        /* Перейдем от объекта типа Integer к Объекту типа String используя функциональный интерфейс
         * В результате применения функционального интерфейса получим 5 долларов
         */
        Function<Integer, String> convert;
        convert = x -> String.valueOf(x) + " долларов";
        System.out.println(convert.apply(5));

        List<Person> people = new ArrayList<>();
        people.add(new Person("Nikita", 22));
        people.add(new Person("Andrey", 25));
        people.add(new Person("Nikolay", 24));
        people.add(new Person("Viktor", 30));
        people.add(new Person("Aleksandra", 20));


        Map personMap = MyStreams.of(people)
                .filter(person -> person.getAge() > 21)
                .transform(person -> new Person(person.getName(), person.getAge() + 5))
                .toMap(person -> person.getName(), person -> person.getAge());

        System.out.println(personMap);

        // Коллекция все же меняеться после выполнения операции...
        people.forEach(System.out::println);
    }
}
