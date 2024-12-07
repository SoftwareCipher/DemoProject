package com.demo.project;

public interface CustomList<T> {
    void add(T newObject);

    void clear();

    boolean isEmpty();

    boolean contains(T element);

    T remove(int index);

    T getFirst();

    int getSize();

    T get(int index);
}
