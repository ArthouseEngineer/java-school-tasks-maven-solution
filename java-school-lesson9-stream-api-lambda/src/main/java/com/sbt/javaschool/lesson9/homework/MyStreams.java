package com.sbt.javaschool.lesson9.homework;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreams<T> {

    private final List<T> collection;

    private MyStreams(Collection<? extends T> collection) {
        this.collection = (List<T>) collection;
    }

    /**
     * @param collection Коллекция для которой будет создан MyStream
     * @param <T> Тип коллекции на входе
     * @return Возвращает новый MyStream
     */
    public static <T> MyStreams<T> of(Collection<T> collection) {
        return new MyStreams<T>(collection);
    }

    /**
     * @param predicate Лямбда выражение отбора даннх
     * @return Возвращает элементы коллекции удовлитворяющие условию лямбда выражения
     */
    public MyStreams<T> filter(Predicate<? super T> predicate) {
        for (Iterator<T> iterator = this.collection.iterator(); iterator.hasNext(); ) {
            T item = iterator.next();
            if (!predicate.test(item)) {
                iterator.remove();
            }
        }
        return this;
    }

    public MyStreams<T> transform(Function<? super T, ? extends T> transformFunction) {
        for (ListIterator<T> listIterator = collection.listIterator(); listIterator.hasNext(); ) {
            // Создать новый лист
            T transformedItem = transformFunction.apply(listIterator.next());
            listIterator.set(transformedItem);
        }
        return this;
    }

    public <K, V> Map<K, V> toMap(Function<? super T, ? extends K> keyMapper,
                                  Function<? super T, ? extends V> valueMapper) {

        Map<K, V> map = new HashMap<>();

        for (T item : collection) {
            K key = keyMapper.apply(item);
            V value = valueMapper.apply(item);
            map.put(key, value);
        }
        return map;
    }
}
