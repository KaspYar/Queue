package com.kaspyar;

import com.kaspyar.queue.MostRecentlyInsertedQueue;

import java.util.Queue;

public class Main {
    public static final int CAPACITY = 3;

    public static void main(String[] args) {
        Queue<Integer> queue = new MostRecentlyInsertedQueue<>(CAPACITY);

        for (int i = 1; i <= 5; i++) {
            queue.add(i);
        }
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);


        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.add(10);
        queue.add(11);
        queue.clear();
    }
}
