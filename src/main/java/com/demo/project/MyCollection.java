package com.demo.project;

import lombok.Getter;

import java.util.Arrays;
import java.util.Iterator;

@Getter
class MyCollection<T> implements Iterable<T>{
    private T[] items;

    public MyCollection(T[] items) {
        this.items = items;
    }

    public T[] getItems() {
        return items;
    }

    public int size() {
        return items.length;
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.stream(items).iterator();
    }
}