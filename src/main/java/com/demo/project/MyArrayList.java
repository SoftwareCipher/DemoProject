package com.demo.project;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> implements CustomList<T>{
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] objects;
    private int size = 0;

    public MyArrayList() {
        this.objects = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        this.objects = new Object[capacity];
    }


    public void add(T newObject) {
        if (objects.length == size) {
            increaseCapacity();
        }
        objects[size++] = newObject;
    }

//    public void add(int index, T newObject) {
//        if (objects.length == size) {
//            increaseCapacity();
//        }
//
//        if (index == size) {
//            objects[size] = newObject;
//        } else {
//            for (int i = size; i > index; i--) {
//                objects[i] = objects[i - 1];
//            }
//            objects[index] = newObject;
//        }
//        size++;
//    }

    public void addSystemCopy(int index, T newObject) {
        if (objects.length == size) {
            increaseCapacity();
        }

        if (index == size) {
            objects[size] = newObject;
        } else {
          //TODO
            // System.arraycopy
        }
        size++;
    }

    public static <T> MyArrayList<T> of(T... elements) {
        MyArrayList<T> list = new MyArrayList<>();
        for (T e : elements) {
            list.add(e);
        }
        return list;
    }

    public T getFirst() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty");
        }
        return (T) objects[0];
    }

    public T getLast() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty");
        }
        return (T) objects[size - 1];
    }

//    public T remove(int index){
//        if(checkIndex(index)){
//            T removeElement = (T) objects[index];
//            for(int i = index; i < size - 1; i++){
//                objects[i] = objects[i + 1]; // 1, 2, 3, 5, 6, 7,
//            }
//            objects[--size] = null;
//            return removeElement;
//        }
//        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
//    }

    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removeElement = (T) objects[index];
        if (index < size - 1) {
            System.arraycopy(objects, index + 1, objects, index, size - 1 - index);
        }
        objects[size - 1] = null;
        size--;
        return removeElement;
    }

    public boolean contains(T element) {
        // return Arrays.asList(objects).contains(element);

        for (int i = 0; i < objects.length; i++) {
            if (objects[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        objects = new Object[DEFAULT_CAPACITY];
        size = 0;
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
