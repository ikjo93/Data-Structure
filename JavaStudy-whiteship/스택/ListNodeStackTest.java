package whiteship.stack;

import static org.assertj.core.api.Assertions.*;

import java.util.EmptyStackException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("연결리스트로 구현한 스택의 기능 단위 테스트")
class ListNodeStackTest {

    ListNodeStack listNodeStack = new ListNodeStack();

    @BeforeEach
    void setup() {
        listNodeStack.push(1);
        listNodeStack.push(2);
        listNodeStack.push(3);
    }

    @AfterEach
    void init() {
        listNodeStack.clear();
    }

    @Test
    @DisplayName("스택에 데이터를 push 할 수 있다.")
    void push() {
        // when
        listNodeStack.push(4);
        listNodeStack.push(5);
        listNodeStack.push(6);

        // then
        assertThat(listNodeStack.get(3)).isEqualTo(4);
        assertThat(listNodeStack.get(4)).isEqualTo(5);
        assertThat(listNodeStack.get(5)).isEqualTo(6);
        assertThat(listNodeStack.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("스택 데이터를 pop 할 수 있다.")
    void pop() {
        // when
        int v1 = listNodeStack.pop();
        int v2 = listNodeStack.pop();
        int v3 = listNodeStack.pop();

        // then
        assertThat(v1).isEqualTo(3);
        assertThat(v2).isEqualTo(2);
        assertThat(v3).isEqualTo(1);
        assertThat(listNodeStack.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("스택이 비어있을 때 pop 하면 EmptyStackException 예외가 발생한다.")
    void pop_exception() {
        // given
        listNodeStack.pop();
        listNodeStack.pop();
        listNodeStack.pop();

        // when, then
        assertThatThrownBy(() -> listNodeStack.pop())
            .isInstanceOf(EmptyStackException.class);
    }
}
