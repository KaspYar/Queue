package com.kaspyar;

import org.junit.Assert;
import org.junit.Test;

import java.util.Queue;

public class MostRecentlyInsertedQueueTest {

    @Test
    public void insertElement() {
        Queue<Integer> queue = new MostRecentlyInsertedQueue<>(1);

        Assert.assertNull(queue.poll());
        Assert.assertNull(queue.peek());

        queue.offer(1);

        Assert.assertEquals(1, queue.size());

        Assert.assertEquals(new Integer(1), queue.peek());
        Assert.assertEquals(new Integer(1), queue.poll());
    }

    @Test
    public void insertElements() {
        int capacity = 3;
        Queue<Integer> queue = new MostRecentlyInsertedQueue<>(capacity);

        Assert.assertEquals(0, queue.size());

        for (int i = 1; i <= 5; i++) {
            queue.add(i);
        }

        Assert.assertEquals(capacity, queue.size());

        Assert.assertEquals(new Integer(3), queue.peek());
        Assert.assertEquals(new Integer(3), queue.poll());

        Assert.assertEquals(new Integer(4), queue.peek());
        Assert.assertEquals(new Integer(4), queue.poll());

        Assert.assertEquals(1, queue.size());

        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);

        Assert.assertEquals(capacity, queue.size());

        Assert.assertEquals(new Integer(7), queue.peek());
        Assert.assertEquals(new Integer(7), queue.poll());

        Assert.assertEquals(new Integer(8), queue.peek());
        Assert.assertEquals(new Integer(8), queue.poll());

        Assert.assertEquals(new Integer(9), queue.peek());
        Assert.assertEquals(new Integer(9), queue.poll());

        Assert.assertNull(queue.peek());
        Assert.assertNull(queue.poll());

        Assert.assertEquals(0, queue.size());
        queue.add(10);
        queue.add(11);

        Assert.assertEquals(2, queue.size());
        queue.clear();
        Assert.assertEquals(0, queue.size());
    }
}
