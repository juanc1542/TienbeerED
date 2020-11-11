package com.example.tienbeerv20.Data;

import java.util.ArrayList;
import java.util.Iterator;

public class BinarySearchTree {

    static class Node {
        // Atributos
        private Cerveza key;
        private Node left, right;

        // Constructor
        public Node(Cerveza item)
        {
            key = item;
            left = right = null;
        }

        // getters and setters
        public Cerveza getKey() {
            return key;
        }
        public void setKey(Cerveza key) {
            this.key = key;
        }

        public Node getLeft() {
            return left;
        }
        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }
        public void setRight(Node right) {
            this.right = right;
        }
    }

    // Root of BST
    private Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // get and set root
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }

    // This method mainly calls insertRec()
    public void insert(Cerveza key) {
        root = insertRec(root, key);
    }

    /* A recursive function to
      insert a new key in BST */
    private Node insertRec(Node root, Cerveza key) {
        /* If the tree is empty,
           return a new node */
        if (root == null)
        {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        int comparator = root.key.getNombre().compareTo(key.getNombre());
        if (comparator < 0)
            root.left = insertRec(root.left, key);
        else if (comparator > 0)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }


    public Node search(Node root, Cerveza key) {
        // Base Cases: root is null or key is present at root
        // if is null (key is not found) return null
        // if key is present at root, return the OBJECT beer
        if (root==null || root.key==key)
            return root;

        // Comparator
        int comparator = root.key.getNombre().compareTo(key.getNombre());

        // Key is greater than root's key
        if (comparator < 0)
            return search(root.right, key);

        // Key is smaller than root's key
        return search(root.left, key);
    }

//    Node llenar(ArrayList<Cerveza> arrayList){
//        for (Cerveza cerveza : arrayList) {
//            insert(cerveza);
//        }
//        return root;
//    }
}
