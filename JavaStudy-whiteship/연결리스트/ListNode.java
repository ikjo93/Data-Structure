package whiteship.linkedlist;

public class ListNode {

    private final int value;
    private ListNode nextNode;

    public ListNode(int value) {
        this.value = value;
    }

    public void add(ListNode listNode) {
        ListNode node = this;

        while (node.nextNode != null) {
            node = node.nextNode;
        }

        node.nextNode = listNode;
    }

    public int size() {
        int size = 1;

        ListNode node = this;

        while (node.nextNode != null) {
            size++;
            node = node.nextNode;
        }

        return size;
    }

    public int getValue() {
        return value;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode listNode) {
        this.nextNode = listNode;
    }

}
