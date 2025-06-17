package com.example.dsa.array;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.Objects;

public class DynamicArray<E> {
    private E[] array;
    private int capacity;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private static final double GROWTH = 1.5;

    public DynamicArray(int initialCapacity) {
        this.capacity = initialCapacity;
        this.array = (E[]) new Object[initialCapacity];
    }

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public E get(int index) {
        checkIndex(index);
        return array[index];
    }

    public void add(E element) {
        updateCapacity();
        array[size++] = element;
    }

    public void insert(int index, E element) {
        updateCapacity();
        checkIndex(index);
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
    }

    public void updateCapacity() {
        if (size == capacity) {
            capacity *= GROWTH;
            array = Arrays.copyOf(array, capacity);
        }
    }

    public void checkIndex(int index) {
        if (index >= size) {
            throw new RuntimeException("INVALID INDEX");
        }
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            if (Objects.nonNull(array[i])) {
                sj.add(String.valueOf(array[i]));
            }
        }
        return sj.toString();
    }

}
