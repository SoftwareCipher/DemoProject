package com.demo.project;

import java.util.Arrays;

public class MyList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] objects;
    private int size = 0;

    public MyList(Object[] objects) {
        this.objects = new Object[DEFAULT_CAPACITY];
    }

    public MyList() {
        this.objects = new Object[DEFAULT_CAPACITY];
    }

    public void add(T newObject){
        if(objects.length == size){
            increaseCapacity();
        }
        objects[size++] = newObject;
    }

    public T get(int index){
        checkIndex(index);
        return (T) objects[index];
    }

    public boolean set(int index, T setObject){
        if(checkIndex(index)) {
            objects[index] = setObject;
            return true;
        }
        return false;
    }

    public boolean checkIndex(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + " is not correct! Size: " + size);
        }
        return true;
    }

    private void increaseCapacity() {
        int newCapacity = objects.length * 2;
        objects = Arrays.copyOf(objects, newCapacity);
    }
}
