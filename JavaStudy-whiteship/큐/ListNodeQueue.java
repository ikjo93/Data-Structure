package whiteship.queue;

import java.util.NoSuchElementException;
import whiteship.linkedlist.ListNode;

public class ListNodeQueue implements Queue {

    private ListNode first;
    private ListNode last;
    private int size = 0;

    @Override
    public void add(int data) {
        ListNode node = new ListNode(data);
        if (last != null) {
            last.setNextNode(node);
        }

        last = node;
        if (first == null) {
            first = last;
        }

        size++;
    }

    @Override
    public int remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        int result = first.getValue();
        first = first.getNextNode();

        if (first == null) {
            last = null;
        }

        size--;

        return result;
    }

    @Override
    public int peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        return first.getValue();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
    }
}
