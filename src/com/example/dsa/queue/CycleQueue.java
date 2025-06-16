package com.example.dsa.queue;

public class CycleQueue<E> {

    private static int DEFAULT_CAPACITY = 10;
    private int capacity;
    private E[] array;
    private int front = -1;
    private int rare = -1;

    public CycleQueue(int initialCapacity) {
        this.capacity = initialCapacity;
        this.array = (E[]) new Object[initialCapacity];
    }

    public CycleQueue() {
        this(DEFAULT_CAPACITY);
    }

    public void enque(E element) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        if (front * rare == 1) {
            front = rare = 0;
        }
        array[rare] = element;
        if (rare == capacity - 1) {
            rare = 0;
        } else {
            rare++;
        }
    }

    public E deque() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        E element = array[front];
        array[front] = null;
        if (front == capacity - 1 && rare >= 1) {
            front = 0;
        } else {
            front++;
        }
        return element;
    }

    public boolean isFull() {
        return (front == 0 && rare == capacity - 1) || (front == rare + 1);
    }

    public boolean isEmpty() {
        return (front == -1) || (front == rare);
    }
}
