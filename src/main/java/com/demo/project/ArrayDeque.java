package com.demo.project;

import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {

    private Object[] elements;
    private int head;
    private int tail;

    private int size;

    private static final int MIN_INITIAL_CAPACITY = 8;

    public ArrayDeque() {
        elements = new Object[MIN_INITIAL_CAPACITY];
    }

    public ArrayDeque(int numElements) {
        elements = new Object[Math.max(MIN_INITIAL_CAPACITY, numElements)];
    }

    @Override
    public void addFirst(T t) {
        if (t == null)
            throw new NullPointerException();

        head = (head - 1) & (elements.length - 1);
        elements[head] = t;

        if (head == tail) {
            doubleCapacity();
        }

        size++;
    }

    private void doubleCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    @Override
    public void addLast(T t) {
        if (t == null)
            throw new NullPointerException();
        tail = (tail + 1) & (elements.length - 1); // кольцевой буфер
        elements[tail] = t;
        if (tail == head) {
            doubleCapacity();
        }
        size++;
    }

    @Override
    public boolean offerFirst(T t) {
        return false;
    }

    @Override
    public boolean offerLast(T t) {
        return false;
    }

    @Override
    public T removeFirst() {
        return null;
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
        return (T) elements[tail];
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
