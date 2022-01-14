/**
 * FIFO queue
 */

package com.example.algorithms;

public class Queue<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private Node last;
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }

        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        
        if (isEmpty()) {
            last = null;
        }

        N--;
        return item;
    }
}
