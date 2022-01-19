/**
 * PushDown(LIFO) stack (resizing array implementation)
 */

package com.example.algorithms.datastructures;

import androidx.annotation.NonNull;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return 0 == N;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];

        for (int i = 0; i < N; ++i) {
            temp[i] = a[i];
        }

        a = temp;
    }

    public void push(Item item) {
        if (a.length == N) {
            resize(2 * a.length);
        }

        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;

        if (N > 0 && a.length / 4 == N) {
            resize(a.length / 2);
        }

        return item;
    }

    @NonNull
    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }
}