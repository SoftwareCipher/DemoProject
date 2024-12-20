package com.demo.project;

import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class MyArrayDeque<T> implements Deque<T> {

    private T[] elements;
    private int head;
    private int tail;

    private int size;

    private static final int DEFAULT_CAPACITY = 10;
    public MyArrayDeque() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        head = 0;
        tail = 0;
        size = 0;
    }

    public MyArrayDeque(int numElements) {
        elements = (T[]) new Object[Math.max(DEFAULT_CAPACITY, numElements)];
    }

    private void doubleCapacity() {
        if (size == elements.length) {
            int r = elements.length - head;
            T[] newElements = (T[]) new Object[elements.length * 2];
            System.arraycopy(elements, head, newElements, 0, r);
            elements = newElements;
            head = 0;
            tail = size;
        }
    }
    @Override
    public void addFirst(T t) {
        doubleCapacity();
        head = (head - 1 + elements.length) % elements.length;
        elements[head] = t;
        size++;
    }

    @Override
    public void addLast(T t) {
        doubleCapacity();
        elements[tail] = t;
        tail = (tail + 1) % elements.length; // кольцевой буфер
        size++;
    }

    @Override
    public boolean offerFirst(T t) {
        try {
            addFirst(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean offerLast(T t) {
        try {
            addLast(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public T removeFirst() {
        T removeElement = (T) elements[head];
        elements[head] = null;
        head = (head + 1) & (elements.length - 1);
        return removeElement;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T pollFirst() {
        return null;
    }

    @Override
    public T pollLast() {
        return null;
    }

    @Override
    public T getFirst() {
        return (T) elements[head];
    }

    @Override
    public T getLast() {
        return (T) elements[size - 1];
    }

    @Override
    public T peekFirst() {
        return null;
    }

    @Override
    public T peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void push(T t) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public Iterator<T> descendingIterator() {
        return null;
    }

    @Override
    public String toString() {
        return "ArrayDeque{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}
