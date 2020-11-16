package com.example.tienbeerv20.DataStructures;

import com.example.tienbeerv20.Data.Cerveza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class BinarySearchTree{

    static public class Node {
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
    public BinarySearchTree() {
        root = null;
    }

    // get and set root
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }

    //A function that constructs BST from array (sorted or not)
    public Node llenar(ArrayList<Cerveza> cervezas){
        Collections.sort(cervezas, Cerveza.cervezaNombreComparator);
        return sortedArrayToBST(cervezas, 0, cervezas.size()-1);
    }
    /* A function that constructs Balanced Binary Search Tree
     from a sorted array */
    private Node sortedArrayToBST(ArrayList<Cerveza> cervezas, int start, int end) {
        /* Base Case */
        if (start > end) {
            return null;
        }
        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        Node node = new Node(cervezas.get(mid));

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(cervezas, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(cervezas, mid + 1, end);

        return node;
    }


    public Node search(Node root, String key) {
        // Base Cases: root is null or key is present at root
        // if root is null (key is not found) return null
        // if key is present at root, return the OBJECT beer
        if (root.key.getNombre().equals(key) || root==null )
            return root;

        // Comparator
        int comparator = root.key.getNombre().compareTo(key);

        // Key is greater than root's key
        if (comparator < 0)
            return search(root.right, key);

        // Key is smaller than root's key
        return search(root.left, key);
    }
}
