package com.company;

import java.util.PriorityQueue;
import java.util.Queue;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private class Node {
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key, V val){
        Node node = root;
        while (node != null){
            if (node.key.compareTo(key) > 0){
                node = node.right;
            } else if (node.key.compareTo(key) < 0){
                node = node.left;
            } else if (node.key.compareTo(key) == 0){
                node.val = val;
                return;
            }
        }
        root = new Node(key, val);
    }
    public V get(K key){
        Node node = root;
        while (node != null){
            if (node.key.compareTo(key) > 0){
                node = node.right;
            } else if (node.key.compareTo(key) < 0){
                node = node.left;
            } else if (node.key.compareTo(key) == 0){
                return node.val;
            }
        }
        return null;
    }
    public void delete(K key){
        Node node = root;
        while (node != null){
            if (node.key.compareTo(key) > 0){
                node = node.right;
            } else if (node.key.compareTo(key) < 0){
                node = node.left;
            } else if (node.key.compareTo(key) == 0){
                node = null;
                return;
            }
        }
    }
    public Iterable<K> iterator(){
        Queue<K> q = new PriorityQueue<K>();
        inorder(root, q);
        return q;
    }
    private void inorder(Node x, Queue<K> q){
        if (x == null) return;
        inorder(x.left, q);
        q.add(x.key);
        inorder(x.right, q);
    }
}
