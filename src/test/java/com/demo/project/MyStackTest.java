package com.demo.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void add() {
        MyStack myStack = new MyStack();
        myStack.add("Element_1");
        myStack.add("Element_2");
        myStack.add("Element_3");

        assertEquals(3, myStack.getSize());
    }

    @Test
    void get(){
        MyStack myStack = new MyStack();
        myStack.add("Element_1");
        myStack.add("Element_2");
        myStack.add("Element_3");

        assertEquals("Element_1", myStack.get(2));
    }
}