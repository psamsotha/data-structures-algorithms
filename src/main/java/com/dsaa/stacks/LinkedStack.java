package com.dsaa.stacks;

import com.dsaa.lists.linked.LinkedList;
import com.dsaa.lists.linked.singly.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {

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
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E top() {
        return list.first();
    }
}
