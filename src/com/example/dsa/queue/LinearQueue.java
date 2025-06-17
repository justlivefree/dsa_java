package com.example.dsa.queue;

public class LinearQueue<E> {
    public static int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int front = 0;
    private int rare = 0;

    public LinearQueue(int initialCapacity) {
        this.array = (E[]) new Object[initialCapacity];
    }

    public LinearQueue() {
        this(DEFAULT_CAPACITY);
    }

    public void enqueue(E element) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        array[front] = element;
        front++;
    }

    public E deuque() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        E element = array[rare];
        array[rare] = null;
        rare++;
        return element;
    }

    public boolean isEmpty() {
        return rare == front;
    }

    public boolean isFull() {
        return front == DEFAULT_CAPACITY - 1;
    }

}
