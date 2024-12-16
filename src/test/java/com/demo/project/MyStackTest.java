package com.demo.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void testAdd() {
        MyStack myStack = new MyStack();
        myStack.add("Element_1");
        myStack.add("Element_2");
        myStack.add("Element_3");

        assertEquals(3, myStack.getSize());
    }

    @Test
    void testGet() {
        MyStack myStack = new MyStack();
        myStack.add("Element_1");
        myStack.add("Element_2");
        myStack.add("Element_3");

        assertEquals("Element_1", myStack.get(2));
    }

    @Test
    void testSet() {
        MyStack myStack = new MyStack();
        myStack.add("Element_1");
        myStack.add("Element_2");
        myStack.add("Element_3");

        myStack.set(0, "Element_3_3");

        assertEquals("Element_3_3", myStack.get(0));
    }


}