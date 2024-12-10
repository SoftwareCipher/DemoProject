package com.demo.project;

public class MyLinkedList<T> implements CustomList<T> {

    public static class Node<T>{
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
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

        if (size == 0) {
            head = newNode;
            tail = newNode;
        }else if(index == 0){
            newNode.next = head;
            head = newNode;
        }else if(index == size - 1){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }else{
            Node<T> prevNode = head;
            for(int i = 0; i < index - 1; i++){
                prevNode = prevNode.next;
            }
            newNode.next = prevNode.next;
            newNode.prev = prevNode;
            prevNode.next = newNode;
        }
        size++;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T element) {
        Node<T> prev = head;
        for(int i = 0; i < size - 1; i++){
            prev = prev.next;
            if(prev.data == element){
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        T removeElement;

        if(index == 0){
            removeElement = head.data;
            head = head.next;
        }else if(index == size - 1){
            removeElement = tail.data;
            tail = tail.prev;
        }else{
            Node<T> prevNode = head;
            for(int i = 0; i < index - 1; i++){
                prevNode = prevNode.next;
            }

            Node<T> nodeToRemove = prevNode.next;
            removeElement = nodeToRemove.data;

            prevNode.next = nodeToRemove.next;
            nodeToRemove.next = nodeToRemove.prev;
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
