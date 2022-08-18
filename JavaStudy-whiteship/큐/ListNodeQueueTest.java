package whiteship.queue;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("연결리스트로 구현한 큐의 기능 단위 테스트")
class ListNodeQueueTest {

    ListNodeQueue queue = new ListNodeQueue();

    @AfterEach
    void init() {
        queue.clear();
    }

    @Test
    @DisplayName("큐에 데이터를 add 할 수 있다.")
    void add() {
        // when
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // then
        assertThat(queue.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("큐 데이터를 poll 할 수 있다.")
    void poll() {
        // given
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // when, then
        assertThat(queue.poll()).isEqualTo(1);
        assertThat(queue.poll()).isEqualTo(2);
        assertThat(queue.poll()).isEqualTo(3);
        assertThat(queue.size()).isEqualTo(0);
    }

}
