package com.demo.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {
    MyList myList;

    @BeforeEach
    void BeforeEach(){
        myList = new MyList();
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

//    @Test
//    void testSet() {
//        MyList<String> listString = new MyList<>();
//
//        listString.add("Element1");
//        listString.add("Element2");
//
//        boolean result = listString.set(0, "NewElement3");
//        assertTrue(result);
//        assertEquals("NewElement3", listString.get(0));
//    }

//    @Test
//    void testSetInvalidIndex() {
//        MyList<String> listString = new MyList<>();
//
//        listString.add("Element1");
//
//        assertThrows(IndexOutOfBoundsException.class,
//                () -> listString.set(3, "NewElement"));
//    }

    @Test
    void testAddAndGetWithDifferentTypes() {
        MyList<String> listString = new MyList<>();

        myList.add(10);
        myList.add(20);
        listString.add("A");
        listString.add("B");

        assertEquals(10, myList.get(0));
        assertEquals(20, myList.get(1));
        assertEquals("A", listString.get(0));
        assertEquals("B", listString.get(1));
    }

//    @Test
//    void addByIndex(){
//        MyList<String> listString = new MyList<>();
//        listString.add("A");
//        listString.add("B");
//
//        listString.add(1, "C");
//        assertEquals(3, listString.getSize());
//        assertEquals("C", listString.get(1));
//    }


//    @Test
//    void addByIndex2(){
//        MyList<String> listString = new MyList<>();
//        listString.add("A");
//        listString.add("B");
//        listString.add("D");
//        listString.add("E");
//
//        listString.add(1, "C");
//        assertEquals(5, listString.getSize());
//        assertEquals("C", listString.get(1));
//        assertEquals("B", listString.get(2));
//        assertEquals("D", listString.get(3));
//        assertEquals("E", listString.get(4));
//
//    }

//    @Test
//    void addByIndex3(){
//        MyList<String> listString = new MyList<>();
//        listString.add("A");
//        listString.add("B");
//
//        listString.add(2, "C");
//        assertEquals(3, listString.getSize());
//        assertEquals("C", listString.get(2));
//
//    }

//    @Test
//    void addByIndex4(){
//        MyList<String> listString = new MyList<>(3);
//        listString.add("A");
//        listString.add("B");
//        listString.add("C");
//
//        listString.add(3, "D");
//        assertEquals(4, listString.getSize());
//        assertEquals("D", listString.get(3));
//    }

//    @Test
//    void addByIndex5(){
//        MyList<String> listString = new MyList<>(3);
//        listString.add("A");
//        listString.add("B");
//        listString.add("C");
//
//        listString.add(0, "D");
//        assertEquals(4, listString.getSize());
//        assertEquals("D", listString.get(0));
//    }

    @Test
    void testGetFirst(){
        MyList<String> listString = new MyList<>(3);
        listString.add("A");
        listString.add("B");

        assertEquals("A", listString.getFirst());
    }

    @Test
    void testGetFirstElseListIsEmpty(){
        MyList<String> listString = new MyList<>();

        assertThrows(IllegalStateException.class,
                listString::getFirst, "List is empty");
    }

    @Test
    void testGetLastElement() {
        MyList<String> listString = new MyList<>();
        listString.add("A");
        listString.add("B");

        assertEquals("B", listString.getLast());
    }

    @Test
    void testRemoveElement(){
        MyList<String> listString = new MyList<>();
        listString.add("A");
        listString.add("B");

        assertEquals(2, listString.getSize());
        assertEquals("B", listString.remove(1));
        assertEquals(1, listString.getSize());
    }

    @Test
    void testRemoveOneElement(){
        MyList<String> listString = new MyList<>(1);
        listString.add("A");

        assertEquals(1, listString.getSize());
        assertEquals("A", listString.remove(0));
        assertEquals(0, listString.getSize());
    }

    @Test
    void testRemoveIntegerElement(){
        MyList<Integer> listString = new MyList<>();
        listString.add(1);
        listString.add(2);
        listString.add(3);
        listString.add(4);
        listString.add(5);
        listString.add(6);

        assertEquals(6, listString.getSize());
        assertEquals(4, listString.remove(3));
        assertEquals(5, listString.getSize());
    }

    @Test
    void testContainsElement(){
        MyList<String> listString = new MyList<>();
        listString.add("A");
        listString.add("B");

        assertTrue(listString.contains("B"));
    }

    @Test
    void isEmpty(){
        MyList<String> listString = new MyList<>();
        listString.add("A");
        listString.add("B");


        assertFalse(listString.isEmpty());
        listString.clear();
        assertTrue(listString.isEmpty());
    }

    @Test
    void testClearArray(){
        MyList<String> listString = new MyList<>();
        listString.add("A");
        listString.add("B");

        listString.clear();
        assertTrue(listString.isEmpty());
    }

    @Test
    void testOf(){
        MyList<String> list = MyList.of("A", "B", "C");

        assertEquals(3, list.getSize());
        assertEquals("B", list.get(1));
    }
}