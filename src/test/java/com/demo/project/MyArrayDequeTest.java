package com.demo.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayDequeTest {

    private MyArrayDeque myArrayDeque;

    @Test
    void addFirst() {
        MyArrayDeque<String> myArrayDeque1 = new MyArrayDeque<>();
        myArrayDeque1.addFirst("Hello!");
        myArrayDeque1.addFirst("Hello1");
        System.out.println(myArrayDeque1.toString());
        assertEquals("Hello1", myArrayDeque1.getFirst());
    }

    @Test
    void addLast() {
        MyArrayDeque<String> myArrayDeque1 = new MyArrayDeque<>();
        myArrayDeque1.addLast("Hello_1");
        myArrayDeque1.addLast("Hello_2");
        myArrayDeque1.addLast("Hello_3");
        myArrayDeque1.addLast("Hello_4");
        myArrayDeque1.addLast("Hello_5");
        myArrayDeque1.addLast("Hello_6");
        myArrayDeque1.addLast("Hello_7");
        myArrayDeque1.addLast("Hello_8");
        myArrayDeque1.addLast("Hello_9");
        myArrayDeque1.addLast("Hello_10");
        myArrayDeque1.addFirst("Hello_11");

        System.out.println(myArrayDeque1.toString());
        assertEquals("Hello_10", myArrayDeque1.getLast());
        assertEquals(10, myArrayDeque1.size());
    }

    @Test
    void offerFirst() {
        MyArrayDeque<String> myArrayDeque1 = new MyArrayDeque<>();
        myArrayDeque1.addFirst("Hello_1");
        myArrayDeque1.addFirst("Hello");
        myArrayDeque1.addLast("Hello_4");
        myArrayDeque1.offerFirst("Hello_2");
        System.out.println(myArrayDeque1.toString());
        assertEquals(true, myArrayDeque1.offerFirst("Hello_3"));
        System.out.println(myArrayDeque1.toString());
    }

    @Test
    void offerLast() {
        MyArrayDeque<String> myArrayDeque1 = new MyArrayDeque<>();
        myArrayDeque1.addFirst("Hello_1");
        myArrayDeque1.addFirst("Hello");
        myArrayDeque1.addLast("Hello_4");
        myArrayDeque1.offerLast("Hello_2");
        System.out.println(myArrayDeque1.toString());
        assertEquals(true, myArrayDeque1.offerLast("Hello_3"));
        System.out.println(myArrayDeque1.toString());
    }

    @Test
    void removeFirst() {
        MyArrayDeque<String> myArrayDeque1 = new MyArrayDeque<>();
        myArrayDeque1.addFirst("Hello_1");
        myArrayDeque1.addFirst("Hello");
        myArrayDeque1.addLast("Hello_4");
        myArrayDeque1.offerLast("Hello_2");
        System.out.println(myArrayDeque1.toString());
        myArrayDeque1.removeFirst();
        System.out.println(myArrayDeque1.toString());
        assertEquals("Hello_1", myArrayDeque1.getFirst());
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