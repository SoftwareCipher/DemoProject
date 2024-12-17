package com.demo.project.MyCollections;

public interface CustomList<T> {
    void add(T newObject);

    void add(int index, T newObject);

    void clear();

    T set(int index, T newObject);

    boolean isEmpty();

    boolean contains(T element);

    T remove(int index);

    T getFirst();

    T getLast();

    int getSize();

    T get(int index);
}
