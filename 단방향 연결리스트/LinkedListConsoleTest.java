package linkedlist;

import java.util.List;

public class LinkedListConsoleTest {

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.add(5);
        linkedList1.add(7);
        linkedList1.add(9);
        linkedList1.add(10);
        linkedList1.add(7);
        linkedList1.add(6);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(6);
        linkedList2.add(8);
        linkedList2.add(10);
        linkedList2.add(7);
        linkedList2.add(6);

        int valueOfIntersectionNode = getValueOfIntersectionNode(linkedList1, linkedList2);
        System.out.println("valueOfIntersectionNode = " + valueOfIntersectionNode);

        printDivide(linkedList1.divide(5));

        linkedList1.delete(2);

        printAll(linkedList1);

        linkedList1.removeDuplicates();

        printAll(linkedList1);
    }

    private static void printDivide(List<Integer> divide) {
        for (Integer value : divide) {
            System.out.printf("%d -> ", value);
        }
        System.out.println();
    }

    private static void printAll(LinkedList linkedList) {
        for (Integer value : linkedList.values()) {
            System.out.printf("%d -> ", value);
        }
        System.out.println();
    }

    private static int getValueOfIntersectionNode(LinkedList linkedList1, LinkedList linkedList2) {
        int size1 = linkedList1.size(), size2 = linkedList2.size();
        int s1, s2;

        if (size1 > size2) {
            s1 = size1 - size2;
            s2 = 0;
        } else {
            s1 = 0;
            s2 = size2 - size1;
        }

        for (int i = s1, j = s2; i < size1; i++, j++) {
            if (linkedList1.get(i) == linkedList2.get(j)) {
                return linkedList1.get(i);
            }
        }

        throw new IllegalStateException("두 연결리스트 간 교차점이 없습니다.");
    }
}
