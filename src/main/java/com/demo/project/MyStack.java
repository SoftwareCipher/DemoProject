package com.demo.project;

import lombok.Getter;

import java.util.NoSuchElementException;

public class MyStack<T> {
    private Node<T> top;
    @Getter
    private int size;

    public static class Node<T>{
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public void push(T elemet){
        Node<T> newNode = new Node<>(elemet);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T get(int index){
        checkIndex(index);
        Node<T> current = top;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    public void set(int index, T data){
        checkIndex(index);
        Node<T> current = top;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        current.data = data;
    }

    public T peek(){
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return top.data;
    }

    public T pop(){
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        Node<T> removeNode = top;
        top = removeNode.next;
        size--;
        return removeNode.data;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int search(T o){
        Node<T> current = top;
        for(int i = 0; i < size - 1; i++){
            if(current.data.equals(o)){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("The index extends beyond the stack");
        }
    }
}
