package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private static final int DEFAULT_ROOT_VALUE = 10;

    private final Node rootNode;
    private int size = 0;

    /**
     * 이진 트리를 초기화하는 생성자 메서드입니다.
     * 루트 노드의 값을 명시하지 않을 경우 기본적으로 10으로 초기화됩니다.
     */
    public BinaryTree() {
        this(DEFAULT_ROOT_VALUE);
    }

    public BinaryTree(int rootValue) {
        rootNode = new Node(rootValue);
        size++;
    }

    /**
     * 이진 트리의 노드를 추가합니다.
     * 추가하려는 노드의 값이 상위 노드 보다 작으면 왼쪽 하위 노드에,
     * 상위 노드 보다 크면 오른쪽 하위 노드에 추가됩니다.
     */
    public void addNode(int value) {
        rootNode.add(value);
        size++;
    }

    /**
     * 이진 트리의 전체 노드 크기를 반환합니다.
     */
    public int size() {
        return size;
    }

    /**
     * 이진 트리의 전위 순회 결과를 리스트 형태로 반환합니다.
     * ※ 전위 순회 : 상위 노드 - 왼쪽 하위 노드 - 오른쪽 하위 노드 순 탐색
     * ※ 전위 순회는 root 노드를 가장 일찍 탐색합니다.
     */
    public List<Integer> preOrder() {
        List<Integer> values = new ArrayList<>();
        preOrder(rootNode, values);

        return values;
    }

    private void preOrder(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }

        values.add(node.value);
        preOrder(node.left, values);
        preOrder(node.right, values);
    }

    /**
     * 이진 트리의 중위 순회 결과를 리스트 형태로 반환합니다.
     * ※ 중위 순회 : 왼쪽 하위 노드 - 상위 노드 - 오른쪽 하위 노드 순 탐색
     * ※ 중위 순회는 root 노드를 중간 지점애서 탐색합니다.
     */
    public List<Integer> inOrder() {
        List<Integer> values = new ArrayList<>();
        inOrder(rootNode, values);

        return values;
    }

    private void inOrder(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }

        inOrder(node.left, values);
        values.add(node.value);
        inOrder(node.right, values);
    }

    /**
     * 이진 트리의 후위 순회 결과를 리스트 형태로 반환합니다.
     * ※ 후위 순회 : 왼쪽 하위 노드 - 오른쪽 하위 노드 - 상위 노드 순 탐색
     * ※ 후위 순회는 root 노드를 가장 마지막애 탐색합니다.
     */
    public List<Integer> postOrder() {
        List<Integer> values = new ArrayList<>();
        postOrder(rootNode, values);

        return values;
    }

    private void postOrder(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }

        postOrder(node.left, values);
        postOrder(node.right, values);
        values.add(node.value);
    }

    static class Node {

        final int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        public void add(int value) {
            if (this.value > value) {
                addLeft(value);
            } else if (this.value < value){
                addRight(value);
            } else {
                // TODO : 동일한
            }
        }

        private void addLeft(int value) {
            if (left == null) {
                left = new Node(value);
                return;
            }

            if (left.value > value) {
                left.addLeft(value);
            } else {
                left.addRight(value);
            }
        }

        private void addRight(int value) {
            if (right == null) {
                right = new Node(value);
                return;
            }

            if (right.value > value) {
                right.addLeft(value);
            } else {
                right.addRight(value);
            }
        }
    }
}
