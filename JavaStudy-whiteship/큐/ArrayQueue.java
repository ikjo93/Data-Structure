package whiteship.queue;

import java.util.NoSuchElementException;

public class ArrayQueue implements Queue {

    private static final int DEFAULT_CAPACITY = 10;
    private int[] values;
    private int size = 0;
    private int first = 0;
    private int last = 0;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        values = new int[capacity];
    }

    @Override
    public void add(int data) {
        if ((last + 1) % values.length == first) {
            resize(values.length * 2);
        }

        last = (last + 1) % values.length;
        values[last] = data;
        size++;
    }

    @Override
    public int remove() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        first = (first + 1) % values.length;

        int result = values[first];

        values[first] = 0;
        size--;

        if (values.length > DEFAULT_CAPACITY && size < (values.length / 4)) {
            resize(Math.max(DEFAULT_CAPACITY, values.length) / 2);
        }

        return result;
    }

    private void resize(int newCapacity) {
        int valuesCapacity = values.length;
        int[] newValues = new int[newCapacity];

        for (int i = 1, j = first + 1; i <= size; i++, j++) {
            newValues[i] = values[j % valuesCapacity];
        }

        values = newValues;

        first = 0;
        last = size;
    }

    @Override
    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        return values[(first + 1) % values.length];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        values = new int[DEFAULT_CAPACITY];
        first = 0;
        last = 0;
        size = 0;
    }
}
