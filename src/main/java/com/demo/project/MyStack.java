package com.demo.project;


import lombok.Getter;

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

    public void add(T elemet){
        Node<T> newNode = new Node<>(elemet);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("The index extends beyond the stack");
        }
        Node<T> current = top;
        for(int i = 0; i < index; i++){
            current = current.next;
        }

        return current.data;
    }
}
