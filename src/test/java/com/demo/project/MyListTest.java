package com.demo.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {
    MyList myList;

    @BeforeEach
    void BeforeEach(){
        myList = new MyList(new Object[0]);
    }

    @Test
    void testAddAndGet() {
        myList.add("Element1");
        myList.add("Element2");
        myList.add("Element3");

        assertEquals("Element1", myList.get(0));
        assertEquals("Element2", myList.get(1));
        assertEquals("Element3", myList.get(2));
    }

    @Test
    void testSet() {
        MyList<String> listString = new MyList<>(new Object[0]);

        listString.add("Element1");
        listString.add("Element2");

        boolean result = listString.set(0, "NewElement3");
        assertTrue(result);
        assertEquals("NewElement3", listString.get(0));
    }

    @Test
    void testSetInvalidIndex() {
        MyList<String> listString = new MyList<>(new Object[0]);

        listString.add("Element1");

        assertThrows(IndexOutOfBoundsException.class,
                () -> listString.set(5, "NewElement"));
    }

    @Test
    void testAddAndGetWithDifferentTypes() {
        MyList<String> listString = new MyList<>(new Object[0]);

        myList.add(10);
        myList.add(20);
        listString.add("A");
        listString.add("B");

        assertEquals(10, myList.get(0));
        assertEquals(20, myList.get(1));
        assertEquals("A", listString.get(0));
        assertEquals("B", listString.get(1));
    }

}