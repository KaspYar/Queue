package com.kaspyar;

import java.util.AbstractQueue;
import java.util.Iterator;

public class MostRecentlyInsertedQueue<E> extends AbstractQueue<E> {

    private final Object[] data;
    private int start;
    private int size;

    public MostRecentlyInsertedQueue(int capacity) {
        data = new Object[capacity];
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean offer(E e) {
        if (e == null) throw new NullPointerException();

        if (size != data.length) {
            data[getStartPosition()] = e;
            size++;
        } else {
            data[start] = e;
            nextStartPosition();
        }
        return true;
    }

    private void nextStartPosition() {
        start = (start + 1) % data.length;
    }

    private int getStartPosition() {
        return (start + size) % data.length;
    }

    @Override
    public E poll() {
        if (size == 0) return null;

        E res = (E) data[start];
        data[start] = null;

        nextStartPosition();
        size--;

        return res;
    }

    @Override
    public E peek() {
        if (size == 0) return null;
        return (E) data[start];
    }

    @Override
    public void clear() {
        start = 0;
        size = 0;
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
    }
}
