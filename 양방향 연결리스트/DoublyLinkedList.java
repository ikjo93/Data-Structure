public class DoublyLinkedList {

    private final Node head;
    private final Node tail;
    private int size = 0;

    public DoublyLinkedList() {
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.previous = head;
    }

    public void addFirst(int value) {
        if (head.next == tail) {
            head.next = new Node(value, head, tail);
            tail.previous = head.next;
            size++;
            return;
        }

        Node node = head.next;
        Node newNode = new Node(value,
            head, node);
        head.next = newNode;
        node.previous = newNode;
        size++;
    }

    public void addLast(int value) {
        if (tail.previous == head) {
            tail.previous = new Node(value, head, tail);
            head.next = tail.previous;
            size++;
            return;
        }

        Node node = tail.previous;
        Node newNode = new Node(value,
            node, tail);
        tail.previous = newNode;
        node.next = newNode;
        size++;
    }

    public int pollFirst() {
        if (head.next == tail) {
            throw new IllegalStateException("Empty");
        }

        Node node = head.next;
        int returnValue = node.value;
        head.next = node.next;
        node.next.previous = head;
        size--;

        return returnValue;
    }

    public int pollLast() {
        if (tail.previous == head) {
            throw new IllegalStateException("Empty");
        }

        Node node = tail.previous;
        int returnValue = node.value;
        tail.previous = node.previous;
        tail.previous.next = tail;
        size--;

        return returnValue;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peekFirst() {
        if (head.next == tail) {
            throw new IllegalStateException("Empty");
        }

        return head.next.value;
    }

    public int peekLast() {
        if (tail.previous == head) {
            throw new IllegalStateException("Empty");
        }

        return tail.previous.value;
    }

    private static class Node {

        int value;
        Node previous;
        Node next;

        Node() {
        }

        Node(int value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
}
