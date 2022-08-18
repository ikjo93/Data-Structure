package whiteship.stack;

import java.util.EmptyStackException;
import whiteship.linkedlist.ListNode;

public class ListNodeStack {

    private ListNode head;
    private int size = 0;

    public void push(int data) {
        size++;
        if (head == null) {
            head = new ListNode(data);
            return;
        }

        ListNode newNode = new ListNode(data);
        newNode.setNextNode(head);
        head = newNode;
    }

    public int pop() {
        if (head == null) {
            throw new EmptyStackException();
        }

        size--;
        int result = head.getValue();
        head = head.getNextNode();

        return result;
    }

    public int get(int index) {
        checkValidIndex(index);

        ListNode node = head;

        for (int i = size - index - 1; i > 0; i--) {
            node = node.getNextNode();
        }

        return node.getValue();
    }

    private void checkValidIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("인덱스 " + index + "은 유효하지 않은 인덱스입니다. 유효 인덱스 : 0 ~ " + (size - 1));
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }
}
