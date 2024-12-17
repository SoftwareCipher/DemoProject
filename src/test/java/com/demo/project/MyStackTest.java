package com.demo.project;

import com.demo.project.MyCollections.MyStack;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void testAdd() {
        MyStack myStack = new MyStack();
        myStack.push("Element_1");
        myStack.push("Element_2");
        myStack.push("Element_3");

        assertEquals(3, myStack.getSize());
    }

    @Test
    void testGet() {
        MyStack myStack = new MyStack();
        myStack.push("Element_1");
        myStack.push("Element_2");
        myStack.push("Element_3");

        assertEquals("Element_1", myStack.get(2));
    }

    @Test
    void testGetInvalidIndex(){
        MyStack myStack = new MyStack();
        myStack.push("Element_1");

        assertThrows(IndexOutOfBoundsException.class, () -> myStack.get(1));
    }

    @Test
    void testSet() {
        MyStack myStack = new MyStack();
        myStack.push("Element_1");
        myStack.push("Element_2");
        myStack.push("Element_3");

        myStack.set(0, "Element_3_3");

        assertEquals("Element_3_3", myStack.get(0));
    }

    @Test
    void testPeek(){
        MyStack myStack = new MyStack();
        myStack.push("Element_1");
        myStack.push("Element_2");
        myStack.push("Element_3");

        assertEquals(myStack.get(0), myStack.peek());
        assertEquals(3, myStack.getSize());
    }

    @Test
    void testPeekEmptyStack(){
        MyStack<String> myStack = new MyStack<>();
        assertThrows(NoSuchElementException.class, myStack::peek);
    }

    @Test
    void testPopEmptyStack(){
        MyStack<String> myStack = new MyStack<>();
        assertThrows(NoSuchElementException.class, myStack::pop);
    }

    @Test
    void testPop(){
        MyStack myStack = new MyStack();
        myStack.push("Element_1");
        myStack.push("Element_2");
        myStack.push("Element_3");

        assertEquals("Element_3", myStack.pop());
        assertEquals(2, myStack.getSize());
        assertEquals("Element_2", myStack.get(0));
    }

    @Test
    void testIsEmptyTrue(){
        MyStack myStack = new MyStack();
        assertTrue(myStack.isEmpty());
    }

    @Test
    void testIsEmptyFalse(){
        MyStack myStack = new MyStack();
        myStack.push("Element_1");
        assertFalse(myStack.isEmpty());
    }

    @Test
    void testSearch(){
        MyStack myStack = new MyStack();
        myStack.push("Element_1");
        myStack.push("Element_2");
        myStack.push("Element_3");
        myStack.push("Element_4");
        myStack.push("Element_5");
        myStack.push("Element_6");
        myStack.push("Element_7");
        myStack.push("Element_8");

        assertEquals(3, myStack.search("Element_5"));
        assertEquals(-1, myStack.search("Element_10"));
        assertEquals(0, myStack.search("Element_8"));
    }
}