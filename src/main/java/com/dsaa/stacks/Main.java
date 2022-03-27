package com.dsaa.stacks;

public class Main {

    public static void main(String... args) {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println("Array Stack");
        while (!stack.isEmpty()) {
            System.out.println("Pop: " + stack.pop() + ", Size: " + stack.size());
        }

        System.out.println("------------------");

        System.out.println("Linked Stack");
        stack = new LinkedStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        while (!stack.isEmpty()) {
            System.out.println("Pop: " + stack.pop() + ", Size: " + stack.size());
        }
    }
}
