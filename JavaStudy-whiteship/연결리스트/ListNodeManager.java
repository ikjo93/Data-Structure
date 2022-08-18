package whiteship;

public class ListNodeManager {

    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        checkValidIndex(head.size(), position);

        if (position == 0) {
            nodeToAdd.setNextNode(head);
            return nodeToAdd;
        }

        ListNode headNode = head;
        ListNode presentNode = head;

        for (int i = 1; i < position; i++) {
            presentNode = presentNode.getNextNode();
        }

        nodeToAdd.setNextNode(presentNode.getNextNode());
        presentNode.setNextNode(nodeToAdd);

        return headNode;
    }

    public ListNode remove(ListNode head, int positionToRemove) {
        checkValidIndex(head.size() - 1, positionToRemove);

        ListNode headNode = head;
        ListNode presentNode = head;

        if (positionToRemove == 0) {
            headNode = head.getNextNode();
            head.setNextNode(null);

            return headNode;
        }

        for (int i = 1; i < positionToRemove; i++) {
            presentNode = presentNode.getNextNode();
        }

        presentNode.setNextNode(presentNode.getNextNode().getNextNode());

        return headNode;
    }

    private void checkValidIndex(int nodeSize, int position) {
        if (position < 0 || position > nodeSize) {
            throw new IndexOutOfBoundsException("인덱스 " + position + "은 유효하지 않은 인덱스입니다. 유효 인덱스 : 0 ~ " + nodeSize);
        }
    }

    public boolean contains(ListNode head, ListNode nodeToCheck) {
        while (head != null) {
            if (head == nodeToCheck) {
                return true;
            }

            head = head.getNextNode();
        }

        return false;
    }
}
