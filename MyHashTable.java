package com.company;

public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "{" + key + " " + value + "}";
        }

    }
    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;
    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }
    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }
    private int hash(K key) {
        return key.hashCode()%M;

    }
    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null) {
            if(node.key.equals(key)){
                node.value = value;
                return;
            }
            node = node.next;
        }
        node = chainArray[index];
        HashNode<K, V> newnode = new HashNode<K, V>(key, value);
        newnode.next = node;
        chainArray[index] = newnode;
        size++;
    }
    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null) {
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        HashNode<K, V> prev = null;
        while (node != null){

            if(node.key.equals(key)){
                break;
            }
            prev = node;
            node = node.next;

        }
        if (node == null) {
        return null;
        } else if(prev != null) {
            prev.next = node.next;
        } else {
            prev = node.next;
        }
        chainArray[index] = prev;
        size--;
        return node.value;
    }
    public boolean contains(V value) {
        for (var node:chainArray){
            while (node != null) {
                if(node.value.equals(value)){
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }
    public K getkey(V value) {
        for (var node:chainArray){
            while (node != null) {
                if(node.value.equals(value)){
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }
}
