import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        rootNode = new Node(rootValue, null);
        size++;
    }

    /**
     * 이진 트리의 노드를 추가합니다.
     * 추가하려는 노드의 값이 상위 노드 보다 작으면 왼쪽 하위 노드에,
     * 상위 노드 보다 크면 오른쪽 하위 노드에 추가됩니다.
     */
    public Node addNode(int value) {
        Node node = rootNode.add(value);
        size++;

        return node;
    }

    /**
     * 이진 트리의 전체 노드 개수를 반환합니다.
     */
    public int size() {
        return size;
    }

    /**
     * 루트 노드를 반홥합니다.
     */
    public Node getRootNode() {
        return rootNode;
    }

    /**
     * 너비 우선 탐색 결과를 리스트 형태로 반환합니다.
     * ※ 너비 우선 탐색 : 0(루트) 계층 -> 1 계층 -> 2 계층 -> ...
     */
    public List<Integer> bfs(Node node) {
        List<Integer> values = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            values.add(n.value);

            if (n.leftChild != null) {
                queue.add(n.leftChild);
            }

            if (n.rightChild != null) {
                queue.add(n.rightChild);
            }
        }

        return values;
    }

    /**
     * 이진 트리의 전위 순회 결과를 리스트 형태로 반환합니다.
     * ※ 전위 순회 : 상위 노드 - 왼쪽 하위 노드 - 오른쪽 하위 노드 순 탐색
     * ※ 전위 순회는 root 노드를 가장 일찍 탐색합니다.
     */
    public List<Integer> preOrder(Node node) {
        List<Integer> values = new ArrayList<>();
        preOrder(node, values);

        return values;
    }

    private void preOrder(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }

        values.add(node.value);
        preOrder(node.leftChild, values);
        preOrder(node.rightChild, values);
    }

    /**
     * 이진 트리의 중위 순회 결과를 리스트 형태로 반환합니다.
     * ※ 중위 순회 : 왼쪽 하위 노드 - 상위 노드 - 오른쪽 하위 노드 순 탐색
     * ※ 중위 순회는 root 노드를 중간 지점애서 탐색합니다.
     */
    public List<Integer> inOrder(Node node) {
        List<Integer> values = new ArrayList<>();
        inOrder(node, values);

        return values;
    }

    private void inOrder(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }

        inOrder(node.leftChild, values);
        values.add(node.value);
        inOrder(node.rightChild, values);
    }

    /**
     * 이진 트리의 후위 순회 결과를 리스트 형태로 반환합니다.
     * ※ 후위 순회 : 왼쪽 하위 노드 - 오른쪽 하위 노드 - 상위 노드 순 탐색
     * ※ 후위 순회는 root 노드를 가장 마지막애 탐색합니다.
     */
    public List<Integer> postOrder(Node node) {
        List<Integer> values = new ArrayList<>();
        postOrder(node, values);

        return values;
    }

    private void postOrder(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }

        postOrder(node.leftChild, values);
        postOrder(node.rightChild, values);
        values.add(node.value);
    }

    static class Node {

        final int value;
        Node parent;
        Node leftChild;
        Node rightChild;

        Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
        }

        public Node add(int value) {
            if (this.value > value) {
                return addLeft(value, this);
            } else if (this.value < value){
                return addRight(value, this);
            } else {
                // TODO : 동일한 노드 삽입 시 처리
                return null;
            }
        }

        private Node addLeft(int value, Node parent) {
            if (leftChild == null) {
                leftChild = new Node(value, parent);
                return leftChild;
            }

            if (leftChild.value > value) {
                return leftChild.addLeft(value, leftChild);
            } else {
                return leftChild.addRight(value, leftChild);
            }
        }

        private Node addRight(int value, Node parent) {
            if (rightChild == null) {
                rightChild = new Node(value, parent);
                return rightChild;
            }

            if (rightChild.value > value) {
                return rightChild.addLeft(value, rightChild);
            } else {
                return rightChild.addRight(value, rightChild);
            }
        }
    }
}
