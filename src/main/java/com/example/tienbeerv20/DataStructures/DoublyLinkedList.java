package com.example.tienbeerv20.DataStructures;

import android.util.Log;

public class DoublyLinkedList {
    //A node class for doubly linked list
    class Node {
        String item;
        Node previous;
        Node next;

        public Node(String item) {
            this.item = item;
        }
    }

    //Initially, heade and tail is set to null
    Node head, tail = null;

    //add a node to the list
    public void addNode(String item) {
        //Create a new node
        Node newNode = new Node(item);

        //if list is empty, head and tail points to newNode
        if (head == null) {
            head = tail = newNode;
            //head's previous will be null
            head.previous = null;
            //tail's next will be null
            tail.next = null;
        } else {
            //add newNode to the end of list. tail->next set to newNode
            tail.next = newNode;
            //newNode->previous set to tail
            newNode.previous = tail;
            //newNode becomes new tail
            tail = newNode;
            //tail's next point to null
            tail.next = null;
        }
    }

    //print all the nodes of doubly linked list
    public void printNodes() {
        //Node current will point to head
        Node current = head;
        if (head == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            //Print each node and then go to next.
            Log.i("IMPRESION", current.item + " ");
            current = current.next;
        }
    }

    public String[][] asignTo2DArray() {
        //Node current will point to head
        Node current = head;
        String[][] arraicito = new String[4][4];

        if (head == null) {
            System.out.println("Doubly linked list is empty");
            return null;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            //Print each node and then go to next.
            for (int i = 0; i < 4; i++) {
                arraicito[i][0] = current.item;
                Log.i("IMPRESION", current.item + " ");
                current = current.next;
            }

        }
        return arraicito;
    }

}

