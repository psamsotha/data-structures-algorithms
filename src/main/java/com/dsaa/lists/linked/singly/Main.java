package com.dsaa.lists.linked.singly;

public class Main {

    public static void main(String... args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addFirst("three");
        list.addFirst("two");
        list.addFirst("one");
        list.addLast("four");

        while (!list.isEmpty()) {
            System.out.println(list.removeFirst());
        }
    }
}
