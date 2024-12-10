package com.demo.project;

public class MyLinkedList<T> implements CustomList<T> {

    public static class Node<T>{
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;


    @Override
    public void add(T newObject) {
        Node<T> newNode = new Node<>(newObject);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T newObject) {
        Node<T> newNode = new Node<>(newObject);
        if(index == 0){
            newNode.next = head;
            head = newNode;
        }else if(index == size - 1){
            tail.next = newNode;
            tail = newNode;
        }else{
            Node<T> prev = head;
            for(int i = 0; i < index - 1; i++){
                prev = prev.next;
            }
            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public T remove(int index) {
        T removeElement;

        if(index == 0){
            removeElement = head.data;
            head = head.next;
        }else{
            Node<T> prev = head; // B
            for(int i = 0; i < index - 1; i++){
                prev = prev.next;
            }

            Node<T> nodeToRemove = prev.next; // nodeToRemove = B.next -> (C)
            removeElement = nodeToRemove.data;
            prev.next = nodeToRemove.next; // B.next = C.next -> (D)
        }

        size--;
        return removeElement;
    }

    @Override
    public T getFirst() {
        return head.data;
    }

    @Override
    public T getLast() {
        return tail.data;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T get(int index) {
        Node<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }
}
