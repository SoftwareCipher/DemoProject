package com.demo.project;

import java.util.ArrayList;
import java.util.Arrays;

public class MyList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] objects;
    private int size = 0;

    public MyList() {
        this.objects = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        this.objects = new Object[capacity];
    }

    public void add(T newObject) {
        if (objects.length == size) {
            increaseCapacity();
        }
        objects[size++] = newObject;
    }

    public void add(int index, T newObject) {
        if (objects.length == size) {
            increaseCapacity();
        }

        if (index == size) {
            objects[size] = newObject;
        } else {
            for (int i = size; i > index; i--) {
                objects[i] = objects[i - 1];
            }
            objects[index] = newObject;
        }
        size++;
    }

    public static <T> MyList<T> of(T ... elements){

    }

    public T getFirst(){

    }

    public T getLast(){

    }

    public T remove(int index){

    }

    public boolean contains(T element){

    }

    public boolean isEmpty(){

    }

    public void clear(){

    }

    public T get(int index) {
        checkIndex(index);
        return (T) objects[index];
    }

//    public boolean set(int index, T setObject){
//        if(checkIndex(index)) {
//            objects[index] = setObject;
//            return true;
//        }
//        return false;
//    }

    public boolean checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " is not correct! Size: " + size);
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    private void increaseCapacity() {
        int newCapacity = objects.length * 2;
        objects = Arrays.copyOf(objects, newCapacity);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < size - 1; i++) {
            builder.append(objects[i]);
            builder.append(", ");
        }
        builder.append(objects[size - 1]);
        builder.append("]");

        return builder.toString();
    }
}
