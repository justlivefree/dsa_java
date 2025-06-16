package com.example.dsa.linkedlist;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringJoiner;

public class SingleLinkedList<E> {
    public Node<E> head;
    public int lenght;

    public void addLast(E element) {
        Node<E> newNode = new Node(element);
        if (Objects.isNull(head)) {
            this.head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        lenght++;
    }

    public void addFirst(E element) {
        if (Objects.isNull(head)) {
            addLast(element);
        } else {
            Node<E> newNode = new Node(element);
            newNode.next = head;
            head = newNode;
        }
        lenght++;
    }

    public int getIndex(E element) {
        int index = 0;
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public E getElement(int index) {
        if (index >= lenght) {
            throw new RuntimeException("Index is out of bound");
        }
        Node<E> current = head;
        while (index > 0) {
            current = current.next;
            index--;
        }
        return current.data;
    }

    public void removeByIndex(int index) {
        if (index >= lenght) {
            throw new RuntimeException("Index is out of bound");
        }
        lenght--;
        if (index == 0) {
            Node<E> current = head;
            head = head.next;
            current.next = null;
        }
        Node<E> current = head;
        while (index - 1 > 0) {
            current = current.next;
            index--;
        }
        Node<E> tempNode = current.next;
        current.next = current.next.next;
        tempNode.next = null;
    }

    public E removeByElement(E element) {
        Node<E> current = head;
        if (Objects.equals(element, head.data)) {
            head = head.next;
            current.next = null;
            lenght--;
            return element;
        }
        while (current.next != null) {
            if (Objects.equals(element, current.next.data)) {
                Node<E> tempNode = current.next;
                current.next = current.next.next;
                tempNode.next = null;
                lenght--;
                return element;
            }
            current = current.next;
        }
        throw new NoSuchElementException();
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        Node<E> current = head;
        while (current != null) {
            sj.add(current.toString());
            current = current.next;
        }
        return sj.toString();
    }

    public static class Node<E> {
        public E data;
        public Node next;

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

}
