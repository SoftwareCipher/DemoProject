package com.demo.project;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayDequeTest {

    private ArrayDeque arrayDeque;

    @Test
    void addFirst() {
        ArrayDeque<String> arrayDeque1 = new ArrayDeque<>();
        arrayDeque1.addFirst("Hello!");

        assertEquals("Hello!", arrayDeque1.getFirst());
    }

    @Test
    void addLast() {
        ArrayDeque<String> arrayDeque1 = new ArrayDeque<>();
        arrayDeque1.addFirst("Hello_1");
        arrayDeque1.addFirst("Hello_2");
        arrayDeque1.addLast("Hello_3");
        arrayDeque1.addLast("Hello_4");
        arrayDeque1.addLast("Hello_5");
        arrayDeque1.addLast("Hello_6");
        arrayDeque1.addLast("Hello_7");
        arrayDeque1.addLast("Hello_8");
        arrayDeque1.addLast("Hello_9");
        arrayDeque1.addLast("Hello_10");

        System.out.println(arrayDeque1.toString());
        assertEquals("Hello_2", arrayDeque1.getFirst());
        assertEquals("Hello_10", arrayDeque1.getLast());
        assertEquals(10, arrayDeque1.size());
    }

    @Test
    void offerFirst() {
    }

    @Test
    void offerLast() {
    }

    @Test
    void removeFirst() {
    }

    @Test
    void removeLast() {
    }

    @Test
    void pollFirst() {
    }

    @Test
    void pollLast() {
    }

    @Test
    void getFirst() {
    }

    @Test
    void getLast() {
    }

    @Test
    void peekFirst() {
    }

    @Test
    void peekLast() {
    }

    @Test
    void removeFirstOccurrence() {
    }

    @Test
    void removeLastOccurrence() {
    }

    @Test
    void add() {
    }

    @Test
    void offer() {
    }

    @Test
    void remove() {
    }

    @Test
    void poll() {
    }

    @Test
    void element() {
    }

    @Test
    void peek() {
    }

    @Test
    void addAll() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void retainAll() {
    }

    @Test
    void clear() {
    }

    @Test
    void push() {
    }

    @Test
    void pop() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void containsAll() {
    }

    @Test
    void contains() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void iterator() {
    }

    @Test
    void toArray() {
    }

    @Test
    void testToArray() {
    }

    @Test
    void descendingIterator() {
    }
}