package com.demo.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void add() {

    }

    @Test
    void addByIndexFirst() {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("Hello_1");
        stringMyLinkedList.add("Hello_2");
        stringMyLinkedList.add("Hello_3");
        stringMyLinkedList.add("Hello_4");

        stringMyLinkedList.add(0, "Hello_1_1");

        assertEquals("Hello_1_1", stringMyLinkedList.getFirst());
    }

    @Test
    void addByIndexLast() {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("Hello_1");
        stringMyLinkedList.add("Hello_2");
        stringMyLinkedList.add("Hello_3");
        stringMyLinkedList.add("Hello_4");

        stringMyLinkedList.add(3, "Hello_1_1");

        assertEquals("Hello_1_1", stringMyLinkedList.getLast());
    }

    @Test
    void addByIndex() {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("Hello_1");
        stringMyLinkedList.add("Hello_2");
        stringMyLinkedList.add("Hello_3");
        stringMyLinkedList.add("Hello_4");

        stringMyLinkedList.add(1, "Hello_2_2");

        assertEquals("Hello_2_2", stringMyLinkedList.get(1));
    }


    @Test
    void testAdd() {
    }

    @Test
    void clear() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void contains() {
    }

    @Test
    void remove() {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("Hello_1");
        stringMyLinkedList.add("Hello_2");
        stringMyLinkedList.add("Hello_3");
        stringMyLinkedList.add("Hello_4");
        stringMyLinkedList.add("Hello_5");

        assertEquals("Hello_5", stringMyLinkedList.remove(4));
        assertEquals(4, stringMyLinkedList.getSize());
    }

    @Test
    void getFirst() {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("Hello_1");
        stringMyLinkedList.add("Hello_2");
        stringMyLinkedList.add("Hello_3");
        stringMyLinkedList.add("Hello_4");

        assertEquals("Hello_1", stringMyLinkedList.getFirst());
    }

    @Test
    void testGetLast() {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("Hello_1");
        stringMyLinkedList.add("Hello_2");
        stringMyLinkedList.add("Hello_3");
        stringMyLinkedList.add("Hello_4");

        assertEquals("Hello_4", stringMyLinkedList.getLast());
    }

    @Test
    void testGetSize() {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("Hello_1");
        stringMyLinkedList.add("Hello_2");
        stringMyLinkedList.add("Hello_3");
        stringMyLinkedList.add("Hello_4");
        stringMyLinkedList.add("Hello_5");
        stringMyLinkedList.add("Hello_6");

        assertEquals(6, stringMyLinkedList.getSize());
    }

    @Test
    void testGetIndex() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);

        assertEquals(3, list.get(2));
    }
}