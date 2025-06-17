package com.example.dsa.stack;

import com.example.dsa.linkedlist.DoubleLinkedList;

public class LinkedStack<E> {
    private DoubleLinkedList<E> list;

    public LinkedStack() {
        list = new DoubleLinkedList<>();
    }

    public void push(E element) {
        list.addLast(element);
    }

    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.popLast();
    }

    public boolean isEmpty() {
        return list.isEmty();
    }

    @Override
    public String toString() {
        return list.toString();
    }

}
