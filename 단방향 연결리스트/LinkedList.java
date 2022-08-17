import java.util.ArrayList;
import java.util.List;

/**
 * 단방향 연결리스트입니다.
 */
public class LinkedList {

    private final Node header;
    private int size = 0;

    /**
     * 연결리스트의 헤더를 초기화 합니다. 이때 헤더는 데이터를 지니지 않는 단순히 다음 노드를 연결하기 위한 노드입니다.
     */
    public LinkedList() {
        header = new Node();
    }

    /**
     * 연결리스트의 전체 노드 개수를 반환 합니다. 단, 헤더 노드는 데이터를 지니지 않으므로 제외합니다.
     */
    public int size() {
        return size;
    }

    /**
     * 연결리스트 마지막 부분에 새로운 노드를 추가합니다.
     */
    public Node add(int value) {
        Node newNode = new Node(value, null);
        Node node = header;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        size++;

        return newNode;
    }

    /**
     * 인덱스를 통해 연결리스트 상의 특정 노드의 값을 반환합니다. 이때, 헤더 노드의 다음 노드부터 인덱스 0을 기준으로 합니다.
     */
    public int get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalStateException("지정된 인덱스 범위를 초과하였습니다.");
        }

        Node node = header;

        for (int i = -1; i < index; i++) {
            node = node.next;
        }

        return node.value;
    }

    /**
     * 연결리스트의 마지막 노드를 기준으로 한 인덱스를 통해 특정 노드의 값을 반환합니다. 이때 마지막 노드의 인덱스는 0을 기준으로 합니다.
     */
    public int getLastOf(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalStateException("지정된 인덱스 범위를 초과하였습니다.");
        }

        Node node = header;

        for (int i = 0; i < size - index; i++) {
            node = node.next;
        }

        return node.value;
    }

    /**
     * 특정 값을 지닌 노드를 모두 삭제합니다.
     */
    public void delete(int value) {
        Node node = header;
        while (node.next != null) {
            if (node.next.value == value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
    }

    /**
     * 중간 노드를 삭제합니다. 이때 중간 노드를 다음 노드로 덮어쓰는 것이기 때문에 마지막 노드는 삭제할 수 없습니다.
     */
    public void deleteNode(Node node) {
        if (node == header || node.next == null) {
            throw new IllegalStateException("헤더와 마지막 노드는 삭제할 수 없습니다.");
        }

        Node nextNode = node.next;
        node.value = nextNode.value;
        node.next = nextNode.next;
    }

    /**
     * 연결된 모든 노드의 데이터 값을 리스트 형태로 반환합니다.
     */
    public List<Integer> values() {
        List<Integer> values = new ArrayList<>();

        Node node = header.next;
        while (node.next != null) {
            values.add(node.value);
            node = node.next;
        }

        values.add(node.value);

        return values;
    }

    /**
     * 현재 노드 중 중복된 데이터를 지니고 있는 노드를 삭제합니다. 이때 중복된 데이터를 지니고 있는 노드들 중에서 가장 먼저 발견된 노드는 삭제 대상에서 제외합니다.
     */
    public void removeDuplicates() {
        Node node = header;

        while (node != null && node.next != null) {
            Node runner = node;

            while (runner.next != null) {
                if (node.value == runner.next.value) {
                    runner.next = runner.next.next;
                    size--;
                } else {
                    runner = runner.next;
                }
            }

            node = node.next;
        }
    }

    /**
     * 특정 값을 기준으로 작은 값은 왼쪽에, 큰거나 같은 값은 오른쪽에 나누어 리스트 형태로 반환합니다.
     */
    public List<Integer> divide(int x) {
        List<Integer> values1 = new ArrayList<>();
        List<Integer> values2 = new ArrayList<>();

        Node node = header;

        while (node.next != null) {
            node = node.next;

            if (node.value < x) {
                values1.add(node.value);
            } else {
                values2.add(node.value);
            }
        }

        values1.addAll(values2);

        return values1;
    }

//    public Node divide(int x) {
//        Node node = header.next;
//        Node head = node;
//        Node tail = node;
//
//        while (node != null) {
//            Node next = node.next;
//
//            if (node.value < x) {
//                node.next = head;
//                head = node;
//            } else {
//                tail.next = node;
//                tail = node;
//            }
//            node = next;
//        }
//
//        tail.next = null;
//
//        return head;
//    }

//    public Node divide(int x) {
//        Node s1 = null, s2 = null, e1 = null, e2 = null;
//
//        Node node = header;
//
//        while (node != null) {
//            Node next = node.next;
//            node.next = null;
//
//            if (node.value < x) {
//                if (s1 == null) {
//                    s1 = node;
//                    e1 = s1;
//                } else {
//                    e1.next = node;
//                    e1 = node;
//                }
//            } else {
//                if (s2 == null) {
//                    s2 = node;
//                    e2 = s2;
//                } else {
//                    e2.next = node;
//                    e2 = node;
//                }
//            }
//
//            node = next;
//        }
//
//        if (s1 == null) {
//            return s2;
//        }
//
//        e1.next = s2;
//
//        return s1;
//    }

    private static class Node {
        int value;
        Node next;

        Node() { }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
