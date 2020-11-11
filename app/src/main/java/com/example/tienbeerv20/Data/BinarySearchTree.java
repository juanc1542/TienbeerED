package com.example.tienbeerv20.Data;

import java.util.ArrayList;
import java.util.Iterator;

public class BinarySearchTree {

    class Node
    {
        Cerveza key;
        Node left, right;

        public Node(Cerveza item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree()
    {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(Cerveza key)
    {
        root = insertRec(root, key);
    }

    /* A recursive function to
      insert a new key in BST */
    Node insertRec(Node root, Cerveza key)
    {
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

//    Node llenar(ArrayList<Cerveza> arrayList){
//        for (Cerveza cerveza : arrayList) {
//            this.insert(cerveza);
//        }
//        return this.root;
//    }
}
