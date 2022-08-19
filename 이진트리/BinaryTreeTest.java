package tree;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import tree.BinaryTree.Node;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("이진 트리 기능 단위테스트")
class BinaryTreeTest {

    BinaryTree binaryTree = new BinaryTree(5);

    @BeforeAll
    void setup() {
        binaryTree.addNode(3);
        binaryTree.addNode(7);
        binaryTree.addNode(1);
        binaryTree.addNode(4);
        binaryTree.addNode(6);
        binaryTree.addNode(8);
    }

    @Test
    @DisplayName("이진 트리 내 노드들을 너비 우선 탐색할 수 있다.")
    void bfs() {
        // given
        Node rootNode = binaryTree.getRootNode();

        // when
        List<Integer> values = binaryTree.bfs(rootNode);

        // then
        List<Integer> expected = List.of(5, 3, 7, 1, 4, 6, 8);

        for (int i = 0; i < expected.size(); i++) {
            assertThat(values.get(i)).isEqualTo(expected.get(i));
        }
    }

    @Test
    @DisplayName("이진 트리 내 노드들을 전위 순회할 수 있다.")
    void preOrder() {
        // given
        Node rootNode = binaryTree.getRootNode();

        // when
        List<Integer> values = binaryTree.preOrder(rootNode);

        // then
        List<Integer> expected = List.of(5, 3, 1, 4, 7, 6, 8);

        for (int i = 0; i < expected.size(); i++) {
            assertThat(values.get(i)).isEqualTo(expected.get(i));
        }
    }

    @Test
    @DisplayName("이진 트리 내 노드들을 중위 순회할 수 있다.")
    void inOrder() {
        // given
        Node rootNode = binaryTree.getRootNode();

        // when
        List<Integer> values = binaryTree.inOrder(rootNode);

        // then
        List<Integer> expected = List.of(1, 3, 4, 5, 6, 7, 8);

        for (int i = 0; i < expected.size(); i++) {
            assertThat(values.get(i)).isEqualTo(expected.get(i));
        }
    }

    @Test
    @DisplayName("이진 트리 내 노드들을 후위 순회할 수 있다.")
    void postOrder() {
        // given
        Node rootNode = binaryTree.getRootNode();

        // when
        List<Integer> values = binaryTree.postOrder(rootNode);

        // then
        List<Integer> expected = List.of(1, 4, 3, 6, 8, 7, 5);

        for (int i = 0; i < expected.size(); i++) {
            assertThat(values.get(i)).isEqualTo(expected.get(i));
        }
    }
}
