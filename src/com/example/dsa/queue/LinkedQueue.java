package com.example.dsa.queue;

import com.example.dsa.linkedlist.DoubleLinkedList;

public class LinkedQueue<E> {

    DoubleLinkedList<E> list;

    public LinkedQueue() {
    }

    public void enque(E element) {
        list.addLast(element);
    }

    public E deque() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list.popFirst();
    }

    public boolean isEmpty() {
        return list.isEmty();
    }
}
