package com.dsaa.lists.linked.singly;

import com.dsaa.lists.linked.LinkedList;

public class SinglyLinkedList<E> implements LinkedList<E> {

    private int size = 0;
    private Node<E> head = null;
    private Node<E> tail = null;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public E first() {
        return isEmpty() ? null : head.getElement();
    }

    @Override
    public E last() {
        return isEmpty() ? null : tail.getElement();
    }

    @Override
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        E element = head.getElement();
        head = head.getNext();
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return element;
    }

    private static class Node<E> {
        private final E element;
        private Node<E> next;

        private Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
