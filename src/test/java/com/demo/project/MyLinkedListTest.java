package com.demo.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void testAddByIndexFirst() {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("Hello_1");
        stringMyLinkedList.add("Hello_2");
        stringMyLinkedList.add("Hello_3");
        stringMyLinkedList.add("Hello_4");

        stringMyLinkedList.add(0, "Hello_1_1");

        assertEquals("Hello_1_1", stringMyLinkedList.getFirst());
    }

    @Test
    void testAddByIndexLast() {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("Hello_1");
        stringMyLinkedList.add("Hello_2");
        stringMyLinkedList.add("Hello_3");
        stringMyLinkedList.add("Hello_4");

        stringMyLinkedList.add(3, "Hello_1_1");

        assertEquals("Hello_1_1", stringMyLinkedList.getLast());
    }

    @Test
    void testAddByIndex() {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("Hello_1");
        stringMyLinkedList.add("Hello_2");
        stringMyLinkedList.add("Hello_3");
        stringMyLinkedList.add("Hello_4");

        stringMyLinkedList.add(2, "Hello_2_2");
        assertEquals("Hello_2_2", stringMyLinkedList.get(2));
        assertEquals(5, stringMyLinkedList.getSize());
    }

    @Test
    void testAdd() {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("Hello_1");
        stringMyLinkedList.add("Hello_2");
        stringMyLinkedList.add("Hello_3");
        stringMyLinkedList.add("Hello_4");
        stringMyLinkedList.add("Hello_5");

        stringMyLinkedList.add("Hello_6");

        assertEquals("Hello_6", stringMyLinkedList.get(5));
        assertEquals(6, stringMyLinkedList.getSize());
    }

    @Test
    void testClear() {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("Hello_1");
        stringMyLinkedList.add("Hello_2");
        stringMyLinkedList.add("Hello_3");
        stringMyLinkedList.add("Hello_4");
        stringMyLinkedList.add("Hello_5");

        assertEquals(5, stringMyLinkedList.getSize());
        assertEquals("Hello_5", stringMyLinkedList.get(4));

        stringMyLinkedList.clear();

        assertEquals(0, stringMyLinkedList.getSize());
    }

    @Test
    void testIsEmptyIsFalse() {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("Hello_1");
        stringMyLinkedList.add("Hello_2");
        stringMyLinkedList.add("Hello_3");
        stringMyLinkedList.add("Hello_4");
        stringMyLinkedList.add("Hello_5");

        assertFalse(stringMyLinkedList.isEmpty());
    }

    @Test
    void testIsEmptyIsTrue() {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        assertTrue(stringMyLinkedList.isEmpty());
    }

    @Test
    void testContainsElementTrue() {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("Hello_1");
        stringMyLinkedList.add("Hello_2");
        stringMyLinkedList.add("Hello_3");
        stringMyLinkedList.add("Hello_4");
        stringMyLinkedList.add("Hello_5");

        assertTrue(stringMyLinkedList.contains("Hello_5"));
    }

    @Test
    void testContainsElementFalse() {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("Hello_1");
        stringMyLinkedList.add("Hello_2");
        stringMyLinkedList.add("Hello_3");
        stringMyLinkedList.add("Hello_4");
        stringMyLinkedList.add("Hello_5");

        assertFalse(stringMyLinkedList.contains("Hello_6"));
    }

    @Test
    void testRemove() {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("Hello_1");
        stringMyLinkedList.add("Hello_2");
        stringMyLinkedList.add("Hello_3");
        stringMyLinkedList.add("Hello_4");
        stringMyLinkedList.add("Hello_5");

        assertEquals("Hello_3", stringMyLinkedList.remove(2));
        assertEquals(4, stringMyLinkedList.getSize());
    }

    @Test
    void testRemoveLast() {
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
    void testGetFirst() {
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