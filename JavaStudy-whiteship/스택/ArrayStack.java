package whiteship.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack {

    private static final int DEFAULT_CAPACITY = 10;
    private int[] values;
    private int size = 0;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayStack(int capacity) {
        values = new int[capacity];
    }

    public void push(int data) {
        values[size++] = data;
        if (size == values.length) {
            sizeUp();
        }
    }

    public int pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        int result = values[--size];
        values[size] = 0;

        if (size < (values.length / 2)) {
            sizeDown();
        }

        return result;
    }

    private void sizeUp() {
        int newCapacity = values.length * 2;
        values = Arrays.copyOf(values, newCapacity);
    }

    private void sizeDown() {
        int newCapacity = (values.length / 2);
        values = Arrays.copyOf(values, Math.max(DEFAULT_CAPACITY, newCapacity));
    }

    public int get(int index) {
        return values[index];
    }

    public int size() {
        return size;
    }

    public void clear() {
        values = new int[DEFAULT_CAPACITY];
        size = 0;
    }

}
