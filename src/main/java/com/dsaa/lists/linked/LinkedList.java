package com.dsaa.lists.linked;

public interface LinkedList<E> {

    /**
     * Get the size of the list.
     * @return the size of the list
     */
    int size();

    /**
     * Check if the list is empty.
     * @return true if the list is empty, otherwise false
     */
    boolean isEmpty();

    /**
     * Get the first element in the list.
     * @return the first element; null if the list is empty
     */
    E first();

    /**
     * Get the last element in the list.
     * @return the last element; null if the list is empty
     */
    E last();

    /**
     * Add an element to the front of the list.
     * @param e the element to add
     */
    void addFirst(E e);

    /**
     * Add an element to the end of the list.
     * @param e the element to add
     */
    void addLast(E e);

    /**
     * Remove the first element of the list.
     * @return the removed element
     */
    E removeFirst();
}
