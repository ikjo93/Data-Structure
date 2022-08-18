package whiteship;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import whiteship.linkedlist.ListNode;
import whiteship.linkedlist.ListNodeManager;

class ListNodeManagerTest {

    ListNodeManager listNodeManager = new ListNodeManager();
    ListNode head;

    @BeforeEach
    void setup() {
        head = new ListNode(1); // 0
        head.add(new ListNode(2)); // 1
        head.add(new ListNode(3)); // 2
    }

    @Test
    @DisplayName("연결리스트 특정 인덱스에 노드를 삽입할 수 있다.")
    void add() {
        // when
        head = listNodeManager.add(head, new ListNode(4), 0);
        head = listNodeManager.add(head, new ListNode(5), 2);
        head = listNodeManager.add(head, new ListNode(6), 5);

        // then
        List<Integer> expectValues = List.of(4, 1, 5, 2, 3, 6);

        for (Integer expectValue : expectValues) {
            assertThat(head.getValue()).isEqualTo(expectValue);
            head = head.getNextNode();
        }
    }

    @Test
    @DisplayName("연결리스트 특정 인덱스의 노드를 제거할 수 있다.")
    void remove() {
        // when
        head = listNodeManager.remove(head, 0);
        head = listNodeManager.remove(head, 1);

        // then
        assertThat(head.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("연결리스트 내 특정 노드를 찾을 수 있다.")
    void contains() {
        // given
        ListNode node = new ListNode(4);
        head.add(node);

        // when
        boolean result = listNodeManager.contains(head, node);

        // then
        assertThat(result).isEqualTo(true);
    }
}
