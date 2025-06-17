package com.example.dsa.stack;

import java.util.Arrays;

public class SimpleStack<E> {
    private static int DEFAULT_CAPACITY = 10;
    private int capacity;
    private E[] array;
    private int topIndex = -1;

    public SimpleStack(int initialCapacity) {
        this.capacity = initialCapacity;
        array = (E[]) new Object[capacity];
    }

    public SimpleStack() {
        this(DEFAULT_CAPACITY);
    }

    public void push(E element) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }
        array[++topIndex] = element;
    }

    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[topIndex--];
    }

    public boolean isFull() {
        return topIndex == capacity - 1;
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
