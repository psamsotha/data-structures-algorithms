package com.dsaa.lists.linked.singly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SinglyLinkedListTest {

    private SinglyLinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList<>();
    }

    @Test
    void testSize() {
        assertThat(list.size()).isEqualTo(0);
        assertThat(list.isEmpty()).isTrue();

        list.addLast("one");
        list.addFirst("two");
        assertThat(list.size()).isEqualTo(2);

        list.removeFirst();
        assertThat(list.size()).isEqualTo(1);

        list.removeFirst();
        assertThat(list.size()).isEqualTo(0);
        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    void testFirst() {
        assertThat(list.first()).isNull();

        list.addFirst("one");
        list.addFirst("two");
        list.addFirst("three");

        assertThat(list.first()).isEqualTo("three");
    }

    @Test
    void testLast() {
        assertThat(list.last()).isNull();

        list.addLast("one");
        list.addLast("two");
        list.addLast("three");

        assertThat(list.last()).isEqualTo("three");
    }

    @Test
    void testAddFirst() {
        list.addFirst("one");
        list.addFirst("two");
        list.addFirst("three");

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.removeFirst()).isEqualTo("three");
        assertThat(list.removeFirst()).isEqualTo("two");
        assertThat(list.removeFirst()).isEqualTo("one");
    }

    @Test
    void testAddLast() {
        list.addLast("one");
        list.addLast("two");
        list.addLast("three");

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.removeFirst()).isEqualTo("one");
        assertThat(list.removeFirst()).isEqualTo("two");
        assertThat(list.removeFirst()).isEqualTo("three");
    }

    @Test
    void testRemoveFirst() {
        list.addFirst("one");
        list.addFirst("two");
        list.addFirst("three");

        assertThat(list.removeFirst()).isEqualTo("three");
        assertThat(list.removeFirst()).isEqualTo("two");
        assertThat(list.removeFirst()).isEqualTo("one");
        assertThat(list.isEmpty()).isTrue();
    }
}
