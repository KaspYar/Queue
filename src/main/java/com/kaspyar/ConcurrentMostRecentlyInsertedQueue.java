package com.kaspyar;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentMostRecentlyInsertedQueue<E> extends MostRecentlyInsertedQueue<E> {

    private ReentrantLock lock;

    public ConcurrentMostRecentlyInsertedQueue(int capacity) {
        super(capacity);
        lock = new ReentrantLock();
    }

    @Override
    public boolean offer(E e) {
        lock.lock();
        try {
            return super.offer(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E poll() {
        lock.lock();
        try {
            return super.poll();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E peek() {
        lock.lock();
        try {
            return super.peek();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int size() {
        lock.lock();
        try {
            return super.size();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void clear() {
        lock.lock();
        try {
            super.clear();
        } finally {
            lock.unlock();
        }
    }
}
