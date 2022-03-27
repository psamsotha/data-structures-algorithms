package com.dsaa.queues;

public class Main {

    public static void main(String... args) {
        Queue<Integer> q = new LinkedQueue<>();
        enqueue(q, 1);
        enqueue(q, 2);
        enqueue(q, 3);
        enqueue(q, 4);
        enqueue(q, 5);

        while (!q.isEmpty()) {
            System.out.println("Dequeue: " + q.dequeue() + ", Size: " + q.size());
        }
    }

    private static void enqueue(Queue<Integer> q, int e) {
        q.enqueue(e);
        System.out.println("Queued: " + e + ", Size: " + q.size());
    }
}
