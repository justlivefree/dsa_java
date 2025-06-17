package com.example.dsa.linkedlist;

import java.util.Objects;
import java.util.StringJoiner;

public class DoubleLinkedList<E> {
    Node<E> head;
    Node<E> tail;
    public int lenght = 0;

    public DoubleLinkedList() {
    }

    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        if (Objects.isNull(head)) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        lenght++;
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        lenght++;
    }

    public E getElement(int index) {
        if (index >= lenght) {
            throw new RuntimeException("Index out of lenght");
        }
        Node<E> current = head;
        while (index > 0) {
            current = current.next;
            index--;
        }
        return current.data;
    }

    public int getIndex(E element) {
        int index = 0;
        Node<E> current = head;
        while (current != null) {
            if (Objects.equals(current.data, element)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public E popFirst() {
        if (isEmty()) {
            throw new RuntimeException("Empty list");
        }
        E result = head.data;
        head = head.next;
        if (head != null) {
            head.prev.next = null;
            head.prev = null;
        } else {
            tail = null;
        }
        lenght--;
        return result;
    }

    public E popLast() {
        if (isEmty()) {
            throw new RuntimeException("Empty list");
        }
        E result = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next.prev = null;
            tail.next = null;
        } else {
            head = null;
        }
        lenght--;
        return result;
    }

    public boolean isEmty() {
        return lenght == 0;
    }

    @Override
    public String toString() {
        Node<E> current = head;
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        while (current != null) {
            sj.add(String.valueOf(current.data));
            current = current.next;
        }
        return sj.toString();
    }

    public static class Node<E> {
        public E data;
        public Node next;
        public Node prev;

        public Node(E data) {
            this.data = data;
        }
    }

}
