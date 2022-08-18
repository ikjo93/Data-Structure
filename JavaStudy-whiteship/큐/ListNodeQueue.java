package whiteship.queue;

import java.util.NoSuchElementException;
import whiteship.linkedlist.ListNode;

public class ListNodeQueue {

    private ListNode first;
    private ListNode last;
    private int size = 0;

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

    public int poll() {
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

    public int peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        return first.getValue();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = null;
        last = null;
    }
}
