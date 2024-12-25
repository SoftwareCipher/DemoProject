package com.demo.project;

public class MyHashMap<K, V> {
    private Node<K, V>[] buckets;
    private int capacity = 16;
    private int size = 0;

    public static class Node<K, V> {
        K key;
        V value;
        int hash;
        Node<K, V> next;

        public Node(K key, V value, int i, Node<K, V> head) {
            this.key = key;
            this.value = value;
            this.hash = i;
            this.next = head;
        }
    }

    private int getBucketIndex(K key) {
        return key == null ? 0 : Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];
        
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        
        size++;
        head = buckets[index];
        Node<K, V> newNode = new Node<>(key, value, key.hashCode(), head);
        buckets[index] = newNode;
        if((0.1 * size) / capacity >= 0.75){
            resize();
        }
    }

    private void resize() {
        Node<K, V>[] temp = buckets;
        capacity *= 2;
        buckets = new Node[capacity];
        size = 0;

        for (Node<K, V> headNode : temp) {
            while (headNode != null) {
                put(headNode.key, headNode.value);
                headNode = headNode.next;
            }
        }
    }
}
