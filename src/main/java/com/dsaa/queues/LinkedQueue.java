package com.dsaa.queues;

import com.dsaa.lists.linked.LinkedList;
import com.dsaa.lists.linked.singly.SinglyLinkedList;

public class LinkedQueue<E> implements Queue<E> {

    private final LinkedList<E> list = new SinglyLinkedList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public E first() {
        return list.first();
    }
}
