package com.sbt.javaschool.lesson9.homework;

import com.sbt.javaschool.lesson9.homework.models.Person;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MyStreamsTest {


    private static List<Person> personList = new ArrayList<>();

    @BeforeClass
    public static void setUp() {
        personList.add(new Person("Nikita", 22));
        personList.add(new Person("Andrey", 25));
        personList.add(new Person("Nikolay", 24));
        personList.add(new Person("Viktor", 30));
        personList.add(new Person("Aleksandra", 20));
    }

    @Test
    public void of() {
        assertEquals("test of()", MyStreams.class, MyStreams.of(personList).getClass());
    }

    @Test
    public void filter() {
        assertEquals("test filter()", MyStreams.class, MyStreams.of(personList)
                .filter(person -> person.getAge() < 26));
    }

    @Test
    public void transform() {
        assertEquals("test transform()", MyStreams.class, MyStreams.of(personList)
                .filter(person -> person.getAge() < 26)
                .transform(person -> new Person(person.getName(), person.getAge() + 5))
                .getClass());
    }

    @Test
    public void toMap() {
        assertEquals("test toMap()", Map.class, MyStreams.of(personList)
                .filter(person -> person.getAge() < 26)
                .transform(person -> new Person(person.getName(), person.getAge() + 5))
                .toMap(person -> person.getName(), person -> person.getAge()));
    }
}